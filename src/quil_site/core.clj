(ns quil-site.core
  (:require [compojure.core :as cmpj]
            [compojure.handler :refer [site]]
            [ring.middleware.json :as json]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.stacktrace :as stacktrace]
            [quil-site.sketches :as sketches]))

(cmpj/defroutes app
  sketches/routes)

(defn dump-request [handler]
  (fn [req]
    (clojure.pprint/pprint req)
    (handler req)))

(def handler
  (-> app
      dump-request
      site
      json/wrap-json-body
      json/wrap-json-response
      stacktrace/wrap-stacktrace))

(def server (run-jetty #(handler %) {:port 8080 :join? false}))
#_(.stop server)
