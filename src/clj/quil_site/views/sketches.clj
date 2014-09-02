(ns quil-site.views.sketches
  (:require [quil-site.views.page :refer [page]]))

(defn create-sketch-page []
  (page {:tab :create
         :type :sketch
         :css-files ["/codemirror-4.5/lib/codemirror.css"]
         :js-files ["/codemirror-4.5/lib/codemirror.js"
                    "/codemirror-4.5/mode/clojure/clojure.js"
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
          [:iframe#result.hidden]
          [:div#ajax-status.hidden
           [:img {:src "/img/sketch_loading.gif"}]
           [:h3 "Compiling"]]]]
))
