(ns quil-site.storage
  (:require [clj-http.client :as http]
            [cheshire.core :refer [generate-string]]
            [clojure.tools.reader.edn :as edn]
            [clojure.data.codec.base64 :as b64]
            [clojure.java.io :as io]
            [pandect.algo.sha256 :as sha256])
  (:import [java.io ByteArrayOutputStream ByteArrayInputStream]
           [java.util.zip GZIPOutputStream GZIPInputStream]))

(def keys-map (edn/read-string (slurp "keys.clj")))

(def headers {"X-Parse-Application-Id" (:app-key keys-map)
              "X-Parse-REST-API-Key" (:rest-key keys-map)})

(def url (str "https://api.parse.com/1/classes/"
              (:class keys-map "SketchDev")))

(defn- create-object [object]
  (:body (http/post url {:headers headers
                         :body (generate-string object)
                         :as :json})))

(defn- find-object-by-hash [object]
  (:body (http/get url {:headers headers
                        :query-params {"where" (generate-string
                                                {:hash (:hash object)})}
                        :as :json})))

(defn- get-object [id]
  (:body (http/get (str url "/" id) {:headers headers
                                     :as :json})))

(defn save-source [source]
  (let [obj {:source source
             :hash (sha256/sha256 source)}]
    (if-let [existing (-> (find-object-by-hash obj)
                          :results
                          first)]
      (:objectId existing)
      (:objectId (create-object obj)))))

(defn load-source [id]
  (try
    (-> id get-object :source)
    (catch Exception e
      nil)))

(defn string->gzip->base64 [text]
  (let [out (ByteArrayOutputStream.)
        gzip (GZIPOutputStream. out)]
    (.write gzip (.getBytes text "UTF-8"))
    (.close gzip)
    (String. (b64/encode (.toByteArray out)) "UTF-8")))

(defn base64->gzip->string [base64-text]
  (->> (.getBytes base64-text "UTF-8")
       (b64/decode)
       (ByteArrayInputStream.)
       (GZIPInputStream.)
       (slurp)))

(comment

  (create-object {:hello "worldddd" :hash "12345"})

  (get-object "fSv6r7DNPd")

  (find-object-by-hash {:hash "12345"})

  (save-source "sdf")

  (do
    (require 'quil-site.controllers.sketches)
    (def source quil-site.controllers.sketches/test-source))
  (count (string->gzip->base64 s))

  )
