(ns quil-site.storage
  (:require [clj-http.client :as http]
            [cheshire.core :refer [generate-string]]
            [clojure.tools.reader.edn :as edn]
            [clojure.data.codec.base64 :as b64]
            [clojure.java.io :as io])
  (:import [java.io ByteArrayOutputStream ByteArrayInputStream]
           [java.util.zip GZIPOutputStream GZIPInputStream]))

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

  (create-object {:hello "worldddd"})

  (get-object "fSv6r7DNPd")

  (do
    (require 'quil-site.controllers.sketches)
    (def source quil-site.controllers.sketches/test-source))
  (count (string->gzip->base64 s))

  )
