(ns quil-site.editor
  (:require [quil-site.compiler :as c]
            [jayq.core :as j]))

(def editor (atom nil))

(defn show-error-alert [error]
  (-> (j/$ "<div></div>")
      (j/add-class "alert")
      (j/add-class "alert-danger")
      (j/attr "role" "alert")
      (j/text (.-message error))
      (j/insert-before "#source")))

(defn set-errors [errors]
  (let [options (.-options (.getOptions @editor "lint"))]
    (set! (.-cljsErrors options) errors)
    (j/remove (j/$ "#source-content .alert-danger"))
    (doseq [error errors]
      (show-error-alert error))
    (.signal js/CodeMirror @editor "change" @editor)))

(defn show-error [error]
  (j/add-class (j/$ "#ajax-status") "hidden")
  (.tab (j/$ "#source-tab") "show")
  (set-errors [error]))

(defn compile []
  (.clearGutter @editor "CodeMirror-lint-markers")
  (let [code (.getValue @editor)]
    (println "Compiling" code)
    (c/run code))
  (.tab (j/$ "#result-tab") "show"))

(defn init []
  (.registerHelper
   js/CodeMirror "lint" "clojure"
   (fn [text options]
     (letfn [(error-to-obj [error]
               #js
               {:from (.Pos js/CodeMirror
                            (- (.-line error) 1)
                            (- (.-column error) 2))
                :to (.Pos js/CodeMirror
                          (- (.-line error) 1)
                          (- (.-column error) 1))
                :message (.-message error)})]
       (map error-to-obj (.-cljsErrors options)))))

  (reset! editor
          (.fromTextArea
           js/CodeMirror
           (first (j/$ "#source"))
           #js
           {:mode "clojure"
            :lineNumbers true
            :gutters #js ["CodeMirror-lint-markers"]
            :lint #js {:options #js {:cljsErrors #js []}}
            :viewportMargin js/Infinity
            :matchBrackets true
            :autoCloseBrackets true}))
  (j/ajax
   {:url (str "/sketches/info/" (j/data (j/$ "#source") "sketch-id"))
    :method "GET"
    :success #(.setValue @editor (.-cljs %))})

  (j/on (j/$ "#send") "click" compile))

(j/$ init)

