(ns quil-site.examples.ten-print
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]
            quil-site.main ;DELETE
            ))

(def scale 20)

(defn setup []
  (q/background 0)
  (q/frame-rate 20)
  (q/color-mode :hsb)
  {:x 0
   :y 0})

(defn update-state [{:keys [x y] :as state}]
  (let [new-x (if (>= x (q/width)) 0 (+ x scale))
        new-y (if (zero? new-x) (+ y scale) y)]
    {:x new-x
     :y (if (>= new-y (q/height)) 0 new-y)}))

(defn draw-state [{:keys [x y once] :as state}]
  (when (and (zero? x) (zero? y))
    (q/background 0))
  (q/stroke (rand-int 255) (rand-int 255) 255)
  (if (> (rand) 0.5)
    (q/line x y (+ x scale) (+ y scale))
    (q/line x (+ y scale) (+ x scale) y)))

(defn run-sketch [host size] ;DELETE
(q/sketch
 :host host
 :size [size size]
 :setup setup
 :update update-state
 :draw draw-state
 :middleware [m/fun-mode])
  ) ;DELETE

(quil-site.main/register-example! "ten print" "Mochamad Lucky Pradana" run-sketch :display-name "10 print") ;DELETE
