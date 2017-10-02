(ns quil-site.examples.game-of-life
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]
            quil-site.main ;DELETE
            ))

;;;
;;; Game of Life
;;; https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
;;;

(def grid-size 20)

(def state {:matrix (vec
                     (repeatedly (* grid-size grid-size) #(rand-int 2)))})

(defn setup []
  (q/frame-rate 10)
  (q/color-mode :hsb)
  (q/no-stroke)
  state)

(defn get-neighbors [idx vec]
  [
   (get vec (dec (- idx grid-size)))
   (get vec (- idx grid-size))
   (get vec (inc (- idx grid-size)))

   (get vec (dec idx))
   (get vec (inc idx))

   (get vec (dec (+ grid-size idx)))
   (get vec (+ grid-size idx))
   (get vec (inc (+ grid-size idx)))
  ])

(defn new-status [idx itm vec]
  (let [alive-n (get (frequencies (get-neighbors idx vec)) 1 0)]
    (if (= 1 itm)
      (if (or (> alive-n 3) (< alive-n 2)) 0 1)
      (if (= 3 alive-n) 1 0)
    )))

(defn update-state [state]
  (assoc state :matrix
    (vec
      (map-indexed
       (fn [idx itm] (new-status idx itm (:matrix state)))
       (:matrix state)))))

(defn draw-state [state]
  (q/background 240)
  (let [cell-size (quot (q/width) grid-size)]
    (doseq [[i v] (map-indexed vector (:matrix state))]
      (let [multiplier (int (/ i grid-size))
            x (* cell-size (- i (* multiplier grid-size)))
            y (* cell-size multiplier)]
        (q/fill
         (if (= 1 v) 0 255))
        (q/rect x y cell-size cell-size)))))

(defn run-sketch [host size] ;DELETE
(q/sketch
  :host host
  :size [size size]
  :setup setup
  :update update-state
  :draw draw-state
  :middleware [m/fun-mode])
) ;DELETE

(quil-site.main/register-example! "game of life" "Mauro De Giorgi" run-sketch) ;DELETE
