(ns quil-site.views.examples
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))

(defn examples-page []
  (page {:tab :examples
         :type :examples-page
         :js-files ["/js/main.js"]
         :title "Quil Examples"}
        [:div.row.examples
         [:div#template {:class "col-md-4 col-sm-6 col-xs-12 hidden"}
          [:div.example
           [:div.name]
           [:div.author]
           [:div.canvas-container
            [:div.play.hidden]]
           [:div.footer
            [:span.glyphicon.glyphicon-sort.hidden
             {:data-toggle "tooltip"
              :data-placement "bottom"
              :title (str "Interactive. Select to start interacting using "
                          "mouse/keyboard.")}]
            [:a "source"]
            [:span.glyphicon.glyphicon-pause.hidden.pause]]]]]))
