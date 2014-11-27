(ns quil-site.views.about
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))

(defn about-page []
  (page {:tab :about
         :type :about
         :js-files ["/js/main.js"]}
        [:div.section
         [:p.lead
          "Clojure/ClojureScript library for creating interactive drawings and animations. Check out " (link-to "/sketches/create" "online sketch") "."]]

        [:div.row.examples
         (for [classes ["col-md-4 col-sm-6 col-xs-12"
                        "col-md-4 col-sm-6 hidden-xs"
                        "col-md-4 hidden-sm hidden-xs"]]
           [:div {:class classes}
            [:div.example
             [:canvas]
             [:div.footer
              [:span.glyphicon.glyphicon-sort.hidden
               {:data-toggle "tooltip"
                :data-placement "bottom"
                :title (str "Interactive. Select to start interacting using "
                            "mouse/keyboard.")}]
              [:a "Source"]
              [:span.author]]]])]

        [:div.section
         [:h3 "Features"]
         [:div.row
          [:div.col-md-6.col-xs-12
           [:dl.features
            [:dt "Clojure and ClojureScript"]
            [:dd "Sketches can be run from clojure or in a browser without modifications."]
            [:dt "2D and 3D"]
            [:dd "Quil provides several renderers that allows to draw in 2D, 3D and even in PDF."]
            [:dt "Based on " (link-to "http://processing.org" "Processing")]
            [:dd "More than 200 various drawing functions."]

            ]]
          [:div.col-md-6.col-xs-12
           [:dl.features
            [:dt "Live reloading"]
            [:dd "Modify sketches on fly without closing them."]
            [:dt "Functional mode"]
            [:dd "Use pure functions to handle user interaction and state updates (" (link-to "https://github.com/quil/quil/wiki/Functional-mode-%28fun-mode%29" "fun-mode") ")."]
            [:dt "Middleware"]
            [:dd "Enhance sketches by creating your own "
             (link-to "https://github.com/quil/quil/wiki/Middleware" "middleware ")
             " or using built-in ones."]]]]]

        [:div.section
         [:h3 "Getting started"]
         [:div.row
          [:div.col-md-6.col-xs-12
           [:h4 "Clojure"]
           [:ol
            [:li "Create project: " [:code "lein new quil my-sketch"]]
            [:li [:code "cd my-sketch"]]
            [:li "Open " [:code "src/my_sketch/core.clj"] ", and evaluate it."]]]
          [:div.col-md-6.col-xs-12
           [:h4 "ClojureScript"]
           [:ol
            [:li "Create project: " [:code "lein new quil-cljs my-sketch"]]
            [:li [:code "cd my-sketch"]]
            [:li "Build the project: "[:code "lein cljsbuild once"]]
            [:li "Open " [:code "web/index.html"]]]]]

         [:p "Check out tutorials for using Quil in "
          (link-to "https://github.com/quil/quil/wiki/Dynamic-Workflow-%28for-LightTable%29" "Light Table")
          " and general "
          (link-to "https://github.com/quil/quil/wiki/Dynamic-Workflow-%28for-REPL%29" "REPL")
          "."]]

        [:div.section
         [:h3 "Documentation and articles"]
         [:ul
          (for [[name link] [["Quil Intro" "http://nbeloglazov.com/2014/05/29/quil-intro.html"]
                             ["API docs" "/api"]
                             ["Project on GitHub" "https://github.com/quil/quil"]
                             ["Wiki articles" "https://github.com/quil/quil/wiki"]
                             ["Age of Middleware" "http://nbeloglazov.com/2014/06/22/quil-age-of-middleware.html"]]]
            [:li (link-to link name)])]]))
