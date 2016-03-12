(ns quil-site.views.sketches
  (:require [quil-site.views.page :refer [page]]
            [hiccup.page :as p]
            [clojure.string :as string]))

(defn sketch-page [id]
  (page {:tab :create
         :type :sketch
         :title (str "Quil " id)
         :css-files ["/css/codemirror-5.12.css"
                     "/css/codemirror-5.12-lint.css"]
         :js-files ["/js/codemirror-5.12-clojure_lint_matchbrackets_closebrackets.js"
                    "/js/editor.js"]}

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
           [:textarea#source
            {:data-sketch-id id}]]]
         [:div#result-content.tab-pane
          [:div#result
           [:iframe
            {:src "/iframe.html"
             :style "width: 500px; height: 500px;"}]]]]
))

(defn create-run-sketch-css [[width height]]
  (-> "
  html { height: 100%; }
  body {
    height: 100%;
    margin: 0px;
    overflow: hidden;
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
