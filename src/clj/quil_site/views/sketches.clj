(ns quil-site.views.sketches
  (:require [quil-site.views.page :refer [page]]
            [hiccup.page :as p]))

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
          [:button#send.btn.btn-primary "Run"]
          [:button#reset.btn "Reset"]
          [:button#share.btn "Share"]]]

        [:div.tab-content
         [:div#source-content.tab-pane.active
          [:div
           [:textarea#source
            {:data-sketch-id id}]]]
         [:div#result-content.tab-pane
          [:div#result
           [:iframe
            {:src "/iframe.html"
             :height "500"
             :width "500"}]]]]))
