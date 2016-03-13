(ns quil-site.examples
  (:require [clojure.java.io :as io]
            [clojure.string :as cstr]))

(defn delete-internal-parts [source]
  (cstr/replace source #"(?m)^.*?;DELETE\n" ""))

(defn replace-sketch-with-defsketch [source name]
  (cstr/replace source #"q/sketch" (str "q/defsketch " name)))

(defn set-size-and-host [source]
  (-> source
      (cstr/replace #":host host" ":host \"host\"")
      (cstr/replace #":size \[size size\]" ":size [500 500]")))

(defn get-example-source
  "Find example on classpath and return it's source. Does some
  processing so example can be run as it is."
  [name]
  (if-let [res (-> name
                   (cstr/replace #"-" "_")
                   (str ".cljs")
                   (io/resource))]
    (-> (slurp res)
        delete-internal-parts
        (replace-sketch-with-defsketch name)
        set-size-and-host
        cstr/trim)
    nil))

