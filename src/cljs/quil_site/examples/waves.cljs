(ns quil-site.examples.waves
  (:require [quil.core :as q :include-macros true]
            quil-site.main ;DELETE
  ))

(defn setup []
  (q/frame-rate 30))

(defn t []
  (* 0.001 (q/millis)))

(defn calc-y [x mid amp]
  (+ mid (* (q/sin (+ (t) x)) amp)))

(defn wave [step mid-y amp]
  (let [w (q/width)
        h (q/height)
        mult (q/map-range w
                          700 200
                          0.01 0.03)]
    (q/begin-shape)
    (q/vertex 0 h) ; lower left corner
    (doseq [x (range (- w) (+ step w) step)]
      (let [t (* x mult)
            y (calc-y t mid-y amp)]
        (q/vertex x y)))
    (q/vertex w h) ; lower right corner
    (q/end-shape)))

(defn draw []
  (q/background 250)
  (q/stroke 255 250)
  (q/fill 50 230 (+ (* 20 (q/sin (t))) 230) 40)
  (let [h (q/height)
        move-down (/ h 5)
        amp (/ h 8)]
    (doseq [y (range move-down (+ amp h) 8)]
      (let [x-step (- (* y 0.8) move-down)]
        (wave x-step y amp)))))

(defn run-sketch [host size] ;DELETE
(q/sketch
   :host host
   :size [size size]
   :setup setup
   :draw draw)
) ;DELETE

(quil-site.main/register-example! "waves" "Erik Svedäng" run-sketch :interactive? false) ;DELETE

