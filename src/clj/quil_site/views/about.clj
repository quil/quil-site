(ns quil-site.views.about
  (:require [quil-site.views.page :refer [page]]))

(defn about-page []
  (page {:tab :about
         :type :about}
        [:h1 "Bootstrap starter template"]
        [:p.lead
         "Use this document as a way to quickly start any new project."
         [:br]
         "All you get is this text and a mostly barebones HTML document."]))
