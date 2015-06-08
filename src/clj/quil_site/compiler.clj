(ns quil-site.compiler
  (:require [cljs.closure :as cljs]
            [cljs.js-deps :as deps]
            [cljs.env :as cljs-env]
            [clojure.tools.reader :as reader]
            [clojure.tools.reader.reader-types :refer [string-push-back-reader]]
            [cljs.tagged-literals :as tags]
            [clojure.core.cache :as c]
            [pandect.algo.sha256 :as sha256]))

(def ^{:private true} cache (atom (c/lru-cache-factory {} :threshold 128)))

(defn parse-cljs
  "Parses cljs source code using clojure.tools.reader and return vector
  of parsed expressions."
  [cljs-source]
  (try
    (let [reader (string-push-back-reader cljs-source)
          endof (gensym)]
      (binding [reader/*read-eval* false
                reader/*data-readers* tags/*cljs-data-readers*]
        (->> #(reader/read reader false endof)
             (repeatedly)
             (take-while #(not= % endof))
             (doall)
             vec)))
    (catch Exception e
      (println e)
      [])))

(defn- get-upstream-deps
  "returns a merged map containing all upstream dependencies defined by libraries on the classpath"
  []
  (let [classloader (. (Thread/currentThread) (getContextClassLoader))
        upstream-deps (map #(read-string (slurp %)) (enumeration-seq (. classloader (getResources "deps.cljs"))))]

    (apply merge-with concat upstream-deps)))

(defn- compile-cljs [cljs-forms]
  (let [upstream (get-upstream-deps)
        opts {:ups-libs (:libs upstream)
              :ups-foreign-libs (:foreign-libs upstream)
              :ups-externs (:externs upstream)
              :preamble ["cljs/imul.js"]}
        compiler-env @(cljs-env/default-compiler-env)]
    (binding [cljs.analyzer/*cljs-file* "something.cljs"]
      (cljs-env/with-compiler-env
        (assoc compiler-env :js-dependency-index (deps/js-dependency-index opts))
        (cljs/-compile cljs-forms {})))))

(defn compile-or-get-cached [cljs-forms orig-source]
  (let [hash (sha256/sha256 orig-source)]
    (if-let [compiled (c/lookup @cache hash)]
      (do
        (swap! cache c/hit hash)
        compiled)
      (let [compiled (compile-cljs cljs-forms)]
        (swap! cache assoc hash compiled)
        compiled))))

(comment

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

  (compile-or-get-cached (parse-cljs test-source))

  )
