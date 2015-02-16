(ns quil-site.examples.dancer
  (:require [quil.core :as q :include-macros true]
            quil-site.main ;DELETE
  ))

(defn setup []
  (q/frame-rate 30))

(defn pulse [low high rate]
  (let [diff (- high low)
        half (/ diff 2)
        mid (+ low half)
        s (/ (q/millis) 1000.0)
        x (q/sin (* s (/ 1.0 rate)))]
    (+ mid (* x half))))

(defn t []
  (* 0.001 (q/millis)))

(def speed 0.5)

(defn stem [base-x]
  (let [magic (/ 8 (q/width))
        x-max (/ (q/width) 4)
        x-max-top (/ x-max 2)
        y-max (/ (q/height) 2)

        x (+ base-x
             (pulse (- x-max-top) x-max-top 1.0))
        y (+ (- y-max)
             (* 0.5 y-max
                (q/sin (+ (* speed (t))
                          (* magic base-x))))
             (* (/ 3) y-max (q/sin (* 2 (t)))))]
    (q/bezier base-x 0 base-x 0
              0 (- x-max) x y)))
(defn draw []
  (q/background 255)
  (q/stroke 0)
  (q/stroke-weight 1)
  (q/no-fill)
  (let [size (q/width)
        x-max (/ size 4)]
    (q/with-translation [(/ size 2) (q/height)]
      (doseq [x (range (- x-max) x-max 2)]
        (stem x)))))

(defn run-sketch [host size] ;DELETE
(q/sketch
   :host host
   :size [size size]
   :setup setup
   :draw draw)
) ;DELETE

(quil-site.main/register-example! "dancer" "Erik Svedäng" run-sketch :interactive? false) ;DELETE

