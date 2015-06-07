(ns quil-site.controllers.sketches
  (:require [compojure.core :refer :all :exclude [routes]]
            [compojure.route :refer [not-found]]
            [clojure.java.io :as io]
            [ring.util.response :as resp]
            [quil-site.views.sketches :as views]
            [quil-site.examples :refer [get-example-source]]
            [quil-site.compiler :refer [compile-or-get-cached parse-cljs]]
            [clojure.core.cache :as cache]
))

(def test-source "(ns my.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :hsb)
  {:color 0
   :angle 0})

(defn update-state [state]
  (let [{:keys [color angle]} state]
    {:color (mod (+ color 0.7) 255)
     :angle (mod (+ angle 0.1) q/TWO-PI)}))

(defn draw-state [state]
  (q/background 240)
  (q/fill (:color state) 255 255)
  (let [angle (:angle state)
        x (* 150 (q/cos angle))
        y (* 150 (q/sin angle))]
    (q/with-translation [(/ (q/width) 2)
                         (/ (q/height) 2)]
      (q/ellipse x y 100 100))))

(q/defsketch my
  :host \"my\"
  :size [500 500]
  :setup setup
  :update update-state
  :draw draw-state
  :middleware [m/fun-mode])")

(defn extract-size [sketch]
  (letfn [(defsketch? [form]
            (and (list? form)
                 (symbol? (first form))
                 (= "defsketch" (name (first form)))))
          (find-defsketch [forms]
            (->> forms
                 (filter defsketch?)
                 first))
          (get-size [[defsketch name & options]]
            (->> (partition 2 options)
                 (filter #(= :size (first %)))
                 (map second)
                 first))]
    (let [size (-> sketch find-defsketch get-size)]
      (if (and (or (list? size) (vector? size))
               (every? number? size))
        (vec (take 2 size))
        nil))))

(def id (atom 0))
(def sketches (atom (cache/lru-cache-factory {} :threshold 128)))

(defn get-example [id]
  (let [name (subs id (count "example_"))]
    (get-example-source name)))

(defn get-sketch [id]
  (if-let [sketch (cache/lookup @sketches id)]
    (do (swap! sketches cache/hit id)
        sketch)
    (if (.startsWith id "example_")
      (if-let [source (get-example id)]
        (let [sketch {:cljs source}]
          (swap! sketches assoc id sketch)
          sketch)
        nil)
      nil)))

(defn sketch-html [id]
  (if-let [sketch (get-sketch id)]
    (let [size (or (:size sketch) [500 500])]
      (-> (views/create-run-sketch-page id size)
          (resp/response)
          (resp/content-type "text/html")))
    (not-found (str "Sketch " id " not found."))))

(defn sketch-info [id]
  (let [default {:cljs test-source}
        sketch (select-keys (or (get-sketch id) default)
                            [:id :cljs :size])]
    (-> sketch
        (assoc :result :ok)
        (resp/response))))

(defn create-sketch [sketch]
  (try
    (let [source (:cljs sketch)
          parsed (parse-cljs source)
          js (compile-or-get-cached parsed)
          size (extract-size parsed)
          id (str (swap! id inc))
          sketch (assoc sketch
                   :id id
                   :size size
                   :js js)]
      (swap! sketches assoc id sketch)
      (sketch-info id))
    (catch clojure.lang.ExceptionInfo e
      (let [data (.getData e)]
        (resp/response {:result :error
                        :message (.getMessage e)
                        :column (:column data)
                        :line (:line data)})))
    (catch java.lang.Exception e
      (.printStackTrace e)
      (resp/response {:result :error
                      :message "Server error :/"}))))

(defn sketch-js [id]
  (-> (:js (get-sketch id))
      (resp/response)
      (resp/content-type "application/javascript")))

(defroutes routes
  (context "/sketches" []
    (GET "/create" [] (views/sketch-page "basic"))
    (GET "/info/:id" [id] (sketch-info id))
    (GET "/show/:id" [id] (views/sketch-page id))
    (GET "/html/:id" [id] (sketch-html id))
    (GET "/js/:id" [id] (sketch-js id))
    (POST "/create" req (create-sketch (:body req)))))
