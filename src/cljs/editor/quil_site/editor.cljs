(ns quil-site.editor
  (:require [quil-site.compiler :as c]
            [quil-site.parser :as p]
            [jayq.core :as j]
            [clojure.string :as cstr]
            [cljs.pprint :as pprint]))

(enable-console-print!)

(def editor (atom nil))
(def result-pane-size (atom [0 0]))
(def scroll-width 20)

(defn hide-result-pane []
  (let [width (.-offsetWidth (.querySelector js/document "#source-content"))]
    (j/css (j/$ "#result-content") "left" (str width "px")))
  (j/add-class (j/$ "#hide") "disabled"))

(defn show-result-pane []
  (let [view-width (.-offsetWidth (.querySelector js/document "#content"))
        pane-width (first @result-pane-size)
        pane-bigger? (> pane-width (int (j/attr (j/$ "iframe") "width")))]
    (j/css (j/$ "#result-content") "left" (str (- view-width
                                                  pane-width
                                                  scroll-width)
                                               "px"))
    ; when pane bigger - it means that it won't slide because
    ; it already enough space to cover the whole iframe.
    ; in that case don't enable "hide" button
    (when-not pane-bigger?
      (j/remove-class (j/$ "#hide") "disabled"))))

(defn set-errors [errors]
  (println errors)
  (let [options (.-options (.getOption @editor "lint"))]
    (.clearGutter @editor "CodeMirror-lint-markers")
    (set! (.-cljsErrors options) errors)
    (.signal js/CodeMirror @editor "change" @editor)))

(defn set-status [status]
  (let [el (j/$ "#result-status")
        set (fn [class text]
              (println "Setting" class text)
              (-> el
                  (j/add-class class)
                  (j/text text)))]
    (-> el
        (j/remove-class "alert-success")
        (j/remove-class "alert-warning")
        (j/remove-class "alert-danger"))
    (case (:type status)
      :ok (set "alert-success" "succesfully evaluated")
      :warnings (set "alert-warning" "evaluated with warnings")
      :errors (set "alert-danger" "found some errors")
      :no-code (set "alert-warning" "no form found under cursor")
      :clear (set "" ""))))

(defn compile
  ([] (compile (.getValue @editor)))
  ([code]
   (println "Compiling")
   (println code)
   (set-status {:type :clear})
   (.clearGutter @editor "CodeMirror-lint-markers")
   (c/run code (fn [res]
                 (cond (:error res) (set-status {:type :errors})
                       (not (empty? (:warnings res))) (set-status {:type :warnings})
                       :default (set-status {:type :ok}))
                 (set-errors (remove nil? (conj (:warnings res) (:error res))))))))

(defn cursor-to-point [cursor]
  [(.-line cursor) (.-ch cursor)])

(defn complete-selection [ns selection pos]
  (let [[line col] pos
        append-symbs (fn [st ch n]
                       (apply str st (repeat n ch)))]
    (if (cstr/includes? selection ns)
      selection
      (-> ns
          (str \newline)
          (append-symbs \newline (- line (count (cstr/split-lines ns))))
          (append-symbs " " (dec col))
          (str selection)))))

(defn get-selection [editor]
  (let [user-selection (.getSelection editor)]
    (if (empty? user-selection)
      (let [point (cursor-to-point (.getCursor editor))
            res (p/get-form-ends-at-point (.getValue editor) point)]
        (if (:form res)
          {:value (:form res)
           :start (:start res)}
          res))
      {:value user-selection
       :start (cursor-to-point (.getCursor editor "from"))})))

(defn compile-selected []
  (let [ns (p/get-ns-form (.getValue @editor))
        selection (get-selection @editor)]
    (cond
      (:value selection) (compile (complete-selection
                                   ns (:value selection) (:start selection)))
      (:error selection) (do
                           (set-status {:type :errors})
                           (set-errors [(:error selection)]))
      :default (set-status {:type :no-code}))))

(defn show-share-dialog [resp]
  (let [path (str "/sketches/show/" (:id resp))
        url (str (.-protocol js/location) "//" (.-host js/location) path)]
    (j/val (j/$ "#share-dialog input") url)
    (when-let [history (.-history js/window)]
      (.replaceState history
                     #js {} "" path))
    (.modal (j/$ "#share-dialog") "show")))

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
        pane (j/$ "#result-content")
        pane-height (j/outer-height pane)
        content-width (j/outer-width (j/$ "#content"))
        source-width (j/outer-width (j/$ "#source-content"))
        pane-width (-> width
                       (min (- content-width scroll-width))
                       (max (- content-width source-width scroll-width)))]
    (reset! result-pane-size [pane-width pane-height])
    (doto (j/$ "iframe")
      (j/attr "width" width)
      (j/attr "height" height)
      (j/css "top" (str (max (- (/ pane-height 2)
                                (/ height 2))
                             0)
                        "px")))
    (doto pane
      (j/css "width" (str (+ scroll-width pane-width) "px"))))
  (show-result-pane))

(defn reset-iframe []
  (c/reset-state!)
  (let [iframe (j/$ "iframe")]
    (j/attr iframe "src" (j/attr iframe "src"))))

(defn set-editor-source [source]
  (j/add-class (j/$ "#sketch-loading") "hidden")
  (j/remove-class (j/$ "#source-content > div") "hidden")
  (.setValue @editor source))

(defn init []
  (.registerHelper
   js/CodeMirror "lint" "clojure"
   (fn [text options]
     (letfn [(error-to-obj [error]
               {:from (.Pos js/CodeMirror
                            (- (:line error) 1)
                            (- (:column error) 1))
                :to (.Pos js/CodeMirror
                          (- (:line error) 1)
                          (- (:column error) 0))
                :message (:message error)
                :severity (name (:type error))})]
       (clj->js
        (map error-to-obj (.-cljsErrors options))))))

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
            :autoCloseBrackets true
            :extraKeys #js {"Ctrl-Enter" compile-selected}}))
  (j/ajax
   {:url (str "/sketches/info/" (j/data (j/$ "#source") "sketch-id"))
    :method "GET"
    :success #(set-editor-source (.-cljs %))})

  (j/on (j/$ "#send") "click" #(compile))
  (j/on (j/$ "#reset") "click" reset-iframe)
  (j/on (j/$ "#share") "click" share)
  (j/on (j/$ "body") "click" "#share-dialog input" #(this-as el (.select el)))
  (j/on (j/$ js/window) "message"
        (fn [event]
          (let [message (js->clj (.-data (.-originalEvent event))
                                 :keywordize-keys true)]
            (when (= (:type message) "resize-iframe")
              (resize-iframe message)))))
  (hide-result-pane)
  (j/on (j/$ "#result-content") "mouseenter" show-result-pane)
  (j/on (j/$ "#hide") "click" hide-result-pane)
  (.on js/CodeMirror @editor "mousedown" #(do
                                            (hide-result-pane)
                                            (.popover (j/$ "#share") "destroy")))
  (.on js/CodeMirror @editor "touchstart" #(do
                                            (hide-result-pane)
                                            (.popover (j/$ "#share") "destroy"))))


(j/$ init)

