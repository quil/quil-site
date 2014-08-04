(ns quil-site.sketches
  (:require [compojure.core :refer :all :exclude [routes]]
            [ring.util.response :as resp]
            [net.cgrand.enlive-html :as enlive]))

(defn new-sketch-page []
  "hello")

(defn show-sketch [id])

(defn run-sketch [id])

(def id (atom 0))
(def sketches (atom {}))

(swap! sketches assoc "123" {:js "console.log('123213123');"})

(defn create-sketch [sketch]
  (let [id (swap! id inc)
        sketch (assoc sketch :id id)]
    (swap! sketches assoc id sketch)
    (resp/response {:id id})))

(defn sketch-js [id]
  (-> (@sketches id)
      (:js (format "alert('Hello, world, %s');" id))
      (resp/response)
      (resp/content-type "application/javascript")))

(defroutes routes
  (context "/sketches" []
    (GET "/new" [] (new-sketch-page))
    (GET "/show/:id" [id] (show-sketch id))
    (GET "/run/:id" [id] (run-sketch id))
    (GET "/js/:id" [id] (sketch-js id))
    (POST "/create" req (create-sketch (:body req)))))
