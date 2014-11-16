(ns quil-site.main
  (:require [goog.dom :as dom]
            [goog.events :as events]
            [goog.events.EventType :as EventType]))

(enable-console-print!)

(defn query-selector
  ([element selector]
     (.querySelector element selector))
  ([selector]
     (query-selector js/document selector)))

(defn query-selector-all
  ([element selector]
     (.querySelectorAll element selector))
  ([selector]
     (query-selector-all js/document selector)))

(extend-type js/NodeList
  ISeqable
  (-seq [array] (array-seq array 0)))

(def examples (atom []))

(defn register-example! [name author run-fn]
  (swap! examples conj {:name name
                        :author author
                        :run-fn run-fn}))

(defn run-example [example host]
  (let [{:keys [name author run-fn]} example
        link (str "/sketches/show/example_" name)]
    (dom/setProperties (query-selector host "a")
                       #js {"href" link})
    (dom/setTextContent (query-selector host ".author")
                        (str "by " author))
   (run-fn (query-selector host "canvas") 200)))

(events/listenOnce js/window EventType/LOAD
  (fn []
    (doseq [[host example] (map vector
                                (query-selector-all ".example")
                                (cycle (shuffle @examples))) ]
      (run-example example host))))

