(ns quil-site.examples.hyper
  (:require [quil.core :as q :include-macros true]
            quil-site.main ;DELETE
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 100)
  (q/background 255)
  (q/rect-mode :center)
  {:r 0.0
   :col 0})

(defn tick [state]
  (update-in state [:r] + 5.0))

(defn flip [state]
  {:r 0.0
   :col (if (= 0 (:col state)) 255 0)})

(defn update-state [state]
  (if (< (:r state) 300)
    (tick state)
    (flip state)))

(defn draw-state [state]
  (q/stroke (:col state))
  (let [hw (* 0.5 (q/width))
        hh (* 0.5 (q/height))]
    (dotimes [_ (quot (q/width) 10)]
      (let [rand-ang (q/random 0 q/TWO-PI)
            r (:r state)]
        (q/line hh
                hw
                (+ hh (* (q/sin rand-ang) r))
                (+ hw (* (q/cos rand-ang) r)))))))

(defn run-sketch [host size] ;DELETE
(q/sketch
   :host host
   :size [size size]
   :setup setup
   :update update-state
   :draw draw-state
   :middleware [m/fun-mode])
) ;DELETE

(quil-site.main/register-example! "hyper" "Erik Svedäng" run-sketch :interactive? false) ;DELETE

