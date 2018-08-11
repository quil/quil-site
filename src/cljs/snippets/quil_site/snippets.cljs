(ns quil-site.snippets
  (:require [goog.dom :as dom]
            [goog.dom.classes :as classes]
            [goog.dom.dataset :as dataset]
            [goog.events :as events]
            [goog.events.EventType :as EventType]
            [quil.snippets.all-snippets :as as]
            [zprint.core :as zp]))

(enable-console-print!)

(def zprint-options
  {:parse-string-all? true
   :fn-map {"q/with-translation" :arg1-force-nl
            "q/with-graphics" :arg1-force-nl
            "q/with-fill" :arg1-force-nl
            "q/with-stroke" :arg1-force-nl
            "q/with-rotation" :arg1-force-nl}})

(def snippets-by-function
  (group-by :fn
            (for [snippet as/all-snippets
                  fn (:fns snippet)]
              (assoc snippet :fn fn))))

(defn pretty-print-snippet [snippet]
  (let [; Remove first and last parentheses
        snippet (subs snippet 1 (dec (count snippet)))]
    (zp/zprint-str snippet 80 zprint-options)))

(defn render-snippets-for-function [container]
  (let [fn-name (dataset/get container "functionName")
        snippets (snippets-by-function fn-name)]
    (doseq [snippet snippets]
      (js/CodeMirror. container
                      #js {:mode "clojure"
                           :value (pretty-print-snippet (:body-str snippet))
                           :matchBrackets true
                           :readOnly true
                           :viewportMargin js/Infinity}))
    (when (empty? snippets)
      (-> container
          .-parentElement
          .-parentElement
          (classes/add "hidden")))))

(defn init []
  (doseq [container (array-seq (.querySelectorAll js/document "[data-function-name]"))]
    (render-snippets-for-function container)))

(init)
