(defproject quil-site "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.3.4"]
                 [hiccup "1.0.5"]
                 [ring "1.3.2"]
                 [ring/ring-json "0.3.1"]
                 [quil "2.3.0"]
                 [me.raynes/fs "1.4.6"]
                 [org.clojure/tools.reader "0.9.2"]
                 [org.clojure/core.cache "0.6.4"]
                 [org.clojure/data.codec "0.1.0"]
                 [clj-http "1.1.2"]
                 [cheshire "5.5.0"]
                 [pandect "0.5.2"]

                 [org.clojure/clojurescript "0.0-3308"]]

  :source-paths ["src/clj"]

  ; Need access to cljs examples.
  :resource-paths ["src/cljs/quil_site/examples"]

  :clean-targets ["public/js/main.js"
                  "public/js/preload.js"
                  "public/js/dancer.js"
                  "public/js/dry_paint.js"
                  "public/js/emerald.js"
                  "public/js/equilibrium.js"
                  "public/js/hyper.js"
                  "public/js/leaf.js"
                  "public/js/nanoscopic.js"
                  "public/js/spaceship.js"
                  "public/js/tailspin.js"
                  "public/js/waves.js"
                  "public/js/tree.js"
                  "public/js/geometric-twinkle.js"
                  "target"]

  :plugins [[lein-cljsbuild "1.0.5"]]

  :profiles {:dev

             {:cljsbuild
              {:builds
               [{:source-paths ["src/cljs"]
                 :compiler
                 {:output-to "public/js/main.js"
                  :optimizations :simple}}]}}
             :prod
             {:cljsbuild
              {:builds
               [{:source-paths ["src/cljs"]
                 :compiler
                 {:output-to "public/js/main.js"
                  :optimizations :advanced
                  :pretty-print false
                  :modules {:cljs-base {:output-to "public/js/main.js"}
                            :dancer {:output-to "public/js/dancer.js"
                                     :entries #{quil-site.examples.dancer}}
                            :dry-paint {:output-to "public/js/dry_paint.js"
                                        :entries #{quil-site.examples.dry-paint}}
                            :emerald {:output-to "public/js/emerald.js"
                                      :entries #{quil-site.examples.emerald}}
                            :equilibrium {:output-to "public/js/equilibrium.js"
                                          :entries #{quil-site.examples.equilibrium}}
                            :hyper {:output-to "public/js/hyper.js"
                                    :entries #{quil-site.examples.hyper}}
                            :leaf {:output-to "public/js/leaf.js"
                                   :entries #{quil-site.examples.leaf}}
                            :nanoscopic {:output-to "public/js/nanoscopic.js"
                                         :entries #{quil-site.examples.nanoscopic}}
                            :spaceship {:output-to "public/js/spaceship.js"
                                        :entries #{quil-site.examples.spaceship}}
                            :tailspin {:output-to "public/js/tailspin.js"
                                       :entries #{quil-site.examples.tailspin}}
                            :waves {:output-to "public/js/waves.js"
                                    :entries #{quil-site.examples.waves}}
                            :tree {:output-to "public/js/tree.js"
                                   :entries #{quil-site.examples.tree}}
                            :geometric-twinkle {:output-to "public/js/geometric-twinkle.js"
                                                :entries #{quil-site.examples.geometric-twinkle}}}}}]}}}

  :cljsbuild {
    :builds [
      {:source-paths ["src/cljs-preload"]
       :compiler
         {:output-to "public/js/preload.js"
          :optimizations :simple
          :pretty-print false}}]})
