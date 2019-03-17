(ns quil-site.examples.matrix
  (:require [quil.core :as q :include-macros true]
            quil-site.main ;DELETE
            [quil.middleware :as m]))


(def katakana "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲン")
(def glyph-size 12)
(def min-drops 1)
(def max-drops 30)

(defn gen-raindrop []
  {:text (apply str (shuffle katakana))
   :index -1
   :x ((fn [x] (- x (mod x glyph-size)))
       (rand (q/width)))
   :eol true})

(defn setup []
  (q/frame-rate 20)
  (q/background 0)

  (repeatedly min-drops gen-raindrop))

(defn update-raindrop [raindrop]
  (let [next-index  (inc (:index raindrop))
        eol         (>= next-index (count (:text raindrop)))]
    (assoc raindrop :index next-index :eol eol)))

(defn regen-raindrop [raindrop]
  (if (and (:eol raindrop) (< (rand) 0.1))
    (gen-raindrop)
    raindrop))

(defn spawn-raindrop [state]
  (if (and (< (count state) max-drops) (< (rand) 0.1))
    (cons (gen-raindrop) state)
    state))

(defn update-state [state]
  (->> state
       (map (comp update-raindrop regen-raindrop))
       (spawn-raindrop)))

(defn draw-state [state]
  ; draw transparent backdrop
  (q/fill 0 10)
  (q/rect 0 0 (q/width) (q/height))

  ; draw text raindrop
  (q/fill 0 255 0)
  (doseq [raindrop state]
    (let [c (.charAt ^String (:text raindrop) (:index raindrop))
          y (* glyph-size (:index raindrop))]
      (if-not(:eol raindrop)
        (q/text c (:x raindrop) y)))))

(defn run-sketch [host size] ;DELETE
 (q/sketch
   :host host
   :size [size size]
   :setup setup
   :update update-state
   :draw draw-state
   :middleware [m/fun-mode])
 ) ;DELETE

(quil-site.main/register-example! "matrix" "Hyunwoo Nam" run-sketch :white-play-button? true) ;DELETE
