(ns quil-site.preload
  (:require quil.core
            quil.middleware
            clojure.string
            clojure.set
            clojure.zip
            [goog.events.EventType :as EventType]))

(defn handle-message [event]
  (let [{:keys [type source]} (js->clj (.-data event)
                                       :keywordize-keys true)]
    (when (= type "eval")
      (js/eval source))))

(.addEventListener js/window EventType/MESSAGE handle-message)

