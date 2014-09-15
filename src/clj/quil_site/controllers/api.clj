(ns quil-site.controllers.api
  (:require [compojure.core :refer :all :exclude [routes]]
            [compojure.route :refer [not-found]]
            [ring.util.response :as resp]
            [quil-site.views.api :as views]
            [clojure.tools.reader.edn :as edn]
            [clojure.tools.reader.reader-types :refer [string-push-back-reader]]))

(defn map-map [f map]
  (into {} (for [[k v] map] [k (f v)])))

(defn split-into-categories [functions]
  (let [categories (->> functions
                        vals
                        (group-by :category))]
    (map-map #(group-by :subcategory %) categories)))

(def all-fns (edn/read-string (slurp "api-2.2.2.clj")))

(def fns-by-categories (split-into-categories all-fns))

(defroutes routes
  (context "/api" []
    (GET "/" [] (views/api-index fns-by-categories))
    (GET "/:category" [category] (views/api-category category
                                                     (fns-by-categories category)))))
