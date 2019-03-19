(ns quil-site.main
  (:require [goog.dom :as dom]
            [goog.dom.classes :as classes]
            [goog.events :as events]
            [goog.events.EventType :as EventType]
            [clojure.string :as cstr]
            [quil.core :as q :include-macros true]
            goog.Uri))

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

(def examples (atom {}))

(defn example-name->link [name]
  (->> (cstr/replace name " " "-")
       (str "/sketches/show/example_")))

(defn should-start-paused? []
  (boolean (query-selector ".container.examples-page")))

(defn setup-play-pause-functionality [host sketch]
  (let [play-button (query-selector host ".play")
        pause-button (query-selector host ".pause")]
    (classes/remove play-button "hidden")
    (classes/remove pause-button "hidden")
    (classes/add pause-button "invisible")
    (events/listen play-button EventType/CLICK
                   (fn []
                     (q/with-sketch sketch
                       (q/start-loop))
                     (classes/add play-button "hidden")
                     (classes/remove pause-button "invisible")))
    (events/listen pause-button EventType/CLICK
                   (fn []
                     (q/with-sketch sketch
                       (q/no-loop))
                     (classes/remove play-button "hidden")
                     (classes/add pause-button "invisible")))))

(defn run-example [example host]
  (let [{:keys [name
                author
                run-fn
                interactive?
                display-name
                white-play-button?]} example
        link (example-name->link name)]
    (when interactive?
      (classes/remove (query-selector host ".glyphicon.hidden")
                      "hidden"))
    (dom/setProperties (query-selector host "a")
                       #js {"href" link})
    (dom/setTextContent (query-selector host ".name")
                        display-name)
    (dom/setTextContent (query-selector host ".author")
                        (str "by " author))
    (let [sketch (run-fn (query-selector host ".canvas-container") 200)]
      (when (should-start-paused?)
        (q/with-sketch sketch
          (q/no-loop))
        (setup-play-pause-functionality host sketch))
      (when white-play-button?
        (classes/add (query-selector host ".play") "white")))))

(defn register-example! [name author run-fn &
                         {:keys [interactive? display-name]
                          :or {interactive? false
                               white-play-button? false}
                          :as st}]
  (let [example (assoc st
                       :name name
                       :author author
                       :run-fn run-fn
                       :display-name (or display-name name))]
    (if-let [host (@examples name)]
      (run-example example host)
      (swap! examples assoc name example))))

(defn enable-tooltips []
  ; I'm lazy to include proper externs now so I will use strings
  ; Please fix it if your eyes are bleeding.
  (let [tooltips ((aget js/window "$")
                  "[data-toggle='tooltip']")]
    (.call (aget tooltips "tooltip")
           tooltips)))

(def available-examples
  ["dancer"
   "dry paint"
   "emerald"
   "matrix"
   "equilibrium"
   "hyper"
   "leaf"
   "colorjoy"
   "nanoscopic"
   "spaceship"
   "tailspin"
   "waves"
   "tree"
   "geometric twinkle"
   "heart"
   "golden ratio flower"
   "floating graph"
   "game of life"
   "ten print"
   "lissajous table"])

(defn get-examples-to-show []
  (let [url (goog.Uri. js/document.URL)
        debug-examples (set (.getParameterValues url "example"))]
    (if (empty? debug-examples)
      (shuffle available-examples)
      debug-examples)))

(defn load-example [name host]
  (swap! examples assoc name host)
  (let [script (dom/createElement "script")
        file-name (str (cstr/replace name " " "_") ".js")]
    (dom/setProperties script
                       #js {"src" (str "/js/examples/" file-name)
                            "async" "async"})
    (dom/append js/document.body script)))

(defn init-about-page []
  (let [[visible invisible] (split-at (num-of-visible-examples)
                                      (query-selector-all ".example"))]
    (doseq [[host example-name] (map vector visible (get-examples-to-show))]
      (if-let [example (@examples example-name)]
        (run-example example host)
        (load-example example-name host)))
    (doseq [host invisible]
      (dom/removeNode host))
    (enable-tooltips)))

(defn init-examples-page []
  (doseq [example-name available-examples]
    (let [host (.cloneNode (query-selector "#template") true)]
      (classes/remove host "hidden")
      (.appendChild (query-selector ".examples") host)
      (.removeAttribute host "id")
      (if-let [example (@examples example-name)]
        (run-example example host)
        (load-example example-name host))))
  (enable-tooltips))

(defn init []
  (cond (query-selector ".container.about")
        (init-about-page)
        (query-selector ".container.examples-page")
        (init-examples-page)))

(events/listenOnce js/window EventType/LOAD init)

; hack to load examples with :optimizations :none
; note that this code should not run under :advanced optimizations
(when goog/DEBUG
  (doseq [example available-examples
          :let [namespace (str "quil_site.examples." (cstr/replace example " " "_"))]]
    ((aget js/goog "require") namespace)))

