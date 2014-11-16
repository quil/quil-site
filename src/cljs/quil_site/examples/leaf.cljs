(ns quil-site.examples.leaf
  (:require [quil.core :as q :include-macros true]
            quil-site.main ;DELETE
            ))

;;;
;;; Example from Quil Intro blogpost
;;; http://nbeloglazov.com/2014/05/29/quil-intro.html
;;;

(defn leaf-fn [t]
  (let [r (* 1.5 t (q/cos t) (q/sin t))]
    [(* r (q/cos t))
     (* r (q/tan t))]))

(defn setup []
  (q/frame-rate 60)
  (q/background 250))

(defn draw []
  (q/with-translation [(/ (q/width) 2) 10]
    (let [t (/ (q/frame-count) 10)]
      (q/line (leaf-fn t) (leaf-fn (+ t 0.1))))))

(defn run-sketch [host size] ;DELETE
(q/sketch
  :host host
  :size [size size]
  :setup setup
  :draw draw)
) ;DELETE

(quil-site.main/register-example! "leaf" "Nikita Beloglazov" run-sketch) ;DELETE
