(ns quil-site.views.page
  (:require [hiccup.page :as p]
            [hiccup.element :as e]))

(defn- head [opts]
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:http-equiv "X-UA-Compatible"
           :content "IE=edge"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1"}]

   [:title (or (:title opts) "Quil")]

   [:script {:async "async"
             :src "//www.google-analytics.com/analytics.js"}]
   [:script
    "(function(i,s,r){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();
  })(window,document,'ga');

  ga('create', 'UA-51485241-2', 'auto');
  ga('send', 'pageview');"]

   (let [css-files (conj (:css-files opts [])
                         "/css/bootstrap.min.css"
                         "/css/styles.css")]
     (apply p/include-css css-files))])

(defn- make-tab [opts name text url]
  [:li {:class (if (= name (:tab opts))
                 "active" "")}
   (e/link-to url text)])

(defn- body [opts content]
  [:body
   [:div.navbar.navbar-default {:role "navigation"}
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
       (make-tab opts :about "About" "/")
       (make-tab opts :api "API" "/api")
       (make-tab opts :create "Create" "/sketches/create")]]]]

   [:div.container {:class (-> opts :type (or "") name)}
    content]

   (let [js-files (concat ["//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"
                           "/js/bootstrap.min.js"]
                          (:js-files opts []))]
       (apply p/include-js js-files))])

(defn page [opts & content]
  (p/html5 {:lang "en"}
           (list (head opts)
                 (body opts content))))
