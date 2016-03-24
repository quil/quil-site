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
    (map-map #(->> %
                   (sort-by :name)
                   (group-by :subcategory)
                   (into (sorted-map)))
             categories)))

(def all-fns (edn/read-string (slurp "api-2.4.0.clj")))

(def fns-by-categories (split-into-categories all-fns))

(def url->full (->> (concat (keys fns-by-categories)
                            (mapcat keys (vals fns-by-categories)))
                    (remove nil?)
                    (map #(vector (views/as-url %) %))
                    (into {})))

(defroutes routes
  (context "/api" []
    (GET "/" [] (views/api-index fns-by-categories))
    (GET "/:category" [category]
         (let [category (url->full category)]
          (views/api-category category
                              (fns-by-categories category))))
    (GET "/:category/:subcategory" [category subcategory]
         (let [category (url->full category)
               subcategory (url->full subcategory)]
          (views/api-subcategory category subcategory
                                 (get-in fns-by-categories
                                         [category subcategory]))))))
