(ns quil-site.examples.lissajous-table
  (:require [quil.core :as q :include-macros true]
            quil-site.main ;DELETE
))

;;;
;;; Lissajous Table
;;; See https://en.wikipedia.org/wiki/Lissajous_curve
;;;

(def circle-width 60)

; atom holding state of the table. See its structure
; in setup function.
(def rules (atom nil))

(defn generate-speeds
  "Generates angle speeds for n circles. Speed is an integer. All speeds 
  will be unique. If n > 6 then speeds will be 1, 2, ..., n otherwise 
  speeds will be randomly selected from 1 to 6. This is done so that
  on small n we get random circles on each sketch run."
  [n]
  (->>
   (range 1 (max (inc n) 6))
   (shuffle)
   (take n)
   (sort)))

(defn setup []
  (q/frame-rate 60)
  (let [cols (dec (quot (q/width) circle-width))
        rows (dec (quot (q/height) circle-width))]
    (reset! rules
            {; number of circles in columns and rows that fit sketch size
             :columns cols
             :rows rows

             ; angle speed controlling how fast each circle rotates
             :speeds {:columns (generate-speeds cols)
                      :rows (generate-speeds cols)}

             ; table of curves. each curve contains its current position under :x :y
             ; and vector of all points in :points vector
             :curves (->> {:x 0 :y 0 :points []}
                          (repeat cols)
                          vec
                          (repeat rows)
                          vec)})))

(defn draw-circles-and-guides [angle mode]
  (let [hcw (/ circle-width 2)
        diameter (- circle-width 10)
        r (/ diameter 2)
        speed ((:speeds @rules) mode)]
    (doseq [i (range (mode @rules))]
      (let [def-cx (+ (* i circle-width) hcw circle-width)
            cx (cond (= :columns mode) def-cx
                     (= :rows mode) hcw)

            cy (cond (= :columns mode) hcw
                     (= :rows mode) def-cx)

            angle-speed (* angle (nth speed i))

            angle-set-to-zero (- angle-speed q/HALF-PI)

            x (* r (q/cos angle-set-to-zero))
            y (* r (q/sin angle-set-to-zero))

            point-x (+ cx x)
            point-y (+ cy y)]

        ; draw circle
        (q/stroke-weight 1)
        (q/ellipse cx cy diameter diameter)

        ; draw point 
        (q/stroke-weight 8)
        (q/point point-x point-y)

        ; draw line
        (q/stroke-weight 1)
        (if (= :columns mode)
          (q/line point-x 0 point-x (q/height))
          (q/line 0 point-y (q/width) point-y))

        (cond
          (= :columns mode)
          (doseq [j (range (:rows @rules))]
            (swap! rules assoc-in [:curves j i :x] point-x))
          (= :rows mode)
          (doseq [j (range (:columns @rules))]
            (swap! rules assoc-in [:curves i j :y] point-y)))))))

(defn draw-lissajous [points]
  (q/stroke-weight 1)
  (q/begin-shape)
  (doseq [p points]
    (q/vertex (:x p) (:y p)))
  (q/end-shape))

(defn draw []
  (q/background 0)
  (q/no-fill)
  (q/stroke 255)

  (let [angle (* 0.04 (q/frame-count))]
    (draw-circles-and-guides angle :columns)
    (draw-circles-and-guides angle :rows)
    (doseq [r (range (:rows @rules))
            c (range (:columns @rules))]
      (let [{:keys [x y points]} (nth (nth (:curves @rules) r) c)]
        ; add current point to the curve list. We add new point only if 
        ; we haven't done a full 2PI iteration after which curve repeats
        ; so no point to store new points.
        (when (<= angle q/TWO-PI)
          (swap! rules update-in [:curves r c :points] conj
                 {:x x :y y}))

        (draw-lissajous points)))))

(defn run-sketch [host size] ;DELETE
  (q/sketch
   :host host
   :size [size size]
   :setup setup
   :draw draw)
) ;DELETE

(quil-site.main/register-example! "lissajous table" "Mochamad Lucky Pradana" run-sketch) ;DELETE
