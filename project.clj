(defproject quil-site "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.2"]
                 [hiccup "1.0.5"]
                 [ring "1.5.1"]
                 [ring/ring-json "0.4.0"]
                 [quil "2.6.0"]
                 [me.raynes/fs "1.4.6"]
                 [org.clojure/tools.reader "0.10.0"]
                 [org.clojure/core.cache "0.6.5"]
                 [org.clojure/data.codec "0.1.0"]
                 [clj-http "3.4.1"]
                 [cheshire "5.7.0"]
                 [pandect "0.6.1"]
                 [jayq "2.5.4"]

                 [org.clojure/clojurescript "1.9.473"]]

  :source-paths ["src/clj"]
  :test-paths ["test/"
               "src/cljs/editor"]

  ; Need access to cljs examples.
  :resource-paths ["src/cljs/main/quil_site/examples"]

  :clean-targets ["public/js/main.js"
                  "public/js/preload.js"
                  "public/js/editor.js"
                  "public/js/examples"
                  "target"
                  "out-main"
                  "out-editor"
                  "out-preload"]

  :plugins [[lein-cljsbuild "1.1.5"]]

  :profiles {:dev

             {:cljsbuild
              {:builds
               [{:source-paths ["src/cljs/main"]
                 :compiler
                 {:output-to "public/js/main.js"
                  :output-dir "out-main"
                  :asset-path "/out-main"
                  :main "quil-site.main"
                  :optimizations :none
                  :pretty-print true}}
                {:source-paths ["src/cljs/editor"]
                 :compiler
                 {:output-to "public/js/editor.js"
                  :output-dir "out-editor"
                  :asset-path "/out-editor"
                  :main "quil-site.editor"
                  :optimizations :none
                  :dump-core false
                  :pretty-print true}}]}}
             :prod
             {:cljsbuild
              {:builds
               [{:source-paths ["src/cljs/main"]
                 :compiler
                 {:output-to "public/js/main.js"
                  :optimizations :advanced
                  :pretty-print false
                  :pseudo-names false
                  :closure-defines {"goog.DEBUG" false}
                  :optimize-constants true
                  :static-fns true
                  :modules {:cljs-base {:output-to "public/js/main.js"}
                            :dancer {:output-to "public/js/examples/dancer.js"
                                     :entries #{quil-site.examples.dancer}}
                            :dry-paint {:output-to "public/js/examples/dry_paint.js"
                                        :entries #{quil-site.examples.dry-paint}}
                            :emerald {:output-to "public/js/examples/emerald.js"
                                      :entries #{quil-site.examples.emerald}}
                            :equilibrium {:output-to "public/js/examples/equilibrium.js"
                                          :entries #{quil-site.examples.equilibrium}}
                            :hyper {:output-to "public/js/examples/hyper.js"
                                    :entries #{quil-site.examples.hyper}}
                            :leaf {:output-to "public/js/examples/leaf.js"
                                   :entries #{quil-site.examples.leaf}}
                            :colorjoy {:output-to "public/js/examples/colorjoy.js"
                                       :entries #{quil-site.examples.colorjoy}}
                            :nanoscopic {:output-to "public/js/examples/nanoscopic.js"
                                         :entries #{quil-site.examples.nanoscopic}}
                            :spaceship {:output-to "public/js/examples/spaceship.js"
                                        :entries #{quil-site.examples.spaceship}}
                            :tailspin {:output-to "public/js/examples/tailspin.js"
                                       :entries #{quil-site.examples.tailspin}}
                            :waves {:output-to "public/js/examples/waves.js"
                                    :entries #{quil-site.examples.waves}}
                            :tree {:output-to "public/js/examples/tree.js"
                                   :entries #{quil-site.examples.tree}}
                            :geometric-twinkle {:output-to "public/js/examples/geometric_twinkle.js"
                                                :entries #{quil-site.examples.geometric-twinkle}}
                            :heart {:output-to "public/js/examples/heart.js"
                                    :entries #{quil-site.examples.heart}}
                            :golden-ratio-flower {:output-to "public/js/examples/golden_ratio_flower.js"
                                                  :entries #{quil-site.examples.golden-ratio-flower}}
                            :floating-graph {:output-to "public/js/examples/floating_graph.js"
                                             :entries #{quil-site.examples.floating-graph}}
                            :game-of-life {:output-to "public/js/examples/game_of_life.js"
                                           :entries #{quil-site.examples.game-of-life}}
                            :ten-print {:output-to "public/js/examples/ten_print.js"
                                        :entries #{quil-site.examples.ten-print}}}}}
                {:source-paths ["src/cljs/editor"]
                 :compiler
                 {:output-to "public/js/editor.js"
                  :optimizations :simple
                  :pretty-print false
                  :static-fns true
                  :dump-core false
                  :closure-defines {"goog.DEBUG" false}}}]}}}
  :cljsbuild {:builds [{:source-paths ["src/cljs/preload"]
                        :compiler
                        {:output-to "public/js/preload.js"
                         :optimizations :simple
                         :pretty-print false
                         :static-fns true}}]})
