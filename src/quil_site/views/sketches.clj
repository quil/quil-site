(ns quil-site.views.sketches
  (:require [quil-site.views.page :refer [page]]))

(defn create-sketch-page []
  (page {:tab :create
         :type :sketch
         :css-files ["/codemirror-4.5/lib/codemirror.css"]
         :js-files ["/codemirror-4.5/lib/codemirror.js"
                    "/codemirror-4.5/mode/clojure/clojure.js"
                    "/js/sketch.js"]}
        [:div.row
         [:div.col-md-6
          [:div
           [:a#send.btn.btn-primary.btn-sm
            {:href "#"} "Run"]]
          [:div
           [:textarea#source]]]
         [:div.col-md-6
          [:iframe#result.hidden]
          [:img#ajax-status.hidden {:src "/img/sketch_loading.gif"}]]]))
