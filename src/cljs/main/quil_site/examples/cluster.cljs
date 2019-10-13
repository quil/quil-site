(ns quil-site.examples.cluster
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]
            quil-site.main ;DELETE
            ))

;=== PARAMETERS ===

(def TREECUTOFF 5)
(def THRESHOLD 1.5)
(def NBODIES 500)
(def TIMESTEP 1)
(def G "AU3/Msol'd2" 2.976235E-4)
(defn HALO [] {:mass 10000 :pos [(* 0.5 (q/width)) (* 0.5 (q/height))]})


;=== UTIL - RANDOM NUMBERS ===

(def seed (atom 0))

(def pars {:size (Math/pow 2 32)
           :mult 1664525
           :inc  1013904223})

(defn next-linear-congruential
  "A simple seedable random number generator"
  []
  (let [n @seed
        {size :size
         mult :mult
         inc  :inc} pars]
    (reset! seed (mod (+ (* mult n) inc) size))))

(defn uniform
  "Returns a random floating point number between 0 (inclusive) and
  n (default 1) (exclusive)."
  ([] (/ (next-linear-congruential) (:size pars)))
  ([x] (* x (uniform)))
  ([x1 x2] (let [diff (- x1 x2)]
             (+ x2 (uniform diff)))))

(defn rand-n
  "Returns a random integer between 0 (inclusive) and n (exclusive)."
  ([n] (int (uniform n)))
  ([n1 n2] (int (uniform n1 n2))))

;=== UTIL - VECTOR MATH ===

