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
   ["Lights, Camera" "Environment"]
   ["Input" "Output" "Structure" "Middleware"]])

(defn as-url [str]
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
     (let [page (if to
                  (str "/api/" (as-url to))
                  "")]
      (e/link-to (if anchor
                   (str page "#" (as-url anchor))
                   page)
                 (u/escape-html text)))))

(defn- render-type-specific [host content type what]
  (if (and (= what :fn) (not= type :both))
    (let [tooltip (str "Available only in "
                       (if (= type :clj)
                         "Clojure"
                         "ClojureScript")
                       " version.")
          type (clojure.core/name type)]
      [host [:span {:title tooltip}
                    content
                    [:sup type]]])
    [host content]))

(defn- render-subcategory-index [cat subcat fns]
  (let [fns (map (fn [{:keys [name type what]}]
                   (let [fn-link (link name
                                       (if subcat
                                         (str cat "/" subcat)
                                         cat)
                                       name)]
                    (render-type-specific :p.function fn-link
                                          type what)))
                 fns)]
    (if subcat
      (cons [:h4.subcategory (link subcat (str cat "/" subcat))]
            fns)
      fns)))

(defn- render-category-index [cat subcats]
  [:div.category-div
   [:h3.category (link cat)]
   (for [[subcat fns] subcats]
     (render-subcategory-index cat subcat fns))])

(defn api-index [functions]
  (page {:type :api
         :tab :api
         :title "Quil API"
         :js-files ["/js/api.js"]}
        (for [column index-page-columns]
          [:div.col-md-2.col-sm-4.col-xs-6
           (map #(render-category-index % (functions %)) column)])))

(defn- trim-docstring
  "Removes extra spaces in the begginning of dostringing lines."
  [dostringing]
  (->> (string/split dostringing #"\n")
       (map #(string/replace % #"^  " ""))
       (string/join "\n")))

(defn- render-function [fn]
  (let [{:keys [name args subcategory docstring link type what
                processing-name requires-bindings category ns]} fn
        args (map #(if (vector? %) {:value % :type :both} %)
                  args)
        fields {:arguments
                (for [{:keys [value type]} args]
                  (render-type-specific :span.arg [:code (pr-str value)]
                                         type what))

                :docstring
                [:pre.docstring (trim-docstring docstring)]

                :binding?
                (if requires-bindings "Yes" "No")

                :original-name
                (if processing-name
                  (if link
                    [:span (e/link-to link processing-name)]
                    [:span processing-name])
                  "None. It is present only in Quil.")}]
    [:div.function-doc {:id (as-url name)}
     (render-type-specific :h3 (str
                                (if ns (str ns "/") "")
                                name) type what)
     [:div.row
      [:div.col-md-7.col-xs-12
       [:dl
        [:dt "Arguments"] [:dd (:arguments fields)]
        [:dt "Docstring"] [:dd (:docstring fields)]]]
      [:div.col-md-5.col-xs-12
       [:dl
        [:dt "Works only inside sketch functions?"] [:dd (:binding? fields)]
        [:dt "Original Processing method"] [:dd (:original-name fields)]]]]
     [:div.row
      [:div.col-xs-12.snippet
       [:dl
        [:dt "Example"]
        [:dd {:data-function-name name}]]]]]))

(defn- render-function-index [{:keys [name type what]}]
  (render-type-specific :p.function (link name nil name)
                        type what))

(defn page-options [name]
  {:type :api
   :tab :api
   :title (str "Quil API " name)
   :css-files ["/css/codemirror-5.12.css"]
   :js-files ["/js/api.js"
              "/js/codemirror-5.12-clojure_lint_matchbrackets_closebrackets.js"
              "/js/snippets.js"]})

(defn api-category [cat subcats]
  (page (page-options cat)
        [:ol.breadcrumb
         [:li (e/link-to "/api" "Index")]
         [:li.active cat]]
        (for [subcat (keys subcats)
              :when subcat]
          [:h4.subcategory (link subcat (str cat "/" subcat))])
        [:div.function-index
         (map render-function-index (subcats nil))]
        (map render-function (subcats nil))))

(defn api-subcategory [cat subcat fns]
  (page (page-options subcat)
        [:ol.breadcrumb
         [:li (e/link-to "/api" "Index")]
         [:li (link cat)]
         [:li.active subcat]]
        [:div.function-index
         (map render-function-index fns)]
        (map render-function fns)))
