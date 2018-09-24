({:fns ["lerp-color"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "lerp-color",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/lerp-color 4278255360 4278190335 0.5) (let [c1 (q/color 255 0 0) c2 (q/color 0 0 255)] (dotimes [i 6] (q/fill (q/lerp-color c1 c2 (/ i 5))) (q/rect (* i 70) (* i 70) 100 100))))",
  :setup "()",
  :target :cljs}
 {:fns ["current-stroke"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "current-stroke",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke 255 0 0) (q/rect 0 0 100 100) (let [cur-stroke (q/current-stroke)] (q/stroke 0 0 255) (q/rect 70 70 100 100) (q/stroke cur-stroke) (q/rect 140 140 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["current-fill"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "current-fill",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 255 0 0) (q/rect 0 0 100 100) (let [cur-fill (q/current-fill)] (q/fill 0 0 255) (q/rect 70 70 100 100) (q/fill cur-fill) (q/rect 140 140 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["color-mode"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "color-mode",
  :opts {:settings nil},
  :draw
  "((q/color-mode :rgb 255) (q/background 255) (q/color-mode :hsb) (q/fill 255 255 255) (q/rect 0 0 100 100) (q/color-mode :rgb 42) (q/fill 42 42 0 20) (q/rect 70 70 100 100) (q/color-mode :hsb 5 10 20) (q/fill 5 10 20) (q/rect 140 140 100 100) (q/color-mode :rgb 5 10 20 30) (q/fill 5 10 0 15) (q/rect 210 210 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["color"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "color",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill (q/color 0)) (q/rect 0 0 100 100) (q/fill (q/color 128 128)) (q/rect 70 70 100 100) (q/fill (q/color 255 0 255)) (q/rect 140 140 100 100) (q/fill (q/color 0 255 255 120)) (q/rect 210 210 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["hue" "saturation" "brightness"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "hue-saturation-brightness",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/hue 4279312947) (q/saturation 4279312947) (q/brightness 4279312947) (q/color-mode :hsb) (let [col (q/color 100 230 100)] (q/fill col) (q/rect 0 0 100 100) (q/fill (q/hue col) 255 255) (q/rect 70 70 100 100) (q/fill 255 (q/saturation col) 255) (q/rect 140 140 100 100) (q/fill 255 255 (q/brightness col)) (q/rect 210 210 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["red" "green" "blue"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "red-green-blue",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/red 4279312947) (q/green 4279312947) (q/blue 4279312947) (let [col (q/color 123 50 220)] (q/fill col) (q/rect 0 0 100 100) (q/fill (q/red col) 0 0) (q/rect 70 70 100 100) (q/fill 0 (q/green col) 0) (q/rect 140 140 100 100) (q/fill 0 0 (q/blue col)) (q/rect 210 210 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["blend-color"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "blend-color",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/blend-color 4278255360 4294901760 :blend) (let [c1 (q/color 255 100 20 50) c2 (q/color 40 200 255 200) modes [:blend :add :subtract :darkest :lightest :difference :exclusion :multiply :screen :overlay :hard-light :soft-light :dodge :burn] splitted (partition-all 3 modes)] (q/fill c1) (q/rect 0 0 70 70) (q/fill c2) (q/rect 100 0 70 70) (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col)] (q/fill (q/blend-color c1 c2 mode))) (q/rect (* col 100) (* (inc row) 100) 70 70)))))",
  :setup "()",
  :target :cljs}
 {:fns ["alpha"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "alpha",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/alpha 4278255360) (let [semi-red (q/color 255 0 0 120) alph (q/alpha semi-red) semi-blue (q/color 0 0 255 alph)] (q/fill semi-red) (q/rect 0 0 100 100) (q/fill semi-blue) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["text-width"],
  :ns "quil.snippets.typography.attributes",
  :name "text-width",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (let [txt \"Hello, world!\" width (q/text-width txt)] (q/text txt 20 20) (q/text (str \"Width of text above is \" width) 20 40)))",
  :setup "()",
  :target :cljs}
 {:fns ["text-size"],
  :ns "quil.snippets.typography.attributes",
  :name "text-size",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (doseq [ind (range 6) :let [size (+ 10 (* ind 5))]] (q/text-size size) (q/text (str \"Text size: \" size) 20 (+ 20 (* ind 80)))))",
  :setup "()",
  :target :cljs}
 {:fns ["text-mode"],
  :ns "quil.snippets.typography.attributes",
  :name "text-mode",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/fill 0) (q/text-mode :model) (q/text \"text-mode: model\" 20 50) (q/text-mode :shape) (q/text \"text-mode: shape\" 20 100))",
  :setup "()",
  :target :cljs}
 {:fns ["text-leading"],
  :ns "quil.snippets.typography.attributes",
  :name "text-leading",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (doseq [ind (range 4) :let [leading (* ind 10)]] (q/text-leading leading) (q/text (str \"text leading\\n\" leading) 20 (+ 20 (* ind 100)))))",
  :setup "()",
  :target :cljs}
 {:fns ["text-align"],
  :ns "quil.snippets.typography.attributes",
  :name "text-align",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (q/stroke 255 0 0) (q/stroke-weight 5) (let [h-align [:left :center :right] v-align [:top :bottom :center :baseline]] (doseq [ind (range (count h-align)) :let [x 50 y (+ 20 (* ind 50))]] (q/text-align (h-align ind)) (q/text (name (h-align ind)) x y) (q/point x y)) (doseq [ind-h (range (count h-align)) ind-v (range (count v-align)) :let [x (+ 70 (* ind-v 100)) y (+ 250 (* ind-h 50)) h-al (h-align ind-h) v-al (v-align ind-v) txt (str (name h-al) \"+\" (name v-al))]] (q/text-align h-al v-al) (q/text txt x y) (q/point x y))))",
  :setup "()",
  :target :cljs}
 {:fns ["set-image"],
  :ns "quil.snippets.image.pixels",
  :name "set-image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 255) (q/fill 255 0 0) (q/ellipse 50 50 90 90)) (q/set-image 10 10 gr)))",
  :setup "()",
  :target :cljs}
 {:fns ["display-filter"],
  :ns "quil.snippets.image.pixels",
  :name "display-filter",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [orig (q/create-graphics 100 100) modes [[:threshold] [:threshold 0.7] [:gray] [:invert] [:posterize 20] [:blur] [:blur 3] [:opaque] [:erode] [:dilate]] splitted (partition-all 4 modes)] (q/with-graphics orig (q/color-mode :rgb 1.0) (q/background 1) (q/no-stroke) (q/ellipse-mode :corner) (doseq [r (range 0 1 0.1) b (range 0 1 0.1)] (q/fill r 0 b) (q/ellipse (* r 100) (* b 100) 10 10))) (q/image orig 0 0) (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col) dest (q/create-graphics 100 100)] (q/with-graphics dest (q/image orig 0 0) (apply q/display-filter mode)) (q/image dest (* col 120) (* 120 (inc row))))))))",
  :setup "()",
  :target :cljs}
 {:fns ["image-filter"],
  :ns "quil.snippets.image.pixels",
  :name "image-filter",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [orig (q/create-graphics 100 100) modes [[:threshold] [:threshold 0.7] [:gray] [:invert] [:posterize 20] [:blur] [:blur 3] [:opaque] [:erode] [:dilate]] splitted (partition-all 4 modes)] (q/with-graphics orig (q/color-mode :rgb 1.0) (q/background 1) (q/no-stroke) (q/ellipse-mode :corner) (doseq [r (range 0 1 0.1) b (range 0 1 0.1)] (q/fill r 0 b) (q/ellipse (* r 100) (* b 100) 10 10))) (q/image orig 0 0) (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col) clone (q/get-pixel orig)] (apply q/image-filter clone mode) (q/image clone (* col 120) (* 120 (inc row))))))))",
  :setup "()",
  :target :cljs}
 {:fns ["millis" "seconds" "minute" "hour" "day" "month" "year"],
  :ns "quil.snippets.input",
  :name "time-and-date",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (doseq [[ind capt fn] [[0 \"millis\" q/millis] [1 \"seconds\" q/seconds] [2 \"minute\" q/minute] [3 \"hour\" q/hour] [4 \"day\" q/day] [5 \"month\" q/month] [6 \"year\" q/year]]] (q/text (str capt \" \" (fn)) 10 (+ (* 20 ind) 20))))",
  :setup "()",
  :target :cljs}
 {:fns
  ["mouse-button"
   "mouse-pressed?"
   "mouse-x"
   "mouse-y"
   "pmouse-x"
   "pmouse-y"],
  :ns "quil.snippets.input",
  :name "mouse",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (doseq [[ind capt fn] [[0 \"mouse-button\" q/mouse-button] [1 \"mouse-pressed?\" q/mouse-pressed?] [2 \"mouse-x\" q/mouse-x] [3 \"mouse-y\" q/mouse-y] [4 \"pmouse-x\" q/pmouse-x] [5 \"pmouse-y\" q/pmouse-y]]] (q/text (str capt \" \" (fn)) 10 (+ (* 20 ind) 20))))",
  :setup "()",
  :target :cljs}
 {:fns
  ["key-as-keyword" "key-code" "key-coded?" "key-pressed?" "raw-key"],
  :ns "quil.snippets.input",
  :name "keyboard",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (doseq [[ind capt fn] [[0 \"key-as-keyword\" q/key-as-keyword] [1 \"key-code\" q/key-code] [2 \"key-coded?\" (fn* [] (q/key-coded? (q/raw-key)))] [3 \"key-pressed?\" q/key-pressed?] [4 \"raw-key\" q/raw-key]]] (q/text (str capt \" \" (fn)) 10 (+ (* 20 ind) 20))))",
  :setup "()",
  :target :cljs}
 {:fns ["sqrt"],
  :ns "quil.snippets.math.calculation",
  :name "sqrt",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/sqrt 25) = \" (q/sqrt 25)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["sq"],
  :ns "quil.snippets.math.calculation",
  :name "sq",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/sq 5) = \" (q/sq 5)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["round"],
  :ns "quil.snippets.math.calculation",
  :name "round",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/round 9.2) = \" (q/round 9.2)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["pow"],
  :ns "quil.snippets.math.calculation",
  :name "pow",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/pow 2 10) = \" (q/pow 2 10)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["norm"],
  :ns "quil.snippets.math.calculation",
  :name "norm",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/norm 20 0 50) = \" (q/norm 20 0 50)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["map-range"],
  :ns "quil.snippets.math.calculation",
  :name "map-range",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/map-range 2 0 5 10 20) = \" (q/map-range 2 0 5 10 20)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["mag"],
  :ns "quil.snippets.math.calculation",
  :name "mag",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/mag 3 4) = \" (q/mag 3 4)) 10 20) (q/text (str \"(q/mag 3 4 5) = \" (q/mag 3 4 5)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["log"],
  :ns "quil.snippets.math.calculation",
  :name "log",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/log Math/E) = \" (q/log Math/E)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["lerp"],
  :ns "quil.snippets.math.calculation",
  :name "lerp",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/lerp 2 5 0.5) = \" (q/lerp 2 5 0.5)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["floor"],
  :ns "quil.snippets.math.calculation",
  :name "floor",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/floor 9.03) = \" (q/floor 9.03)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["exp"],
  :ns "quil.snippets.math.calculation",
  :name "exp",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/exp 2) = \" (q/exp 2)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["dist"],
  :ns "quil.snippets.math.calculation",
  :name "dist",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/dist 0 0 3 4) = \" (q/dist 0 0 3 4)) 10 20) (q/text (str \"(q/dist 0 0 0 5 5 5) = \" (q/dist 0 0 0 5 5 5)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["constrain"],
  :ns "quil.snippets.math.calculation",
  :name "constrain",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/constrain 4 10 20) = \" (q/constrain 4 10 20)) 10 20) (q/text (str \"(q/constrain 4.5 1.5 3.9) = \" (q/constrain 4.5 1.5 3.9)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["ceil"],
  :ns "quil.snippets.math.calculation",
  :name "ceil",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/ceil 9.03) = \" (q/ceil 9.03)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["abs"],
  :ns "quil.snippets.math.calculation",
  :name "abs",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/abs -1) = \" (q/abs -1)) 10 20) (q/text (str \"(q/abs -0.5) = \" (q/abs -0.5)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["unhex"],
  :ns "quil.snippets.data.conversion",
  :name "unhex",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/unhex \"2A\")) 10 10))",
  :setup "()",
  :target :cljs}
 {:fns ["unbinary"],
  :ns "quil.snippets.data.conversion",
  :name "unbinary",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/unbinary \"0101010\")) 10 10))",
  :setup "()",
  :target :cljs}
 {:fns ["hex"],
  :ns "quil.snippets.data.conversion",
  :name "hex",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (q/hex 42) 10 10) (q/text (q/hex 42 5) 10 30))",
  :setup "()",
  :target :cljs}
 {:fns ["binary"],
  :ns "quil.snippets.data.conversion",
  :name "binary",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (q/binary 42) 10 10) (q/text (q/binary 42 5) 10 30))",
  :setup "()",
  :target :cljs}
 {:fns ["tint"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "tint",
  :opts {:settings nil},
  :draw
  "((q/background 127) (q/tint 4279312947) (q/no-tint) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 0 0) (q/fill 255) (q/ellipse 25 25 40 40) (q/fill 255 0 0) (q/ellipse 75 25 40 40) (q/fill 0 255 0) (q/ellipse 25 75 40 40) (q/fill 0 0 255) (q/ellipse 75 75 40 40)) (q/no-tint) (q/image gr 0 0) (q/tint 127) (q/image gr 120 0) (q/tint 255 127) (q/image gr 240 0) (q/tint 200 127 180) (q/image gr 0 120) (q/tint 200 127 180 127) (q/image gr 120 120)))",
  :setup "()",
  :target :cljs}
 {:fns ["image"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "request-image",
  :opts {:settings nil},
  :draw
  "((if (zero? (.-width (q/state :image))) (q/text \"Loading\" 10 10) (q/image (q/state :image) 0 0)))",
  :setup
  "(q/set-state! :image (q/request-image \"https://github.com/quil/quil/raw/master/dev-resources/quil.png\"))",
  :target :cljs}
 {:fns ["no-tint"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "no-tint",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 0 0) (q/fill 255) (q/ellipse 50 50 70 70)) (q/image gr 0 0) (q/tint 127 255 255) (q/image gr 100 0) (q/no-tint) (q/image gr 200 0)))",
  :setup "()",
  :target :cljs}
 {:fns ["image-mode"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "image-mode",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/fill 0 0 255) (q/stroke 0 0 255) (q/rect 0 0 100 100)) (q/stroke-weight 10) (q/image-mode :corner) (q/image gr 50 50) (q/point 50 50) (q/image-mode :center) (q/image gr 250 100) (q/point 250 100) (q/image-mode :corners) (q/image gr 350 50 400 150) (q/point 350 50) (q/point 400 150)))",
  :setup "()",
  :target :cljs}
 {:fns ["image"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 70 70)] (q/with-graphics gr (q/ellipse 35 35 70 70)) (q/image gr 0 0) (q/image gr 100 0 100 70)))",
  :setup "()",
  :target :cljs}
 {:fns ["shape-mode"],
  :ns "quil.snippets.shape.loading-and-displaying",
  :name "shape-mode",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [sh (q/load-shape \"Heckert_GNU_white.svg\")] (q/stroke-weight 5) (q/stroke 255 0 0) (q/shape-mode :corner) (q/shape sh 20 20 200 200) (q/point 20 20) (q/shape-mode :corners) (q/shape sh 270 20 370 120) (q/point 270 20) (q/point 370 120) (q/shape-mode :center) (q/shape sh 100 350 150 150) (q/point 100 350)))",
  :setup "()",
  :target :cljs}
 {:fns ["shape"],
  :ns "quil.snippets.shape.loading-and-displaying",
  :name "shape",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [sh (q/load-shape \"Heckert_GNU_white.svg\")] (q/shape sh) (q/shape sh 100 100) (q/shape sh 300 300 200 200)))",
  :setup "()",
  :target :cljs}
 {:fns ["load-shape"],
  :ns "quil.snippets.shape.loading-and-displaying",
  :name "load-shape",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [sh (q/load-shape \"Heckert_GNU_white.svg\")] (q/shape sh 0 0 500 500)))",
  :setup "()",
  :target :cljs}
 {:fns ["text-descent"],
  :ns "quil.snippets.typography.metrics",
  :name "text-descent",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"Descent is \" (q/text-descent)) 20 20))",
  :setup "()",
  :target :cljs}
 {:fns ["text-ascent"],
  :ns "quil.snippets.typography.metrics",
  :name "text-ascent",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"Ascent is \" (q/text-ascent)) 20 20))",
  :setup "()",
  :target :cljs}
 {:fns ["translate"],
  :ns "quil.snippets.transform",
  :name "translate",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (q/translate 100 0) (q/box 50) (q/translate [-100 100]) (q/box 50) (q/translate 0 -100 100) (q/box 50))",
  :setup "()",
  :target :cljs}
 {:fns ["shear-x" "shear-y"],
  :ns "quil.snippets.transform",
  :name "shear-x-y",
  :opts {:settings nil},
  :draw
  "((q/with-translation [125 125] (q/rect 0 0 100 50)) (q/with-translation [375 125] (q/shear-y 0.5) (q/rect 0 0 100 50)) (q/with-translation [125 375] (q/shear-x 0.5) (q/rect 0 0 100 50)))",
  :setup "()",
  :target :cljs}
 {:fns ["scale"],
  :ns "quil.snippets.transform",
  :name "scale",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (q/with-translation [100 0 0] (q/scale 0.5) (q/box 50) (q/scale 2)) (q/with-translation [0 100 0] (q/scale 1 0.5) (q/box 50) (q/scale 1 2)) (q/with-translation [0 0 100] (q/scale 0.5 1 1.5) (q/box 50) (q/scale 2 1 0.75)))",
  :setup "()",
  :target :cljs}
 {:fns ["rotate-x" "rotate-y" "rotate-z"],
  :ns "quil.snippets.transform",
  :name "rotate-x-y-z",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (q/push-matrix) (q/translate 100 0 0) (q/rotate-x 0.5) (q/box 50) (q/pop-matrix) (q/push-matrix) (q/translate 0 100 0) (q/rotate-y 0.5) (q/box 50) (q/pop-matrix) (q/push-matrix) (q/translate 0 0 100) (q/rotate-z 0.5) (q/box 50) (q/pop-matrix))",
  :setup "()",
  :target :cljs}
 {:fns ["rotate"],
  :ns "quil.snippets.transform",
  :name "rotate",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (q/push-matrix) (q/translate 100 0 0) (q/rotate 0.5) (q/box 50) (q/pop-matrix) (q/push-matrix) (q/translate 0 100 0) (q/rotate 0.5 1 0 0) (q/box 50) (q/pop-matrix) (q/push-matrix) (q/translate 0 0 100) (q/rotate 0.5 0 1 0) (q/box 50) (q/pop-matrix))",
  :setup "()",
  :target :cljs}
 {:fns ["reset-matrix"],
  :ns "quil.snippets.transform",
  :name "reset-matrix",
  :opts {:settings nil},
  :draw
  "((q/rect 0 0 100 50) (q/translate 250 250) (q/rect 0 0 50 50) (q/reset-matrix) (q/rect 0 0 50 100))",
  :setup "()",
  :target :cljs}
 {:fns ["print-matrix"],
  :ns "quil.snippets.transform",
  :name "print-matrix",
  :opts {:settings nil},
  :draw
  "((q/translate 250 250) (q/rotate 1) (q/rect 0 0 100 100) (q/print-matrix))",
  :setup "()",
  :target :cljs}
 {:fns ["push-matrix" "pop-matrix"],
  :ns "quil.snippets.transform",
  :name "push-matrix-pop-matrix",
  :opts {:settings nil},
  :draw
  "((q/fill 255 0 0) (q/translate 20 20) (q/rect 0 0 50 50) (q/translate 150 0) (q/push-matrix) (q/rotate 1) (q/rect 0 0 50 50) (q/pop-matrix) (q/translate 150 0) (q/rect 0 0 50 50))",
  :setup "()",
  :target :cljs}
 {:fns ["apply-matrix"],
  :ns "quil.snippets.transform",
  :name "apply-matrix",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (let [s (q/sin 1) c (q/cos 1)] (q/apply-matrix 1 0 0 0 0 c s 50 0 (- s) c -50 0 0 0 1)) (q/box 50))",
  :setup "()",
  :target :cljs}
 {:fns ["with-graphics"],
  :ns "quil.snippets.rendering",
  :name "with-graphics",
  :opts {:settings nil},
  :draw
  "((let [gr (q/create-graphics 250 250)] (q/with-graphics gr (q/background 255) (q/fill 255 0 0) (q/triangle 50 30 220 120 20 180)) (q/image gr 0 0) (q/image gr 250 0) (q/image gr 0 250) (q/image gr 250 250)))",
  :setup "()",
  :target :cljs}
 {:fns ["hint"],
  :ns "quil.snippets.rendering",
  :name "hint",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((let [hints [:enable-async-saveframe :disable-async-saveframe :enable-depth-test :disable-depth-test :enable-depth-sort :disable-depth-sort :enable-opengl-errors :disable-opengl-errors :enable-depth-mask :disable-depth-mask :enable-optimized-stroke :disable-optimized-stroke :enable-stroke-perspective :disable-stroke-perspective :enable-stroke-pure :disable-stroke-pure :enable-texture-mipmaps :disable-texture-mipmaps]] (doseq [h hints] (q/hint h))) (q/ellipse 250 250 400 200))",
  :setup "()",
  :target :cljs}
 {:fns ["sphere-detail"],
  :ns "quil.snippets.shape.primitives-3d",
  :name "sphere-detail",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/sphere-detail 30) (q/with-translation [0 0 100] (q/sphere 70)) (q/sphere-detail 15) (q/with-translation [100 0 0] (q/sphere 70)) (q/sphere-detail 30 5) (q/with-translation [0 100 0] (q/sphere 70)))",
  :setup "()",
  :target :cljs}
 {:fns ["sphere"],
  :ns "quil.snippets.shape.primitives-3d",
  :name "sphere",
  :opts {:renderer :p3d, :settings nil},
  :draw "((q/camera 200 200 200 0 0 0 0 0 -1) (q/sphere 150))",
  :setup "()",
  :target :cljs}
 {:fns ["box"],
  :ns "quil.snippets.shape.primitives-3d",
  :name "box",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/with-translation [100 0 0] (q/box 70)) (q/with-translation [0 100 0] (q/box 70 100 50)))",
  :setup "()",
  :target :cljs}
 {:fns ["looping?"],
  :ns "quil.snippets.structure",
  :name "looping?",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/looping?) = \" (q/looping?)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["push-style" "pop-style"],
  :ns "quil.snippets.structure",
  :name "push-style-pop-style",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 255 0 0) (q/ellipse 125 125 100 100) (q/push-style) (q/fill 0 0 255) (q/ellipse 250 250 100 100) (q/pop-style) (q/ellipse 375 375 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["spot-light"],
  :ns "quil.snippets.lights-camera.lights",
  :name "spot-light",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/spot-light 255 0 0 50 0 50 -1 0 -1 q/PI 1) (q/spot-light [0 0 255] [0 100 100] [0 -1 -1] q/PI 1) (q/box 50))",
  :setup "()",
  :target :cljs}
 {:fns ["point-light"],
  :ns "quil.snippets.lights-camera.lights",
  :name "point-light",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/point-light 255 150 150 100 100 100) (q/box 50))",
  :setup "()",
  :target :cljs}
 {:fns ["normal"],
  :ns "quil.snippets.lights-camera.lights",
  :name "normal",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 40 40 0 0 0 -1) (q/point-light 150 250 150 10 30 50) (q/begin-shape) (q/normal 0 0 1) (doseq [v [[20 20 -10] [80 20 10] [80 80 -10] [20 80 10]]] (apply q/vertex v)) (q/end-shape :close))",
  :setup "()",
  :target :cljs}
 {:fns ["no-lights"],
  :ns "quil.snippets.lights-camera.lights",
  :name "no-lights",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/directional-light 255 150 150 -1 -0.76 -0.5) (q/box 50) (q/no-lights) (q/translate 0 50 0) (q/sphere 20))",
  :setup "()",
  :target :cljs}
 {:fns ["lights"],
  :ns "quil.snippets.lights-camera.lights",
  :name "lights",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/lights) (q/box 50))",
  :setup "()",
  :target :cljs}
 {:fns ["light-specular"],
  :ns "quil.snippets.lights-camera.lights",
  :name "light-specular",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/light-specular 100 100 255) (q/directional-light 255 150 150 -1 -0.76 -0.5) (q/box 50))",
  :setup "()",
  :target :cljs}
 {:fns ["light-falloff"],
  :ns "quil.snippets.lights-camera.lights",
  :name "light-falloff",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/light-falloff 1 0.008 0) (q/point-light 255 150 150 100 100 100) (q/box 50))",
  :setup "()",
  :target :cljs}
 {:fns ["directional-light"],
  :ns "quil.snippets.lights-camera.lights",
  :name "directional-light",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/directional-light 255 150 150 -1 -0.76 -0.5) (q/box 50))",
  :setup "()",
  :target :cljs}
 {:fns ["ambient-light"],
  :ns "quil.snippets.lights-camera.lights",
  :name "ambient-light",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 1) (q/ambient-light 200 190 230) (q/sphere 50))",
  :setup "()",
  :target :cljs}
 {:fns ["texture-mode"],
  :ns "quil.snippets.shape.vertex",
  :name "texture-mode",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((if (zero? (.-width (q/state :image))) (q/text \"Loading\" 10 10) (let [gr (q/state :image)] (q/with-translation [375 125] (q/begin-shape) (q/texture gr) (q/texture-mode :image) (q/vertex 0 0 0 0) (q/vertex 100 100 100 100) (q/vertex 0 100 0 100) (q/end-shape :close)) (q/with-translation [125 375] (q/begin-shape) (q/texture gr) (q/texture-mode :normal) (q/vertex 0 0 0 0) (q/vertex 100 100 1 1) (q/vertex 0 100 0 1) (q/end-shape :close)))))",
  :setup "(q/set-state! :image (q/request-image \"texture.jpg\"))",
  :target :cljs}
 {:fns ["texture"],
  :ns "quil.snippets.shape.vertex",
  :name "texture",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((if (zero? (.-width (q/state :image))) (q/text \"Loading\" 10 10) (let [gr (q/state :image)] (q/with-translation [250 250] (q/begin-shape) (q/texture gr) (q/vertex 50 100 75 100) (q/vertex 100 50 100 75) (q/vertex 100 -50 100 25) (q/vertex 50 -100 75 0) (q/vertex -50 -100 25 0) (q/vertex -100 -50 0 25) (q/vertex -100 50 0 75) (q/vertex -50 100 25 100) (q/end-shape :close)))))",
  :setup "(q/set-state! :image (q/request-image \"texture.jpg\"))",
  :target :cljs}
 {:fns ["curve-vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "curve-vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 50 200 50 50 0 0 0 0 1) (q/begin-shape) (q/curve-vertex 0 0) (q/curve-vertex 0 0) (q/curve-vertex 100 20) (q/curve-vertex 100 80) (q/curve-vertex 20 80) (q/curve-vertex 0 0) (q/curve-vertex 0 0) (q/end-shape :close) (q/begin-shape) (q/curve-vertex 0 0 0) (q/curve-vertex 0 0 0) (q/curve-vertex 100 0 20) (q/curve-vertex 100 0 80) (q/curve-vertex 20 0 80) (q/curve-vertex 0 0 0) (q/curve-vertex 0 0 0) (q/end-shape :close))",
  :setup "()",
  :target :cljs}
 {:fns ["bezier-vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "bezier-vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera -400 250 -100 500 250 0 0 0 1) (q/begin-shape) (q/vertex 30 20) (q/bezier-vertex 480 0 480 475 30 475) (q/bezier-vertex 250 380 360 125 30 20) (q/end-shape :close) (q/begin-shape) (q/vertex 30 20 0) (q/bezier-vertex 480 0 20 480 475 30 30 475 40) (q/bezier-vertex 250 380 40 360 125 10 30 20 0) (q/end-shape :close))",
  :setup "()",
  :target :cljs}
 {:fns ["begin-shape" "end-shape"],
  :ns "quil.snippets.shape.vertex",
  :name "begin-shape-end-shape-in-graphics",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [gr (q/create-graphics 400 400 :p2d)] (q/with-graphics gr (q/stroke 255 0 0) (q/begin-shape :triangles) (q/vertex 200 40) (q/vertex 320 120) (q/vertex 320 280) (q/vertex 200 360) (q/vertex 80 280) (q/vertex 80 120) (q/end-shape)) (q/image gr 0 0)))",
  :setup "()",
  :target :cljs}
 {:fns ["begin-shape" "end-shape"],
  :ns "quil.snippets.shape.vertex",
  :name "begin-shape-end-shape",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/stroke 255 0 0) (doseq [[ind begin-mode close-mode] [[0 nil nil] [1 nil :close] [2 :points] [3 :lines] [4 :triangles] [5 :triangle-fan] [6 :triangle-strip] [7 :quads] [8 :quad-strip]] :let [base-x (* 150 (mod ind 3)) base-y (* 150 (quot ind 3))]] (if begin-mode (q/begin-shape begin-mode) (q/begin-shape)) (q/vertex (+ base-x 50) (+ base-y 10)) (q/vertex (+ base-x 80) (+ base-y 30)) (q/vertex (+ base-x 80) (+ base-y 70)) (q/vertex (+ base-x 50) (+ base-y 90)) (q/vertex (+ base-x 20) (+ base-y 70)) (q/vertex (+ base-x 20) (+ base-y 30)) (if close-mode (q/end-shape close-mode) (q/end-shape))))",
  :setup "()",
  :target :cljs}
 {:fns ["stroke"],
  :ns "quil.snippets.color.setting",
  :name "stroke",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke-weight 10) (q/stroke 120) (q/rect 0 0 100 100) (q/stroke 80 120) (q/rect 70 70 100 100) (q/stroke 0 255 0) (q/rect 140 140 100 100) (q/stroke 255 0 0 120) (q/rect 210 210 100 100) (q/stroke 4278255360) (q/rect 280 280 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["no-stroke"],
  :ns "quil.snippets.color.setting",
  :name "no-stroke",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 120) (q/stroke 0) (q/rect 0 0 100 100) (q/no-stroke) (q/rect 70 70 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["no-fill"],
  :ns "quil.snippets.color.setting",
  :name "no-fill",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke 0) (q/fill 120) (q/rect 0 0 100 100) (q/no-fill) (q/rect 70 70 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["fill"],
  :ns "quil.snippets.color.setting",
  :name "fill",
  :opts {:settings nil},
  :draw
  "((q/background 0 0 255) (q/fill 120) (q/rect 0 0 100 100) (q/fill 80 120) (q/rect 70 70 100 100) (q/fill 0 255 0) (q/rect 140 140 100 100) (q/fill 255 0 0 120) (q/rect 210 210 100 100) (q/fill 4278255360) (q/rect 280 280 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["background-image"],
  :ns "quil.snippets.color.setting",
  :name "background-image",
  :opts {:settings nil},
  :draw
  "((let [gr (q/create-graphics (q/width) (q/height))] (q/with-graphics gr (q/background 0 90 120) (q/ellipse 250 250 300 300)) (q/background-image gr)))",
  :setup "()",
  :target :cljs}
 {:fns ["background"],
  :ns "quil.snippets.color.setting",
  :name "background",
  :opts {:settings nil},
  :draw
  "((q/background 255 0 0) (q/background 4279312947) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 120)) (q/image gr 0 0) (q/with-graphics gr (q/background 70 120)) (q/image gr 70 70) (q/with-graphics gr (q/background 0 255 255)) (q/image gr 140 140) (q/with-graphics gr (q/background 0 0 255 120)) (q/image gr 210 210)))",
  :setup "()",
  :target :cljs}
 {:fns ["print-projection"],
  :ns "quil.snippets.lights-camera.camera",
  :name "print-projection",
  :opts {:renderer :p3d, :settings nil},
  :draw "((q/print-projection))",
  :setup "()",
  :target :cljs}
 {:fns ["print-camera"],
  :ns "quil.snippets.lights-camera.camera",
  :name "print-camera",
  :opts {:renderer :p3d, :settings nil},
  :draw "((q/print-camera))",
  :setup "()",
  :target :cljs}
 {:fns ["perspective"],
  :ns "quil.snippets.lights-camera.camera",
  :name "perspective",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [perspective-params [[] [(/ q/PI 2) 0.5 50 300]] pos [[0 0] [250 0] [127 250]]] (dotimes [ind (count perspective-params)] (let [gr (q/create-graphics 240 240 :p3d)] (q/with-graphics gr (q/background 255) (q/camera 100 100 100 0 0 0 0 0 -1) (apply q/perspective (nth perspective-params ind)) (q/fill 127) (q/box 100)) (apply q/image gr (nth pos ind))))))",
  :setup "()",
  :target :cljs}
 {:fns ["ortho"],
  :ns "quil.snippets.lights-camera.camera",
  :name "ortho",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [ortho-params [[] [0 300 0 300] [0 300 0 300 0 170]] pos [[0 0] [250 0] [127 250]]] (dotimes [ind (count ortho-params)] (let [gr (q/create-graphics 240 240 :p3d)] (q/with-graphics gr (q/background 255) (q/camera 100 100 100 0 0 0 0 0 -1) (apply q/ortho (nth ortho-params ind)) (q/fill 127) (q/box 100)) (apply q/image gr (nth pos ind))))))",
  :setup "()",
  :target :cljs}
 {:fns ["frustum"],
  :ns "quil.snippets.lights-camera.camera",
  :name "frustum",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/camera 200 200 200 0 0 0 0 0 -1) (q/frustum -100 100 -100 100 200 330) (q/stroke-weight 2) (q/stroke 0) (q/fill 127) (q/box 100) (q/stroke 255 0 0) (q/line 0 0 0 100 0 0) (q/stroke 0 255 0) (q/line 0 0 0 0 100 0) (q/stroke 0 0 255) (q/line 0 0 0 0 0 100))",
  :setup "()",
  :target :cljs}
 {:fns ["camera"],
  :ns "quil.snippets.lights-camera.camera",
  :name "camera",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/camera 200 200 200 0 0 0 0 0 -1) (q/stroke-weight 2) (q/stroke 0) (q/fill 127) (q/box 100) (q/stroke 255 0 0) (q/line 0 0 0 100 0 0) (q/stroke 0 255 0) (q/line 0 0 0 0 100 0) (q/stroke 0 0 255) (q/line 0 0 0 0 0 100))",
  :setup "()",
  :target :cljs}
 {:fns ["begin-camera" "end-camera" "camera"],
  :ns "quil.snippets.lights-camera.camera",
  :name "begin-camera-end-camera-camera",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/begin-camera) (q/camera) (q/translate 250 0 -250) (q/rotate-z (/ q/PI 4)) (q/rotate-x (/ q/PI 8)) (q/rotate-y (/ q/PI -8)) (q/end-camera) (q/stroke-weight 2) (q/stroke 0) (q/fill 127) (q/box 100) (q/stroke 255 0 0) (q/line 0 0 0 100 0 0) (q/stroke 0 255 0) (q/line 0 0 0 0 100 0) (q/stroke 0 0 255) (q/line 0 0 0 0 0 100))",
  :setup "()",
  :target :cljs}
 {:fns ["triangle"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "triangle",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 220 200 255) (q/triangle 50 50 450 200 100 390))",
  :setup "()",
  :target :cljs}
 {:fns ["rect"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "rect",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 220 200 255) (q/rect 50 50 150 100) (q/rect 300 50 150 100 20) (q/rect 50 300 150 100 5 10 20 30))",
  :setup "()",
  :target :cljs}
 {:fns ["quad"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "quad",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 220 200 255) (q/quad 100 120 450 70 260 390 10 380))",
  :setup "()",
  :target :cljs}
 {:fns ["point"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "point",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/stroke-weight 10) (q/stroke 255 0 0) (q/point 10 10) (q/stroke 0 0 255) (q/point 50 50 -200))",
  :setup "()",
  :target :cljs}
 {:fns ["line"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "line",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/camera 250 250 250 0 0 0 0 0 -1) (q/stroke 255 0 0) (q/line [0 0] [100 100]) (q/stroke 0 255 0) (q/line 100 0 0 100) (q/stroke 0 0 255) (q/line 0 0 0 170 120 100) (q/line 170 120 100 50 -50 20) (q/line 50 -50 20 0 0 0))",
  :setup "()",
  :target :cljs}
 {:fns ["ellipse"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "ellipse",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke 0) (q/fill 220 200 255) (q/ellipse 250 250 400 200))",
  :setup "()",
  :target :cljs}
 {:fns ["arc"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "arc",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke 0) (q/fill 220 200 255) (q/arc 50 100 200 170 0 q/QUARTER-PI) (doseq [[ind mode] [[0 :open] [1 :chord] [2 :pie]]] (q/arc (+ 50 (* ind 150)) 300 200 170 0 q/QUARTER-PI)))",
  :setup "()",
  :target :cljs}
 {:fns ["tan"],
  :ns "quil.snippets.math.trigonometry",
  :name "tan",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/tan 0) = \" (q/tan 0)) 10 20) (q/text (str \"(q/tan  q/QUARTER-PI) = \" (q/tan q/QUARTER-PI)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["sin"],
  :ns "quil.snippets.math.trigonometry",
  :name "sin",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/sin 0) = \" (q/sin 0)) 10 20) (q/text (str \"(q/sin q/HALF-PI) = \" (q/sin q/HALF-PI)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["radians"],
  :ns "quil.snippets.math.trigonometry",
  :name "radians",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/radians 0) = \" (q/radians 0)) 10 20) (q/text (str \"(q/radians 90) = \" (q/radians 90)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["degrees"],
  :ns "quil.snippets.math.trigonometry",
  :name "degrees",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/degrees 0) = \" (q/degrees 0)) 10 20) (q/text (str \"(q/degrees q/HALF-PI) = \" (q/degrees q/HALF-PI)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["cos"],
  :ns "quil.snippets.math.trigonometry",
  :name "cos",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/cos 0) = \" (q/cos 0)) 10 20) (q/text (str \"(q/cos q/HALF-PI) = \" (q/cos q/HALF-PI)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["atan2"],
  :ns "quil.snippets.math.trigonometry",
  :name "atan2-s",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/atan2 2 1) = \" (q/atan2 2 1)) 10 20) (q/text (str \"(q/atan2 1 2) = \" (q/atan2 1 2)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["atan"],
  :ns "quil.snippets.math.trigonometry",
  :name "atan",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/atan 0) = \" (q/atan 0)) 10 20) (q/text (str \"(q/atan 1) = \" (q/atan 1)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["asin"],
  :ns "quil.snippets.math.trigonometry",
  :name "asin",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/asin 0) = \" (q/asin 0)) 10 20) (q/text (str \"(q/asin 1) = \" (q/asin 1)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["acos"],
  :ns "quil.snippets.math.trigonometry",
  :name "acos",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/acos 0) = \" (q/acos 0)) 10 20) (q/text (str \"(q/acos 1) = \" (q/acos 1)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["screen-x" "screen-y" "screen-z"],
  :ns "quil.snippets.lights-camera.coordinates",
  :name "screen-x-y-z",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [gr3d (q/create-graphics 240 240 :p3d) gr-text (q/create-graphics 240 240 :java2d)] (q/with-graphics gr3d (q/background 255) (q/camera 13 25 50 0 0 0 0 0 -1) (q/stroke-weight 2) (q/stroke 255 0 0) (q/line 0 0 0 20 0 0) (q/stroke 0 255 0) (q/line 0 0 0 0 20 0) (q/stroke 0 0 255) (q/line 0 0 0 0 0 20) (q/stroke 255 0 0) (q/stroke-weight 7) (q/point 0 0 0) (q/point 10 5 7) (let [x1 (q/screen-x 0 0) x2 (q/screen-x 10 5 7) y1 (q/screen-y 0 0) y2 (q/screen-y 10 5 7) z1 (q/model-z 0 0 0) z2 (q/model-z 10 5 7)] (q/with-graphics gr-text (q/background 255) (q/fill 0) (doseq [[ind capt val] [[1 \"(q/screen-x 0 0)\" x1] [2 \"(q/screen-x 10 5 6)\" x2] [3 \"(q/screen-y 0 0)\" y1] [4 \"(q/screen-y 10 5 6)\" y2] [5 \"(q/screen-z 0 0 0)\" x1] [6 \"(q/screen-z 10 5 6)\" z2]]] (q/text (str capt \" is \" val) 20 (* ind 20)))))) (q/image gr3d 0 0) (q/image gr-text 250 0)))",
  :setup "()",
  :target :cljs}
 {:fns ["model-x" "model-y" "model-z"],
  :ns "quil.snippets.lights-camera.coordinates",
  :name "model-x-y-z",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [gr3d (q/create-graphics 240 240 :p3d) gr-text (q/create-graphics 240 240 :java2d)] (q/with-graphics gr3d (q/background 255) (q/camera 50 25 13 0 0 0 0 0 -1) (q/stroke-weight 2) (q/stroke 255 0 0) (q/line 0 0 0 20 0 0) (q/stroke 0 255 0) (q/line 0 0 0 0 20 0) (q/stroke 0 0 255) (q/line 0 0 0 0 0 20) (q/stroke 255 0 0) (q/stroke-weight 5) (q/translate 10 20 5) (q/point 0 0 0) (let [x (q/model-x 0 0 0) y (q/model-y 0 0 0) z (q/model-z 0 0 0)] (q/with-graphics gr-text (q/background 255) (q/fill 0) (doseq [[ind capt val] [[1 \"(q/model-x 0 0 0)\" x] [2 \"(q/model-y 0 0 0)\" y] [3 \"(q/model-z 0 0 0)\" z]]] (q/text (str capt \" is \" val) 20 (* ind 20)))))) (q/image gr3d 0 0) (q/image gr-text 250 0)))",
  :setup "()",
  :target :cljs}
 {:fns ["specular"],
  :ns "quil.snippets.lights-camera.material-properties",
  :name "specular",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 150 150 150 0 25 0 0 0 -1) (q/no-stroke) (q/fill 0 51 102) (q/light-specular 255 255 255) (q/directional-light 204 204 204 -1 -1 -1) (q/specular 255) (q/sphere 50) (q/translate 0 100 0) (q/specular 204 102 0) (q/sphere 40))",
  :setup "()",
  :target :cljs}
 {:fns ["shininess"],
  :ns "quil.snippets.lights-camera.material-properties",
  :name "shininess",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 150 150 150 0 25 0 0 0 -1) (q/fill 127 0 255) (q/no-stroke) (q/light-specular 204 204 204) (q/directional-light 102 102 102 -1 -1 -1) (q/specular 255 255 255) (q/shininess 2) (q/sphere 50) (q/translate 0 100 0) (q/shininess 10) (q/sphere 40))",
  :setup "()",
  :target :cljs}
 {:fns ["emissive"],
  :ns "quil.snippets.lights-camera.material-properties",
  :name "emissive",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 150 150 150 0 0 0 0 0 -1) (q/ambient-light 255 127 127) (q/emissive 0 0 255) (q/box 100) (q/translate 0 100 0) (q/emissive (q/color 0 127 0)) (q/sphere 40))",
  :setup "()",
  :target :cljs}
 {:fns ["ambient"],
  :ns "quil.snippets.lights-camera.material-properties",
  :name "ambient",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 150 150 150 0 0 0 0 0 -1) (q/ambient-light 255 127 127) (q/ambient 255 127 0) (q/box 100) (q/translate 0 100 0) (q/ambient 127) (q/sphere 40))",
  :setup "()",
  :target :cljs}
 {:fns ["random-3d"],
  :ns "quil.snippets.math.random",
  :name "random-3d",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/random-3d) = \" (q/random-3d)) 10 20) (letfn [(unit-vector? [v] (let [n (->> v (map q/sq) (apply +))] (< (Math/abs (- n 1.0)) 0.001)))] (dotimes [_ 100] (when-not (unit-vector? (q/random-3d)) (throw (ex-info \"random-3d doesn't return a unit vector\" {}))))))",
  :setup "()",
  :target :cljs}
 {:fns ["random-2d"],
  :ns "quil.snippets.math.random",
  :name "random-2d",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/random-2d) = \" (q/random-2d)) 10 20) (letfn [(unit-vector? [v] (let [n (->> v (map q/sq) (apply +))] (< (Math/abs (- n 1.0)) 0.001)))] (dotimes [_ 100] (when-not (unit-vector? (q/random-2d)) (throw (ex-info \"random-2d doesn't return a unit vector\" {}))))))",
  :setup "()",
  :target :cljs}
 {:fns ["random-seed"],
  :ns "quil.snippets.math.random",
  :name "random-seed",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/random-seed 42) (q/text (str \"(q/random 42) = \" (q/random 42)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["random-gaussian"],
  :ns "quil.snippets.math.random",
  :name "random-gaussian",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/random-gaussian) = \" (q/random-gaussian)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["random"],
  :ns "quil.snippets.math.random",
  :name "random",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/random 42) = \" (q/random 42)) 10 20) (q/text (str \"(q/random Math/E q/PI) = \" (q/random Math/E q/PI)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["noise-seed"],
  :ns "quil.snippets.math.random",
  :name "noise-seed",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/noise-seed 42) (q/text (str \"(q/noise 42) = \" (q/noise 42)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["noise-detail"],
  :ns "quil.snippets.math.random",
  :name "noise-detail",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/noise-detail 3) (q/text (str \"(q/noise 42) = \" (q/noise 42)) 10 20) (q/noise-detail 5 0.5) (q/text (str \"(q/noise 42) = \" (q/noise 42)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["noise"],
  :ns "quil.snippets.math.random",
  :name "noise",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/noise 42) = \" (q/noise 42)) 10 20) (q/text (str \"(q/noise 1 2) = \" (q/noise 1 2)) 10 40) (q/text (str \"(q/noise 50 10 3) = \" (q/noise 50 10 3)) 10 60))",
  :setup "()",
  :target :cljs}
 {:fns ["set-state!" "state"],
  :ns "quil.snippets.state",
  :name "set-state-state",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (q/text (q/state :text) 10 20) (q/text (str \"Full state: \" (q/state)) 10 40))",
  :setup "(q/set-state! :text \"I'm state!\" :year (q/year))",
  :target :cljs}
 {:fns ["create-image"],
  :ns "quil.snippets.image",
  :name "create-image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [im (q/create-image 100 100 :rgb)] (dotimes [x 100] (dotimes [y 100] (q/set-pixel im x y (q/color (* 2 x) (* 2 y) (+ x y))))) (q/image im 0 0) (q/image im 50 50)))",
  :setup "()",
  :target :cljs}
 {:fns ["no-cursor"],
  :ns "quil.snippets.environment",
  :name "no-cursor",
  :opts {:settings nil},
  :draw "((q/no-cursor))",
  :setup "()",
  :target :cljs}
 {:fns ["height" "width"],
  :ns "quil.snippets.environment",
  :name "height-width",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/width) \"x\" (q/height)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["frame-rate"],
  :ns "quil.snippets.environment",
  :name "frame-rate",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/target-frame-rate)) 10 20) (q/frame-rate (inc (rand-int 5))))",
  :setup "()",
  :target :cljs}
 {:fns ["frame-count"],
  :ns "quil.snippets.environment",
  :name "frame-count",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/frame-count)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["focused"],
  :ns "quil.snippets.environment",
  :name "focused",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/focused)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["cursor-image"],
  :ns "quil.snippets.environment",
  :name "cursor-image",
  :opts {:settings nil},
  :draw
  "((if (zero? (.-width (q/state :image))) (q/text \"Loading\" 10 10) (do (q/cursor-image (q/state :image)) (q/cursor-image (q/state :image) 16 16) (q/image (q/state :image) 0 0))))",
  :setup "(q/set-state! :image (q/request-image \"cursor.jpg\"))",
  :target :cljs}
 {:fns ["cursor"],
  :ns "quil.snippets.environment",
  :name "cursor",
  :opts {:settings nil},
  :draw
  "((q/no-cursor) (q/cursor) (doseq [type [:arrow :cross :hand :move :text :wait]] (q/cursor type)))",
  :setup "()",
  :target :cljs}
 {:fns ["current-graphics"],
  :ns "quil.snippets.environment",
  :name "current-graphics",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0 0 255) (.rect (q/current-graphics) 0 0 100 100) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (.fill (q/current-graphics) 255 255 0) (.ellipse (q/current-graphics) 50 50 100 100)) (q/image gr 70 70)))",
  :setup "()",
  :target :cljs}
 {:fns ["current-frame-rate" "target-frame-rate"],
  :ns "quil.snippets.environment",
  :name "current-frame-rate-target-frame-rate",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/current-frame-rate)) 10 20) (q/text (str (q/target-frame-rate)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["with-translation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-translation",
  :opts {:settings nil},
  :draw
  "((q/translate 10 10) (q/rect 0 0 50 50) (q/with-translation [150 0] (q/rect 0 0 50 50)) (q/with-translation [0 150] (q/rect 0 0 50 50)))",
  :setup "()",
  :target :cljs}
 {:fns ["with-rotation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-rotation",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (q/translate 0 0 100) (q/with-rotation [1] (q/box 50)) (q/translate 100 0 -100) (q/with-rotation [1 1 0 0] (q/box 50)) (q/translate -100 100 0) (q/with-rotation [1 0 1 0] (q/box 50)))",
  :setup "()",
  :target :cljs}
 {:fns ["curve-tightness"],
  :ns "quil.snippets.shape.curves",
  :name "curve-tightness",
  :opts {:settings nil},
  :draw
  "((q/no-fill) (doseq [[ind t] [[0 -5] [1 -1] [2 0] [3 1] [4 5]]] (q/curve-tightness t) (q/with-translation [100 (+ 50 (* ind 70))] (q/curve 0 0 0 0 50 30 100 -30) (q/curve 0 0 50 30 100 -30 150 0) (q/curve 50 30 100 -30 150 0 150 0))))",
  :setup "()",
  :target :cljs}
 {:fns ["curve-tangent"],
  :ns "quil.snippets.shape.curves",
  :name "curve-tangent",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/curve-tangent 0 5 7 0 v) txt (str \"(q/bezier-point 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :cljs}
 {:fns ["curve-point"],
  :ns "quil.snippets.shape.curves",
  :name "curve-point",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/curve-point 0 5 7 0 v) txt (str \"(q/bezier-point 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :cljs}
 {:fns ["curve-detail"],
  :ns "quil.snippets.shape.curves",
  :name "curve-detail",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 0 0 300 0 0 0 0 1 0) (q/no-fill) (q/curve-detail 5) (q/curve 0 0 50 100 100 -100 150 0) (q/curve-detail 20) (q/curve 0 0 -50 100 -100 -100 -150 0))",
  :setup "()",
  :target :cljs}
 {:fns ["curve"],
  :ns "quil.snippets.shape.curves",
  :name "curve",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/curve 0 0 50 100 100 -100 150 0) (q/curve 0 0 0 0 100 0 0 0 100 100 0 0))",
  :setup "()",
  :target :cljs}
 {:fns ["bezier-tangent"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-tangent",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/bezier-tangent 0 5 7 0 v) txt (str \"(q/bezier-point 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :cljs}
 {:fns ["bezier-point"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-point",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/bezier-point 0 5 7 0 v) txt (str \"(q/bezier-point 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :cljs}
 {:fns ["bezier-detail"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-detail-3d",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 0 0 300 0 0 0 0 1 0) (q/no-fill) (q/bezier-detail 20) (q/bezier 0 0 0 0 100 0 0 100 0 100 0 0))",
  :setup "()",
  :target :cljs}
 {:fns ["bezier-detail"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-detail-2d",
  :opts {:settings nil},
  :draw
  "((q/no-fill) (q/bezier-detail 5) (q/bezier 0 0 50 100 100 -100 150 0))",
  :setup "()",
  :target :cljs}
 {:fns ["bezier-3d"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-3d",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/bezier 0 0 0 0 100 0 0 100 0 100 0 0))",
  :setup "()",
  :target :cljs}
 {:fns ["bezier-2d"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-2d",
  :opts {:settings nil},
  :draw "((q/no-fill) (q/bezier 0 0 50 100 100 -100 150 0))",
  :setup "()",
  :target :cljs}
 {:fns ["stroke-weight"],
  :ns "quil.snippets.shape.attributes",
  :name "stroke-weight",
  :opts {:settings nil},
  :draw
  "((doseq [i (range 1 10)] (q/stroke-weight i) (q/line 230 (+ (* i 30) 100) 270 (+ (* i 30) 100))))",
  :setup "()",
  :target :cljs}
 {:fns ["stroke-join"],
  :ns "quil.snippets.shape.attributes",
  :name "stroke-join",
  :opts {:settings nil},
  :draw
  "((q/rect-mode :center) (q/stroke-weight 12) (q/stroke-join :miter) (q/rect 125 125 100 100) (q/stroke-join :bevel) (q/rect 375 125 100 100) (q/stroke-join :round) (q/rect 125 375 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["stroke-cap"],
  :ns "quil.snippets.shape.attributes",
  :name "stroke-cap",
  :opts {:settings nil},
  :draw
  "((q/stroke-weight 12) (q/stroke-cap :square) (q/line 230 200 270 200) (q/stroke-cap :project) (q/line 230 250 270 250) (q/stroke-cap :round) (q/line 230 300 270 300))",
  :setup "()",
  :target :cljs}
 {:fns ["rect-mode"],
  :ns "quil.snippets.shape.attributes",
  :name "rect-mode",
  :opts {:settings nil},
  :draw
  "((q/stroke-weight 5) (q/rect-mode :center) (q/with-translation [125 125] (q/stroke 0) (q/rect 0 0 100 70) (q/stroke 255 0 0) (q/point 0 0)) (q/rect-mode :radius) (q/with-translation [375 125] (q/stroke 0) (q/rect 0 0 100 70) (q/stroke 255 0 0) (q/point 0 0)) (q/rect-mode :corner) (q/with-translation [125 375] (q/stroke 0) (q/rect 0 0 100 70) (q/stroke 255 0 0) (q/point 0 0)) (q/rect-mode :corners) (q/with-translation [375 375] (q/stroke 0) (q/rect -50 -35 50 35) (q/stroke 255 0 0) (q/point -50 -35) (q/point 50 35)))",
  :setup "()",
  :target :cljs}
 {:fns ["smooth" "no-smooth"],
  :ns "quil.snippets.shape.attributes",
  :name "smooth-no-smooth",
  :opts {:renderer :p2d, :settings nil},
  :draw "((q/with-translation [125 125] (q/ellipse 0 0 200 200)))",
  :setup "()",
  :target :cljs}
 {:fns ["ellipse-mode"],
  :ns "quil.snippets.shape.attributes",
  :name "ellipse-mode",
  :opts {:settings nil},
  :draw
  "((q/stroke-weight 5) (q/ellipse-mode :center) (q/with-translation [125 125] (q/ellipse 0 0 100 70) (q/point 0 0)) (q/ellipse-mode :radius) (q/with-translation [375 125] (q/ellipse 0 0 100 70) (q/point 0 0)) (q/ellipse-mode :corner) (q/with-translation [125 375] (q/ellipse 0 0 100 70) (q/point 0 0)) (q/ellipse-mode :corners) (q/with-translation [375 375] (q/ellipse -50 -35 50 35) (q/point -50 -35) (q/point 50 35)))",
  :setup "()",
  :target :cljs}
 {:fns ["text-font"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "text-font",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (let [font (q/create-font \"serif\" 20)] (q/text-font font) (q/text \"(print :hello)\" 20 30) (q/text-font font 30) (q/text \"(print-bigger :hello)\" 20 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["text"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "text",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/camera 50 50 50 0 0 0 0 0 -1) (q/line 0 0 0 0 0 20) (q/line 0 0 0 0 20 0) (q/line 0 0 0 20 0 0) (q/text \"2D\" 0 15) (q/rotate-x (- q/HALF-PI)) (q/text \"3D\" 0 -5 0) (q/rotate-y q/HALF-PI) (q/rect-mode :corners) (q/text \"box\" -30 0 30 -15))",
  :setup "()",
  :target :cljs}
 {:fns ["create-font"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "create-font",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text-font (q/create-font \"Courier New\" 30)) (q/text \"(print :hello)\" 20 50) (q/text-font (q/create-font \"Georgia\" 30 true)) (q/text \"(print :hello)\" 20 100) (q/text \"(print :hello)\" 20 150))",
  :setup "()",
  :target :cljs}
 {:fns ["available-fonts"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "available-fonts",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text-size 7) (doseq [[col fonts] (->> (q/available-fonts) (partition-all 50) (map-indexed vector)) [row font] (map-indexed vector fonts)] (q/text font (+ 20 (* col 100)) (+ 20 (* row 10)))))",
  :setup "()",
  :target :cljs}
 {:fns ["text-descent"],
  :ns "quil.snippets.typography.metrics",
  :name "text-descent",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"Descent is \" (q/text-descent)) 20 20))",
  :setup "()",
  :target :clj}
 {:fns ["text-ascent"],
  :ns "quil.snippets.typography.metrics",
  :name "text-ascent",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"Ascent is \" (q/text-ascent)) 20 20))",
  :setup "()",
  :target :clj}
 {:fns ["text-num"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "text-num",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/camera 70 70 70 0 0 0 0 0 -1) (q/text-num 42 0 0) (q/text-num 1/2 0 0 10))",
  :setup "()",
  :target :clj}
 {:fns ["text-font"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "text-font",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (let [font (q/create-font \"Courier New\" 20)] (q/text-font font) (q/text \"(print :hello)\" 20 30) (q/text-font font 30) (q/text \"(print-bigger :hello)\" 20 100)))",
  :setup "()",
  :target :clj}
 {:fns ["text-char"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "text-char",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/camera 50 50 50 0 0 0 0 0 -1) (q/text-char \\Q 0 0) (q/text-char \\W 0 0 10))",
  :setup "()",
  :target :clj}
 {:fns ["text"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "text",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/camera 50 50 50 0 0 0 0 0 -1) (q/line 0 0 0 0 0 20) (q/line 0 0 0 0 20 0) (q/line 0 0 0 20 0 0) (q/text \"2D\" 0 15) (q/rotate-x (- q/HALF-PI)) (q/text \"3D\" 0 -5 0) (q/rotate-y q/HALF-PI) (q/rect-mode :corners) (q/text \"box\" -30 0 30 -15))",
  :setup "()",
  :target :clj}
 {:fns ["load-font"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "load-font",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (->> (clojure.java.io/resource \"ComicSansMS-48.vlw\") (.getPath) (q/load-font) (q/text-font)) (q/text \"CoMiC SaNs HeRe\" 20 100))",
  :setup "()",
  :target :clj}
 {:fns ["font-available?"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "font-available?-s",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"'Courier New' available: \" (q/font-available? \"Courier New\")) 20 20) (q/text (str \"'Ubuntu' available: \" (q/font-available? \"Ubuntu\")) 20 40) (q/text (str \"'My Custom Font' available: \" (q/font-available? \"My Custom Font\")) 20 60))",
  :setup "()",
  :target :clj}
 {:fns ["create-font"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "create-font",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text-font (q/create-font \"Courier New\" 30)) (q/text \"(print :hello)\" 20 50) (q/text-font (q/create-font \"Georgia\" 30 true)) (q/text \"(print :hello)\" 20 100) (q/text-font (q/create-font \"Georgia\" 30 false (char-array \"what is it for?\"))) (q/text \"(print :hello)\" 20 150))",
  :setup "()",
  :target :clj}
 {:fns ["available-fonts"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "available-fonts",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text-size 7) (doseq [[col fonts] (->> (q/available-fonts) (partition-all 50) (map-indexed vector)) [row font] (map-indexed vector fonts)] (q/text font (+ 20 (* col 100)) (+ 20 (* row 10)))))",
  :setup "()",
  :target :clj}
 {:fns ["text-width"],
  :ns "quil.snippets.typography.attributes",
  :name "text-width",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (let [txt \"Hello, world!\" width (q/text-width txt)] (q/text txt 20 20) (q/text (str \"Width of text above is \" width) 20 40)))",
  :setup "()",
  :target :clj}
 {:fns ["text-size"],
  :ns "quil.snippets.typography.attributes",
  :name "text-size",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (doseq [ind (range 6) :let [size (+ 10 (* ind 5))]] (q/text-size size) (q/text (str \"Text size: \" size) 20 (+ 20 (* ind 80)))))",
  :setup "()",
  :target :clj}
 {:fns ["text-mode"],
  :ns "quil.snippets.typography.attributes",
  :name "text-mode",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/fill 0) (q/text-mode :model) (q/text \"text-mode: model\" 20 50) (q/text-mode :shape) (q/text \"text-mode: shape\" 20 100))",
  :setup "()",
  :target :clj}
 {:fns ["text-leading"],
  :ns "quil.snippets.typography.attributes",
  :name "text-leading",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (doseq [ind (range 4) :let [leading (* ind 10)]] (q/text-leading leading) (q/text (str \"text leading\\n\" leading) 20 (+ 20 (* ind 100)))))",
  :setup "()",
  :target :clj}
 {:fns ["text-align"],
  :ns "quil.snippets.typography.attributes",
  :name "text-align",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (q/stroke 255 0 0) (q/stroke-weight 5) (let [h-align [:left :center :right] v-align [:top :bottom :center :baseline]] (doseq [ind (range (count h-align)) :let [x 50 y (+ 20 (* ind 50))]] (q/text-align (h-align ind)) (q/text (name (h-align ind)) x y) (q/point x y)) (doseq [ind-h (range (count h-align)) ind-v (range (count v-align)) :let [x (+ 70 (* ind-v 100)) y (+ 250 (* ind-h 50)) h-al (h-align ind-h) v-al (v-align ind-v) txt (str (name h-al) \"+\" (name v-al))]] (q/text-align h-al v-al) (q/text txt x y) (q/point x y))))",
  :setup "()",
  :target :clj}
 {:fns ["with-translation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-translation",
  :opts {:settings nil},
  :draw
  "((q/translate 10 10) (q/rect 0 0 50 50) (q/with-translation [150 0] (q/rect 0 0 50 50)) (q/with-translation [0 150] (q/rect 0 0 50 50)))",
  :setup "()",
  :target :clj}
 {:fns ["with-rotation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-rotation",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (q/translate 0 0 100) (q/with-rotation [1] (q/box 50)) (q/translate 100 0 -100) (q/with-rotation [1 1 0 0] (q/box 50)) (q/translate -100 100 0) (q/with-rotation [1 0 1 0] (q/box 50)))",
  :setup "()",
  :target :clj}
 {:fns ["vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 100 400 200 100 0 0 0 0 -1) (q/line 0 0 0 0 0 100) (q/line 0 0 0 0 100 0) (q/line 0 0 0 100 0 0) (let [txtr (q/create-graphics 100 100)] (q/with-graphics txtr (q/background 255) (q/fill 255 0 0) (q/rect 0 60 100 40) (q/fill 0 150 0) (q/rect 0 0 100 60)) (q/begin-shape) (q/vertex 0 0) (q/vertex 100 0) (q/vertex 100 100) (q/vertex 0 100) (q/end-shape :close) (q/begin-shape) (q/vertex 0 0 0) (q/vertex 100 0 0) (q/vertex 100 0 100) (q/vertex 0 0 100) (q/end-shape :close) (q/begin-shape) (q/texture txtr) (q/vertex 100 0 0 0) (q/vertex 200 0 100 0) (q/vertex 200 100 100 100) (q/vertex 100 100 0 100) (q/end-shape :close) (q/begin-shape) (q/texture txtr) (q/vertex 100 0 0 0 0) (q/vertex 200 0 0 100 0) (q/vertex 200 0 100 100 100) (q/vertex 100 0 100 0 100) (q/end-shape :close)))",
  :setup "()",
  :target :clj}
 {:fns ["texture-wrap"],
  :ns "quil.snippets.shape.vertex",
  :name "texture-wrap",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [txtr (q/create-graphics 100 100) mode (if (even? (q/frame-count)) :clamp :repeat)] (q/with-graphics txtr (q/background 255) (q/fill 255 0 0) (q/rect 0 60 100 40) (q/fill 0 150 0) (q/rect 0 0 100 60)) (q/image txtr 0 0) (q/texture-wrap mode) (q/with-translation [200 200] (q/begin-shape) (q/texture txtr) (q/vertex 0 0 0 0) (q/vertex 200 0 200 0) (q/vertex 200 200 200 200) (q/vertex 0 200 0 200) (q/end-shape :close))))",
  :setup "()",
  :target :clj}
 {:fns ["texture-mode"],
  :ns "quil.snippets.shape.vertex",
  :name "texture-mode",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 255) (q/fill 255 0 0) (q/rect 0 60 100 40) (q/fill 0 150 0) (q/rect 0 0 100 60)) (q/image gr 0 0) (q/with-translation [375 125] (q/begin-shape) (q/texture gr) (q/texture-mode :image) (q/vertex 0 0 0 0) (q/vertex 100 100 100 100) (q/vertex 0 100 0 100) (q/end-shape :close)) (q/with-translation [125 375] (q/begin-shape) (q/texture gr) (q/texture-mode :normal) (q/vertex 0 0 0 0) (q/vertex 100 100 1 1) (q/vertex 0 100 0 1) (q/end-shape :close))))",
  :setup "()",
  :target :clj}
 {:fns ["texture"],
  :ns "quil.snippets.shape.vertex",
  :name "texture",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 255) (q/fill 255 0 0) (q/rect 0 60 100 40) (q/fill 0 150 0) (q/rect 0 0 100 60)) (q/image gr 0 0) (q/with-translation [250 250] (q/begin-shape) (q/texture gr) (q/vertex 50 100 75 100) (q/vertex 100 50 100 75) (q/vertex 100 -50 100 25) (q/vertex 50 -100 75 0) (q/vertex -50 -100 25 0) (q/vertex -100 -50 0 25) (q/vertex -100 50 0 75) (q/vertex -50 100 25 100) (q/end-shape :close))))",
  :setup "()",
  :target :clj}
 {:fns ["quadratic-vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "quadratic-vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 50 200 50 50 0 0 0 0 -1) (q/line 0 0 0 0 0 100) (q/line 0 0 0 0 100 0) (q/line 0 0 0 100 0 0) (q/begin-shape) (q/vertex 0 0) (q/quadratic-vertex 30 50 10 100) (q/quadratic-vertex 50 -50 90 100) (q/quadratic-vertex 80 50 100 0) (q/end-shape :close) (q/begin-shape) (q/vertex 0 0 0) (q/quadratic-vertex 30 0 50 10 0 100) (q/quadratic-vertex 50 0 -50 90 0 100) (q/quadratic-vertex 80 0 50 100 0 0) (q/end-shape :close))",
  :setup "()",
  :target :clj}
 {:fns ["curve-vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "curve-vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 50 200 50 50 0 0 0 0 1) (q/begin-shape) (q/curve-vertex 0 0) (q/curve-vertex 0 0) (q/curve-vertex 100 20) (q/curve-vertex 100 80) (q/curve-vertex 20 80) (q/curve-vertex 0 0) (q/curve-vertex 0 0) (q/end-shape :close) (q/begin-shape) (q/curve-vertex 0 0 0) (q/curve-vertex 0 0 0) (q/curve-vertex 100 0 20) (q/curve-vertex 100 0 80) (q/curve-vertex 20 0 80) (q/curve-vertex 0 0 0) (q/curve-vertex 0 0 0) (q/end-shape :close))",
  :setup "()",
  :target :clj}
 {:fns ["bezier-vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "bezier-vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera -400 250 -100 500 250 0 0 0 1) (q/begin-shape) (q/vertex 30 20) (q/bezier-vertex 480 0 480 475 30 475) (q/bezier-vertex 250 380 360 125 30 20) (q/end-shape :close) (q/begin-shape) (q/vertex 30 20 0) (q/bezier-vertex 480 0 20 480 475 30 30 475 40) (q/bezier-vertex 250 380 40 360 125 10 30 20 0) (q/end-shape :close))",
  :setup "()",
  :target :clj}
 {:fns ["begin-shape" "end-shape"],
  :ns "quil.snippets.shape.vertex",
  :name "begin-shape-end-shape-in-graphics",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [gr (q/create-graphics 400 400 :p2d)] (q/with-graphics gr (q/stroke 255 0 0) (q/begin-shape :triangles) (q/vertex 200 40) (q/vertex 320 120) (q/vertex 320 280) (q/vertex 200 360) (q/vertex 80 280) (q/vertex 80 120) (q/end-shape)) (q/image gr 0 0)))",
  :setup "()",
  :target :clj}
 {:fns ["begin-shape" "end-shape"],
  :ns "quil.snippets.shape.vertex",
  :name "begin-shape-end-shape",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/stroke 255 0 0) (doseq [[ind begin-mode close-mode] [[0 nil nil] [1 nil :close] [2 :points] [3 :lines] [4 :triangles] [5 :triangle-fan] [6 :triangle-strip] [7 :quads] [8 :quad-strip]] :let [base-x (* 150 (mod ind 3)) base-y (* 150 (quot ind 3))]] (if begin-mode (q/begin-shape begin-mode) (q/begin-shape)) (q/vertex (+ base-x 50) (+ base-y 10)) (q/vertex (+ base-x 80) (+ base-y 30)) (q/vertex (+ base-x 80) (+ base-y 70)) (q/vertex (+ base-x 50) (+ base-y 90)) (q/vertex (+ base-x 20) (+ base-y 70)) (q/vertex (+ base-x 20) (+ base-y 30)) (if close-mode (q/end-shape close-mode) (q/end-shape))))",
  :setup "()",
  :target :clj}
 {:fns ["begin-contour" "end-contour"],
  :ns "quil.snippets.shape.vertex",
  :name "begin-contour-end-contour",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/stroke 255 0 0) (q/begin-shape) (q/vertex 250 20) (q/vertex 400 400) (q/vertex 50 400) (q/begin-contour) (q/vertex 200 200) (q/vertex 300 200) (q/vertex 250 380) (q/end-contour) (q/end-shape :close))",
  :setup "()",
  :target :clj}
 {:fns ["sphere-detail"],
  :ns "quil.snippets.shape.primitives-3d",
  :name "sphere-detail",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/sphere-detail 30) (q/with-translation [0 0 100] (q/sphere 70)) (q/sphere-detail 15) (q/with-translation [100 0 0] (q/sphere 70)) (q/sphere-detail 30 5) (q/with-translation [0 100 0] (q/sphere 70)))",
  :setup "()",
  :target :clj}
 {:fns ["sphere"],
  :ns "quil.snippets.shape.primitives-3d",
  :name "sphere",
  :opts {:renderer :p3d, :settings nil},
  :draw "((q/camera 200 200 200 0 0 0 0 0 -1) (q/sphere 150))",
  :setup "()",
  :target :clj}
 {:fns ["box"],
  :ns "quil.snippets.shape.primitives-3d",
  :name "box",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/with-translation [100 0 0] (q/box 70)) (q/with-translation [0 100 0] (q/box 70 100 50)))",
  :setup "()",
  :target :clj}
 {:fns ["triangle"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "triangle",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 220 200 255) (q/triangle 50 50 450 200 100 390))",
  :setup "()",
  :target :clj}
 {:fns ["rect"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "rect",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 220 200 255) (q/rect 50 50 150 100) (q/rect 300 50 150 100 20) (q/rect 50 300 150 100 5 10 20 30))",
  :setup "()",
  :target :clj}
 {:fns ["quad"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "quad",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 220 200 255) (q/quad 100 120 450 70 260 390 10 380))",
  :setup "()",
  :target :clj}
 {:fns ["point"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "point",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/stroke-weight 10) (q/stroke 255 0 0) (q/point 10 10) (q/stroke 0 0 255) (q/point 50 50 -200))",
  :setup "()",
  :target :clj}
 {:fns ["line"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "line",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/camera 250 250 250 0 0 0 0 0 -1) (q/stroke 255 0 0) (q/line [0 0] [100 100]) (q/stroke 0 255 0) (q/line 100 0 0 100) (q/stroke 0 0 255) (q/line 0 0 0 170 120 100) (q/line 170 120 100 50 -50 20) (q/line 50 -50 20 0 0 0))",
  :setup "()",
  :target :clj}
 {:fns ["ellipse"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "ellipse",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke 0) (q/fill 220 200 255) (q/ellipse 250 250 400 200))",
  :setup "()",
  :target :clj}
 {:fns ["arc"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "arc",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke 0) (q/fill 220 200 255) (q/arc 50 100 200 170 0 q/QUARTER-PI) (doseq [[ind mode] [[0 :open] [1 :chord] [2 :pie]]] (q/arc (+ 50 (* ind 150)) 300 200 170 0 q/QUARTER-PI mode)))",
  :setup "()",
  :target :clj}
 {:fns ["shape-mode"],
  :ns "quil.snippets.shape.loading-and-displaying",
  :name "shape-mode",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [sh (q/load-shape \"https://upload.wikimedia.org/wikipedia/en/2/22/Heckert_GNU_white.svg\")] (q/stroke-weight 5) (q/stroke 255 0 0) (q/shape-mode :corner) (q/shape sh 20 20 200 200) (q/point 20 20) (q/shape-mode :corners) (q/shape sh 270 20 370 120) (q/point 270 20) (q/point 370 120) (q/shape-mode :center) (q/shape sh 100 350 150 150) (q/point 100 350)))",
  :setup "()",
  :target :clj}
 {:fns ["shape"],
  :ns "quil.snippets.shape.loading-and-displaying",
  :name "shape",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [sh (q/load-shape \"https://upload.wikimedia.org/wikipedia/en/2/22/Heckert_GNU_white.svg\")] (q/shape sh) (q/shape sh 100 100) (q/shape sh 300 300 200 200)))",
  :setup "()",
  :target :clj}
 {:fns ["load-shape"],
  :ns "quil.snippets.shape.loading-and-displaying",
  :name "load-shape",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [sh (q/load-shape \"https://upload.wikimedia.org/wikipedia/en/2/22/Heckert_GNU_white.svg\")] (q/shape sh 0 0 500 500)))",
  :setup "()",
  :target :clj}
 {:fns ["curve-tightness"],
  :ns "quil.snippets.shape.curves",
  :name "curve-tightness",
  :opts {:settings nil},
  :draw
  "((q/no-fill) (doseq [[ind t] [[0 -5] [1 -1] [2 0] [3 1] [4 5]]] (q/curve-tightness t) (q/with-translation [100 (+ 50 (* ind 70))] (q/curve 0 0 0 0 50 30 100 -30) (q/curve 0 0 50 30 100 -30 150 0) (q/curve 50 30 100 -30 150 0 150 0))))",
  :setup "()",
  :target :clj}
 {:fns ["curve-tangent"],
  :ns "quil.snippets.shape.curves",
  :name "curve-tangent",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/curve-tangent 0 5 7 0 v) txt (str \"(q/bezier-point 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :clj}
 {:fns ["curve-point"],
  :ns "quil.snippets.shape.curves",
  :name "curve-point",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/curve-point 0 5 7 0 v) txt (str \"(q/bezier-point 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :clj}
 {:fns ["curve-detail"],
  :ns "quil.snippets.shape.curves",
  :name "curve-detail",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 0 0 300 0 0 0 0 1 0) (q/no-fill) (q/curve-detail 5) (q/curve 0 0 50 100 100 -100 150 0) (q/curve-detail 20) (q/curve 0 0 -50 100 -100 -100 -150 0))",
  :setup "()",
  :target :clj}
 {:fns ["curve"],
  :ns "quil.snippets.shape.curves",
  :name "curve",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/curve 0 0 50 100 100 -100 150 0) (q/curve 0 0 0 0 100 0 0 0 100 100 0 0))",
  :setup "()",
  :target :clj}
 {:fns ["bezier-tangent"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-tangent",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/bezier-tangent 0 5 7 0 v) txt (str \"(q/bezier-point 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :clj}
 {:fns ["bezier-point"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-point",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/bezier-point 0 5 7 0 v) txt (str \"(q/bezier-point 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :clj}
 {:fns ["bezier-detail"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-detail",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 0 0 300 0 0 0 0 1 0) (q/no-fill) (q/bezier-detail 5) (q/bezier 0 0 50 100 100 -100 150 0) (q/bezier-detail 20) (q/bezier 0 0 -50 100 -100 -100 -150 0))",
  :setup "()",
  :target :clj}
 {:fns ["bezier"],
  :ns "quil.snippets.shape.curves",
  :name "bezier",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/bezier 0 0 50 100 100 -100 150 0) (q/bezier 0 0 0 0 100 0 0 100 0 100 0 0))",
  :setup "()",
  :target :clj}
 {:fns ["stroke-weight"],
  :ns "quil.snippets.shape.attributes",
  :name "stroke-weight",
  :opts {:settings nil},
  :draw
  "((doseq [i (range 1 10)] (q/stroke-weight i) (q/line 230 (+ (* i 30) 100) 270 (+ (* i 30) 100))))",
  :setup "()",
  :target :clj}
 {:fns ["stroke-join"],
  :ns "quil.snippets.shape.attributes",
  :name "stroke-join",
  :opts {:settings nil},
  :draw
  "((q/rect-mode :center) (q/stroke-weight 12) (q/stroke-join :miter) (q/rect 125 125 100 100) (q/stroke-join :bevel) (q/rect 375 125 100 100) (q/stroke-join :round) (q/rect 125 375 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["stroke-cap"],
  :ns "quil.snippets.shape.attributes",
  :name "stroke-cap",
  :opts {:settings nil},
  :draw
  "((q/stroke-weight 12) (q/stroke-cap :square) (q/line 230 200 270 200) (q/stroke-cap :project) (q/line 230 250 270 250) (q/stroke-cap :round) (q/line 230 300 270 300))",
  :setup "()",
  :target :clj}
 {:fns ["rect-mode"],
  :ns "quil.snippets.shape.attributes",
  :name "rect-mode",
  :opts {:settings nil},
  :draw
  "((q/stroke-weight 5) (q/rect-mode :center) (q/with-translation [125 125] (q/stroke 0) (q/rect 0 0 100 70) (q/stroke 255 0 0) (q/point 0 0)) (q/rect-mode :radius) (q/with-translation [375 125] (q/stroke 0) (q/rect 0 0 100 70) (q/stroke 255 0 0) (q/point 0 0)) (q/rect-mode :corner) (q/with-translation [125 375] (q/stroke 0) (q/rect 0 0 100 70) (q/stroke 255 0 0) (q/point 0 0)) (q/rect-mode :corners) (q/with-translation [375 375] (q/stroke 0) (q/rect -50 -35 50 35) (q/stroke 255 0 0) (q/point -50 -35) (q/point 50 35)))",
  :setup "()",
  :target :clj}
 {:fns ["smooth" "no-smooth"],
  :ns "quil.snippets.shape.attributes",
  :name "smooth-no-smooth",
  :opts {:renderer :p2d, :settings nil},
  :draw "((q/with-translation [125 125] (q/ellipse 0 0 200 200)))",
  :setup "()",
  :target :clj}
 {:fns ["ellipse-mode"],
  :ns "quil.snippets.shape.attributes",
  :name "ellipse-mode",
  :opts {:settings nil},
  :draw
  "((q/stroke-weight 5) (q/ellipse-mode :center) (q/with-translation [125 125] (q/ellipse 0 0 100 70) (q/point 0 0)) (q/ellipse-mode :radius) (q/with-translation [375 125] (q/ellipse 0 0 100 70) (q/point 0 0)) (q/ellipse-mode :corner) (q/with-translation [125 375] (q/ellipse 0 0 100 70) (q/point 0 0)) (q/ellipse-mode :corners) (q/with-translation [375 375] (q/ellipse -50 -35 50 35) (q/point -50 -35) (q/point 50 35)))",
  :setup "()",
  :target :clj}
 {:fns ["tan"],
  :ns "quil.snippets.math.trigonometry",
  :name "tan",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/tan 0) = \" (q/tan 0)) 10 20) (q/text (str \"(q/tan  q/QUARTER-PI) = \" (q/tan q/QUARTER-PI)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["sin"],
  :ns "quil.snippets.math.trigonometry",
  :name "sin",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/sin 0) = \" (q/sin 0)) 10 20) (q/text (str \"(q/sin q/HALF-PI) = \" (q/sin q/HALF-PI)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["radians"],
  :ns "quil.snippets.math.trigonometry",
  :name "radians",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/radians 0) = \" (q/radians 0)) 10 20) (q/text (str \"(q/radians 90) = \" (q/radians 90)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["degrees"],
  :ns "quil.snippets.math.trigonometry",
  :name "degrees",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/degrees 0) = \" (q/degrees 0)) 10 20) (q/text (str \"(q/degrees q/HALF-PI) = \" (q/degrees q/HALF-PI)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["cos"],
  :ns "quil.snippets.math.trigonometry",
  :name "cos",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/cos 0) = \" (q/cos 0)) 10 20) (q/text (str \"(q/cos q/HALF-PI) = \" (q/cos q/HALF-PI)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["atan2"],
  :ns "quil.snippets.math.trigonometry",
  :name "atan2-s",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/atan2 2 1) = \" (q/atan2 2 1)) 10 20) (q/text (str \"(q/atan2 1 2) = \" (q/atan2 1 2)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["atan"],
  :ns "quil.snippets.math.trigonometry",
  :name "atan",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/atan 0) = \" (q/atan 0)) 10 20) (q/text (str \"(q/atan 1) = \" (q/atan 1)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["asin"],
  :ns "quil.snippets.math.trigonometry",
  :name "asin",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/asin 0) = \" (q/asin 0)) 10 20) (q/text (str \"(q/asin 1) = \" (q/asin 1)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["acos"],
  :ns "quil.snippets.math.trigonometry",
  :name "acos",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/acos 0) = \" (q/acos 0)) 10 20) (q/text (str \"(q/acos 1) = \" (q/acos 1)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["random-3d"],
  :ns "quil.snippets.math.random",
  :name "random-3d",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/random-3d) = \" (q/random-3d)) 10 20) (letfn [(unit-vector? [v] (let [n (->> v (map q/sq) (apply +))] (< (Math/abs (- n 1.0)) 0.001)))] (dotimes [_ 100] (when-not (unit-vector? (q/random-3d)) (throw (ex-info \"random-3d doesn't return a unit vector\" {}))))))",
  :setup "()",
  :target :clj}
 {:fns ["random-2d"],
  :ns "quil.snippets.math.random",
  :name "random-2d",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/random-2d) = \" (q/random-2d)) 10 20) (letfn [(unit-vector? [v] (let [n (->> v (map q/sq) (apply +))] (< (Math/abs (- n 1.0)) 0.001)))] (dotimes [_ 100] (when-not (unit-vector? (q/random-2d)) (throw (ex-info \"random-2d doesn't return a unit vector\" {}))))))",
  :setup "()",
  :target :clj}
 {:fns ["random-seed"],
  :ns "quil.snippets.math.random",
  :name "random-seed",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/random-seed 42) (q/text (str \"(q/random 42) = \" (q/random 42)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["random-gaussian"],
  :ns "quil.snippets.math.random",
  :name "random-gaussian",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/random-gaussian) = \" (q/random-gaussian)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["random"],
  :ns "quil.snippets.math.random",
  :name "random",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/random 42) = \" (q/random 42)) 10 20) (q/text (str \"(q/random Math/E q/PI) = \" (q/random Math/E q/PI)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["noise-seed"],
  :ns "quil.snippets.math.random",
  :name "noise-seed",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/noise-seed 42) (q/text (str \"(q/noise 42) = \" (q/noise 42)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["noise-detail"],
  :ns "quil.snippets.math.random",
  :name "noise-detail",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/noise-detail 3) (q/text (str \"(q/noise 42) = \" (q/noise 42)) 10 20) (q/noise-detail 5 0.5) (q/text (str \"(q/noise 42) = \" (q/noise 42)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["noise"],
  :ns "quil.snippets.math.random",
  :name "noise",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/noise 42) = \" (q/noise 42)) 10 20) (q/text (str \"(q/noise 1 2) = \" (q/noise 1 2)) 10 40) (q/text (str \"(q/noise 50 10 3) = \" (q/noise 50 10 3)) 10 60))",
  :setup "()",
  :target :clj}
 {:fns ["sqrt"],
  :ns "quil.snippets.math.calculation",
  :name "sqrt",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/sqrt 25) = \" (q/sqrt 25)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["sq"],
  :ns "quil.snippets.math.calculation",
  :name "sq",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/sq 5) = \" (q/sq 5)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["round"],
  :ns "quil.snippets.math.calculation",
  :name "round",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/round 9.2) = \" (q/round 9.2)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["pow"],
  :ns "quil.snippets.math.calculation",
  :name "pow",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/pow 2 10) = \" (q/pow 2 10)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["norm"],
  :ns "quil.snippets.math.calculation",
  :name "norm",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/norm 20 0 50) = \" (q/norm 20 0 50)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["map-range"],
  :ns "quil.snippets.math.calculation",
  :name "map-range",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/map-range 2 0 5 10 20) = \" (q/map-range 2 0 5 10 20)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["mag"],
  :ns "quil.snippets.math.calculation",
  :name "mag",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/mag 3 4) = \" (q/mag 3 4)) 10 20) (q/text (str \"(q/mag 3 4 5) = \" (q/mag 3 4 5)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["log"],
  :ns "quil.snippets.math.calculation",
  :name "log",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/log Math/E) = \" (q/log Math/E)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["lerp"],
  :ns "quil.snippets.math.calculation",
  :name "lerp",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/lerp 2 5 0.5) = \" (q/lerp 2 5 0.5)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["floor"],
  :ns "quil.snippets.math.calculation",
  :name "floor",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/floor 9.03) = \" (q/floor 9.03)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["exp"],
  :ns "quil.snippets.math.calculation",
  :name "exp",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/exp 2) = \" (q/exp 2)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["dist"],
  :ns "quil.snippets.math.calculation",
  :name "dist",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/dist 0 0 3 4) = \" (q/dist 0 0 3 4)) 10 20) (q/text (str \"(q/dist 0 0 0 5 5 5) = \" (q/dist 0 0 0 5 5 5)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["constrain"],
  :ns "quil.snippets.math.calculation",
  :name "constrain",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/constrain 4 10 20) = \" (q/constrain 4 10 20)) 10 20) (q/text (str \"(q/constrain 4.5 1.5 3.9) = \" (q/constrain 4.5 1.5 3.9)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["ceil"],
  :ns "quil.snippets.math.calculation",
  :name "ceil",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/ceil 9.03) = \" (q/ceil 9.03)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["abs"],
  :ns "quil.snippets.math.calculation",
  :name "abs",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/abs -1) = \" (q/abs -1)) 10 20) (q/text (str \"(q/abs -0.5) = \" (q/abs -0.5)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["specular"],
  :ns "quil.snippets.lights-camera.material-properties",
  :name "specular",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 150 150 150 0 25 0 0 0 -1) (q/no-stroke) (q/fill 0 51 102) (q/light-specular 255 255 255) (q/directional-light 204 204 204 -1 -1 -1) (q/specular 255) (q/sphere 50) (q/translate 0 100 0) (q/specular 204 102 0) (q/sphere 40))",
  :setup "()",
  :target :clj}
 {:fns ["shininess"],
  :ns "quil.snippets.lights-camera.material-properties",
  :name "shininess",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 150 150 150 0 25 0 0 0 -1) (q/fill 127 0 255) (q/no-stroke) (q/light-specular 204 204 204) (q/directional-light 102 102 102 -1 -1 -1) (q/specular 255 255 255) (q/shininess 2) (q/sphere 50) (q/translate 0 100 0) (q/shininess 10) (q/sphere 40))",
  :setup "()",
  :target :clj}
 {:fns ["emissive"],
  :ns "quil.snippets.lights-camera.material-properties",
  :name "emissive",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 150 150 150 0 0 0 0 0 -1) (q/ambient-light 255 127 127) (q/emissive 0 0 255) (q/box 100) (q/translate 0 100 0) (q/emissive (q/color 0 127 0)) (q/sphere 40))",
  :setup "()",
  :target :clj}
 {:fns ["ambient"],
  :ns "quil.snippets.lights-camera.material-properties",
  :name "ambient",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 150 150 150 0 0 0 0 0 -1) (q/ambient-light 255 127 127) (q/ambient 255 127 0) (q/box 100) (q/translate 0 100 0) (q/ambient 127) (q/sphere 40))",
  :setup "()",
  :target :clj}
 {:fns ["spot-light"],
  :ns "quil.snippets.lights-camera.lights",
  :name "spot-light",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/spot-light 255 0 0 50 0 50 -1 0 -1 q/PI 1) (q/spot-light [0 0 255] [0 100 100] [0 -1 -1] q/PI 1) (q/box 50))",
  :setup "()",
  :target :clj}
 {:fns ["point-light"],
  :ns "quil.snippets.lights-camera.lights",
  :name "point-light",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/point-light 255 150 150 100 100 100) (q/box 50))",
  :setup "()",
  :target :clj}
 {:fns ["normal"],
  :ns "quil.snippets.lights-camera.lights",
  :name "normal",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 40 40 0 0 0 -1) (q/point-light 150 250 150 10 30 50) (q/begin-shape) (q/normal 0 0 1) (doseq [v [[20 20 -10] [80 20 10] [80 80 -10] [20 80 10]]] (apply q/vertex v)) (q/end-shape :close))",
  :setup "()",
  :target :clj}
 {:fns ["no-lights"],
  :ns "quil.snippets.lights-camera.lights",
  :name "no-lights",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/directional-light 255 150 150 -1 -0.76 -0.5) (q/box 50) (q/no-lights) (q/translate 0 50 0) (q/sphere 20))",
  :setup "()",
  :target :clj}
 {:fns ["lights"],
  :ns "quil.snippets.lights-camera.lights",
  :name "lights",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/lights) (q/box 50))",
  :setup "()",
  :target :clj}
 {:fns ["light-specular"],
  :ns "quil.snippets.lights-camera.lights",
  :name "light-specular",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/light-specular 100 100 255) (q/directional-light 255 150 150 -1 -0.76 -0.5) (q/box 50))",
  :setup "()",
  :target :clj}
 {:fns ["light-falloff"],
  :ns "quil.snippets.lights-camera.lights",
  :name "light-falloff",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/light-falloff 1 0.008 0) (q/point-light 255 150 150 100 100 100) (q/box 50))",
  :setup "()",
  :target :clj}
 {:fns ["directional-light"],
  :ns "quil.snippets.lights-camera.lights",
  :name "directional-light",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (q/directional-light 255 150 150 -1 -0.76 -0.5) (q/box 50))",
  :setup "()",
  :target :clj}
 {:fns ["ambient-light"],
  :ns "quil.snippets.lights-camera.lights",
  :name "ambient-light",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 1) (q/ambient-light 200 190 230) (q/sphere 50))",
  :setup "()",
  :target :clj}
 {:fns ["screen-x" "screen-y" "screen-z"],
  :ns "quil.snippets.lights-camera.coordinates",
  :name "screen-x-y-z",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [gr3d (q/create-graphics 240 240 :p3d) gr-text (q/create-graphics 240 240 :java2d)] (q/with-graphics gr3d (q/background 255) (q/camera 13 25 50 0 0 0 0 0 -1) (q/stroke-weight 2) (q/stroke 255 0 0) (q/line 0 0 0 20 0 0) (q/stroke 0 255 0) (q/line 0 0 0 0 20 0) (q/stroke 0 0 255) (q/line 0 0 0 0 0 20) (q/stroke 255 0 0) (q/stroke-weight 7) (q/point 0 0 0) (q/point 10 5 7) (let [x1 (q/screen-x 0 0) x2 (q/screen-x 10 5 7) y1 (q/screen-y 0 0) y2 (q/screen-y 10 5 7) z1 (q/model-z 0 0 0) z2 (q/model-z 10 5 7)] (q/with-graphics gr-text (q/background 255) (q/fill 0) (doseq [[ind capt val] [[1 \"(q/screen-x 0 0)\" x1] [2 \"(q/screen-x 10 5 6)\" x2] [3 \"(q/screen-y 0 0)\" y1] [4 \"(q/screen-y 10 5 6)\" y2] [5 \"(q/screen-z 0 0 0)\" x1] [6 \"(q/screen-z 10 5 6)\" z2]]] (q/text (str capt \" is \" val) 20 (* ind 20)))))) (q/image gr3d 0 0) (q/image gr-text 250 0)))",
  :setup "()",
  :target :clj}
 {:fns ["model-x" "model-y" "model-z"],
  :ns "quil.snippets.lights-camera.coordinates",
  :name "model-x-y-z",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [gr3d (q/create-graphics 240 240 :p3d) gr-text (q/create-graphics 240 240 :java2d)] (q/with-graphics gr3d (q/background 255) (q/camera 50 25 13 0 0 0 0 0 -1) (q/stroke-weight 2) (q/stroke 255 0 0) (q/line 0 0 0 20 0 0) (q/stroke 0 255 0) (q/line 0 0 0 0 20 0) (q/stroke 0 0 255) (q/line 0 0 0 0 0 20) (q/stroke 255 0 0) (q/stroke-weight 5) (q/translate 10 20 5) (q/point 0 0 0) (let [x (q/model-x 0 0 0) y (q/model-y 0 0 0) z (q/model-z 0 0 0)] (q/with-graphics gr-text (q/background 255) (q/fill 0) (doseq [[ind capt val] [[1 \"(q/model-x 0 0 0)\" x] [2 \"(q/model-y 0 0 0)\" y] [3 \"(q/model-z 0 0 0)\" z]]] (q/text (str capt \" is \" val) 20 (* ind 20)))))) (q/image gr3d 0 0) (q/image gr-text 250 0)))",
  :setup "()",
  :target :clj}
 {:fns ["print-projection"],
  :ns "quil.snippets.lights-camera.camera",
  :name "print-projection",
  :opts {:renderer :p3d, :settings nil},
  :draw "((q/print-projection))",
  :setup "()",
  :target :clj}
 {:fns ["print-camera"],
  :ns "quil.snippets.lights-camera.camera",
  :name "print-camera",
  :opts {:renderer :p3d, :settings nil},
  :draw "((q/print-camera))",
  :setup "()",
  :target :clj}
 {:fns ["perspective"],
  :ns "quil.snippets.lights-camera.camera",
  :name "perspective",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [perspective-params [[] [(/ q/PI 2) 0.5 50 300]] pos [[0 0] [250 0] [127 250]]] (dotimes [ind (count perspective-params)] (let [gr (q/create-graphics 240 240 :p3d)] (q/with-graphics gr (q/background 255) (q/camera 100 100 100 0 0 0 0 0 -1) (apply q/perspective (nth perspective-params ind)) (q/fill 127) (q/box 100)) (apply q/image gr (nth pos ind))))))",
  :setup "()",
  :target :clj}
 {:fns ["ortho"],
  :ns "quil.snippets.lights-camera.camera",
  :name "ortho",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [ortho-params [[] [0 300 0 300] [0 300 0 300 0 170]] pos [[0 0] [250 0] [127 250]]] (dotimes [ind (count ortho-params)] (let [gr (q/create-graphics 240 240 :p3d)] (q/with-graphics gr (q/background 255) (q/camera 100 100 100 0 0 0 0 0 -1) (apply q/ortho (nth ortho-params ind)) (q/fill 127) (q/box 100)) (apply q/image gr (nth pos ind))))))",
  :setup "()",
  :target :clj}
 {:fns ["frustum"],
  :ns "quil.snippets.lights-camera.camera",
  :name "frustum",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/camera 200 200 200 0 0 0 0 0 -1) (q/frustum -100 100 -100 100 200 330) (q/stroke-weight 2) (q/stroke 0) (q/fill 127) (q/box 100) (q/stroke 255 0 0) (q/line 0 0 0 100 0 0) (q/stroke 0 255 0) (q/line 0 0 0 0 100 0) (q/stroke 0 0 255) (q/line 0 0 0 0 0 100))",
  :setup "()",
  :target :clj}
 {:fns ["camera"],
  :ns "quil.snippets.lights-camera.camera",
  :name "camera",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/camera 200 200 200 0 0 0 0 0 -1) (q/stroke-weight 2) (q/stroke 0) (q/fill 127) (q/box 100) (q/stroke 255 0 0) (q/line 0 0 0 100 0 0) (q/stroke 0 255 0) (q/line 0 0 0 0 100 0) (q/stroke 0 0 255) (q/line 0 0 0 0 0 100))",
  :setup "()",
  :target :clj}
 {:fns ["begin-camera" "end-camera" "camera"],
  :ns "quil.snippets.lights-camera.camera",
  :name "begin-camera-end-camera-camera",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/begin-camera) (q/camera) (q/translate 250 0 -250) (q/rotate-z (/ q/PI 4)) (q/rotate-x (/ q/PI 8)) (q/rotate-y (/ q/PI -8)) (q/end-camera) (q/stroke-weight 2) (q/stroke 0) (q/fill 127) (q/box 100) (q/stroke 255 0 0) (q/line 0 0 0 100 0 0) (q/stroke 0 255 0) (q/line 0 0 0 0 100 0) (q/stroke 0 0 255) (q/line 0 0 0 0 0 100))",
  :setup "()",
  :target :clj}
 {:fns ["unhex"],
  :ns "quil.snippets.data.conversion",
  :name "unhex",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/unhex \"2A\")) 10 10))",
  :setup "()",
  :target :clj}
 {:fns ["unbinary"],
  :ns "quil.snippets.data.conversion",
  :name "unbinary",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/unbinary \"0101010\")) 10 10))",
  :setup "()",
  :target :clj}
 {:fns ["hex"],
  :ns "quil.snippets.data.conversion",
  :name "hex",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (q/hex 42) 10 10) (q/text (q/hex 42 5) 10 30))",
  :setup "()",
  :target :clj}
 {:fns ["binary"],
  :ns "quil.snippets.data.conversion",
  :name "binary",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (q/binary 42) 10 10) (q/text (q/binary 42 5) 10 30))",
  :setup "()",
  :target :clj}
 {:fns ["with-stroke"],
  :ns "quil.snippets.color.utility-macros",
  :name "with-stroke",
  :opts {:settings nil},
  :draw
  "((q/fill 255) (q/stroke-weight 10) (q/rect 30 30 60 60) (q/with-stroke [255 0 0] (q/rect 60 60 90 90) (q/rect 90 90 120 120)) (q/rect 120 120 150 150))",
  :setup "()",
  :target :clj}
 {:fns ["with-fill"],
  :ns "quil.snippets.color.utility-macros",
  :name "with-fill",
  :opts {:settings nil},
  :draw
  "((q/fill 255) (q/rect 30 30 60 60) (q/with-fill [255 0 0] (q/rect 60 60 90 90) (q/rect 90 90 120 120)) (q/rect 120 120 150 150))",
  :setup "()",
  :target :clj}
 {:fns ["clear"],
  :ns "quil.snippets.color.setting",
  :name "clear",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [g (q/create-graphics 200 200 :p2d)] (q/background 255) (q/with-graphics g (q/fill 255 0 0) (q/rect 25 25 150 150)) (q/image g 0 0) (q/with-graphics g (q/clear) (q/fill 0 255 0) (q/ellipse 100 100 150 150)) (q/image g 50 50) (q/with-graphics g (q/clear) (q/fill 0 0 255) (q/triangle 25 25 175 25 25 175)) (q/image g 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["stroke"],
  :ns "quil.snippets.color.setting",
  :name "stroke",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke-weight 10) (q/stroke 120) (q/rect 0 0 100 100) (q/stroke 80 120) (q/rect 70 70 100 100) (q/stroke 0 255 0) (q/rect 140 140 100 100) (q/stroke 255 0 0 120) (q/rect 210 210 100 100) (q/stroke 4278255360) (q/rect 280 280 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["no-stroke"],
  :ns "quil.snippets.color.setting",
  :name "no-stroke",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 120) (q/stroke 0) (q/rect 0 0 100 100) (q/no-stroke) (q/rect 70 70 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["no-fill"],
  :ns "quil.snippets.color.setting",
  :name "no-fill",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke 0) (q/fill 120) (q/rect 0 0 100 100) (q/no-fill) (q/rect 70 70 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["fill"],
  :ns "quil.snippets.color.setting",
  :name "fill",
  :opts {:settings nil},
  :draw
  "((q/background 0 0 255) (q/fill 120) (q/rect 0 0 100 100) (q/fill 80 120) (q/rect 70 70 100 100) (q/fill 0 255 0) (q/rect 140 140 100 100) (q/fill 255 0 0 120) (q/rect 210 210 100 100) (q/fill 4278255360) (q/rect 280 280 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["background-image"],
  :ns "quil.snippets.color.setting",
  :name "background-image",
  :opts {:settings nil},
  :draw
  "((let [gr (q/create-graphics (q/width) (q/height))] (q/with-graphics gr (q/background 0 90 120) (q/ellipse 250 250 300 300)) (q/background-image gr)))",
  :setup "()",
  :target :clj}
 {:fns ["background"],
  :ns "quil.snippets.color.setting",
  :name "background",
  :opts {:settings nil},
  :draw
  "((q/background 255 0 0) (q/background 4279312947) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 120)) (q/image gr 0 0) (q/with-graphics gr (q/background 70 120)) (q/image gr 70 70) (q/with-graphics gr (q/background 0 255 255)) (q/image gr 140 140) (q/with-graphics gr (q/background 0 0 255 120)) (q/image gr 210 210)))",
  :setup "()",
  :target :clj}
 {:fns ["lerp-color"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "lerp-color",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/lerp-color 4278255360 4278190335 0.5) (let [c1 (q/color 255 0 0) c2 (q/color 0 0 255)] (dotimes [i 6] (q/fill (q/lerp-color c1 c2 (/ i 5))) (q/rect (* i 70) (* i 70) 100 100))))",
  :setup "()",
  :target :clj}
 {:fns ["current-stroke"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "current-stroke",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke 255 0 0) (q/rect 0 0 100 100) (let [cur-stroke (q/current-stroke)] (q/stroke 0 0 255) (q/rect 70 70 100 100) (q/stroke cur-stroke) (q/rect 140 140 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["current-fill"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "current-fill",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 255 0 0) (q/rect 0 0 100 100) (let [cur-fill (q/current-fill)] (q/fill 0 0 255) (q/rect 70 70 100 100) (q/fill cur-fill) (q/rect 140 140 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["color-mode"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "color-mode",
  :opts {:settings nil},
  :draw
  "((q/color-mode :rgb 255) (q/background 255) (q/color-mode :hsb) (q/fill 255 255 255) (q/rect 0 0 100 100) (q/color-mode :rgb 42) (q/fill 42 42 0 20) (q/rect 70 70 100 100) (q/color-mode :hsb 5 10 20) (q/fill 5 10 20) (q/rect 140 140 100 100) (q/color-mode :rgb 5 10 20 30) (q/fill 5 10 0 15) (q/rect 210 210 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["color"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "color",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill (q/color 0)) (q/rect 0 0 100 100) (q/fill (q/color 128 128)) (q/rect 70 70 100 100) (q/fill (q/color 255 0 255)) (q/rect 140 140 100 100) (q/fill (q/color 0 255 255 120)) (q/rect 210 210 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["hue" "saturation" "brightness"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "hue-saturation-brightness",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/hue 4279312947) (q/saturation 4279312947) (q/brightness 4279312947) (q/color-mode :hsb) (let [col (q/color 100 230 100)] (q/fill col) (q/rect 0 0 100 100) (q/fill (q/hue col) 255 255) (q/rect 70 70 100 100) (q/fill 255 (q/saturation col) 255) (q/rect 140 140 100 100) (q/fill 255 255 (q/brightness col)) (q/rect 210 210 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["red" "green" "blue"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "red-green-blue",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/red 4279312947) (q/green 4279312947) (q/blue 4279312947) (let [col (q/color 123 50 220)] (q/fill col) (q/rect 0 0 100 100) (q/fill (q/red col) 0 0) (q/rect 70 70 100 100) (q/fill 0 (q/green col) 0) (q/rect 140 140 100 100) (q/fill 0 0 (q/blue col)) (q/rect 210 210 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["blend-color"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "blend-color",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/blend-color 4278255360 4294901760 :blend) (let [c1 (q/color 255 100 20 50) c2 (q/color 40 200 255 200) modes [:blend :add :subtract :darkest :lightest :difference :exclusion :multiply :screen :overlay :hard-light :soft-light :dodge :burn] splitted (partition-all 3 modes)] (q/fill c1) (q/rect 0 0 70 70) (q/fill c2) (q/rect 100 0 70 70) (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col)] (q/fill (q/blend-color c1 c2 mode))) (q/rect (* col 100) (* (inc row) 100) 70 70)))))",
  :setup "()",
  :target :clj}
 {:fns ["alpha"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "alpha",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/alpha 4278255360) (let [semi-red (q/color 255 0 0 120) alph (q/alpha semi-red) semi-blue (q/color 0 0 255 alph)] (q/fill semi-red) (q/rect 0 0 100 100) (q/fill semi-blue) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["tint"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "tint",
  :opts {:settings nil},
  :draw
  "((q/background 127) (q/tint 4279312947) (q/no-tint) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 0 0) (q/fill 255) (q/ellipse 25 25 40 40) (q/fill 255 0 0) (q/ellipse 75 25 40 40) (q/fill 0 255 0) (q/ellipse 25 75 40 40) (q/fill 0 0 255) (q/ellipse 75 75 40 40)) (q/no-tint) (q/image gr 0 0) (q/tint 127) (q/image gr 120 0) (q/tint 255 127) (q/image gr 240 0) (q/tint 200 127 180) (q/image gr 0 120) (q/tint 200 127 180 127) (q/image gr 120 120)))",
  :setup "()",
  :target :clj}
 {:fns ["image"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "request-image",
  :opts {:settings nil},
  :draw
  "((if (zero? (.-width (q/state :image))) (q/text \"Loading\" 10 10) (q/image (q/state :image) 0 0)))",
  :setup
  "(q/set-state! :image (q/request-image \"https://github.com/quil/quil/raw/master/dev-resources/quil.png\"))",
  :target :clj}
 {:fns ["no-tint"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "no-tint",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 0 0) (q/fill 255) (q/ellipse 50 50 70 70)) (q/image gr 0 0) (q/tint 127 255 255) (q/image gr 100 0) (q/no-tint) (q/image gr 200 0)))",
  :setup "()",
  :target :clj}
 {:fns ["mask-image"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "mask-image",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100 :p3d) gr2 (q/create-graphics 100 100 :p3d) mask (q/create-graphics 100 100 :p3d)] (q/with-graphics gr (q/background 0 0 255) (q/stroke-weight 3) (q/stroke 255 0 0) (q/line 0 0 100 100) (q/line 0 100 100 0)) (q/with-graphics gr2 (q/background 255) (q/stroke 0 255 0) (q/stroke-weight 5) (q/line 0 50 100 50) (q/line 50 0 50 100)) (q/with-graphics mask (q/background 0) (q/stroke-weight 5) (q/no-fill) (q/stroke 255) (q/ellipse 50 50 10 10) (q/stroke 200) (q/ellipse 50 50 30 30) (q/stroke 150) (q/ellipse 50 50 50 50) (q/stroke 100) (q/ellipse 50 50 70 70) (q/stroke 50) (q/ellipse 50 50 90 90)) (q/image gr 20 20) (q/image mask 140 20) (q/mask-image gr mask) (q/image gr 260 20) (q/image gr2 20 140) (q/image mask 140 140) (q/with-graphics gr2 (q/mask-image mask)) (q/image gr2 260 140)))",
  :setup "()",
  :target :clj}
 {:fns ["resize"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "resize-image",
  :opts {:settings nil},
  :draw
  "((let [im (q/load-image \"https://github.com/quil/quil/raw/master/dev-resources/quil.png\")] (q/image im 0 0) (q/resize im 50 50) (q/image im 0 0)))",
  :setup "()",
  :target :clj}
 {:fns ["load-image"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "load-image",
  :opts {:settings nil},
  :draw
  "((let [im (q/load-image \"https://github.com/quil/quil/raw/master/dev-resources/quil.png\")] (q/image im 0 0)))",
  :setup "()",
  :target :clj}
 {:fns ["image-mode"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "image-mode",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/fill 0 0 255) (q/stroke 0 0 255) (q/rect 0 0 100 100)) (q/stroke-weight 10) (q/image-mode :corner) (q/image gr 50 50) (q/point 50 50) (q/image-mode :center) (q/image gr 250 100) (q/point 250 100) (q/image-mode :corners) (q/image gr 350 50 400 150) (q/point 350 50) (q/point 400 150)))",
  :setup "()",
  :target :clj}
 {:fns ["image"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 70 70)] (q/with-graphics gr (q/ellipse 35 35 70 70)) (q/image gr 0 0) (q/image gr 100 0 100 70)))",
  :setup "()",
  :target :clj}
 {:fns ["set-pixel"],
  :ns "quil.snippets.image.pixels",
  :name "set-pixel",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 255)) (doseq [i (range 30) j (range 30)] (q/set-pixel gr i j (q/color (* 7 i) (* 7 j) 0))) (q/image gr 0 0) (doseq [i (range 30) j (range 30)] (q/set-pixel (+ 40 i) (+ 40 j) (q/color 0 (* 7 i) (* 7 j))))))",
  :setup "()",
  :target :clj}
 {:fns ["set-image"],
  :ns "quil.snippets.image.pixels",
  :name "set-image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 255) (q/fill 255 0 0) (q/ellipse 50 50 90 90)) (q/set-image 10 10 gr)))",
  :setup "()",
  :target :clj}
 {:fns ["pixels" "update-pixels"],
  :ns "quil.snippets.image.pixels",
  :name "pixels-update-pixels",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/background 255) (let [size 50 gr (q/create-graphics size size :p2d)] (q/with-graphics gr (q/background 255) (q/fill 255 0 0) (q/ellipse (/ size 2) (/ size 3) (* size 2/3) (* size 2/3))) (q/image gr 0 0) (let [px (q/pixels gr) half (/ (* size size) 2)] (dotimes [i half] (aset-int px (+ i half) (aget px i)))) (q/update-pixels gr) (q/image gr (+ size 20) 0) (let [px (q/pixels) half (/ (* (q/width) (q/height)) 10)] (dotimes [i half] (aset-int px (+ i half) (aget px i)))) (q/update-pixels)))",
  :setup "()",
  :target :clj}
 {:fns ["get-pixel"],
  :ns "quil.snippets.image.pixels",
  :name "get-pixel",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 255) (q/fill 127 255 180) (q/ellipse 50 50 70 70)) (q/image gr 0 0) (q/image (q/get-pixel gr) 0 120) (q/fill (q/get-pixel gr 50 50)) (q/rect 120 120 100 100) (q/image (q/get-pixel gr 0 0 50 50) 240 120) (q/image (q/get-pixel) 400 400) (q/fill (q/get-pixel 50 50)) (q/rect 120 240 100 100) (q/image (q/get-pixel 0 0 50 50) 240 240)))",
  :setup "()",
  :target :clj}
 {:fns ["filter-shader"],
  :ns "quil.snippets.image.pixels",
  :name "filter-shader",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/background 255) (let [orig (q/create-graphics 100 100) shd (q/load-shader (.getPath (clojure.java.io/resource \"SimpleShader.glsl\")))] (q/with-graphics orig (q/color-mode :rgb 1.0) (q/background 1) (q/no-stroke) (q/ellipse-mode :corner) (doseq [r (range 0 1 0.1) b (range 0 1 0.1)] (q/fill r 0 b) (q/ellipse (* r 100) (* b 100) 10 10))) (q/image orig 0 0) (q/filter-shader shd) (q/image orig 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["display-filter"],
  :ns "quil.snippets.image.pixels",
  :name "display-filter",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [orig (q/create-graphics 100 100) modes [[:threshold] [:threshold 0.7] [:gray] [:invert] [:posterize 20] [:blur] [:blur 3] [:opaque] [:erode] [:dilate]] splitted (partition-all 4 modes)] (q/with-graphics orig (q/color-mode :rgb 1.0) (q/background 1) (q/no-stroke) (q/ellipse-mode :corner) (doseq [r (range 0 1 0.1) b (range 0 1 0.1)] (q/fill r 0 b) (q/ellipse (* r 100) (* b 100) 10 10))) (q/image orig 0 0) (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col) dest (q/create-graphics 100 100)] (q/with-graphics dest (q/image orig 0 0) (apply q/display-filter mode)) (q/image dest (* col 120) (* 120 (inc row))))))))",
  :setup "()",
  :target :clj}
 {:fns ["image-filter"],
  :ns "quil.snippets.image.pixels",
  :name "image-filter",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [orig (q/create-graphics 100 100) modes [[:threshold] [:threshold 0.7] [:gray] [:invert] [:posterize 20] [:blur] [:blur 3] [:opaque] [:erode] [:dilate]] splitted (partition-all 4 modes)] (q/with-graphics orig (q/color-mode :rgb 1.0) (q/background 1) (q/no-stroke) (q/ellipse-mode :corner) (doseq [r (range 0 1 0.1) b (range 0 1 0.1)] (q/fill r 0 b) (q/ellipse (* r 100) (* b 100) 10 10))) (q/image orig 0 0) (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col) clone (q/get-pixel orig)] (apply q/image-filter clone mode) (q/image clone (* col 120) (* 120 (inc row))))))))",
  :setup "()",
  :target :clj}
 {:fns ["copy"],
  :ns "quil.snippets.image.pixels",
  :name "copy",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 0 0 255) (q/stroke-weight 5) (q/stroke 0 255 0) (q/no-fill) (q/ellipse 50 50 10 10) (q/ellipse 50 50 50 50) (q/ellipse 50 50 90 90) (q/stroke 255 0 0) (q/line 0 0 100 100) (q/line 100 0 0 100)) (let [im (.copy gr)] (q/image im 0 0) (q/copy im im [0 0 50 50] [50 0 50 50]) (q/copy im [0 0 100 100] [120 0 100 100]) (q/copy [0 0 50 50] [240 0 100 100]))))",
  :setup "()",
  :target :clj}
 {:fns ["blend"],
  :ns "quil.snippets.image.pixels",
  :name "blend",
  :opts {:settings nil},
  :draw
  "((q/background 255 100 20 50) (let [gr (q/create-graphics 50 50) modes [:blend :add :subtract :darkest :lightest :difference :exclusion :multiply :screen :overlay :hard-light :soft-light :dodge :burn] splitted (partition-all 5 modes)] (q/with-graphics gr (q/background 40 200 255 200) (q/fill 255 0 0) (q/ellipse 12 12 20 20) (q/fill 0 255 0) (q/ellipse 38 12 20 20) (q/fill 0 0 255) (q/ellipse 25 38 20 20)) (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col)] (q/blend 400 0 50 50 (* col 55) (* row 55) 50 50 mode) (q/blend gr 0 0 50 50 (* col 55) (+ 170 (* row 55)) 50 50 mode) (q/blend gr (q/current-graphics) 0 0 50 50 (* col 55) (+ 340 (* row 55)) 50 50 mode))))))",
  :setup "()",
  :target :clj}
 {:fns ["create-graphics"],
  :ns "quil.snippets.image.rendering",
  :name "create-graphics",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 127) (q/ellipse 50 50 80 40)) (q/image gr 0 0)) (let [gr (q/create-graphics 100 100 :java2d)] (q/with-graphics gr (q/background 127) (q/ellipse 50 50 40 80)) (q/image gr 100 100)) (let [gr (q/create-graphics 100 100 :pdf \"generated/create-graphics.pdf\")] (q/with-graphics gr (q/background 127) (q/ellipse 50 50 80 40) (.dispose gr))))",
  :setup "()",
  :target :clj}
 {:fns ["blend-mode"],
  :ns "quil.snippets.image.rendering",
  :name "blend-mode",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/background 255) (let [modes [:replace :blend :add :subtract :darkest :lightest :exclusion :multiply :screen] splitted (partition-all 4 modes)] (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col) gr (q/create-graphics 100 100 :p2d)] (q/with-graphics gr (q/background 127) (q/blend-mode mode) (q/no-stroke) (q/fill 255 0 0) (q/rect 10 20 80 20) (q/fill 50 170 255 127) (q/rect 60 10 20 80) (q/fill 200 130 150 200) (q/rect 10 60 80 20) (q/fill 20 240 50 50) (q/rect 20 10 20 80)) (q/image gr (* col 120) (* row 120)))))))",
  :setup "()",
  :target :clj}
 {:fns ["translate"],
  :ns "quil.snippets.transform",
  :name "translate",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (q/translate 100 0) (q/box 50) (q/translate [-100 100]) (q/box 50) (q/translate 0 -100 100) (q/box 50))",
  :setup "()",
  :target :clj}
 {:fns ["shear-x" "shear-y"],
  :ns "quil.snippets.transform",
  :name "shear-x-y",
  :opts {:settings nil},
  :draw
  "((q/with-translation [125 125] (q/rect 0 0 100 50)) (q/with-translation [375 125] (q/shear-y 0.5) (q/rect 0 0 100 50)) (q/with-translation [125 375] (q/shear-x 0.5) (q/rect 0 0 100 50)))",
  :setup "()",
  :target :clj}
 {:fns ["scale"],
  :ns "quil.snippets.transform",
  :name "scale",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (q/with-translation [100 0 0] (q/scale 0.5) (q/box 50) (q/scale 2)) (q/with-translation [0 100 0] (q/scale 1 0.5) (q/box 50) (q/scale 1 2)) (q/with-translation [0 0 100] (q/scale 0.5 1 1.5) (q/box 50) (q/scale 2 1 0.75)))",
  :setup "()",
  :target :clj}
 {:fns ["rotate-x" "rotate-y" "rotate-z"],
  :ns "quil.snippets.transform",
  :name "rotate-x-y-z",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (q/push-matrix) (q/translate 100 0 0) (q/rotate-x 0.5) (q/box 50) (q/pop-matrix) (q/push-matrix) (q/translate 0 100 0) (q/rotate-y 0.5) (q/box 50) (q/pop-matrix) (q/push-matrix) (q/translate 0 0 100) (q/rotate-z 0.5) (q/box 50) (q/pop-matrix))",
  :setup "()",
  :target :clj}
 {:fns ["rotate"],
  :ns "quil.snippets.transform",
  :name "rotate",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (q/push-matrix) (q/translate 100 0 0) (q/rotate 0.5) (q/box 50) (q/pop-matrix) (q/push-matrix) (q/translate 0 100 0) (q/rotate 0.5 1 0 0) (q/box 50) (q/pop-matrix) (q/push-matrix) (q/translate 0 0 100) (q/rotate 0.5 0 1 0) (q/box 50) (q/pop-matrix))",
  :setup "()",
  :target :clj}
 {:fns ["reset-matrix"],
  :ns "quil.snippets.transform",
  :name "reset-matrix",
  :opts {:settings nil},
  :draw
  "((q/rect 0 0 100 50) (q/translate 250 250) (q/rect 0 0 50 50) (q/reset-matrix) (q/rect 0 0 50 100))",
  :setup "()",
  :target :clj}
 {:fns ["print-matrix"],
  :ns "quil.snippets.transform",
  :name "print-matrix",
  :opts {:settings nil},
  :draw
  "((q/translate 250 250) (q/rotate 1) (q/rect 0 0 100 100) (q/print-matrix))",
  :setup "()",
  :target :clj}
 {:fns ["push-matrix" "pop-matrix"],
  :ns "quil.snippets.transform",
  :name "push-matrix-pop-matrix",
  :opts {:settings nil},
  :draw
  "((q/fill 255 0 0) (q/translate 20 20) (q/rect 0 0 50 50) (q/translate 150 0) (q/push-matrix) (q/rotate 1) (q/rect 0 0 50 50) (q/pop-matrix) (q/translate 150 0) (q/rect 0 0 50 50))",
  :setup "()",
  :target :clj}
 {:fns ["apply-matrix"],
  :ns "quil.snippets.transform",
  :name "apply-matrix",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (q/apply-matrix 1 0 50 0 1 -50) (q/box 50) (let [s (q/sin 1) c (q/cos 1)] (q/apply-matrix 1 0 0 0 0 c s 50 0 (- s) c -50 0 0 0 1)) (q/box 50))",
  :setup "()",
  :target :clj}
 {:fns ["looping?"],
  :ns "quil.snippets.structure",
  :name "looping?",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/looping?) = \" (q/looping?)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["delay"],
  :ns "quil.snippets.structure",
  :name "delay",
  :opts {:settings nil},
  :draw
  "((q/background 127) (q/ellipse (* 5 (q/frame-count)) (* 5 (q/frame-count)) 50 50) (q/delay-frame (rand-int (* 500 (rand-int 4)))))",
  :setup "()",
  :target :clj}
 {:fns ["push-style" "pop-style"],
  :ns "quil.snippets.structure",
  :name "push-style-pop-style",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 255 0 0) (q/ellipse 125 125 100 100) (q/push-style) (q/fill 0 0 255) (q/ellipse 250 250 100 100) (q/pop-style) (q/ellipse 375 375 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["set-state!" "state"],
  :ns "quil.snippets.state",
  :name "set-state-state",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (q/text (q/state :text) 10 20) (q/text (str \"Full state: \" (q/state)) 10 40))",
  :setup "(q/set-state! :text \"I'm state!\" :year (q/year))",
  :target :clj}
 {:fns ["clip" "no-clip"],
  :ns "quil.snippets.rendering",
  :name "clip-no-clip",
  :opts {:settings nil},
  :draw
  "((q/no-clip) (q/background 255) (q/fill 0) (q/clip 50 100 100 100) (q/triangle 100 70 170 180 30 180) (q/no-clip) (q/with-translation [(/ (q/width) 2) (/ (q/height) 2)] (q/triangle 100 70 170 180 30 180)))",
  :setup "()",
  :target :clj}
 {:fns ["load-shader"],
  :ns "quil.snippets.rendering",
  :name "load-shader",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [gr (q/create-graphics 250 250) path (clojure.java.io/resource \"SimpleShader.glsl\") shd (q/load-shader (.getPath path))] (q/with-graphics gr (q/background 255) (q/fill 255 0 0) (q/triangle 50 30 220 120 20 180)) (q/image gr 0 0) (q/image gr 250 0) (q/shader shd) (q/image gr 0 250) (q/reset-shader) (q/image gr 250 250)))",
  :setup "()",
  :target :clj}
 {:fns ["with-graphics"],
  :ns "quil.snippets.rendering",
  :name "with-graphics",
  :opts {:settings nil},
  :draw
  "((let [gr (q/create-graphics 250 250)] (q/with-graphics gr (q/background 255) (q/fill 255 0 0) (q/triangle 50 30 220 120 20 180)) (q/image gr 0 0) (q/image gr 250 0) (q/image gr 0 250) (q/image gr 250 250)))",
  :setup "()",
  :target :clj}
 {:fns ["hint"],
  :ns "quil.snippets.rendering",
  :name "hint",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((let [hints [:enable-async-saveframe :disable-async-saveframe :enable-depth-test :disable-depth-test :enable-depth-sort :disable-depth-sort :enable-opengl-errors :disable-opengl-errors :enable-depth-mask :disable-depth-mask :enable-optimized-stroke :disable-optimized-stroke :enable-stroke-perspective :disable-stroke-perspective :enable-stroke-pure :disable-stroke-pure :enable-texture-mipmaps :disable-texture-mipmaps]] (doseq [h hints] (q/hint h))) (q/ellipse 250 250 400 200))",
  :setup "()",
  :target :clj}
 {:fns ["do-record"],
  :ns "quil.snippets.output",
  :name "do-record",
  :opts {:settings nil},
  :draw
  "((doseq [type [:svg :pdf] i (range 3)] (let [file (str \"generated/record_\" i \".\" (name type))] (q/do-record (q/create-graphics 200 200 type file) (q/fill 255 0 0) (q/ellipse 100 100 (+ 50 (* 50 i)) (+ 50 (* 50 i)))) (is (pos? (.length (clojure.java.io/file file)))))))",
  :setup "()",
  :target :clj}
 {:fns ["save-frame"],
  :ns "quil.snippets.output",
  :name "save-frame",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 150 150 150 0 0 0 0 0 1) (q/background 127) (q/with-rotation [(/ (q/frame-count) 10)] (q/box 100)) (q/save-frame) (q/save-frame \"generated/rotating-box-####.png\"))",
  :setup "()",
  :target :clj}
 {:fns ["save"],
  :ns "quil.snippets.output",
  :name "save",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 150 150 150 0 0 0 0 0 1) (q/box 100) (q/save \"generated/box.png\"))",
  :setup "()",
  :target :clj}
 {:fns ["begin-raw" "end-raw"],
  :ns "quil.snippets.output",
  :name "begin-raw-end-raw",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/begin-raw :dxf \"generated/dxf.txt\") (q/camera 150 150 150 0 0 0 0 0 1) (q/box 100) (q/end-raw))",
  :setup "()",
  :target :clj}
 {:fns ["millis" "seconds" "minute" "hour" "day" "month" "year"],
  :ns "quil.snippets.input",
  :name "time-and-date",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (doseq [[ind capt fn] [[0 \"millis\" q/millis] [1 \"seconds\" q/seconds] [2 \"minute\" q/minute] [3 \"hour\" q/hour] [4 \"day\" q/day] [5 \"month\" q/month] [6 \"year\" q/year]]] (q/text (str capt \" \" (fn)) 10 (+ (* 20 ind) 20))))",
  :setup "()",
  :target :clj}
 {:fns
  ["mouse-button"
   "mouse-pressed?"
   "mouse-x"
   "mouse-y"
   "pmouse-x"
   "pmouse-y"],
  :ns "quil.snippets.input",
  :name "mouse",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (doseq [[ind capt fn] [[0 \"mouse-button\" q/mouse-button] [1 \"mouse-pressed?\" q/mouse-pressed?] [2 \"mouse-x\" q/mouse-x] [3 \"mouse-y\" q/mouse-y] [4 \"pmouse-x\" q/pmouse-x] [5 \"pmouse-y\" q/pmouse-y]]] (q/text (str capt \" \" (fn)) 10 (+ (* 20 ind) 20))))",
  :setup "()",
  :target :clj}
 {:fns
  ["key-as-keyword" "key-code" "key-coded?" "key-pressed?" "raw-key"],
  :ns "quil.snippets.input",
  :name "keyboard",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (doseq [[ind capt fn] [[0 \"key-as-keyword\" q/key-as-keyword] [1 \"key-code\" q/key-code] [2 \"key-coded?\" (fn* [] (q/key-coded? (q/raw-key)))] [3 \"key-pressed?\" q/key-pressed?] [4 \"raw-key\" q/raw-key] [5 \"key-modifiers\" q/key-modifiers]]] (q/text (str capt \" \" (fn)) 10 (+ (* 20 ind) 20))))",
  :setup "()",
  :target :clj}
 {:fns ["pixel-density"],
  :ns "quil.snippets.environment",
  :name "pixel-density",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/ellipse 102 102 200 200) (q/triangle 200 200 400 300 300 400))",
  :setup "()",
  :target :clj}
 {:fns ["display-density"],
  :ns "quil.snippets.environment",
  :name "display-density",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text-num (q/display-density) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["screen-width" "screen-height"],
  :ns "quil.snippets.environment",
  :name "screen-height-screen-width",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (let [w (q/screen-width) h (q/screen-height)] (q/text (str w \"x\" h) 10 20)))",
  :setup "()",
  :target :clj}
 {:fns ["no-cursor"],
  :ns "quil.snippets.environment",
  :name "no-cursor",
  :opts {:settings nil},
  :draw "((q/no-cursor))",
  :setup "()",
  :target :clj}
 {:fns ["height" "width"],
  :ns "quil.snippets.environment",
  :name "height-width",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/width) \"x\" (q/height)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["frame-rate"],
  :ns "quil.snippets.environment",
  :name "frame-rate",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/target-frame-rate)) 10 20) (q/frame-rate (inc (rand-int 5))))",
  :setup "()",
  :target :clj}
 {:fns ["frame-count"],
  :ns "quil.snippets.environment",
  :name "frame-count",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/frame-count)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["focused"],
  :ns "quil.snippets.environment",
  :name "focused",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/focused)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["cursor-image"],
  :ns "quil.snippets.environment",
  :name "cursor-image",
  :opts {:settings nil},
  :draw
  "((if (zero? (.-width (q/state :image))) (q/text \"Loading\" 10 10) (do (q/cursor-image (q/state :image)) (q/cursor-image (q/state :image) 16 16) (q/image (q/state :image) 0 0))))",
  :setup
  "(q/set-state! :image (q/request-image \"test/html/cursor.jpg\"))",
  :target :clj}
 {:fns ["cursor"],
  :ns "quil.snippets.environment",
  :name "cursor",
  :opts {:settings nil},
  :draw
  "((q/no-cursor) (q/cursor) (doseq [type [:arrow :cross :hand :move :text :wait]] (q/cursor type)))",
  :setup "()",
  :target :clj}
 {:fns ["current-graphics"],
  :ns "quil.snippets.environment",
  :name "current-graphics",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0 0 255) (.rect (q/current-graphics) 0 0 100 100) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (.fill (q/current-graphics) 255 255 0) (.ellipse (q/current-graphics) 50 50 100 100)) (q/image gr 70 70)))",
  :setup "()",
  :target :clj}
 {:fns ["current-frame-rate" "target-frame-rate"],
  :ns "quil.snippets.environment",
  :name "current-frame-rate-target-frame-rate",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str (q/current-frame-rate)) 10 20) (q/text (str (q/target-frame-rate)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["create-image"],
  :ns "quil.snippets.image",
  :name "create-image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [im (q/create-image 100 100 :rgb)] (dotimes [x 100] (dotimes [y 100] (q/set-pixel im x y (q/color (* 2 x) (* 2 y) (+ x y))))) (q/image im 0 0) (q/image im 50 50)))",
  :setup "()",
  :target :clj})
