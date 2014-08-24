(ns quil-site.views.util
  (:require [hiccup.page :as p]
            [hiccup.element :as e]))

(defn- head []
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:http-equiv "X-UA-Compatible"
           :content "IE=edge"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1"}]

   [:title "Quil"]

   (p/include-css "/css/bootstrap.min.css" "/css/styles.css")])

(defn- body [content]
  [:body
   [:div.navbar.navbar-inverse.navbar-fixed-top {:role "navigation"}
    [:div.container
     [:div.navbar-header
      [:button.navbar-toggle {:type "button"
                              :data-toggle "collapse"
                              :data-target ".navbar-collapse"}
       [:span.sr-only "Toggle navigation"]
       [:span.icon-bar]
       [:span.icon-bar]
       [:span.icon-bar]]
      [:a.navbar-brand {:href "/"} "Quil"]]

     [:div.collapse.navbar-collapse
      [:ul.nav.navbar-nav
       [:li.active (e/link-to "/" "About")]
       [:li.api (e/link-to "http://quil.info" "API")]
       [:li.create (e/link-to "/sketches/create" "Create")]]]]]

   [:div.container
    [:div.starter-template content]]
   (p/include-js "//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" "/js/bootstrap.min.js" "/js/script.js")])

(defn page [& content]
  (p/html5 {:lang "en"}
           (list (head)
                 (body content))))
