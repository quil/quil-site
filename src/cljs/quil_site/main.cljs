(ns quil-site.main
  (:require [goog.dom :as dom]
            [goog.dom.classes :as classes]
            [goog.events :as events]
            [goog.events.EventType :as EventType]
            [clojure.string :as cstr]))

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

(defn num-of-visible-examples []
  (let [size (dom/getViewportSize)
        width (.-width size)]
    (condp < width
      992 3
      768 2
      0   1)))

(extend-type js/NodeList
  ISeqable
  (-seq [array] (array-seq array 0)))

(def examples (atom []))

(defn register-example! [name author run-fn &
                         {:keys [interactive?]
                          :or {interactive? false}
                          :as st}]
  (swap! examples conj (assoc st
                         :name name
                         :author author
                         :run-fn run-fn)))

(defn example-name->link [name]
  (->> (cstr/replace name " " "-")
       (str "/sketches/show/example_")))

(defn run-example [example host]
  (let [{:keys [name author run-fn interactive?]} example
        link (example-name->link name)]
    (when interactive?
      (classes/remove (query-selector host ".glyphicon.hidden")
                      "hidden"))
    (dom/setProperties (query-selector host "a")
                       #js {"href" link})
    (dom/setTextContent (query-selector host ".name")
                        name)
    (dom/setTextContent (query-selector host ".author")
                        (str "by " author))
   (run-fn (query-selector host "canvas") 200)))

(defn enable-tooltips []
  ; I'm lazy to include proper externs now so I will use strings
  ; Please fix it if your eyes are bleeding.
  (let [tooltips ((aget js/window "$")
                  "[data-toggle='tooltip']")]
    (.call (aget tooltips "tooltip")
           tooltips)))

(events/listenOnce js/window EventType/LOAD
  (fn []
    (let [[visible invisible] (split-at (num-of-visible-examples)
                                        (query-selector-all ".example"))]
     (doseq [[host example] (map vector visible (shuffle @examples)) ]
       (run-example example host))
     (doseq [host invisible]
       (dom/removeNode host))
     (enable-tooltips))))

