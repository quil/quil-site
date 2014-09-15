(ns quil-site.views.api
  (:require [quil-site.views.page :refer [page]]
            [hiccup.page :as p]
            [hiccup.element :as e]
            [hiccup.util :as u]
            [clojure.string :as string]))

(def ^:private index-page-columns
  [["Color" "Typography"]
   ["Image" "Transform" "Rendering" ]
   ["Math" "Data" "State"]
   ["Shape"]
   ["Lights, Camera" "Output"]
   ["Environment" "Input" "Structure"]])

(defn- as-url [str]
  (-> str
      (string/lower-case)
      (string/replace  #"[ &,?]" {" " "-"
                                  "," ""
                                  "&" "and"
                                  "?" "_q"})))

(defn- link
  ([to]
    (link to to))
  ([text to]
     (link text to nil))
  ([text to anchor]
     (let [page (->> (or to "")
                     as-url
                     (str "/api/"))]
      (e/link-to (if anchor
                   (str page "#" (as-url anchor))
                   page)
                 (u/escape-html text)))))

(defn- subcategory-index [cat subcat fns]
  (let [fns (map (fn [{:keys [name type what]}]
                   (if (and (= what :fn) (not= type :both))
                     (let [tooltip (str "Available only in "
                                        (if (= type :clj)
                                          "Clojure"
                                          "ClojureScript")
                                        " version.")
                           type (clojure.core/name type)]
                       [:p.function [:span {:title tooltip}
                                     (link name cat name)
                                     [:sup type]]])
                     [:p.function (link name cat name)]))
                 fns)]
    (if subcat
      (cons [:h4.subcategory (link subcat cat (str subcat "-subcategory"))]
            fns)
      fns)))

(defn- category-index [cat subcats]
  [:div.category-div
   [:h3.category (link cat)]
   (for [[subcat fns] subcats]
     (subcategory-index cat subcat fns))])

(defn api-index [functions]
  (page {:type :api-index
         :tab :api
         :js-files ["/js/api.js"]}
        (for [column index-page-columns]
          [:div.col-md-2.col-sm-4.col-xs-6
           (map #(category-index % (functions %)) column)])))

(defn api-category [name subcats]
  (page {:type :api-category
         :tab :api
         :js-files ["/js/api.js"]}
        name))
