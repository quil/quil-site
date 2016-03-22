(ns quil-site.parser-test
  (:require [clojure.test :as t]
            [quil-site.parser :as p]))

(t/deftest get-form-ends-at-point
  (t/are [source point result] (= (p/get-form-ends-at-point source point)
                                  result)
    "{}" [0 2] {:form "{}" :start [0 0]}

    "[]" [0 2] {:form "[]" :start [0 0]}

    "()" [0 2] {:form "()" :start [0 0]}

    "[(()()[[[[[]]]]])]" [0 18] {:form "[(()()[[[[[]]]]])]"
                                 :start [0 0]}

    "()[]" [0 2] {:form "()" :start [0 0]}

    "()[]" [0 4] {:form "[]" :start [0 2]}

    "(ns hello.world (:require string.abc))" [0 38]
    {:form "(ns hello.world (:require string.abc))" :start [0 0]}

    "[({1 2})]" [0 8] {:form "({1 2})" :start [0 1]}

    "[]\n\n{1 {1 2}}\n\n    ()" [0 2] {:form "[]" :start [0 0]}

    "[]\n\n{1 {1 2}}\n\n    ()" [2 9] {:form "{1 {1 2}}" :start [2 0]}

    "[]\n\n{1 {1 2}}\n\n    ()" [4 6] {:form "()" :start [4 4]}

    "(defn abc [a b]\n  (println 123)\n  (+ a b))" [2 10]
    {:form "(defn abc [a b]\n  (println 123)\n  (+ a b))" :start [0 0]}

    " (def abc \\))" [0 13] {:form "(def abc \\))" :start [0 1]}

    " (def abc \\()" [0 13] {:form "(def abc \\()" :start [0 1]}

    " (def abc \\])" [0 13] {:form "(def abc \\])" :start [0 1]}

    " (def abc \"((((((([]\")" [0 22] {:form "(def abc \"((((((([]\")" :start [0 1]}

    " (def abc \"]]))()\")" [0 19] {:form "(def abc \"]]))()\")" :start [0 1]}

    ";()()[]]}{}}}\n(def abc ; this ) abc You!\n42)" [2 3]
    {:form "(def abc ; this ) abc You!\n42)" :start [1 0]}))

