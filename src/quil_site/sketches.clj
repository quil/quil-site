(ns quil-site.sketches
  (:require [compojure.core :refer :all :exclude [routes]]
            [ring.util.response :as resp]
            [hiccup.page :as p]
            [cljs.closure :as cljs]
            [cljs.env :as cljs-env]
            [me.raynes.fs :as fs]
            [quil-site.views.sketches :as views]))

(def cljs-compilation-dir (fs/temp-dir "cljs-compilation"))

(defn compile-cljs [cljs-text]
  (let [source (fs/temp-file "cljs-source" "cljs")
        compiled (fs/temp-file "cljs-compiled")]
    (spit source cljs-text)
    (cljs/build source
                {:optimizations :advanced
                 :output-to (.getAbsolutePath compiled)
                 :output-dir (.getAbsolutePath cljs-compilation-dir)
                 :externs ["externs/processing.js"]
                 :preamble ["processing.min.js"]
                 :pretty-print false})
    (let [compiled-text (slurp compiled)]
      (fs/delete source)
      (fs/delete compiled)
      compiled-text)))

(defn show-sketch [id])

(defn sketch-html [id]
  (-> (list [:head
             [:title "Sketch"]
             [:script {:src (str "/sketches/js/" id)}]
             [:style {:type "text/css"}
              "body { margin: 0px; overflow: hidden; } "]]
            [:body])
      (p/html5)
      (resp/response)
      (resp/content-type "text/html")))

(def id (atom 0))
(def sketches (atom {}))

(defn create-sketch [sketch]
  (let [id (str (swap! id inc))
        js (-> sketch :cljs compile-cljs)
        sketch (assoc sketch
                      :id id
                      :js js)]
    (swap! sketches assoc id sketch)
    (resp/response {:id id})))

(defn sketch-js [id]
  (-> (@sketches id)
      (:js (format "alert('Hello, world, %s');" id))
      (resp/response)
      (resp/content-type "application/javascript")))

(def test "(ns my.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :hsb)
  {:color 0
   :angle 0})

(defn update [state]
  (let [{:keys [color angle]} state]
    {:color (mod (+ color 0.7) 255)
     :angle (mod (+ angle 0.1) q/TWO-PI)}))

(defn draw [state]
  (q/background 240)
  (q/fill (:color state) 255 255)
  (let [angle (:angle state)
        x (* 150 (q/cos angle))
        y (* 150 (q/sin angle))]
    (q/with-translation [(/ (q/width) 2)
                         (/ (q/height) 2)]
      (q/ellipse x y 100 100))))

(q/defsketch my
  :host \"my\"
  :size [500 500]
  :setup setup
  :update update
  :draw draw
  :middleware [m/fun-mode])")

(defn sketch-info [id]
  (resp/response {:id id
                  :cljs test}))

(defroutes routes
  (context "/sketches" []
    (GET "/create" [] (views/create-sketch-page))
    (GET "/info/:id" [id] (sketch-info id))
    (GET "/show/:id" [id] (show-sketch id))
    (GET "/html/:id" [id] (sketch-html id))
    (GET "/js/:id" [id] (sketch-js id))
    (POST "/create" req (create-sketch (:body req)))))
