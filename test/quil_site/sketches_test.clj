(ns quil-site.core-test
  (:require [clojure.test :refer :all]
            [quil-site.sketches :refer :all]))


(deftest extract-size-test
  (are [source expected] (= expected (extract-size source))
       "" nil

       "(q/defsketch my
          :size [500 500])" [500 500]

       "(quilll/defsketch yours
          :size [123 456])" [123 456]

       "(defsketch his :size [20 30])" [20 30]

       "(def size [10 20])
        (q/defsketch her :size size)" nil

        "(def width 60)
         (def height 70)
         (q/defsketch their
           :size [width height" nil

       "(broken 32103193clojure" nil))
