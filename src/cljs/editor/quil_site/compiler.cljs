(ns quil-site.compiler
  (:require [cljs.js :as cjs]
            [cljs.reader :as r]
            [goog.events :as events]
            [goog.events.EventType :as EventType])
  (:import goog.net.XhrIo))

(enable-console-print!)

(def test-source "(ns my.core
  (:require [quil.core :include-macros true]
            [quil.middleware :as m]))

(defn setup []
  (quil.core/frame-rate 30)
  (quil.core/color-mode :hsb)
  {:color 0
   :angle 0})

(defn update-state [state]
  (let [{:keys [color angle]} state]
    {:color (mod (+ color 0.7) 255)
     :angle (mod (+ angle 0.1) quil.core/TWO-PI)}))

(defn draw-state [state]
  (quil.core/background 240)
  (quil.core/fill (:color state) 255 255)
  (let [angle (:angle state)
        x (* 150 (quil.core/cos angle))
        y (* 150 (quil.core/sin angle))]
    (quil.core/with-translation [(/ (quil.core/width) 2)
                         (/ (quil.core/height) 2)]
      (quil.core/ellipse x y 100 100))))

(quil.core/defsketch my
  :host \"my\"
  :size [500 500]
  :setup setup
  :update update-state
  :draw draw-state
  :middleware [m/fun-mode])")

(def test-source2 "(ns my.core
  (:require [quil.core :include-macros true]
            [quil.middleware :as m]))

(defn update-state [state]
  (let [{:keys [color angle]} state]
    {:color (mod (+ color 1.0) 255)
     :angle (mod (+ angle 0.3) quil.core/TWO-PI)}))")

(defn fetch-file!
  "Very simple implementation of XMLHttpRequests that given a file path
  calls src-cb with the string fetched of nil in case of error.

  See doc at https://developers.google.com/closure/library/docs/xhrio"
  [file-url src-cb]
  (try
    (.send XhrIo file-url
           (fn [e]
             (if (.isSuccess (.-target e))
               (src-cb (.. e -target getResponseText))
               (src-cb nil))))
    (catch :default e
      (src-cb nil))))

(def cached-macros (atom {}))

(set! js/Processing
      #js {"prototype" #js {"PConstants" #js {}}})
(set! js/window #js {})

(fetch-file! "/quil-cache.edn"
             #(do
                (reset! cached-macros (r/read-string %))))

(def core-cache (atom nil))

(fetch-file! "/core-cache.edn" #(reset! core-cache (r/read-string %)))

(defn load-macros-ns [{:keys [name macros] :as opts} cb]
  (if-let [{:keys [source cache]} (@cached-macros
                                   {:name name
                                    :macros (boolean macros)})]
    (cb {:lang :js
         :source source
         :cache cache})
    (cb {:lang :clj
         :source ""})))

(defn compile [source cb]
  (let [state (cjs/empty-state)]
    (cjs/load-analysis-cache!
     state 'cljs.core (@core-cache 'cljs.core))
    (cjs/compile-str state source nil
                    {:load load-macros-ns
                     :eval cjs/js-eval
                     :verbose false}
                    cb)))

(defn run [source]
  (compile source (fn [res]
                    (println "Sending" res)
                    (.postMessage (.-contentWindow (.querySelector js/document "iframe"))
                                  #js {:type "eval"
                                       :source (:value res)}
                                  "*"))))

(goog/exportSymbol "compile" #(compile % (fn [res]
                                           (println @cjs/*loaded*)
                                           (println res))))

(goog/exportSymbol "run" run)

(goog/exportSymbol "source" test-source)

(goog/exportSymbol "jss" clj->js)
