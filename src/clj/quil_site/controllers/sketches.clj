(ns quil-site.controllers.sketches
  (:require [compojure.core :refer :all :exclude [routes]]
            [compojure.route :refer [not-found]]
            [clojure.java.io :as io]
            [ring.util.response :as resp]
            [quil-site.views.sketches :as views]
            [quil-site.examples :refer [get-example-source]]
            [quil-site.compiler :refer [compile-or-get-cached parse-cljs]]
            [quil-site.storage :as s]
            [clojure.core.cache :as c]
            [pandect.algo.sha256 :as sha256]))

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
  :host \"host\"
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
(def sketches (atom (c/lru-cache-factory {} :threshold 128)))

(def id-caches (atom (c/lru-cache-factory {} :threshold 512)))

(defn get-example [id]
  (let [name (subs id (count "example_"))]
    (get-example-source name)))

(defn get-id-for-source [source]
  (let [hash (sha256/sha256 source)]
    (if-let [id (c/lookup @id-caches hash)]
      (do (swap! id-caches c/hit hash)
          id)
      (let [id (s/save-source source)]
        (swap! id-caches assoc hash id)
        id))))

(defn get-source-for-id [id]
  (cond
    (.startsWith id "example_") (get-example id)
    (= id "basic") test-source
    :default (s/load-source id)))

(defn sketch-from-source [source id]
  (let [parsed (parse-cljs source)
        js (future (compile-or-get-cached parsed source))
        size (extract-size parsed)
        id (future (or id (get-id-for-source source)))]
    {:cljs source
     :js js
     :size size
     :id @id}))

(defn get-sketch [id]
  (if-let [sketch (c/lookup @sketches id)]
    (do (swap! sketches c/hit id)
        sketch)
    (if-let [source (get-source-for-id id)]
      (let [sketch (sketch-from-source source id)]
        (do (swap! sketches assoc id sketch)
            sketch))
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
    (let [sketch (sketch-from-source (:cljs sketch) nil)
          id (:id sketch)]
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
      deref
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
