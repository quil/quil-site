(ns quil-site.examples.floating-graph
  (:require [quil.core :as q :include-macros true]
            quil-site.main ;DELETE
            [quil.middleware :as m]
            [clojure.set :as sets]))
;;;
;;; By Johnny Hoffman - Aug 2016
;;; A quil sketch of a graph with slowly floating nodes, which change color according
;;; to breadth-first-search and depth-first-search.
;;;

;;;
;;; configuration (note that not all possible values are valid (e.g. size-min > size-max))
;;;

(def node-count 13)
(def edge-count 17)
(def frame-rate 30)
(def directional-axis-acceleration 0.05)
(def size-acceleration 0.01)
(def directional-speed-max 3)
(def size-max 30)
(def size-min 6)
(def size-bounce-velocity 0.08)
(def directional-bounce-velocity 0.48)
(def edge-width-proportion 0.2) ; proportional to size of each node in an edge
(def frames-between-visits 20)
; (def colors ... ) in setup because use of q/color cannot be used outside of sketch function
(def collections-init-by-search-type  ; bfs uses queue whereas dfs uses list
  {:bfs cljs.core/PersistentQueue.EMPTY
   :dfs '()})

;;;
;;; util
;;;

(defn rand-bi-dir
  "get a random value between -n and n"
  [n]
  (q/random (- n) n))

(defn map-value
  "iterates through map and applies fn to values returning new map"
  [fn m]
  (into {} (for [[key value] m] [key (fn value)])))

;;;
;;; graph elements and operations
;;;

(defn create-random-node
  "Construct a random node record
   label used for referencing the node in the graph's map"
  [label]
  {:label label
   :pos {:x (rand-int (q/width))
         :y (rand-int (q/height))}
   ; color key used by the x-first-search and as the key for physically coloring the node
   :color-key :untouched
   :size (+ size-min (rand-int (- size-max size-min)))
   :vel {:x (rand-bi-dir directional-speed-max)
         :y (rand-bi-dir directional-speed-max)
         :s (rand-bi-dir size-acceleration)}
   :siblings '()})

(defn add-edge
  "add an edge (set with two elements - the label of each node) to a node-map (map node-label->node)."
  [nodes edge]
  (let [[n1-label n2-label] edge]
    (-> nodes
        (update-in [n1-label :siblings] conj n2-label)
        (update-in [n2-label :siblings] conj n1-label))))

;;;
;;; quil state manipulation and drawing
;;;

(defn set-color
  "return a node map with a node colored given a node map, the label of the node to color, and a color"
  [nodes node-label color]
  (assoc-in nodes [node-label :color-key] color))


(defn adjust-directional-vel-to-bounds
  "adjust velocity if it is too fast or goes outside of view area"
  [vel pos max-speed min-pos max-pos bounce-vel size]
  (cond
    (> (+ pos vel (/ size 2)) max-pos)
    (- 0 bounce-vel)

    (< (+ pos vel (/ size -2)) min-pos)
    bounce-vel

    (> vel max-speed)
    max-speed

    (< vel (- 0 max-speed))
    (- 0 max-speed)

    :else
    vel))

(defn infer-new-search-state
  "Create sketch state with a fresh search-state, given search-type key and node map"
  [search-type nodes]
  (let [starting-node-key (rand-nth (keys nodes))] ; start search at random node
    {:nodes (set-color nodes starting-node-key search-type) ; set the start node as colored (i.e. visited by the new search alg)
     :search-state {:frames-to-wait frames-between-visits
                    :search-type search-type
                    :collection (into (search-type collections-init-by-search-type) [starting-node-key])}})) ; use the appropriate collection type for the search type

(defn setup
  "quil setup step"
  []
  (q/frame-rate frame-rate)

  (q/color-mode :rgb)

  ;; create initial nodes and edges ~randomly
  (let [labels (map #(keyword (str "n" %))
                    (range node-count))
        nodes (into {} (for [label labels]
                         [label (create-random-node label)]))
        create-random-edge #(->> labels shuffle (take 2) sort)
        edges (distinct (repeatedly edge-count create-random-edge))
        nodes (reduce add-edge nodes edges)
        state (infer-new-search-state :dfs nodes)]
    (assoc state
           ;; don't change :dfs/:bfs color names as they are equivalent
           ;; to search-states's search-type keywords
           :colors {:dfs (q/color 220 255 255)
                    :bfs (q/color 225 150 225)
                    :visiting (q/color 0)
                    :edge (q/color 240 150)
                    :untouched (q/color 240 150)}
           :edges edges)))

(defn update-movement
  "apply changes to velocity, position, and size"
  [state]
  (letfn [(new-velocity-coord [node coordinate max]
            (adjust-directional-vel-to-bounds
             (+ (get-in node [:vel coordinate]) (rand-bi-dir directional-axis-acceleration))
             (get-in node [:pos coordinate])
             directional-speed-max
             0
             max
             directional-bounce-velocity
             (:size node)))

          (new-velocity [node]
            {:x (new-velocity-coord node :x (q/width))
             :y (new-velocity-coord node :y (q/height))
             :s (let [new-vel (+ (:s (:vel node)) (rand-bi-dir size-acceleration))]
                  (cond (> (+ (:size node) new-vel) size-max) (- 0 size-bounce-velocity)
                        (< (+ (:size node) new-vel) size-min) size-bounce-velocity
                        :else new-vel))})

          (update-node [node]
            (assoc node
                   :vel (new-velocity node)
                   :size (+ (:size node) (:s (:vel node)))
                   :pos {:x (+ (:x (:pos node)) (:x (:vel node)))
                         :y (+ (:y (:pos node)) (:y (:vel node)))}))]
    (update-in state [:nodes] #(map-value update-node %))) )

(defn x-first-search
  "Colors nodes based on the progression of a search algorithm, determined by the search-type and collection type.
  Generic for breadth first search and depth first search because they just use different collection types (queue vs stack)."
  [state]
  (let [{:keys [nodes search-state]} state
        ; search-type key for coloring / checking if visited
        ; collection is  a stack if dfs, queue if bfs. Contains node labels.
        {:keys [search-type collection]} search-state
        n (nodes (peek collection)) ; for both list and queue, the first element
        next-n-label (first
                      ;; filter is lazy so we aren't necessarily searching through entire list.
                      (filter (fn [node-label]
                                (not= search-type (:color-key (nodes node-label))))
                              (:siblings n)))
        collection (if (nil? next-n-label)
                     (pop collection) ; for both list and queue, remove the first element
                     (conj collection next-n-label)) ; for list, add to front, for queue add to end - the defining difference between nfs and bfs
        nodes (if (nil? next-n-label)
                nodes
                (set-color nodes next-n-label search-type))]
    (-> state
        (assoc :nodes nodes)
        (assoc-in [:search-state :collection] collection))))

(defn update-colors
  "Wait for frames to pass by, or color nodes based on the search algorithm, or reset search when another search has ended"
  [state]
  (let [search-state (:search-state state)
        state (if (= (:frames-to-wait search-state) 1)
                (x-first-search (assoc-in state [:search-state :frames-to-wait] frames-between-visits))
                (update-in state [:search-state :frames-to-wait] dec))
        collection (get-in state [:search-state :collection])
        state (if (empty? collection)
                ;; when x-first-search returns empty collection, search finished, so start fresh with the other search alg
                (merge state
                       (infer-new-search-state (if (= :bfs (get-in state [:search-state :search-type])) :dfs :bfs) (:nodes state)))
                state)]
    state))

(defn update-state
  "quil update-state step"
  [state]
  (-> state update-movement update-colors))

(defn draw-edges [state]
  (let [{:keys [nodes colors edges]} state]
    (q/fill (:edge colors)) ; set fill as edge color
    ;; draw each edge as a quad. Determine points using some mathematical math.
    (doseq [edge edges]
      (let [[n1 n2] (map nodes edge)
            n1-pos (:pos n1)
            n2-pos (:pos n2)
            x1 (:x n1-pos)
            y1 (:y n1-pos)
            x2 (:x n2-pos)
            y2 (:y n2-pos)
            size1 (:size n1)
            size2 (:size n2)
            size1-adj (* size1 edge-width-proportion)
            size2-adj (* size2 edge-width-proportion)
            x-delta (- x2 x1)
            y-delta (- y2 y1)
            theta (q/atan2 x-delta y-delta)
            theta-2 (- (q/radians 90) theta)
            x-delta-2 (q/sin theta-2)
            y-delta-2 (q/cos theta-2)
            x1-a (+ x1 (* size1-adj x-delta-2))
            x1-b (- x1 (* size1-adj x-delta-2))
            y1-a (- y1 (* size1-adj y-delta-2))
            y1-b (+ y1 (* size1-adj y-delta-2))
            x2-a (+ x2 (* size2-adj x-delta-2))
            x2-b (- x2 (* size2-adj x-delta-2))
            y2-a (- y2 (* size2-adj y-delta-2))
            y2-b (+ y2 (* size2-adj y-delta-2))]
        (q/quad x1-a y1-a x1-b y1-b x2-b y2-b x2-a y2-a)))))

(defn draw-nodes [state]
  (let [{:keys [nodes colors search-state]} state
        visiting (peek (:collection search-state))]
    ;; draw each node
    (doseq [n (vals nodes)]
      (q/fill ((:color-key n) colors))
      (if (= visiting (:label n)) ; use a stroke for the node at the front of the stack/queue
        (q/stroke (:visiting colors))
        (q/no-stroke))
      (q/ellipse (:x (:pos n)) (:y (:pos n)) (:size n) (:size n)))))

(defn draw-state
  "quil draw-state step"
  [state]
  (q/background 255)
  (q/no-stroke)
  (draw-edges state)
  (draw-nodes state))

(defn run-sketch [host size] ;DELETE
  (q/sketch
    :host host
    :size [size size]
    :setup setup
    :update update-state
    :draw draw-state
    :middleware [m/fun-mode])
  ) ;DELETE

(quil-site.main/register-example! "floating graph" "Johnny Hoffman" run-sketch) ;DELETE
