(ns quil-site.examples.spaceship
  (:require [quil.core :as q :include-macros true]
            quil-site.main ;DELETE
            [quil.middleware :as m]))

(def field-size 700)

(def images [:body :bg :star :anchor :engine :cupola :flag0 :flag1 :fire0 :fire1 :fire2 :fire3 :antenna])

(defn pulse [low high rate]
  (let [diff (- high low)
        half (/ diff 2)
        mid (+ low half)
        s (/ (q/millis) 1000.0)
        x (q/sin (* s (/ 1.0 rate)))]
    (+ mid (* x half))))

(defn load-image [image]
  (let [path (str "/img/spaceship/" (name image) ".png")]
    (q/load-image path)))

(defn draw-image [state k [x y]]
  (q/image (get-in state [:images k]) x y))

(defn random-star [speed]
  [(rand-int (* 2 field-size))
   (- (rand-int field-size)
      (/ field-size 2))
   (* speed (+ 1.0 (rand 3.0)))])

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :rgb)
  (q/image-mode :center)
  {:stars  (take 25 (repeatedly #(random-star 6.0)))
   :stars2 (take 25 (repeatedly #(random-star 3.0)))
   :fade 1.2
   :images (zipmap images (map load-image images))})

(defn wrap [[x y v]]
  (if (< x (- field-size))
    [field-size
     (- (rand-int field-size)
        (/ field-size 2))
     v]
    [x y v]))

(defn move-star [[x y v]]
  (wrap [(- x v) y v]))

(defn update-state [state]
  (-> state
      (update-in [:fade] #(if (> % 0.0) (- % 0.02) %))
      (update-in [:stars] #(map move-star %))
      (update-in [:stars2] #(map move-star %))))

(defn animated-keyword [base-name n speed]
  (let [s (* speed (/ (q/millis) 1000.0))
        x (mod (int s) n)]
    (keyword (str (name base-name) x))))

(defn draw-stars [state stars]
  (doseq [[x y v] stars]
    (q/push-matrix)
    (q/translate x y)
    (q/scale (* 0.05 v))
    (draw-image state :star [0 0])
    (q/pop-matrix)))

(defn draw-state [state]
  (let [w (q/width)
        h (q/height)]
    (q/with-translation [(/ w 2) (/ h 2)]
      (q/scale (/ (min w h) field-size))
      (q/background 255)

      ; Draw background and back stars
      (draw-image state :bg [0 0])
      (draw-stars state (:stars2 state))

      ; Slightly move and rotate spaceship
      (q/push-matrix)
      (q/translate (pulse -20 20 3.0) (pulse -10 10 0.25))
      (q/rotate (pulse -0.02 0.02 0.5))

      (draw-image state (animated-keyword :fire 4 10.0) [-300 64])

      ; Draw antenna
      (q/with-translation [145 20]
        (q/with-rotation [(pulse 0.12 -0.12 1.0)]
          (draw-image state :antenna [50 0])))

      ; Draw cupola
      (q/with-translation [-160 (pulse 67 74 0.20)]
        (draw-image state :cupola [160 -235]))

      (draw-image state :body [0 0])

      ; Draw anchor
      (q/with-translation [-175 75]
        (q/with-rotation [(pulse 0.1 -0.1 0.25)]
          (draw-image state :anchor [0 35])))

      ; Draw engine
      (q/with-translation [-72 4]
        (q/with-rotation [(* 0.01 (q/millis))]
          (draw-image state :engine [0 0])))

      ; Draw flag
      (q/with-translation [-72 4]
        (draw-image state (animated-keyword :flag 2 10.0) [-100 -53]))

      ; Spaceship finished. Restore transformation matrix and draw
      ; front stars.
      (q/pop-matrix)
      (draw-stars state (:stars state))
      (q/fill 255 (* 255 (:fade state))))))

(defn run-sketch [host size] ;DELETE
(q/sketch
  :host host
  :size [size size]
  :setup setup
  :update update-state
  :draw draw-state
  :middleware [m/fun-mode])
) ;DELETE

(quil-site.main/register-example! "spaceship" "Erik Svedäng" run-sketch) ;DELETE
