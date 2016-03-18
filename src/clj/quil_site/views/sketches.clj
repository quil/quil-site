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

        [:div.btn-group
         [:button#send.btn.btn-primary "Run"]
         [:button#reset.btn "Reset"]
         [:button#share.btn "Share"]]

        [:div#content
         [:div#source-content
          [:div
           [:textarea#source
            {:data-sketch-id id}]]]
         [:div#result-content
          {:style "width: 500px; height: 500px;"}
          [:iframe
           {:src "/iframe.html"}]]]))
