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

(defn group-snippets-by-function [snippets]
  (->> (for [snippet snippets
             fn (:fns snippet)]
         (assoc snippet :fn fn))
       (group-by :fn)))

(def all-fns (edn/read-string (slurp "api-2.7.0.clj")))

(def snippets (edn/read-string (slurp "snippets.clj")))

(def fns-by-categories (split-into-categories all-fns))

(def snippets-by-function (group-snippets-by-function snippets))

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
                              (fns-by-categories category)
                              snippets-by-function)))
    (GET "/:category/:subcategory" [category subcategory]
         (let [category (url->full category)
               subcategory (url->full subcategory)]
          (views/api-subcategory category subcategory
                                 (get-in fns-by-categories
                                         [category subcategory])
                                 snippets-by-function)))))
