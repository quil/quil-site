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
;;; graph elements and operations
;;;

(defn node 
  "Construct a node record"
  [label ; used for referencing the node in the graph's map
   pos ; {:x __ :y __}
   color-key ; color key used by the x-first-search and as the key for physically coloring the node
   size ; float
   vel ; velocity {:x __ :y __ :s __} where s is size-change velocity
   siblings] ; set of labels of directly connected nodes

  {:label label :pos pos :color-key color-key :size size :vel vel :siblings siblings})

(defn add-edge
  "add an edge (set with two elements - the label of each node) to a node-map (map node-label->node)."
  [nodes edge]
  (let [edge (into '() edge) ; cannot index/peek set, so use list
        n1-key (peek edge)
        n2-key (peek (pop edge))
        ;; each node has the other node as a sibling
        nodes (update-in nodes [n1-key :siblings] (fn [s] (conj s n2-key)))
        nodes (update-in nodes [n2-key :siblings] (fn [s] (conj s n1-key)))]
    nodes))

(defn extract-edges
  "get a set of edges given a node-map"
  [nodes]
  ;; reduce edge sets from each node into a single set
  (reduce 
    (fn [edges n]
      (sets/union edges 
                  ;; create set of edges from a given node
                  (reduce 
                    (fn [edges k]
                      (conj edges #{(:label n) k}))
                    #{}
                    (:siblings n))))
    #{}
    nodes))

;;;
;;; util
;;;

(defn rand-bi-dir
  "get a random value between -n and n"
  [n]
  (- (rand (* 2 n)) n))

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
  ;; don't change :dfs/:bfs color names as they are equivalent to search-states's search-type keywords
  (def colors {:dfs(q/color 220 255 255)
               :bfs(q/color 225 150 225)
               :visiting (q/color 0)
               :edge (q/color 240 150)
               :untouched (q/color 240 150)})

  (q/frame-rate frame-rate)

  (q/color-mode :rgb)

  ;; create initial nodes and edges ~randomly 
  (let [nodes (loop [nodes {} amt-to-add node-count]
                (let [label (keyword (str "n" amt-to-add))
                      node (node label
                                 {:x (rand-int (q/width))
                                  :y (rand-int (q/height))}
                                 :untouched
                                 (+ size-min (rand-int (- size-max size-min)))
                                 {:x (rand-bi-dir directional-speed-max)
                                  :y (rand-bi-dir directional-speed-max)
                                  :s (rand-bi-dir size-acceleration)}
                                 '())
                      nodes (assoc nodes label node)]
                  (if (> amt-to-add 0) 
                    (recur nodes (dec amt-to-add))
                    nodes)))
        nodes (loop [nodes nodes amt-to-add edge-count]
                (let [ks (keys nodes)
                      k1 (rand-nth ks)
                      ks (into [] (disj (into #{} ks) k1))
                      k2 (rand-nth ks)
                      nodes (add-edge nodes #{k1 k2})] ; edge might already exist, but whatever
                  (if (> amt-to-add 0)
                    (recur nodes (dec amt-to-add))
                    nodes)))]
    (infer-new-search-state :dfs nodes)))

(defn update-movement
  "apply changes to velocity, position, and size"
  [state]
  (assoc state
         :nodes (loop [moved-nodes {} nodes (:nodes state)]
                  (let [k (first (keys nodes))
                        n (k nodes)
                        nodes (dissoc nodes k)
                        n (assoc n
                                 :vel {:x (adjust-directional-vel-to-bounds
                                            (+ (:x (:vel n)) (rand-bi-dir directional-axis-acceleration))
                                            (:x (:pos n))
                                            directional-speed-max
                                            0
                                            (q/width)
                                            directional-bounce-velocity
                                            (:size n))

                                       :y (adjust-directional-vel-to-bounds
                                            (+ (:y (:vel n)) (rand-bi-dir directional-axis-acceleration))
                                            (:y (:pos n))
                                            directional-speed-max
                                            0
                                            (q/height)
                                            directional-bounce-velocity
                                            (:size n))

                                       :s (let
                                            [new-vel (+ (:s (:vel n)) (rand-bi-dir size-acceleration))]
                                            (if (> (+ (:size n) new-vel) size-max)
                                              (- 0 size-bounce-velocity)
                                              (if (< (+ (:size n) new-vel) size-min)
                                                size-bounce-velocity
                                                new-vel)))}

                                 :size (+ (:size n) (:s (:vel n)))

                                 :pos {:x (+ (:x (:pos n)) (:x (:vel n)))
                                       :y (+ (:y (:pos n)) (:y (:vel n)))})
                        moved-nodes (assoc moved-nodes k n)]
                    (if (empty? nodes)
                      moved-nodes
                      (recur moved-nodes nodes))))))

(defn x-first-search
  "Colors nodes based on the progression of a search algorithm, determined by the search-type and collection type.
  Generic for breadth first search and depth first search because they just use different collection types (queue vs stack)."
  [state]
  (let [search-type (get-in state [:search-state :search-type]) ; search-type key for coloring / checking if visited
        nodes (:nodes state)
        collection (get-in state [:search-state :collection]) ; is a stack if dfs, queue if bfs
        n ((peek collection) nodes) ; for both list and queue, the first element
        next-n-key (first 
                     ;; filter is lazy so we aren't necessarily searching through entire list.
                     (filter (fn [node-key]  
                               (not= search-type (:color-key (node-key nodes)))) 
                             (:siblings n)))
        collection (if (nil? next-n-key)
                     (pop collection) ; for both list and queue, remove the first element
                     (conj collection next-n-key)) ; for list, add to front, for queue add to end - the defining difference between nfs and bfs
        nodes (if (nil? next-n-key)
                nodes
                (set-color nodes next-n-key search-type))]
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
                (infer-new-search-state (if (= :bfs (get-in state [:search-state :search-type])) :dfs :bfs) (:nodes state))
                state)]
    state))

(defn update-state
  "quil update-state step"
  [state]
  (update-colors 
    (update-movement state)))

(defn draw-state 
  "quil draw-state step"
  [state]
  (q/background 0 0 0 0)
  (q/no-stroke)
  (let [nodes (:nodes state)
        edges (extract-edges (vals nodes))
        visiting (peek (get-in state [:search-state :collection]))] 
    (q/fill (:edge colors)) ; set fill as edge color
    ;; draw each edge as a quad. Determine points using some mathematical math.
    (doseq [ks edges]
      (let [ks (into [] ks)
            n1 ((nth ks 0) nodes)
            n2 ((nth ks 1) nodes)
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
        (q/with-translation [0 0]
          (q/quad x1-a y1-a x1-b y1-b x2-b y2-b x2-a y2-a))))

    ;; draw each node
    (doseq [n (vals nodes)]
      (q/fill ((:color-key n) colors))
      (if (= visiting (:label n)) ; use a stroke for the node at the front of the stack/queue
        (q/stroke (:visiting colors))
        (q/no-stroke))
      (q/with-translation [0 0]
        (q/ellipse (:x (:pos n)) (:y (:pos n)) (:size n) (:size n))))
    state))

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
