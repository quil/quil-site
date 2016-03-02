(defproject quil-site "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.4.0"]
                 [hiccup "1.0.5"]
                 [ring "1.4.0"]
                 [ring/ring-json "0.4.0"]
                 [quil "2.3.1-SNAPSHOT"]
                 [me.raynes/fs "1.4.6"]
                 [org.clojure/tools.reader "0.10.0"]
                 [org.clojure/core.cache "0.6.4"]
                 [org.clojure/data.codec "0.1.0"]
                 [clj-http "2.0.1"]
                 [cheshire "5.5.0"]
                 [pandect "0.5.4"]
                 [replumb "0.1.4"]

                 [org.clojure/clojurescript "1.7.228"]]

  :source-paths ["src/clj"]

  ; Need access to cljs examples.
  :resource-paths ["src/cljs/main/quil_site/examples"]

  :clean-targets ["public/js/main.js"
                  "public/js/preload.js"
                  "public/js/editor.js"
                  "public/js/dancer.js"
                  "public/js/dry_paint.js"
                  "public/js/emerald.js"
                  "public/js/equilibrium.js"
                  "public/js/hyper.js"
                  "public/js/leaf.js"
                  "public/js/colorjoy.js"
                  "public/js/nanoscopic.js"
                  "public/js/spaceship.js"
                  "public/js/tailspin.js"
                  "public/js/waves.js"
                  "public/js/tree.js"
                  "public/js/geometric_twinkle.js"
                  "public/js/heart.js"
                  "public/js/golden_ratio_flower.js"
                  "target"
                  "out-main"
                  "out-editor"]

  :plugins [[lein-cljsbuild "1.1.2"]]

  :profiles {:dev

             {:cljsbuild
              {:builds
               [{:source-paths ["src/cljs/main"]
                 :compiler
                 {:output-to "public/js/main.js"
                  :output-dir "out-main"
                  :main "quil-site.main"
                  :optimizations :none
                  :pretty-print true}}
                {:source-paths ["src/cljs/compiler"]
                 :compiler
                 {:output-to "public/js/editor.js"
                  :output-dir "out-editor"
                  :main "quil-site.compiler"
                  :optimizations :none
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
                            :colorjoy {:output-to "public/js/colorjoy.js"
                                   :entries #{quil-site.examples.colorjoy}}
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
                            :geometric-twinkle {:output-to "public/js/geometric_twinkle.js"
                                                :entries #{quil-site.examples.geometric-twinkle}}
                            :heart {:output-to "public/js/heart.js"
                                    :entries #{quil-site.examples.heart}}
                            :golden-ratio-flower {:output-to "public/js/golden_ratio_flower.js"
                                                  :entries #{quil-site.examples.golden-ratio-flower}}}}}
                {:source-paths ["src/cljs/editor"]
                 :compiler
                 {:output-to "public/js/editor.js"
                  :optimizations :simple
                  :pretty-print false
                  :closure-defines {"goog.DEBUG" false}}}]}}}

  :cljsbuild {
    :builds [
      {:source-paths ["src/cljs/preload"]
       :compiler
         {:output-to "public/js/preload.js"
          :optimizations :simple
          :pretty-print false}}]})
