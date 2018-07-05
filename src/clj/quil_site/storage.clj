(ns quil-site.storage
  (:require [clj-http.client :as http]
            [cheshire.core :refer [generate-string]]
            [clojure.tools.reader.edn :as edn]
            [clojure.java.io :as io]
            [pandect.algo.sha256 :as sha256]))

;;; keys.clj contains necessary keys for connecting to
;;; Firebase. It should contain :url, :path and :access-token
;;; params. To generate :access-token follow this tutorial:
;;; https://firebase.google.com/docs/database/rest/auth?authuser=0
(def keys-map (try (edn/read-string (slurp "keys.clj"))
                   (catch Exception e {})))

(def base-firebase-url (str (:url keys-map "local")
                   "/"
                   (:path keys-map "sketchesDev")))

(def local-url "local/sketchesDev")
(def local-db (atom {}))
(def local-id (atom 1))

(defn- create-object [id object]
  (let [url (str base-firebase-url "/" id ".json?print=pretty")
        query-params {"print" "silent"
                      "access_token" (:access-token keys-map)}]
   (->(http/put url {:body (generate-string object)
                     :as :json
                     :query-params query-params})
       :body
       :name)))

(defn- get-object [id]
  (let [url (str base-firebase-url "/" id ".json")
        query-params {"access_token" (:access-token keys-map)}]
    (:body (http/get url
                     {:as :json
                      :query-params query-params}))))


(defn- save-source-in-firebase [source]
  (let [id (sha256/sha256 source)]
    (create-object id {:source source} )
    id))

(defn- load-source-from-firebase [id]
  (try
    (-> id get-object :source)
    (catch Exception e
      nil)))

(defn- save-source-local [source]
  (let [id (str (swap! local-id inc))]
    (swap! local-db assoc id source)
    id))

(defn- load-source-local [id]
  (@local-db id))

(defn save-source [source]
  (if (= base-firebase-url local-url)
    (save-source-local source)
    (save-source-in-firebase source)))

(defn load-source [id]
  (if (= base-firebase-url local-url)
    (load-source-local id)
    (load-source-from-firebase id)))

(comment

  (create-object {:source "worldddd" :hash "12345"})

  (get-object "fSv6r7DNPd")

  (save-source "sdfff")

  (do
    (require 'quil-site.controllers.sketches)
    (def source quil-site.controllers.sketches/test-source))


  )
