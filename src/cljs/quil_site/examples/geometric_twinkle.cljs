(ns quil-site.examples.geometric-twinkle
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]
            quil-site.main ;DELETE
            ))

(defn setup []
  (q/frame-rate 30)
  (let [r 10
        w (q/width)
        h (q/height)
        y-vals (take-nth r (range (+ h r)))
        x-vals (flatten
                 (map #(repeat (count y-vals) %)
                      (take-nth r (range (+ w r)))))
        origins (partition 2 (interleave x-vals (cycle y-vals)))
        circles (map (fn [[x y]] {:x x :y y :r r}) origins)]
    {:radius r
     :circles circles}))

(defn update-state [state]
  (update state :circles #(map (fn [c]
                                 (let [cx (/ (q/width) 2)
                                       cy (/ (q/height) 2)
                                       x (:x c)
                                       y (:y c)
                                       r (:radius state)
                                       t (/ (q/millis) 1000)]
                                   (assoc c :r (* r
                                                  (q/sin
                                                    (+ t
                                                       (+ (q/sq (- cx x))
                                                          (q/sq (- cy y))))))))) %)))

(defn draw-state [state]
  (q/background 0 0 0)
  (q/no-stroke)

  (doseq [c (:circles state)]
    (q/ellipse (:x c) (:y c) (:r c) (:r c))))


(defn run-sketch [host size] ;DELETE
(q/defsketch my-sketch
  :host host
  :size [size size]
  :setup setup
  :update update-state
  :draw draw-state
  :middleware [m/fun-mode])
) ;DELETE

(quil-site.main/register-example! "geometric-twinkle" "Jeremy Kross" run-sketch) ;DELETE
