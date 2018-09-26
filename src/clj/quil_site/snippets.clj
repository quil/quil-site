(ns quil-site.snippets
  "Utility namespace to get snippets from snippets.clj.
  Snippets are small pieces of code demonstrating how to
  use particular function."
  (:require [clojure.tools.reader.edn :as edn]
            [clojure.string :as string]
            [zprint.core :as zp]))

(defn- group-snippets-by-function [snippets]
  (->> (for [snippet snippets
             fn (:fns snippet)]
         (assoc snippet :fn fn))
       (group-by :fn)))

(def ^:private snippets (edn/read-string (slurp "snippets-data.clj")))

(def ^:private zprint-options
  {:parse-string-all? true
   :fn-map {"q/with-translation" :arg1-force-nl
            "q/with-graphics" :arg1-force-nl
            "q/with-fill" :arg1-force-nl
            "q/with-stroke" :arg1-force-nl
            "q/with-rotation" :arg1-force-nl}})

(defn pretty-print-snippet-code [code]
  (let [; Remove first and last parentheses
        code (subs code 1 (dec (count code)))]
    (zp/zprint-str code 80 zprint-options)))

(def snippets-by-function (group-snippets-by-function snippets))

(defn- parse-snippet-name [snippet-name]
  (let [snippet-name (-> snippet-name
                         (string/lower-case)
                         (string/replace "_q" "?"))
        separator (string/index-of snippet-name "_")]
    (if (nil? separator)
      [snippet-name 0]
      [(subs snippet-name 0 separator)
       (Integer/parseInt (subs snippet-name (inc separator)))])))

(defn- add-spaces-to-each-line [text num-spaces-to-add]
  (let [spaces (apply str (repeat num-spaces-to-add " "))]
    (as-> text v
      (string/split-lines text)
      (map #(str spaces %) v)
      (string/join "\n" v))))

(defn get-snippet-as-full-sketch-source
  "Given name of snippet returns string representing this
  snippet as full sketch with ns, setup, draw, defsketch and other stuff.
  Name of snippet should be function name and optional _ind representing index
  of the snippet if it's not the first one."
  [snippet-name]
  (let [[fn-name ind] (parse-snippet-name snippet-name)
        snippet (as-> fn-name v
                  (snippets-by-function v)
                  (filter #(= (:target %) :cljs) v)
                  (nth v ind))
        {:keys [opts draw setup]} snippet
        has-setup? (not= setup "()")]

    (str "(ns my.core
  (:require [quil.core :as q :include-macros true]))\n\n"

         (if has-setup?
           (str "(defn setup []\n"
                (-> (str "(" setup ")")
                    (pretty-print-snippet-code)
                    (add-spaces-to-each-line 2))
                ")\n\n")
           "")

         "(defn draw []\n"
         (-> (pretty-print-snippet-code draw)
             (add-spaces-to-each-line 2))
         ")\n\n"

         "(q/defsketch my
  :host \"host\"
  :size [500 500]\n"

         (if (:renderer opts)
           (str "  :renderer " (:renderer opts) "\n")
           "")

         (if has-setup?
           "  :setup setup\n"
           "")

         "  :draw draw)\n")))
