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

(defn show-share-dialog [resp]
  (let [path (str "/sketches/show/" (:id resp))
        url (str (.-protocol js/location) "//" (.-host js/location) path)]
    (println "Share url:" url)
    (when-let [history (.-history js/window)]
      (.replaceState history
                     #js {} "" path))))

(defn share []
  (j/ajax
   {:url "/sketches/create"
    :method "POST"
    :data (.stringify js/JSON #js {:cljs (.getValue @editor)})
    :contentType "application/json"
    :success (fn [resp]
              (let [resp (js->clj resp :keywordize-keys true)]
                (show-share-dialog resp)))}))

(defn resize-iframe [message]
  (let [{:keys [width height]} message
        iframe (j/$ "iframe")]
    (j/attr iframe "width" width)
    (j/attr iframe "height" height)))

(defn reset-iframe []
  (let [iframe (j/$ "iframe")]
    (j/attr iframe "src" (j/attr iframe "src"))))

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

  (j/on (j/$ "#send") "click" compile)
  (j/on (j/$ "#reset") "click" reset-iframe)
  (j/on (j/$ "#share") "click" share)
  (j/on (j/$ js/window) "message"
        (fn [event]
          (let [message (js->clj (.-data (.-originalEvent event))
                                 :keywordize-keys true)]
            (when (= (:type message) "resize-iframe")
              (resize-iframe message))))))

(j/$ init)

