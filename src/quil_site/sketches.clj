(ns quil-site.sketches
  (:require [compojure.core :refer :all :exclude [routes]]
            [ring.util.response :as resp]
            [hiccup.page :as p]
            [cljs.closure :as cljs]
            [cljs.env :as cljs-env]
            [me.raynes.fs :as fs]))

(def cljs-compilation-dir (fs/temp-dir "cljs-compilation"))

(defn compile-cljs [cljs-text]
  (let [source (fs/temp-file "cljs-source" "cljs")
        compiled (fs/temp-file "cljs-compiled")]
    (spit source cljs-text)
    (cljs/build source
                {:optimizations :simple
                 :output-to (.getAbsolutePath compiled)
                 :output-dir (.getAbsolutePath cljs-compilation-dir)
                 :externs ["externs/processing.js"]
                 :preamble ["processing.min.js"]
                 :pretty-print true})
    (let [compiled-text (slurp compiled)]
      (fs/delete source)
      (fs/delete compiled)
      compiled-text)))

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
  (let [id (str (swap! id inc))
        js (-> sketch :cljs compile-cljs)
        sketch (assoc sketch
                      :id id
                      :js js)]
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
