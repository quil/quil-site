(ns quil-site.storage
  (:require [clj-http.client :as http]
            [cheshire.core :refer [generate-string]]
            [clojure.tools.reader.edn :as edn]))

(def keys-map (edn/read-string (slurp "keys.clj")))

(defn request [method keys path body]
  (:body
   (http/request {:method method
                  :url (str "https://api.parse.com/1/classes/" path)
                  :headers {"X-Parse-Application-Id" (:app-key keys)
                            "X-Parse-REST-API-Key" (:rest-key keys)}
                  :body body
                  :as :json})))

(defn create-object [object]
  (request :post keys-map "Sketch" (generate-string object)))

(defn get-object [id]
  (request :get keys-map (str "Sketch/" id) nil))

(comment

  (create-object {:hello "worldddd"})

  (get-object "fSv6r7DNPd"))
