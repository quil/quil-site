(ns quil-site.examples.tailspin
  (:require [quil.core :as q :include-macros true]
            quil-site.main ;DELETE
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 30)
  (let [max-r (/ (q/width) 2)
        n (int (q/map-range (q/width)
                            200 500
                            20 50))]
   {:dots (into [] (for [r (map #(* max-r %)
                                (range 0 1 (/ n)))]
                     [r 0]))}))

(def speed 0.0003)
(def speed 0.001) ; hack to make it faster in small size ;DELETE

(defn move [dot]
  (let [[r a] dot]
    [r (+ a (* r speed))]))

(defn update [state]
  (update-in state [:dots] #(map move %)))

(defn dot->coord [[r a]]
  [(+ (/ (q/width) 2) (* r (q/cos a)))
   (+ (/ (q/height) 2) (* r (q/sin a)))])

(defn draw [state]
  (q/background 250)
  (q/fill 0)
  (let [dots (:dots state)]
    (loop [curr (first dots)
           tail (rest dots)
           prev nil]
      (let [[x y] (dot->coord curr)]
        (q/ellipse x y 5 5)
        (when prev
          (let [[x2 y2] (dot->coord prev)]
            (q/line x y x2 y2))))
      (when (seq tail)
        (recur (first tail)
               (rest tail)
               curr)))))

(defn run-sketch [host size] ;DELETE
(q/sketch
  :host host
  :size [size size]
  :setup setup
  :update update
  :draw draw
  :middleware [m/fun-mode])
) ;DELETE

(quil-site.main/register-example! "tailspin" "Erik Svedäng" run-sketch) ;DELETE
