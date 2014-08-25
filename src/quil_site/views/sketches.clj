(ns quil-site.views.sketches
  (:require [quil-site.views.page :refer [page]]))

(defn create-sketch-page []
  (page {:tab :create
         :type :sketch}
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
