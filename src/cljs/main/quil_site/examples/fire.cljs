(ns quil-site.examples.fire
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]
            quil-site.main ;DELETE
            ))

(defn add [v1 v2]
  [(+ (first v1) (first v2))
   (+ (second v1) (second v2))])

(defn div [[x y] n]
  (if (or (= n 0) (= n 0.0))
    (vector x y)
    (vector (/ x n) (/ y n))))

(defn create-particle [location]
  {:location location
   :velocity [(* (q/random-gaussian) 0.3)
              (- (* (q/random-gaussian) 0.4) 1.0)]
   :acceleration [0 0]
   :lifespan 255
   :mass 10})

(defn add-particle [ps]
  (update ps :particles #(conj % (create-particle (:origin ps)))))

(defn display-particle [{:keys [lifespan] [x y] :location :as particle}]
  (q/color-mode :rgb)
  (q/fill (q/color 255 24 0 lifespan))
  (q/ellipse x y (q/map-range lifespan 0 255 0 (/ (q/width) 10))
                 (q/map-range lifespan 0 255 0 (/ (q/width) 10))))

(defn dead? [{:keys [lifespan]}]
  (< lifespan 0.0))

(defn apply-force [{:keys [mass acceleration] :as particle} force]
  (assoc particle :acceleration (add acceleration (div force mass))))

(defn update-particle [{:keys [acceleration velocity location lifespan] :as particle}]
  (let [velocity (add velocity acceleration)]
    (assoc particle
      :velocity velocity
      :location (add velocity location)
      :lifespan (- lifespan 2.0)
      :acceleration [0 0])))

(defn update-state [state]
  (let [wind [(q/map-range (q/mouse-x) 0.0 (q/width) -0.3 0.3)
              (q/map-range (q/mouse-y) 0.0 (q/height) -0.3 0.3)]]
      (-> state
          (update :particles #(map (fn [particle] (apply-force particle wind)) %))
          (update :particles #(map update-particle %))
          (update :particles #(remove dead? %))
          add-particle
          add-particle
          add-particle)))

(defn setup []
  (q/blend-mode :add)
  {:particles ()
   :origin [(/ (q/width) 2)
            (* 2 (/ (q/height) 3))]})

(defn draw-state [{:keys [particles] :as state}]
  (q/clear)
  (q/background 0)
  (doseq [particle particles]
    (display-particle particle)))

(defn run-sketch [host size] ;DELETE
(q/sketch
  :host host
  :size [size size]
  :setup setup
  :update update-state
  :draw draw-state
  :middleware [m/fun-mode])
) ;DELETE

(quil-site.main/register-example! "fire" "Thomas Sojka" run-sketch :interactive? true :white-play-button? true) ;DELETE
