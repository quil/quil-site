(defproject quil-site "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [hiccup "1.0.5"]
                 [ring "1.3.0"]
                 [ring/ring-json "0.3.1"]
                 [org.clojure/clojurescript "0.0-2268"]
                 [quil "2.2.2-SNAPSHOT"]
                 [me.raynes/fs "1.4.6"]
                 [org.clojure/tools.reader "0.8.8"]
                 [org.clojure/core.cache "0.6.4"]]

  :source-paths ["src/clj"]

  :plugins [[lein-cljsbuild "1.0.3"]]

  :cljsbuild {
    :builds [{
        :source-paths ["src/cljs-preload"]
        :compiler {
          :output-to "public/js/preload.js"
          :optimizations :simple
          :preamble ["processing.min.js"]}}]})
