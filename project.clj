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
                 [quil "2.2.3-SNAPSHOT"]
                 [me.raynes/fs "1.4.6"]
                 [org.clojure/tools.reader "0.8.8"]
                 [org.clojure/core.cache "0.6.4"]

                 [org.clojure/clojurescript "0.0-2268"]]

  :source-paths ["src/clj"]

  ; Need access to cljs examples.
  :resource-paths ["src/cljs/quil_site/examples"]

  :plugins [[lein-cljsbuild "1.0.3"]]

  :profiles {:dev
             {:cljsbuild
              {:builds
               [{:source-paths ["src/cljs"]
                 :compiler
                 {:output-to "public/js/main.js"
                  :optimizations :simple
                  :preamble ["processing.min.js"]}}]}}
             :prod
             {:cljsbuild
              {:builds
               [{:source-paths ["src/cljs"]
                 :compiler
                 {:output-to "public/js/main.js"
                  :optimizations :advanced
                  :pretty-print false
                  :preamble ["processing.min.js"]
                  :externs ["externs/processing.js"]}}]}}}

  :cljsbuild {
    :builds [
      {:source-paths ["src/cljs-preload"]
       :compiler
         {:output-to "public/js/preload.js"
          :optimizations :simple
          :pretty-print false
          :preamble ["processing.min.js"]}}]})
