(ns quil-site.views.sketches
  (:require [quil-site.views.util :refer [page]]))

(defn create-sketch-page []
  (page [:div#input-area
         [:textarea#source]
         [:button#send "Send"]]
        [:iframe#result]))
