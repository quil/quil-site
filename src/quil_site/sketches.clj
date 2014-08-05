(ns quil-site.sketches
  (:require [compojure.core :refer :all :exclude [routes]]
            [ring.util.response :as resp]
            [hiccup.page :as p]))

(defn new-sketch-page []
  "hello")

(defn show-sketch [id])

(defn sketch-html [id]
  (-> (list [:head
             [:title "Sketch"]
             [:script {:async "async"
                       :src (str "/sketches/js/" id)}]]
            [:body])
      (p/html5)))

(defn run-sketch [id]
  (-> (sketch-html id)
      (resp/response)
      (resp/content-type "text/html")))

(def id (atom 0))
(def sketches (atom {}))

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
