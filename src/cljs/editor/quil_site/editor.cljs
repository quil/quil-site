(ns quil-site.editor
  (:require [quil-site.compiler :as c]
            [jayq.core :as j]
            [clojure.string :as cstr]))

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
        pane-width (first @result-pane-size)]
    (j/css (j/$ "#result-content") "left" (str (- view-width
                                                  pane-width
                                                  scroll-width)
                                               "px")))
  (j/remove-class (j/$ "#hide") "disabled"))

(defn set-errors [errors]
  (let [options (.-options (.getOption @editor "lint"))]
    (set! (.-cljsErrors options) errors)
    (.signal js/CodeMirror @editor "change" @editor)))

(defn compile
  ([] (compile (.getValue @editor)))
  ([code]
   (.clearGutter @editor "CodeMirror-lint-markers")
   (c/run code (fn [res]
                 (set-errors (remove nil? (conj (:warnings res) (:error res))))))))

(defn get-ns-part [code]
  (loop [[fst & rst] (cstr/trim code)
         accum ""
         balance 0]
    (if (or (and (zero? balance) (not (empty? accum)))
            (nil? fst))
      accum
      (recur rst (str accum fst)
             (+ balance
                (condp contains? fst
                  #{\[ \( \{} 1
                  #{\] \) \}} -1
                  0))))))

(defn complete-selection [ns selection pos]
  (let [line (inc (.-line pos))
        col (.-ch pos)
        append-symbs (fn [st ch n]
                       (apply str st (repeat n ch)))]
    (-> ns
        (append-symbs \newline (- line (count (cstr/split-lines ns))))
        (append-symbs " " (dec col))
        (str selection))))

(defn compile-selected []
  (let [selection (.getSelection @editor)
        code (.getValue @editor)]
    (if (empty? selection)
      (compile code)
      (compile (complete-selection
                (get-ns-part code)
                selection
                (.getCursor @editor "from"))))))

(def popover-template
  "<div id=\"share-dialog\">
    <input value=\"$URL\" class=\"form-control\" readonly=\"readonly\"/>
  </div>")

(defn show-share-dialog [resp]
  (let [path (str "/sketches/show/" (:id resp))
        url (str (.-protocol js/location) "//" (.-host js/location) path)
        el (cstr/replace popover-template "$URL" url)]
    (when-let [history (.-history js/window)]
      (.replaceState history
                     #js {} "" path))
    (.popover (j/$ "#share")
              #js {:container "body"
                   :placement "right"
                   :html true
                   :content el
                   :trigger "manual"})
    (.popover (j/$ "#share") "show")))

(defn share []
  (.popover (j/$ "#share") "destroy")
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
    :success #(.setValue @editor (.-cljs %))})

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

