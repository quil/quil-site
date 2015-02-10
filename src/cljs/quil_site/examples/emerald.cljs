(ns quil-site.examples.emerald
  (:require [quil.core :as q :include-macros true]
            quil-site.main ;DELETE
  ))

(defn setup []
  (q/frame-rate 60))

(defn pulse [low high rate]
  (let [diff (- high low)
        half (/ diff 2)
        mid (+ low half)
        s (/ (q/millis) 1000.0)
        x (q/sin (* s (/ 1.0 rate)))]
    (+ mid (* x half))))

(defn setup []
  (q/frame-rate 60))

(defn draw []
  (q/no-stroke)
  (q/background 255)
  (let [w (q/width)
        h (q/height)
        hw (/ w 2)
        hh (/ h 2)
        inner-r (* hw 0.5)
        outer-r hw]
    (q/fill (pulse 20 50 2.0) 230 (pulse 150 200 1.0))
    (q/ellipse hw hh w h)
    (q/stroke 255 255 255 100)
    (q/with-translation [hw hh]
      (doseq [a (range 0 q/TWO-PI (/ q/PI 256.0))]
        (let [skew1 (* 0.001 (q/millis) a)
              skew2 (* skew1 2.0)]
          (q/line (* inner-r (q/cos (+ skew1 a)))
                  (* inner-r (q/sin (+ skew1 a)))
                  (* outer-r (q/cos (+ skew2 a)))
                  (* outer-r (q/sin (+ skew2 a)))))))))

(defn run-sketch [host size] ;DELETE
(q/sketch
   :host host
   :size [size size]
   :setup setup
   :draw draw)
) ;DELETE

(quil-site.main/register-example! "emerald" "Erik Svedäng" run-sketch :interactive? false) ;DELETE

