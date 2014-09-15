(ns quil-site.controllers.sketches
  (:require [compojure.core :refer :all :exclude [routes]]
            [compojure.route :refer [not-found]]
            [ring.util.response :as resp]
            [cljs.closure :as cljs]
            [cljs.env :as cljs-env]
            [me.raynes.fs :as fs]
            [quil-site.views.sketches :as views]
            [clojure.tools.reader.edn :as edn]
            [clojure.tools.reader.reader-types :refer [string-push-back-reader]]))


(def test-source "(ns my.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :hsb)
  {:color 0
   :angle 0})

(defn update [state]
  (let [{:keys [color angle]} state]
    {:color (mod (+ color 0.7) 255)
     :angle (mod (+ angle 0.1) q/TWO-PI)}))

(defn draw [state]
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
  :update update
  :draw draw
  :middleware [m/fun-mode])")


(defn extract-size [sketch-source]
  (letfn [(read-all [text]
            (try
              (let [reader (string-push-back-reader text)
                    endof (gensym)]
                (->> #(edn/read {:eof endof} reader)
                     (repeatedly)
                     (take-while #(not= % endof))
                     (doall)))
              (catch Exception e '())))
          (defsketch? [form]
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
    (let [size (-> sketch-source read-all find-defsketch get-size)]
      (clojure.pprint/pprint (find-defsketch (read-all sketch-source)))
      (if (and (or (list? size) (vector? size))
               (every? number? size))
        (vec (take 2 size))
        nil))))

(def cljs-compilation-dir (fs/temp-dir "cljs-compilation"))

(defn compile-cljs-2 [cljs-text]
  (let [source (fs/temp-file "cljs-source" "cljs")]
   (spit source cljs-text)
   (let [compiled (cljs-env/with-compiler-env (cljs-env/default-compiler-env)
                    (cljs/-compile source {}))]
     (fs/delete source)
     compiled)))

(defn compile-cljs [cljs-text]
  (let [source (fs/temp-file "cljs-source" "cljs")
        compiled (fs/temp-file "cljs-compiled")]
    (spit source cljs-text)
    (cljs/build source
                {:optimizations :simple
                 :output-to (.getAbsolutePath compiled)
                 :output-dir (.getAbsolutePath cljs-compilation-dir)
                 :externs ["externs/processing.js"]
                 :preamble ["processing.min.js"]
                 :pretty-print true})
    (let [compiled-text (slurp compiled)]
      (fs/delete source)
      (fs/delete compiled)
      compiled-text)))

(defn show-sketch [id])

(def id (atom 0))
(def sketches (atom {}))

(defn sketch-html [id]
  (if-let [sketch (@sketches id)]
    (let [size (or (:size sketch) [500 500])]
      (-> (views/create-run-sketch-page id size)
          (resp/response)
          (resp/content-type "text/html")))
    (not-found (str "Sketch " id " not found."))))

(defn sketch-info [id]
  (let [default {:cljs test-source}
        sketch (select-keys (@sketches id default)
                            [:id :cljs :size])]
    (-> sketch
        (assoc :result :ok)
        (resp/response))))

(defn create-sketch [sketch]
  (try
    (let [source (:cljs sketch)
          js (compile-cljs-2 source)
          size (extract-size source)
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
      (resp/response {:result :error
                      :message "Server error :/"}))))

(defn sketch-js [id]
  (-> (@sketches id)
      (:js (format "alert('Hello, world, %s');" id))
      (resp/response)
      (resp/content-type "application/javascript")))

(defroutes routes
  (context "/sketches" []
    (GET "/create" [] (views/create-sketch-page))
    (GET "/info/:id" [id] (sketch-info id))
    (GET "/show/:id" [id] (show-sketch id))
    (GET "/html/:id" [id] (sketch-html id))
    (GET "/js/:id" [id] (sketch-js id))
    (POST "/create" req (create-sketch (:body req)))))