(def add #(mapv + %1 %2))

(def sub #(mapv - %1 %2))

(def inv #(/ 1 %))

(defn scalar [num v] (mapv #(* num %) v))

(defn norm [v]
  (let [sqr #(* % %)]
    (Math/sqrt (+ (sqr (v 0)) (sqr (v 1))))))

(defn normalize [v]
  (scalar (inv (norm v)) v))

(defn v-dist [v1 v2]
  (let [dv (sub v1 v2)]
    (norm dv)))

;=== UTIL - QUAD TREE HANDLING ===

(def X 0)
(def Y 1)
(def WIDTH 2)
(def HEIGHT 3)
; Rectangle vector format: [X Y WIDTH HEIGHT]

(defn center [rect]
  [(+ (get rect X) (* 0.5 (get rect WIDTH)))
   (+ (get rect Y) (* 0.5 (get rect HEIGHT)))])

(defn area [rect]
  (* (get rect WIDTH) (get rect HEIGHT)))

(defn slice
  "return one of the four quads of rect, specified by direction 0-3"
  [rect [center-x center-y] direction]
  (let [height (* 0.5 (get rect WIDTH))
        width (* 0.5 (get rect HEIGHT))]
    (case direction 0 [(get rect X) (get rect Y) height width]
                    1 [center-x (get rect Y) height width]
                    2 [(get rect X) center-y height width]
                    3 [center-x center-y height width])))

(defn group-by-quad
  "take a list of bodies with :pos information and group them by direction relative to the given center point"
  [[center-x center-y] bodies]
  (loop [remaining bodies
         nw [] ne [] sw [] se []]
    (if (empty? remaining) [nw ne sw se]
                           (let [body (first remaining)
                                 west? (< (get (:pos body) X) center-x)
                                 north? (< (get (:pos body) Y) center-y)]
                             (cond (and west? north?) (recur (rest remaining) (conj nw body) ne sw se)
                                   (and (not west?) (not north?)) (recur (rest remaining) nw ne sw (conj se body))
                                   west? (recur (rest remaining) nw ne (conj sw body) se)
                                   north? (recur (rest remaining) nw (conj ne body) sw se))))))

(defn quadtree-node
  "recursively build a quad-tree of the bodies distribution with mass and density information"
  [rect bodies]
  (let [mass (apply + (map #(:mass %) bodies))
        center (center rect)
        num (count bodies)
        density (/ mass (area rect))
        node {:rect    rect
              :pos     center
              :mass    mass
              :density density}]

    (if (<= num TREECUTOFF) (-> node
                                (assoc :bodies bodies)
                                (assoc :leaf true))
                            (let [grouped (group-by-quad center bodies)
                                  children (map (fn [dir group] (quadtree-node (slice rect center dir) group))
                                                [0 1 2 3] grouped)]
                              (-> node
                                  (assoc :children children)
                                  (assoc :leaf false))))))

(defn get-clustered
  "traverse the tree to return bodies close to the pos arg and distant ones as grouped"
  [pos node]
  (let [dist-par (/ (get (:rect node) WIDTH) (v-dist pos (:pos node)))
        far-node? (< dist-par THRESHOLD)]
    (cond far-node? (select-keys node [:pos :mass])
          (:leaf node) (flatten (map #(get-clustered pos %) (:children node)))
          true (:bodies node))))

;=== PHYSICS - GRAVITY SIMULATION ===
(defn gravity-acc [body pos dampen]
  (if (nil? (:pos body)) [0 0]
                         (let [inv-dist #(/ 1 (+ dampen (Math/pow (v-dist %1 %2) 3)))]
                           (scalar (* G (:mass body) (inv-dist (:pos body) pos))
                                   (sub (:pos body) pos)))))

(defn gravacc-at-pos
  "Acceleration at pos caused by n-bodies and the HALO constant"
  [pos n-bodies]
  (let [n-bodies-acc (map #(gravity-acc % pos 1e-03) n-bodies)
        halo-acc (gravity-acc (HALO) pos 100)]
    (reduce add (conj n-bodies-acc halo-acc))))

(defn move-in-potential
  "Euler integration for one Body by in the gravity potential of n-bodies"
  [body dt n-bodies]
  (let [acc (gravacc-at-pos (:pos body) n-bodies)
        intervel (add (scalar (* 0.5 dt) acc) (:vel body))
        pos (add (scalar dt intervel) (:pos body))
        interacc (gravacc-at-pos pos n-bodies)
        vel (add (scalar dt interacc) intervel)]
    (-> body
        (assoc-in [:acc] acc)
        (assoc-in [:vel] vel)
        (assoc-in [:pos] pos))))

(defn get-gravitating-bodies
  "Get the simplified mass distribution from the quad-tree"
  [body quadtree]
  (let [not-self? (fn [other] (not= (:id body) (:id other)))
        n-bodies (filter not-self? (get-clustered (:pos body) quadtree))]
    n-bodies))

(defn update-body [body dt quadtree]
  (let [n-bodies (get-gravitating-bodies body quadtree)]
    (move-in-potential body dt n-bodies)))

(defn update-physics [bodies quadtree]
  (map #(update-body % TIMESTEP quadtree) bodies))

;=== STATE HANDLING ===

(defn get-screenrect [] [0 0 (q/width) (q/height)])

(def init-bodies (for [_ (range NBODIES)]
                   {:pos  [(* (q/width) (uniform 0.2 0.8)) (* (q/height) (uniform 0.2 0.8))]
                    :vel  [(uniform -0.25 0.25) (uniform -0.25 0.25)]
                    :mass (rand-n 10 100)
                    :id   (rand-n 4096)}))

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :hsb)
  (apply q/background [20 20 70])
  ; return initial-state
  {:bodies   init-bodies
   :quadtree (quadtree-node (get-screenrect) init-bodies)
   :draw-quadtree? false})

(defn update-state [state]
  (let [on-screen? (fn [body] (let [[x y] (:pos body)] (and (< 0 x (q/width)) (< 0 y (q/height)))))
        bodies (filter on-screen? (doall (update-physics (:bodies state) (:quadtree state))))
        quadtree (doall (quadtree-node (get-screenrect) bodies))]
    (-> state
        (assoc :bodies bodies)
        (assoc :quadtree quadtree))))

;=== DRAWING ===

(defn draw-circle [[x y] radius]
  (q/ellipse x y radius radius))

(defn draw-node [node]
  (when (and (some? node) (seq (:children node)))
    (q/fill 160 100 (* 20 (:density node)))
    (apply q/rect (:rect node))
    (doseq [child (:children node)]
      (draw-node child))))

(defn draw-quadtree [node]
  (q/stroke-weight 1)
  (q/stroke 160 60 160)
  (q/no-fill)
  (draw-node node))

(defn draw-bodies [bodies]
  (q/fill 255 0 255)
  (q/no-stroke)
  (doseq [body bodies]
    (draw-circle (:pos body) (Math/sqrt (* 0.1 (:mass body))))))

(defn draw-state [state]
  (apply q/background [160 20 60])
  (when (:draw-quadtree? state)
   (draw-quadtree (:quadtree state)))
  (draw-bodies (:bodies state)))

;=== CORE ===

(defn run-sketch [host size] ;DELETE
  (q/sketch
   :title "cluster"
   :size [size size]
   :host host

   :setup setup
   :update update-state
   :draw draw-state
   :mouse-clicked (fn [state] (update state :draw-quadtree? not))

   :middleware [m/fun-mode])
  ) ;DELETE

(quil-site.main/register-example! "cluster" "Marco Fink" run-sketch :interactive? true :white-play-button? true) ;DELETE
