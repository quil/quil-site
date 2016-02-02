(ns quil-site.storage
  (:require [clj-http.client :as http]
            [cheshire.core :refer [generate-string]]
            [clojure.tools.reader.edn :as edn]
            [clojure.java.io :as io]
            [pandect.algo.sha256 :as sha256]))

(def keys-map (try (edn/read-string (slurp "keys.clj"))
                   (catch Exception e {})))

(def url (str (:url keys-map "local")
              "/"
              (:path keys-map "sketchesDev")))

(def local-url "local/sketchesDev")
(def local-db (atom {}))
(def local-id (atom 1))

(defn- create-object [object]
  (-> (str url ".json")
    (http/post {:body (generate-string object)
                :as :json})
    :body
    :name))

(defn- find-object-by-hash [object]
  (:body (http/get (str url ".json")
                   {:query-params {"orderBy" "\"hash\""
                                   "equalTo" (str \" (:hash object) \")}
                    :as :json})))

(defn- get-object [id]
  (:body (http/get (str url "/" id ".json") {:as :json})))

(defn- save-source-in-firebase [source]
  (let [obj {:source source
             :hash (sha256/sha256 source)}]
    (if-let [existing-id (-> obj find-object-by-hash first first)]
      (name existing-id)
      (create-object obj))))

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
  (if (= url local-url)
    (save-source-local source)
    (save-source-in-firebase source)))

(defn load-source [id]
  (if (= url local-url)
    (load-source-local id)
    (load-source-from-firebase id)))

(comment

  (create-object {:source "worldddd" :hash "12345"})

  (get-object "fSv6r7DNPd")

  (find-object-by-hash {:source "sdf" :hash "12345"})

  (save-source "sdfff")

  (do
    (require 'quil-site.controllers.sketches)
    (def source quil-site.controllers.sketches/test-source))


  )
