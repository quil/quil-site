(ns quil-site.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.handler :refer [site]]
            [compojure.route :refer [files]]
            [ring.middleware.json :as json]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.stacktrace :as stacktrace]
            [quil-site.sketches :as sketches]
            [quil-site.views.about :refer [about-page]]))

(defroutes app
  (GET "/" [] (about-page))
  sketches/routes
  (files "/"))

(defn dump-request [handler]
  (fn [req]
    (clojure.pprint/pprint req)
    (handler req)))

(def handler
  (-> #'app
      dump-request
      site
      (json/wrap-json-body {:keywords? true})
      json/wrap-json-response
      stacktrace/wrap-stacktrace))

(defn run []
  (run-jetty handler {:port 8080}))

(comment

 (def server (run-jetty #(handler %) {:port 8080 :join? false}))

 (.stop server)

)
