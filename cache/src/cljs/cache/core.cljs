(ns cache.core
  (:require [cljs.nodejs :as nodejs]
            cljs.js
            [clojure.string :as cstr]
            [cljs.reader :as r]
            [cljs.pprint :as pprint]))

(nodejs/enable-util-print!)

(def fs (nodejs/require "fs"))
(def http (nodejs/require "http"))

(defn read-stream [stream cb]
  (let [buffer (atom "")]
    (doto stream
      (.on "data" (fn [chunk]
                    (swap! buffer str chunk)))
      (.on "end" #(cb @buffer)))))

(def ignore-lib
  #{"clojure.string"
    "cljsjs.p5"
    "goog.style"
    "goog.dom"
    "goog.events"
    "goog.events.EventType"})

(defn send-get [path cb]
  (.get http (str "http://localhost:7788/" path)
        (fn [res]
          (if (= (.-statusCode res) 200)
            (read-stream res (fn [content]
                               (cb {:value content})))
            (cb {:error (str "Server returned " (.-statusCode res)
                             " for path " path)})))))

(defn read-source [file cb]
  (println "Reading " file)
  (send-get file (fn [res]
                   (if (:value res)
                     (println "Success for" file)
                     (println "Failure for" file (:error res)))
                   (cb res))))

(defn write-file [file content]
  (.writeFileSync fs file content "utf8"))

(defn try-read-extensions [file [ext & rst] cb]
  (if ext
    (read-source
     (str file "." ext)
     (fn [res]
       (if (:value res)
         (cb res)
         (try-read-extensions file rst cb))))
    (cb {:error (str "No source found for file " file)})))

(defn map-value [f map]
  (into {}
        (for [[k v] map]
          [k (f v)])))

(def caches (atom {}))

(defn strip-cache [cache]
  (letfn [(strip-meta [meta]
            (select-keys
             meta [:macro :top-fn]))
          (strip-def [def]
            (-> def
                (select-keys [:macro :variadic :protocol-impl
                              :max-fixed-arity :fn-var :name :meta
                              :method-params])
                (update :meta strip-meta)))]
    (-> cache
        (update :defs #(map-value strip-def %)))))

(defn cache-name [filename macros source?]
  (str "cache/" filename (if macros "_macros" "") (if source? ".js" ".edn")))

(defn save-cache [{:keys [name path source cache]}]
  (let [macros (-> (:name cache)
                   clojure.core/name
                   (.indexOf "$macros")
                   pos?)]
    (swap! caches assoc
           {:name name :macros macros}
           {:cache (strip-cache cache) :source source})))

(def load-quil-sketch (atom false))

(defn load-library-quil [{:keys [name macros]} cb]
  (println "Loading" name "macros" macros)
  (let [filename (-> (str name)
                     (cstr/replace "." "/")
                     (cstr/replace "-" "_"))
        exts (if macros
               ["clj" "cljc"]
               ["cljs" "cljc"])]
    (if (or (ignore-lib (str name))
            (and (= (str name) "quil.sketch")
                 (not macros)
                 (not @load-quil-sketch)))
      (cb {:lang :clj :source
           (if (= name 'clojure.string) "" (str "(ns " name ")"))})
      (try-read-extensions filename exts
                           (fn [res]
                             (if (:value res)
                               (cb {:lang :clj :source (:value res)})
                               (cb res)))))))


(set! js/window #js {})

(def block (str (cstr/join \newline (repeat 3 "#################"))
                \newline))

(defn write-caches [f]
  (println "Writing caches")
  (let [sk-cache ((-> f :state deref :cljs.analyzer/namespaces) 'quil.sketch)]
    (swap! caches assoc {:name 'quil.sketch :macros false} {:cache (strip-cache sk-cache)
                                                            :source ""}))

  (write-file "quil-cache.edn" (pr-str @caches))
  (let [core-cache (:cljs.analyzer/namespaces @(cljs.js/empty-state))]
    (write-file "core-cache.edn" (pr-str (map-value strip-cache core-cache))))
  (if (:value f)
    (println "Success!")
    (println "Something went wrong" f)))

(defn compile [str cb]
  (reset! cljs.js/*loaded* #{'clojure.string})
  (let [state (cljs.js/empty-state)]
   (cljs.js/compile-str
    state str "test"
    {:eval (fn [res]
             (cljs.js/js-eval res))
     :load load-library-quil
     :verbose false
     :load-macros (not @load-quil-sketch)
     :cache-source #(do (println "Cache" (:name %1))
                        (save-cache %1)
                        (%2 {:value nil}))}
    (fn [res] (cb (assoc res :state state))))))

(defn compile-quil-core [cb]
  (println "########")
  (println "Compiling quil.core")
  (compile "(ns my.foo (:require-macros [quil.core]))
            (quil.core/defsketch my
              :size [500 500])"
           #(do
              (println "Finished compiling quil.core")
              (cb))))

(defn compile-quil-sketch [cb]
  (println "########")
  (println "Compiling quil.sketch")
  (reset! load-quil-sketch true)
  (compile "(ns my.foo (:require [quil.sketch])) (+ 1 1)"
           #(do
              (println "Finished compiling quil.sketch")
              (cb %)
              )))

(defn -main [& args]
  (reset! cljs.js/*loaded* #{'clojure.string})
  (compile-quil-core #(compile-quil-sketch write-caches)))

(set! *main-cli-fn* -main)
