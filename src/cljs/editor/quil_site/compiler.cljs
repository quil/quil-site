(ns quil-site.compiler
  (:require [cljs.js :as cjs]
            [cljs.analyzer :as ana :include-macros true]
            [cljs.reader :as r]
            [cljs.pprint :as pprint]
            [goog.events :as events]
            [goog.Promise :as Promise]
            [goog.events.EventType :as EventType]
            [quil-site.parser :as p])
  (:import goog.net.XhrIo))

(defn fetch-file!
  "Very simple implementation of XMLHttpRequests that given a file path
  calls src-cb with the string fetched of nil in case of error.

  See doc at https://developers.google.com/closure/library/docs/xhrio"
  [file-url src-cb]
  (try
    (.send XhrIo file-url
           (fn [e]
             (if (.isSuccess (.-target e))
               (src-cb (.. e -target getResponseText))
               (src-cb nil))))
    (catch :default e
      (src-cb nil))))

(def macros-loaded (Promise/withResolver))
(def core-loaded (Promise/withResolver))
(def all-loaded (Promise/all #js [(.-promise macros-loaded)
                                  (.-promise core-loaded)]))

(def cached-macros (atom {}))

(set! js/Processing
      #js {"prototype" #js {"PConstants" #js {}}})
(set! js/window #js {})

(fetch-file! "/quil-cache.edn"
             #(do
                (.resolve macros-loaded)
                (reset! cached-macros (r/read-string %))))

(def core-cache (atom nil))

(fetch-file! "/core-cache.edn" #(do
                                  (.resolve core-loaded)
                                  (reset! core-cache (r/read-string %))))

(defn load-macros-ns [{:keys [name macros] :as opts} cb]
  (if-let [{:keys [source cache]} (@cached-macros
                                   {:name name
                                    :macros (boolean macros)})]
    (cb {:lang :js
         :source source
         :cache cache})
    (cb {:lang :clj
         :source ""})))

(defn convert-warning [warning]
  (let [{:keys [type env extra]} warning]
    {:message (ana/error-message type extra)
     :type :warning
     :line (:line env)
     :column (:column env)}))

(def state (atom nil))

(defn reset-state! []
  (reset! state (cjs/empty-state))
  (cjs/load-analysis-cache!
   @state 'cljs.core (@core-cache 'cljs.core)))

(defn compile [source cb]
  (when (nil? @state)
    (reset-state!))
  (let [warnings (atom [])]
    (ana/with-warning-handlers [(fn [type env extra]
                                  (swap! warnings conj
                                         {:type type
                                          :env env
                                          :extra extra}))]
      (cjs/compile-str @state source nil
                       {:load load-macros-ns
                        :eval cjs/js-eval
                        :verbose false}
                       #(cb (assoc % :warnings
                                   (map convert-warning @warnings)))))))

(defn run [source cb]
  (compile source (fn [res]
                    (when-let [value (:value res)]
                      (.postMessage (.-contentWindow (.querySelector js/document "iframe"))
                                    #js {:type "eval"
                                         :source (:value res)}
                                    "*"))
                    (cb (update res
                                :error p/convert-error)))))

(goog/exportSymbol "compile" #(compile % (fn [res]
                                           (println res))))
(goog/exportSymbol "run" run)
