(ns quil-site.examples.golden-ratio-flower
  (:require [quil.core :as q :include-macros true]
            quil-site.main ;DELETE
            ))

(def PHI (/ (+ 1 (Math/sqrt 5)) 2))

(def palette
  (cycle [[249 187  78]
          [ 70 162 141]
          [220 112 100]]))

(defn setup []
  (q/frame-rate 10))

(defn draw []
  (q/no-stroke)
  (q/background 255 255 236)
  (q/with-translation [(/ (q/width) 2) (/ (q/height) 2)]
    (doseq [i (range 1000)]
      (let [v (+ (mod (q/frame-count) 3) i)
            ang (* v PHI q/TWO-PI)
            r   (* (Math/sqrt v) (q/width) (/ 70))
            x   (* (q/cos ang) r)
            y   (* (q/sin ang) r)
            sz  (+ 3 (* i 0.002))]
        (apply q/fill (nth palette i))
        (q/ellipse x y sz sz)))))

(defn run-sketch [host size] ;DELETE
(q/sketch
  :host host
  :size [size size]
  :setup setup
  :draw draw)
) ;DELETE

(quil-site.main/register-example! "golden ratio flower" "Jack Rusher" run-sketch) ;DELETE
