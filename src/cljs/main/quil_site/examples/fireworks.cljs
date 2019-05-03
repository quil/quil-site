(ns quil-site.examples.fireworks
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(defn add [v1 v2]
  [(+ (first v1) (first v2))
   (+ (second v1) (second v2))])

(defn div [[x y] n]
  (if (zero? n)
    (vector x y)
    (vector (/ x n) (/ y n))))

(defn create-particle [location velocity]
  {:location location
   :velocity (add velocity [(* 1.5 (q/random-gaussian))
                            (* 1.5 (q/random-gaussian))])
   :acceleration [0 0]
   :lifespan 255
   :mass 10})

(defn create-bomb [location]
  (let [h (q/height)
        v (Math/pow h 0.5)]
    {:location location
     :velocity [(q/random -4 4)
                (* v (q/random -0.85 -0.95))]
     :acceleration [0 0]
     :mass 10}))

(defn dead? [{:keys [lifespan]}]
  (< lifespan 0.0))

(defn apply-force [{:keys [mass acceleration] :as particle} force]
  (assoc particle :acceleration (add acceleration (div force mass))))

(defn update-particle [{:keys [acceleration velocity location lifespan] :as particle}]
  (let [velocity (add velocity acceleration)]
    (assoc particle
      :velocity velocity
      :location (add velocity location)
      :lifespan (- lifespan 10)
      :acceleration [0 0])))

(defn update-bomb [{:keys [acceleration velocity location] :as bomb}]
  (let [velocity (add velocity acceleration)]
    (assoc bomb
      :velocity velocity
      :location (add velocity location)
      :acceleration [0 0])))

(defn apply-gravity-to-particles [fireworks gravity]
  (update fireworks :particles #(map (fn [particle] (apply-force particle gravity)) %)))

(defn update-particles [fireworks]
  (update fireworks :particles #(map update-particle %)))

(defn remove-dead-particles [fireworks]
  (update fireworks :particles #(remove dead? %)))

(defn apply-gravity-to-bombs [fireworks gravity]
  (update fireworks :bombs #(map (fn [bomb] (apply-force bomb gravity)) %)))

(defn update-bombs [fireworks]
  (update fireworks :bombs #(map update-bomb %)))

(defn add-bomb [fireworks]
  (if (zero? (rem (q/frame-count) (* 5 (int (q/random 1 5)))))
   (update fireworks :bombs #(conj % (create-bomb (:origin fireworks))))
   fireworks))

(defn remove-dead-bombs [fireworks]
  (update fireworks :bombs (fn [bombs]
                             (remove (fn [bomb]
                                       (> (second (:velocity bomb)) 0)) bombs))))

(defn explode-bomb [{:keys [lifespan location velocity] :as bomb}]
  (when (> (second velocity) 0)
    (map #(create-particle location velocity) (range 300))))

(defn explode-bombs [fireworks]
  (update fireworks :particles #(concat % (mapcat explode-bomb (:bombs fireworks)))))

(defn draw-particle [{:keys [lifespan] [x y] :location :as particle}]
  (let [s (q/map-range lifespan 0 255 0 (/ (q/width) 100))]
    (q/fill (q/color 255 (- 255 lifespan) 0 lifespan))
    (q/ellipse x y s s)))

(defn draw-bomb [{:keys [location] :as bomb}]
  (q/fill 35)
  (let [s (/ (q/width) 100)
        [x y] location]
    (q/ellipse x y s s)))

(defn setup []
  (q/color-mode :rgb)
  (q/blend-mode :add)
  {:particles ()
   :bombs ()
   :origin [(/ (q/width) 2)
            (q/height)]})

(defn update-fireworks [fireworks]
  (let [gravity [0 5]]
      (-> fireworks
          (apply-gravity-to-particles gravity)
          (update-particles)
          (remove-dead-particles)
          (apply-gravity-to-bombs gravity)
          (update-bombs)
          (explode-bombs)
          (remove-dead-bombs)
          (add-bomb))))

(defn draw-fireworks [{:keys [particles bombs] :as fireworks}]
  (q/clear)
  (q/background 0)
  (doseq [bomb bombs]
   (draw-bomb bomb))
  (doseq [particle particles]
    (draw-particle particle)))

(defn run-sketch [host size] ;DELETE
(q/sketch
  :host host
  :size [size size]
  :setup setup
  :update update-fireworks
  :draw draw-fireworks
  :middleware [m/fun-mode])
) ;DELETE

(quil-site.main/register-example! "fireworks" "Anthony Galea" run-sketch :interactive? false :white-play-button? true) ;DELETE
