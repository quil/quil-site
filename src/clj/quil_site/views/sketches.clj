(ns quil-site.views.sketches
  (:require [quil-site.views.page :refer [page]]
            [hiccup.page :as p]
            [clojure.string :as string]))

(defn create-sketch-page []
  (page {:tab :create
         :type :sketch
         :css-files ["/codemirror-4.5/lib/codemirror.css"
                     "/codemirror-4.5/addon/lint/lint.css"]
         :js-files ["/codemirror-4.5/lib/codemirror.js"
                    "/codemirror-4.5/mode/clojure/clojure.js"
                    "/codemirror-4.5/addon/lint/lint.js"
                    "/js/sketch.js"]}

        [:ul.nav.nav-tabs {:role "tablist"}
         [:li.active [:a#source-tab {:href "#"
                                     :role "tab"
                                     :data-target "#source-content"
                                     :data-toggle "tab"}
                      "Source"]]
         [:li [:a#result-tab {:href "#"
                              :role "tab"
                              :data-target "#result-content"
                              :data-toggle "tab"}
               "View"]]
         [:div.btn-group
           [:button#send.btn.btn-primary "Run"]]]

        [:div.tab-content
         [:div#source-content.tab-pane.active
          [:div
           [:textarea#source]]]
         [:div#result-content.tab-pane
          [:div#result.hidden
           [:a "Link"]
           [:iframe]]
          [:div#ajax-status.hidden
           [:img {:src "/img/sketch_loading.gif"}]
           [:h3 "Compiling"]]]]
))

(defn create-run-sketch-css [[width height]]
  (-> "
  html { height: 100%; }
  body {
    height: 100%;
    margin: 0px;
    overflow: hidden;
    position: relative;
  }
  canvas {
    display: block;
    width: $WIDTH$px;
    height: $HEIGHT$px;
    position: relative;
    top: 50%;
    left: 50%;
    margin-left: -$HALF-WIDTH$px;
    margin-top: -$HALF-HEIGHT$px;
  }"
      (string/replace "$WIDTH$" (str width))
      (string/replace "$HEIGHT$" (str height))
      (string/replace "$HALF-WIDTH$" (str (quot width 2)))
      (string/replace "$HALF-HEIGHT$" (str (quot height 2)))))

(defn create-run-sketch-page [id size]
  (let [css (create-run-sketch-css size)
        head [:head
                 [:title "Sketch"]
                 [:script {:src "/js/preload.js"}]
                 [:script {:src (str "/sketches/js/" id)}]
                 [:style {:type "text/css"} css]]
        body [:body]]
    (p/html5 {:lang "en"}
             (list head body))))
