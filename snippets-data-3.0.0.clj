({:fns [],
  :ns "quil.snippets.color.creating-and-reading",
  :name "use-hex-colors",
  :opts {:settings nil},
  :draw
  "((q/hue \"0xFF112233\") (q/saturation \"0xFF112233\") (q/brightness \"0xFF112233\") (q/red \"0xFF112233\") (q/green \"0xFF112233\") (q/blue \"0xFF112233\") (q/background \"0xFF112233\"))",
  :setup "()",
  :target :cljs}
 {:fns ["lerp-color"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "lerp-color",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [red (q/color 255 0 0) blue (q/color 0 0 255)] (comment \"draw colors that transition from red to blue\") (dotimes [i 6] (q/fill (q/lerp-color red blue (/ i 5))) (q/rect (* i 70) (* i 70) 100 100))))",
  :setup "()",
  :target :cljs}
 {:fns ["current-stroke"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "current-stroke",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"set to red\") (q/stroke 255 0 0) (q/rect 0 0 100 100) (let [_ (comment \"remember current color\") cur-stroke (q/current-stroke)] (comment \"change to blue\") (q/stroke 0 0 255) (q/rect 70 70 100 100) (comment \"change back to the original color\") (q/stroke cur-stroke) (q/rect 140 140 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["current-fill"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "current-fill",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"set to red\") (q/fill 255 0 0) (q/rect 0 0 100 100) (let [_ (comment \"remember current color\") cur-fill (q/current-fill)] (comment \"change to blue\") (q/fill 0 0 255) (q/rect 70 70 100 100) (comment \"change back to the original color\") (q/fill cur-fill) (q/rect 140 140 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["color-mode"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "color-mode",
  :opts {:settings nil},
  :draw
  "((q/color-mode :rgb 255) (q/background 255) (comment \"use HSB and draw red\") (q/color-mode :hsb) (q/fill 255 255 255) (q/rect 0 0 100 100) (comment \"use HSB with different max and draw dark green\") (q/color-mode :hsb 5 10 20) (q/fill 2 10 5) (q/rect 70 70 100 100) (comment \"use RGB with 42 max value and draw 75% transparent blue\") (q/color-mode :rgb 40) (q/fill 0 0 40 30) (q/rect 140 140 100 100) (comment \"use RGB with different max values and draw semitransparent cyan\") (q/color-mode :rgb 5 10 20 30) (q/fill 0 10 20 15) (q/rect 210 210 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["color-mode"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "color-mode-hsl",
  :opts {:settings nil},
  :draw
  "((q/color-mode :rgb 255) (q/background 255) (q/color-mode :hsl) (comment \"use red color\") (q/fill 255 255 127) (q/rect 0 0 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["color"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "color",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"black\") (q/fill (q/color 0)) (q/rect 0 0 100 100) (comment \"semitransparent gray\") (q/fill (q/color 128 128)) (q/rect 70 70 100 100) (comment \"purple\") (q/fill (q/color 255 0 255)) (q/rect 140 140 100 100) (comment \"semitransparent cyan\") (q/fill (q/color 0 255 255 120)) (q/rect 210 210 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["brightness"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "brightness",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/color-mode :hsb) (let [dark-green (q/color 100 230 100)] (q/fill dark-green) (q/rect 0 0 100 100) (comment \"use the same brightness but different color\") (q/fill 255 255 (q/brightness dark-green)) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["saturation"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "saturation",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/color-mode :hsb) (let [dark-green (q/color 100 230 100)] (q/fill dark-green) (q/rect 0 0 100 100) (comment \"use the same saturation but different color\") (q/fill 255 (q/saturation dark-green) 255) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["hue"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "hue",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/color-mode :hsb) (let [dark-green (q/color 100 230 100)] (q/fill dark-green) (q/rect 0 0 100 100) (comment \"use the hue (green) but make it bright\") (q/fill (q/hue dark-green) 255 255) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["blue"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "blue",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [purple (q/color 123 50 220)] (q/fill purple) (q/rect 0 0 100 100) (comment \"use only blue component of purple\") (q/fill 0 0 (q/blue purple)) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["green"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "green",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [purple (q/color 123 50 220)] (q/fill purple) (q/rect 0 0 100 100) (comment \"use only green component of purple\") (q/fill 0 (q/green purple) 0) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["red"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "red",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [purple (q/color 123 50 220)] (q/fill purple) (q/rect 0 0 100 100) (comment \"use only red component of purple\") (q/fill (q/red purple) 0 0) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["lightness"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "lightness",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/color-mode :hsl) (let [_ (comment \"blue with low lightness (70 of 255)\") blue (q/color 156 255 70) _ (comment \"extract lightness\") l (q/lightness blue) _ (comment \"create red with same lightness\") red (q/color 0 255 l)] (q/fill blue) (q/rect 0 0 100 100) (q/fill red) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["alpha"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "alpha",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [_ (comment \"create semitransparent red\") semi-red (q/color 255 0 0 120) _ (comment \"extract alpha value from it\") alph (q/alpha semi-red) _ (comment \"create semitransparent blue using the alpha\") semi-blue (q/color 0 0 255 alph)] (q/fill semi-red) (q/rect 0 0 100 100) (q/fill semi-blue) (q/rect 70 70 100 100)))",
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
 {:fns ["text-style"],
  :ns "quil.snippets.typography.attributes",
  :name "text-style",
  :opts {:settings nil},
  :draw
  "((q/fill 0) (q/text-style :normal) (q/text \"text-style: normal\" 20 50) (q/text-style :italic) (q/text \"text-style: italic\" 20 100) (q/text-style :bold) (q/text \"text-style: bold\" 20 150))",
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
  "((q/fill 0) (let [h-align [:left :center :right] v-align [:top :bottom :center :baseline]] (comment \"text-align with single argument\") (doseq [ind (range (count h-align)) :let [x 50 y (+ 20 (* ind 50))]] (q/text-align (h-align ind)) (q/text (name (h-align ind)) x y) (q/push-style) (q/stroke 255 0 0) (q/stroke-weight 5) (q/point x y) (q/pop-style)) (comment \"text-align with multiple arguments\") (doseq [ind-h (range (count h-align)) ind-v (range (count v-align)) :let [x (+ 70 (* ind-v 100)) y (+ 250 (* ind-h 50)) h-al (h-align ind-h) v-al (v-align ind-v) txt (str (name h-al) \"+\" (name v-al))]] (q/text-align h-al v-al) (q/text txt x y) (q/push-style) (q/stroke 255 0 0) (q/stroke-weight 5) (q/point x y) (q/pop-style))))",
  :setup "()",
  :target :cljs}
 {:fns ["set-image" "set-pixel"],
  :ns "quil.snippets.image.pixels",
  :name "set-image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [im (q/create-image 100 100)] (comment \"draw gradient on the image\") (dotimes [x 100] (dotimes [y 100] (q/set-pixel im x y (q/color (* 2 x) (* 2 y) (+ x y))))) (q/update-pixels im) (comment \"draw image on sketch\") (q/set-image 10 10 im)))",
  :setup "()",
  :target :cljs}
 {:fns ["pixels" "update-pixels"],
  :ns "quil.snippets.image.pixels",
  :name "pixels-update-pixels",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/background 255) (let [size 50 gr (q/create-graphics size size :p2d)] (comment \"draw red circle on the graphics\") (q/with-graphics gr (q/background 255) (q/fill 255 0 0) (q/ellipse (/ size 2) (/ size 2) (* size (/ 2 3)) (* size (/ 2 3)))) (comment \"draw original graphics\") (q/image gr 0 0) (comment \"get pixels of the graphics and copy\") (comment \"the first half of all pixels to the second half\") (let [px (q/pixels gr) half (* 4 (* (q/display-density) size) (/ (* (q/display-density) size) 2))] (dotimes [i half] (aset px (+ i half) (aget px i)))) (q/update-pixels gr) (q/image gr (+ size 20) 0) (comment \"get pixels of the sketch itself and copy\") (comment \"the first half of all pixels to the second half\") (let [px (q/pixels) half (/ (* 4 (* (q/display-density) (q/width)) (* (q/display-density) (q/height))) 10)] (dotimes [i half] (aset px (+ i half) (aget px i)))) (q/update-pixels)))",
  :setup "()",
  :target :cljs}
 {:fns ["get-pixel"],
  :ns "quil.snippets.image.pixels",
  :name "get-pixel",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (comment \"draw circle on the graphics\") (q/with-graphics gr (q/background 255) (q/fill 127 255 180) (q/ellipse 50 50 70 70)) (comment \"draw original graphics\") (q/image gr 0 0) (comment \"copy graphics and draw it\") (q/image (q/get-pixel gr) 0 120) (comment \"use get-pixel to get color of specific pixel\") (comment \"and draw square\") (q/fill (q/get-pixel gr 50 50)) (q/rect 120 120 100 100) (comment \"use get-pixel to copy part of the graphics\") (q/image (q/get-pixel gr 0 0 50 50) 240 120) (comment \"use get-pixel to copy part of the sketch itself\") (q/image (q/get-pixel) 400 400) (q/fill (q/get-pixel 50 50)) (q/rect 120 240 100 100) (q/image (q/get-pixel 0 0 50 50) 240 240)))",
  :setup "()",
  :target :cljs}
 {:fns ["display-filter"],
  :ns "quil.snippets.image.pixels",
  :name "display-filter",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [orig (q/create-graphics 100 100) modes [[:threshold] [:threshold 0.2] [:gray] [:invert] [:posterize 20] [:blur] [:blur 3] [:opaque] [:erode] [:dilate]] splitted (partition-all 4 modes)] (comment \"draw 10x10 square from circles of different color\") (q/with-graphics orig (q/color-mode :rgb 1.0) (q/background 1) (q/no-stroke) (q/ellipse-mode :corner) (doseq [r (range 0 1 0.1) b (range 0 1 0.1)] (q/fill r 0 b) (q/ellipse (* r 100) (* b 100) 10 10))) (comment \"apply different filters, four filters per row\") (q/image orig 0 0) (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col) dest (q/create-graphics 100 100)] (q/with-graphics dest (q/image orig 0 0) (apply q/display-filter mode)) (q/image dest (* col 120) (* 120 (inc row))))))))",
  :setup "()",
  :target :cljs}
 {:fns ["image-filter"],
  :ns "quil.snippets.image.pixels",
  :name "image-filter",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [orig (q/create-graphics 100 100) modes [[:threshold] [:threshold 0.2] [:gray] [:invert] [:posterize 20] [:blur] [:blur 3] [:opaque] [:erode] [:dilate]] splitted (partition-all 4 modes)] (comment \"draw 10x10 square from circles of different color\") (q/with-graphics orig (q/color-mode :rgb 1.0) (q/background 1) (q/no-stroke) (q/ellipse-mode :corner) (doseq [r (range 0 1 0.1) b (range 0 1 0.1)] (q/fill r 0 b) (q/ellipse (* r 100) (* b 100) 10 10))) (comment \"apply different filters, four filters per row\") (q/image orig 0 0) (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col) clone (q/get-pixel orig)] (apply q/image-filter clone mode) (q/image clone (* col 120) (* 120 (inc row))))))))",
  :setup "()",
  :target :cljs}
 {:fns ["copy"],
  :ns "quil.snippets.image.pixels",
  :name "copy",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [im (q/create-image 100 100)] (comment \" gradient on the image\") (dotimes [x 100] (dotimes [y 100] (q/set-pixel im x y (q/color (* 2 x) (* 2 y) (+ x y))))) (q/update-pixels im) (comment \"draw original image\") (q/image im 0 0) (comment \"copy left top quarter to the right top quarter\") (q/copy im im [0 0 50 50] [50 0 50 50]) (comment \"copy the whole image to the sketch, essentially just draw it\") (q/copy im [0 0 100 100] [120 0 100 100]) (comment \"copy top left 50x50 square of sketch \") (comment \"to the 100x100 square at [240, 0] position\") (q/copy [0 0 50 50] [240 0 100 100])))",
  :setup "()",
  :target :cljs}
 {:fns ["blend"],
  :ns "quil.snippets.image.pixels",
  :name "blend",
  :opts {:settings nil},
  :draw
  "((q/background 255 100 20 50) (let [im (q/create-image 50 50) modes [:replace :blend :add :darkest :lightest :difference :exclusion :multiply :screen :overlay :hard-light :soft-light :dodge :burn] splitted (partition-all 5 modes)] (comment \"draw 3 squares of different color on the graphics\") (dotimes [x 10] (dotimes [y 10] (q/set-pixel im (+ x 10) (+ y 10) (q/color 255 0 0)) (q/set-pixel im (+ x 30) (+ y 10) (q/color 0 255 0)) (q/set-pixel im (+ x 20) (+ y 30) (q/color 0 0 255)))) (q/update-pixels im) (comment \"draw all possible blended modes\") (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col)] (comment \"blend with sketch itself\") (q/blend 400 0 50 50 (* col 55) (* row 55) 50 50 mode) (comment \"blend with image\") (q/blend im 0 0 50 50 (* col 55) (+ 170 (* row 55)) 50 50 mode) (comment \"blend image to image\") (q/blend im (q/current-graphics) 0 0 50 50 (* col 55) (+ 340 (* row 55)) 50 50 mode))))))",
  :setup "(q/no-loop)",
  :target :cljs}
 {:fns ["millis" "seconds" "minute" "hour" "day" "month" "year"],
  :ns "quil.snippets.input",
  :name "time-and-date",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (comment \"iterate through all time-related functions\") (comment \"and print their values\") (doseq [[ind capt fn] [[0 \"millis\" q/millis] [1 \"seconds\" q/seconds] [2 \"minute\" q/minute] [3 \"hour\" q/hour] [4 \"day\" q/day] [5 \"month\" q/month] [6 \"year\" q/year]]] (q/text (str capt \" \" (fn)) 10 (+ (* 20 ind) 20))))",
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
  "((q/background 255) (q/fill 0) (comment \"iterate through all mouse-related functions\") (comment \"and print their values\") (doseq [[ind capt fn] [[0 \"mouse-button\" q/mouse-button] [1 \"mouse-pressed?\" q/mouse-pressed?] [2 \"mouse-x\" q/mouse-x] [3 \"mouse-y\" q/mouse-y] [4 \"pmouse-x\" q/pmouse-x] [5 \"pmouse-y\" q/pmouse-y]]] (q/text (str capt \" \" (fn)) 10 (+ (* 20 ind) 20))))",
  :setup "()",
  :target :cljs}
 {:fns
  ["key-as-keyword"
   "key-code"
   "key-coded?"
   "key-pressed?"
   "raw-key"
   "key-modifiers"],
  :ns "quil.snippets.input",
  :name "keyboard",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (comment \"iterate through all key-related functions\") (comment \"and print their values\") (doseq [[ind capt fn] [[0 \"key-as-keyword\" q/key-as-keyword] [1 \"key-code\" q/key-code] [2 \"key-coded?\" (fn* [] (q/key-coded? (q/raw-key)))] [3 \"key-pressed?\" q/key-pressed?] [4 \"raw-key\" q/raw-key]]] (q/text (str capt \" \" (fn)) 10 (+ (* 20 ind) 20))))",
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
  "((q/background 255) (q/fill 0) (q/text (str \"(q/mag 3 4) = \" (q/mag 3 4)) 10 20))",
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
  "((q/background 255) (q/fill 0) (q/text (str \"(q/unhex \\\"2A\\\") = \" (q/unhex \"2A\")) 10 10))",
  :setup "()",
  :target :cljs}
 {:fns ["unbinary"],
  :ns "quil.snippets.data.conversion",
  :name "unbinary",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/unbinary \\\"0101010\\\") = \" (q/unbinary \"0101010\")) 10 10))",
  :setup "()",
  :target :cljs}
 {:fns ["hex"],
  :ns "quil.snippets.data.conversion",
  :name "hex",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/hex 42) = \" (q/hex 42)) 10 10) (q/text (str \"(q/hex 42 5) = \" (q/hex 42 5)) 10 30))",
  :setup "()",
  :target :cljs}
 {:fns ["binary"],
  :ns "quil.snippets.data.conversion",
  :name "binary",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/binary 42) = \" (q/binary 42)) 10 10) (q/text (str \"(q/binary 42 5) = \" (q/binary 42 5)) 10 30))",
  :setup "()",
  :target :cljs}
 {:fns ["tint"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "tint",
  :opts {:settings nil},
  :draw
  "((q/background 127) (let [gr (q/create-graphics 100 100)] (comment \"draw 4 circles of different color on the graphics\") (q/with-graphics gr (q/background 0 0) (q/fill 255) (q/ellipse 25 25 40 40) (q/fill 255 0 0) (q/ellipse 75 25 40 40) (q/fill 0 255 0) (q/ellipse 25 75 40 40) (q/fill 0 0 255) (q/ellipse 75 75 40 40)) (comment \"apply different types of tint\") (q/no-tint) (q/image gr 0 0) (q/tint 127) (q/image gr 120 0) (q/tint 255 127) (q/image gr 240 0) (q/tint 200 127 180) (q/image gr 0 120) (q/tint 200 127 180 127) (q/image gr 120 120)))",
  :setup "()",
  :target :cljs}
 {:fns ["no-tint"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "no-tint",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"create graphics with white circle\") (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 0 0) (q/fill 255) (q/ellipse 50 50 70 70)) (comment \"apply cyan tint\") (q/image gr 0 0) (q/tint 127 255 255) (q/image gr 100 0) (comment \"remove tint\") (q/no-tint) (q/image gr 200 0)))",
  :setup "()",
  :target :cljs}
 {:fns ["mask-image"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "mask-image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"define 2 images and a mask to apply to them\") (let [im (q/create-image 100 100) im2 (q/create-image 100 100) mask (q/create-image 100 100)] (comment \"first image is a blue square with a red cross\") (dotimes [x 100] (dotimes [y 100] (if (or (< 0 (- x y) 5) (< 95 (+ x y) 100)) (q/set-pixel im x y (q/color 255 0 0 255)) (q/set-pixel im x y (q/color 0 0 255))))) (q/update-pixels im) (comment \"second image is a green cross\") (dotimes [x 100] (dotimes [y 5] (q/set-pixel im2 (+ y 47) x (q/color 0 255 0)) (q/set-pixel im2 x (+ y 47) (q/color 0 255 0)))) (q/update-pixels im2) (comment \"mask is rectangles with different shades of gray\") (dotimes [x 100] (dotimes [y 100] (q/set-pixel mask x y (q/color 0 (* 40 (+ (quot x 20) (quot y 20))))))) (q/update-pixels mask) (comment \"draw first image, mask and image with mask applied\") (q/image im 20 20) (q/image mask 140 20) (q/mask-image im mask) (q/image im 260 20) (comment \"draw second image, mask and image with mask applied\") (q/image im2 20 140) (q/image mask 140 140) (q/mask-image im2 mask) (q/image im2 260 140)))",
  :setup "()",
  :target :cljs}
 {:fns ["load-image"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "load-image",
  :opts {:settings nil},
  :draw
  "((let [im (q/state :image)] (comment \"check if image is loaded using function loaded?\") (when (q/loaded? im) (q/image im 0 0))))",
  :setup
  "(let [_ (comment \"create url to load image 100x100\") url \"https://placekitten.com/100/100\"] (q/set-state! :image (q/load-image url)))",
  :target :cljs}
 {:fns ["image-mode"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "image-mode",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/fill 0 0 255) (q/stroke 0 0 255) (q/rect 0 0 100 100)) (q/stroke-weight 10) (comment \"use :corner mode\") (q/image-mode :corner) (q/image gr 50 50) (q/point 50 50) (comment \"use :center mode\") (q/image-mode :center) (q/image gr 250 100) (q/point 250 100) (comment \"use :corners mode\") (q/image-mode :corners) (q/image gr 350 50 400 150) (q/point 350 50) (q/point 400 150)))",
  :setup "()",
  :target :cljs}
 {:fns ["image"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"create graphics with circle\") (let [gr (q/create-graphics 70 70)] (q/with-graphics gr (q/ellipse 35 35 70 70)) (comment \"draw graphics twice\") (q/image gr 0 0) (q/image gr 100 0 100 70)))",
  :setup "()",
  :target :cljs}
 {:fns ["shape" "load-shape"],
  :ns "quil.snippets.shape.loading-and-displaying",
  :name "shape",
  :opts {:renderer :p3d, :settings nil},
  :draw "((let [sh (q/state :shp)] (q/shape sh)))",
  :setup
  "(let [sh (q/load-shape \"octahedron.obj\")] (q/set-state! :shp sh))",
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
  "((comment \"setup camera and draw box at [0 0 0]\") (q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (comment \"draw 3 identical boxes in 3 different positions\") (comment \"using different translate calls\") (q/translate 100 0) (q/box 50) (q/translate [-100 100]) (q/box 50) (q/translate 0 -100 100) (q/box 50))",
  :setup "()",
  :target :cljs}
 {:fns ["shear-x" "shear-y"],
  :ns "quil.snippets.transform",
  :name "shear-x-y",
  :opts {:settings nil},
  :draw
  "((comment \"draw normal rect\") (q/with-translation [125 125] (q/rect 0 0 100 50)) (comment \"draw rect sheared by y\") (q/with-translation [375 125] (q/shear-y 0.5) (q/rect 0 0 100 50)) (comment \"draw rect sheared by x\") (q/with-translation [125 375] (q/shear-x 0.5) (q/rect 0 0 100 50)))",
  :setup "()",
  :target :cljs}
 {:fns ["scale"],
  :ns "quil.snippets.transform",
  :name "scale",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((comment \"setup camera and draw box at [0 0 0]\") (q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (comment \"draw box 50% smaller\") (q/with-translation [100 0 0] (q/scale 0.5) (q/box 50) (q/scale 2)) (comment \"draw box 50% narrower but same length/height\") (q/with-translation [0 100 0] (q/scale 1 0.5) (q/box 50) (q/scale 1 2)) (comment \"draw box 50% shorter and 150% taller, but same width\") (q/with-translation [0 0 100] (q/scale 0.5 1 1.5) (q/box 50) (q/scale 2 1 0.75)))",
  :setup "()",
  :target :cljs}
 {:fns ["rotate-x" "rotate-y" "rotate-z"],
  :ns "quil.snippets.transform",
  :name "rotate-x-y-z",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((comment \"setup camera and draw box at [0 0 0]\") (q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (q/push-matrix) (comment \"move, rotate x axis and draw box\") (q/translate 100 0 0) (q/rotate-x 0.5) (q/box 50) (q/pop-matrix) (q/push-matrix) (comment \"move, rotate y axis and draw box\") (q/translate 0 100 0) (q/rotate-y 0.5) (q/box 50) (q/pop-matrix) (q/push-matrix) (comment \"move, rotate z axis and draw box\") (q/translate 0 0 100) (q/rotate-z 0.5) (q/box 50) (q/pop-matrix))",
  :setup "()",
  :target :cljs}
 {:fns ["rotate"],
  :ns "quil.snippets.transform",
  :name "rotate",
  :opts {:settings nil},
  :draw
  "((q/stroke 100) (q/no-fill) (q/rect 0 0 52 52) (q/translate (/ (q/width) 4) (/ (q/height) 4)) (q/rotate (/ q/PI 3)) (q/rect 0 0 52 52))",
  :setup "()",
  :target :cljs}
 {:fns ["reset-matrix"],
  :ns "quil.snippets.transform",
  :name "reset-matrix",
  :opts {:settings nil},
  :draw
  "((q/rect 0 0 100 50) (q/translate 250 250) (q/rect 0 0 50 50) (comment \"resetting brings us back to [0, 0]\") (q/reset-matrix) (q/rect 0 0 50 100))",
  :setup "()",
  :target :cljs}
 {:fns ["push-matrix" "pop-matrix"],
  :ns "quil.snippets.transform",
  :name "push-matrix-pop-matrix",
  :opts {:settings nil},
  :draw
  "((q/fill 255 0 0) (comment \"draw rect at [20, 20]\") (q/translate 20 20) (q/rect 0 0 50 50) (comment \"move by 150 to right and save matrix\") (q/translate 150 0) (q/push-matrix) (comment \"rotate matrix and draw rect\") (q/rotate 1) (q/rect 0 0 50 50) (comment \"pop matrix should revert rotation\") (q/pop-matrix) (comment \"move by another 150 pixels and draw rect\") (q/translate 150 0) (q/rect 0 0 50 50))",
  :setup "()",
  :target :cljs}
 {:fns ["apply-matrix"],
  :ns "quil.snippets.transform",
  :name "apply-matrix",
  :opts {:settings nil},
  :draw
  "((q/no-fill) (q/rect 10 10 50 50) (comment \"move position by 100, 100 and shear\") (q/apply-matrix 1 0 1 1 100 100) (q/rect 10 10 50 50))",
  :setup "()",
  :target :cljs}
 {:fns ["load-shader" "loaded?" "shader"],
  :ns "quil.snippets.rendering",
  :name "load-shader",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((let [shd (q/state :shader)] (when (q/loaded? shd) (q/shader shd) (q/set-uniform shd \"p\" (array -0.74364388703 0.13182590421)) (q/set-uniform shd \"r\" (* 1.5 (q/exp (* -6.5 (+ 1 (q/sin (/ (q/millis) 2000))))))) (q/quad -1 -1 1 -1 1 1 -1 1))))",
  :setup
  "(let [shd (q/load-shader \"shader.frag\" \"shader.vert\")] (q/set-state! :shader shd))",
  :target :cljs}
 {:fns ["with-graphics"],
  :ns "quil.snippets.rendering",
  :name "with-graphics",
  :opts {:settings nil},
  :draw
  "((let [gr (q/create-graphics 250 250)] (q/with-graphics gr (q/background 255) (q/fill 255 0 0) (q/triangle 50 30 220 120 20 180)) (q/image gr 0 0) (q/image gr 250 0) (q/image gr 0 250) (q/image gr 250 250)))",
  :setup "()",
  :target :cljs}
 {:fns ["create-graphics"],
  :ns "quil.snippets.image.rendering",
  :name "create-graphics",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 127) (q/ellipse 50 50 80 40)) (q/image gr 0 0)))",
  :setup "()",
  :target :cljs}
 {:fns ["blend-mode"],
  :ns "quil.snippets.image.rendering",
  :name "blend-mode",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/background 255) (let [modes [:replace :blend :add :darkest :lightest :difference :exclusion :multiply :screen :overlay :hard-light :soft-light :dodge :burn] splitted (partition-all 4 modes)] (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col) gr (q/create-graphics 100 100 :p2d)] (q/with-graphics gr (q/background 127) (q/blend-mode mode) (q/no-stroke) (q/fill 255 0 0) (q/rect 10 20 80 20) (q/fill 50 170 255 127) (q/rect 60 10 20 80) (q/fill 200 130 150 200) (q/rect 10 60 80 20) (q/fill 20 240 50 50) (q/rect 20 10 20 80)) (q/image gr (* col 120) (* row 120)))))))",
  :setup "()",
  :target :cljs}
 {:fns ["torus"],
  :ns "quil.snippets.shape.primitives-3d",
  :name "torus",
  :opts {:renderer :p3d, :settings nil},
  :draw "((q/rotate-x (/ q/PI 4)) (q/torus 70 20))",
  :setup "()",
  :target :cljs}
 {:fns ["sphere"],
  :ns "quil.snippets.shape.primitives-3d",
  :name "sphere",
  :opts {:renderer :p3d, :settings nil},
  :draw "((q/camera 200 200 200 0 0 0 0 0 -1) (q/sphere 150))",
  :setup "()",
  :target :cljs}
 {:fns ["ellipsoid"],
  :ns "quil.snippets.shape.primitives-3d",
  :name "ellipsoid",
  :opts {:renderer :p3d, :settings nil},
  :draw "((q/ellipsoid 40 60 80))",
  :setup "()",
  :target :cljs}
 {:fns ["cylinder"],
  :ns "quil.snippets.shape.primitives-3d",
  :name "cylinder",
  :opts {:renderer :p3d, :settings nil},
  :draw "((q/rotate-x (* q/PI 1.25)) (q/cylinder 40 140))",
  :setup "()",
  :target :cljs}
 {:fns ["cone"],
  :ns "quil.snippets.shape.primitives-3d",
  :name "cone",
  :opts {:renderer :p3d, :settings nil},
  :draw "((q/rotate-x (* q/PI 1.25)) (q/cone 80 140))",
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
 {:fns ["redraw"],
  :ns "quil.snippets.structure",
  :name "redraw",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text \"click to move\" 10 20) (q/rect (* (q/frame-count) 10) (+ (* (q/frame-count) 10) 40) 50 50))",
  :setup "(q/no-loop)",
  :target :cljs}
 {:fns ["no-loop" "start-loop" "looping?"],
  :ns "quil.snippets.structure",
  :name "no-loop-start-loop",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (comment \"pause sketch on every 10th frame\") (when (zero? (rem (q/frame-count) 10)) (q/no-loop) (q/text \"paused, click to unpause\" 10 20)) (q/text (str \"(q/looping?) = \" (q/looping?)) 10 40) (q/text (str \"frame: \" (q/frame-count)) 10 60))",
  :setup "()",
  :target :cljs}
 {:fns ["exit"],
  :ns "quil.snippets.structure",
  :name "exit",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (comment \"exit sketch on 50th frame\") (q/text (str \"countdown \" (- 50 (q/frame-count))) 20 20) (when (= 50 (q/frame-count)) (q/exit)))",
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
 {:fns ["save"],
  :ns "quil.snippets.output",
  :name "save",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 150 150 150 0 0 0 0 0 1) (q/box 100) (q/save \"generated/box.png\") (comment \"stop sketch after saving image\") (comment \"otherwise it will show save dialog\") (comment \"on every iteration\") (q/exit))",
  :setup "()",
  :target :cljs}
 {:fns ["point-light"],
  :ns "quil.snippets.lights-camera.lights",
  :name "point-light",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (comment \"set light from the same point as camera [100, 100, 100]\") (q/point-light 255 150 150 100 100 100) (q/box 50))",
  :setup "()",
  :target :cljs}
 {:fns ["directional-light"],
  :ns "quil.snippets.lights-camera.lights",
  :name "directional-light",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (comment \"use red-ish color with direction [-1, -0.76, -0.5]\") (q/directional-light 255 150 150 -1 -0.76 -0.5) (q/box 50))",
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
 {:fns ["vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 100 400 200 100 0 0 0 0 -1) (q/line 0 0 0 0 0 150) (q/line 0 0 0 0 150 0) (q/line 0 0 0 150 0 0) (let [txtr (q/create-graphics 100 100)] (q/with-graphics txtr (q/background 255) (comment \"draw belarusian flag, kinda\") (q/fill 255 0 0) (q/rect 0 60 100 40) (q/fill 0 150 0) (q/rect 0 0 100 60)) (comment \"draw blue rect\") (q/fill 0 0 127) (q/begin-shape) (q/vertex 0 0) (q/vertex 100 0) (q/vertex 100 100) (q/vertex 0 100) (q/end-shape :close) (comment \"draw another blue rect\") (q/begin-shape) (q/vertex 0 0 0) (q/vertex 100 0 0) (q/vertex 100 0 100) (q/vertex 0 0 100) (q/end-shape :close) (comment \"draw rect using our custom texture\") (q/begin-shape) (q/texture txtr) (q/vertex 100 0 0 0) (q/vertex 200 0 100 0) (q/vertex 200 100 100 100) (q/vertex 100 100 0 100) (q/end-shape :close) (comment \"draw another rect using our custom texture\") (q/begin-shape) (q/texture txtr) (q/vertex 100 0 0 0 0) (q/vertex 200 0 0 100 0) (q/vertex 200 0 100 100 100) (q/vertex 100 0 100 0 100) (q/end-shape :close)))",
  :setup "()",
  :target :cljs}
 {:fns ["texture"],
  :ns "quil.snippets.shape.vertex",
  :name "texture",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((if (zero? (.-width (q/state :image))) (q/text \"Loading\" 10 10) (let [gr (q/state :image)] (q/with-translation [50 0] (q/texture gr) (q/plane 200 200)))))",
  :setup
  "(q/set-state! :image (q/load-image \"https://placekitten.com/100/100\"))",
  :target :cljs}
 {:fns ["quadratic-vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "quadratic-vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((comment \"setup camera and draw axes\") (q/camera 50 200 50 50 0 0 0 0 -1) (q/line 0 0 0 0 0 100) (q/line 0 0 0 0 100 0) (q/line 0 0 0 100 0 0) (comment \"draw first shape\") (q/begin-shape) (q/vertex 0 0) (q/quadratic-vertex 30 50 10 100) (q/quadratic-vertex 50 -50 90 100) (q/quadratic-vertex 80 50 100 0) (q/end-shape :close) (comment \"draw second shape\") (q/begin-shape) (q/vertex 0 0 0) (q/quadratic-vertex 30 0 50 10 0 100) (q/quadratic-vertex 50 0 -50 90 0 100) (q/quadratic-vertex 80 0 50 100 0 0) (q/end-shape :close))",
  :setup "()",
  :target :cljs}
 {:fns ["curve-vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "curve-vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 50 200 50 50 0 0 0 0 1) (comment \"draw first shape\") (q/begin-shape) (q/curve-vertex 0 0) (q/curve-vertex 0 0) (q/curve-vertex 100 20) (q/curve-vertex 100 80) (q/curve-vertex 20 80) (q/curve-vertex 0 0) (q/curve-vertex 0 0) (q/end-shape :close) (comment \"draw second shape\") (q/begin-shape) (q/curve-vertex 0 0 0) (q/curve-vertex 0 0 0) (q/curve-vertex 100 0 20) (q/curve-vertex 100 0 80) (q/curve-vertex 20 0 80) (q/curve-vertex 0 0 0) (q/curve-vertex 0 0 0) (q/end-shape :close))",
  :setup "()",
  :target :cljs}
 {:fns ["bezier-vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "bezier-vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera -400 250 -100 500 250 0 0 0 1) (comment \"draw first shape\") (q/begin-shape) (q/vertex 30 20) (q/bezier-vertex 480 0 480 475 30 475) (q/bezier-vertex 250 380 360 125 30 20) (q/end-shape :close) (comment \"draw second shape\") (q/begin-shape) (q/vertex 30 20 0) (q/bezier-vertex 480 0 20 480 475 30 30 475 40) (q/bezier-vertex 250 380 40 360 125 10 30 20 0) (q/end-shape :close))",
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
  "((q/stroke 255 0 0) (comment \"try all kinds of begin modes\") (doseq [[ind begin-mode close-mode] [[0 nil nil] [1 nil :close] [2 :points] [3 :lines] [4 :triangles] [5 :triangle-fan] [6 :triangle-strip] [7 :quads] [8 :quad-strip]] :let [base-x (* 150 (mod ind 3)) base-y (* 150 (quot ind 3))]] (if begin-mode (q/begin-shape begin-mode) (q/begin-shape)) (q/vertex (+ base-x 50) (+ base-y 10)) (q/vertex (+ base-x 80) (+ base-y 30)) (q/vertex (+ base-x 80) (+ base-y 70)) (q/vertex (+ base-x 50) (+ base-y 90)) (q/vertex (+ base-x 20) (+ base-y 70)) (q/vertex (+ base-x 20) (+ base-y 30)) (if close-mode (q/end-shape close-mode) (q/end-shape))))",
  :setup "()",
  :target :cljs}
 {:fns ["begin-contour" "end-contour"],
  :ns "quil.snippets.shape.vertex",
  :name "begin-contour-end-contour",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/stroke 255 0 0) (q/fill 0 127 0) (q/begin-shape) (comment \"outer shape\") (q/vertex 250 20) (q/vertex 400 400) (q/vertex 50 400) (comment \"inner shape\") (q/begin-contour) (q/vertex 200 200) (q/vertex 250 380) (q/vertex 300 200) (q/end-contour) (q/end-shape :close))",
  :setup "()",
  :target :cljs}
 {:fns ["clear"],
  :ns "quil.snippets.color.setting",
  :name "clear",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((comment \"reusing the same graphics to draw 3 things\") (let [g (q/create-graphics 200 200 :p2d)] (q/background 255) (comment \"draw red square\") (q/with-graphics g (q/fill 255 0 0) (q/rect 25 25 150 150)) (q/image g 0 0) (comment \"draw circle without clearing\") (comment \"red square is still present\") (q/with-graphics g (q/fill 0 255 0) (q/ellipse 100 100 150 150)) (q/image g 50 50) (comment \"draw triangle but with clear\") (q/with-graphics g (q/clear) (q/fill 0 0 255) (q/triangle 25 25 175 25 25 175)) (q/image g 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["stroke"],
  :ns "quil.snippets.color.setting",
  :name "stroke",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke-weight 10) (comment \"grey\") (q/stroke 120) (q/rect 10 10 100 100) (comment \"semitransparent light grey\") (q/stroke 80 120) (q/rect 80 80 100 100) (comment \"green\") (q/stroke 0 255 0) (q/rect 150 150 100 100) (comment \"semitransparent red\") (q/stroke 255 0 0 120) (q/rect 220 220 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["no-stroke"],
  :ns "quil.snippets.color.setting",
  :name "no-stroke",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke-weight 10) (comment \"set stroke to black\") (q/fill 120) (q/stroke 0) (q/rect 30 30 100 100) (comment \"remove stroke, no border around square\") (q/no-stroke) (q/rect 100 100 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["no-fill"],
  :ns "quil.snippets.color.setting",
  :name "no-fill",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"set background to grey\") (q/stroke 0) (q/fill 120) (q/rect 0 0 100 100) (comment \"remove background, only border left\") (q/no-fill) (q/rect 70 70 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["fill"],
  :ns "quil.snippets.color.setting",
  :name "fill",
  :opts {:settings nil},
  :draw
  "((comment \"blue background\") (q/background 0 0 255) (comment \"grey\") (q/fill 120) (q/rect 0 0 100 100) (comment \"semitransparent light grey\") (q/fill 80 120) (q/rect 70 70 100 100) (comment \"green\") (q/fill 0 255 0) (q/rect 140 140 100 100) (comment \"semitransparent red\") (q/fill 255 0 0 120) (q/rect 210 210 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["background-image"],
  :ns "quil.snippets.color.setting",
  :name "background-image",
  :opts {:settings nil},
  :draw
  "((let [im (q/state :image)] (comment \"check if image is loaded by checking its size matches sketch size\") (when (= (.-width im) (q/width)) (q/background-image im))))",
  :setup
  "(let [_ (comment \"create url to image to used as background\") url (str \"https://placekitten.com/\" (q/width) \"/\" (q/height))] (q/set-state! :image (q/load-image url)))",
  :target :cljs}
 {:fns ["background"],
  :ns "quil.snippets.color.setting",
  :name "background",
  :opts {:settings nil},
  :draw
  "((comment \"red\") (q/background 255 0 0) (let [_ (comment \"create graphics to test backgrounds\") gr (q/create-graphics 100 100)] (q/with-graphics gr (comment \"grey\") (q/background 120)) (q/image gr 0 0) (q/with-graphics gr (comment \"light-grey transparent\") (q/background 70 120)) (q/image gr 70 70) (q/with-graphics gr (comment \"cyan\") (q/background 0 255 255)) (q/image gr 140 140) (q/with-graphics gr (comment \"semitransparent blue\") (q/background 0 0 255 120)) (q/image gr 210 210)))",
  :setup "()",
  :target :cljs}
 {:fns ["ortho" "perspective"],
  :ns "quil.snippets.lights-camera.camera",
  :name "ortho-perspective",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 240) (comment \"flip between ortho and perspective camera every frame\") (comment \"enable ortho camera\") (comment \"in ortho all figures will look the same regardless distance\") (comment \"in perspective (default) all figures will look smaller the farther they are\") (if (even? (q/frame-count)) (q/ortho) (q/perspective)) (comment \"set camera to look from [300, 0, 300] at point [100, 0, 0]\") (q/camera 300 0 300 100 0 0 0 0 -1) (q/fill 0 127 127) (comment \"draw 3 boxes with x coordinates 0, 100 and 200\") (doseq [x [0 100 200]] (q/with-translation [x 0 0] (q/box 50))))",
  :setup "(q/frame-rate 1)",
  :target :cljs}
 {:fns ["orbit-control"],
  :ns "quil.snippets.lights-camera.camera",
  :name "orbit-control",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/orbit-control) (q/background 255) (q/fill 0 127 127) (q/box 200) (comment \"rotate camera around box using mouse\"))",
  :setup "()",
  :target :cljs}
 {:fns ["camera"],
  :ns "quil.snippets.lights-camera.camera",
  :name "camera",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (comment \"set camera in point [200, 200, 200]\") (comment \"the camera looks in direction of point [0, 0, 0]\") (comment \"\\\"up\\\" vector is [0, 0, -1]\") (q/camera 200 200 200 0 0 0 0 0 -1) (comment \"draw a box of size 100 at the [0, 0, 0] point\") (q/stroke-weight 2) (q/stroke 0) (q/fill 127) (q/box 100) (comment \"draw red X axis\") (q/stroke 255 0 0) (q/line 0 0 0 100 0 0) (comment \"draw green Y axis\") (q/stroke 0 255 0) (q/line 0 0 0 0 100 0) (comment \"draw blue Z axis\") (q/stroke 0 0 255) (q/line 0 0 0 0 0 100))",
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
  "((q/background 255) (q/fill 220 200 255) (comment \"normal rect\") (q/rect 50 50 150 100) (comment \"rect with rounded corners\") (q/rect 300 50 150 100 20) (comment \"rect with rounded corners where each corner is different\") (q/rect 50 300 150 100 5 10 20 30))",
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
  "((q/background 255) (q/stroke-weight 10) (comment \"red ponit\") (q/stroke 255 0 0) (q/point 10 10) (comment \"blue point\") (q/stroke 0 0 255) (q/point 50 50 -200))",
  :setup "()",
  :target :cljs}
 {:fns ["line"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "line",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/camera 250 250 250 0 0 0 0 0 -1) (comment \"red line\") (q/stroke 255 0 0) (q/line [0 0] [100 100]) (comment \"green line\") (q/stroke 0 255 0) (q/line 100 0 0 100) (comment \"three blue lines\") (q/stroke 0 0 255) (q/line 0 0 0 170 120 100) (q/line 170 120 100 50 -50 20) (q/line 50 -50 20 0 0 0))",
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
  "((q/background 255) (q/stroke 0) (q/fill 220 200 255) (comment \"draw default arc\") (q/arc 50 100 200 170 0 q/QUARTER-PI) (comment \"draw different arc modes\") (doseq [[ind mode] [[0 :open] [1 :chord] [2 :pie]]] (q/arc (+ 50 (* ind 150)) 300 200 170 0 q/QUARTER-PI mode)))",
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
 {:fns ["angle-mode"],
  :ns "quil.snippets.math.trigonometry",
  :name "angle-mode",
  :opts {:settings nil},
  :draw
  "((comment \"draw a red square for reference\") (q/fill 255 0 0) (q/rect 0 0 100 100) (comment \"rotation will be in degrees (instead of the default radians)\") (q/angle-mode :degrees) (q/rotate 45) (comment \"draw a green square after the rotation of 45 degrees\") (q/fill 0 255 0) (q/rect 0 0 100 100))",
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
 {:fns ["specular"],
  :ns "quil.snippets.lights-camera.material-properties",
  :name "specular",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/fill 255) (q/background 0) (q/camera 150 150 150 0 25 0 0 0 -1) (q/ambient-light 60 60 60) (q/no-stroke) (q/point-light 25 255 255 150 150 150) (q/specular 255) (q/sphere 50) (q/translate 0 100 0) (q/specular 204 0 0) (q/sphere 40))",
  :setup "()",
  :target :cljs}
 {:fns ["ambient"],
  :ns "quil.snippets.lights-camera.material-properties",
  :name "ambient",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 150 150 150 0 0 0 0 0 -1) (comment \"set light to kinda pink\") (q/ambient-light 255 127 127) (comment \"first box has full reflectance\") (q/ambient 255) (q/translate 0 -50 0) (q/box 50) (comment \"second box has abmient material with blue-only component\") (q/translate 0 75 0) (q/ambient 0 0 255) (q/box 50) (comment \"third box has gray ambient material\") (q/translate 0 75 0) (q/ambient 127) (q/box 50))",
  :setup "()",
  :target :cljs}
 {:fns ["with-stroke"],
  :ns "quil.snippets.color.utility-macros",
  :name "with-stroke",
  :opts {:settings nil},
  :draw
  "((comment \"set fill to white, stroke to black and draw a square\") (q/fill 255) (q/stroke-weight 10) (q/stroke 0) (q/rect 30 30 60 60) (comment \"set border to red and draw 2 squares\") (q/with-stroke [255 0 0] (q/rect 60 60 90 90) (q/rect 90 90 120 120)) (comment \"draw another square, should have black borders\") (q/rect 120 120 150 150))",
  :setup "()",
  :target :cljs}
 {:fns ["with-fill"],
  :ns "quil.snippets.color.utility-macros",
  :name "with-fill",
  :opts {:settings nil},
  :draw
  "((comment \"set fill to white and draw a square\") (q/fill 255) (q/rect 30 30 60 60) (comment \"set fill to red and draw 2 squares\") (q/with-fill [255 0 0] (q/rect 60 60 90 90) (q/rect 90 90 120 120)) (comment \"draw square, it'll use white color\") (q/rect 120 120 150 150))",
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
  "((q/background 255) (q/fill 0) (q/text (q/state :text) 10 20) (q/text (str \"Full state: \" (q/state)) 10 40))",
  :setup "(q/set-state! :text \"I'm state!\" :year (q/year))",
  :target :cljs}
 {:fns ["resize"],
  :ns "quil.snippets.image",
  :name "resize-image",
  :opts {:settings nil},
  :draw
  "((comment \"create image and draw gradient on it\") (let [im (q/create-image 100 100)] (dotimes [x 100] (dotimes [y 100] (q/set-pixel im x y (q/color (* 2 x) (* 2 y) (+ x y))))) (q/update-pixels im) (q/image im 0 0) (comment \"resize image from 100x100 to 50x50 and draw again\") (q/resize im 50 50) (q/image im 100 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["create-image" "set-pixel"],
  :ns "quil.snippets.image",
  :name "create-image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"create image and draw gradient on it\") (let [im (q/create-image 100 100)] (dotimes [x 100] (dotimes [y 100] (q/set-pixel im x y (q/color (* 2 x) (* 2 y) (+ x y))))) (q/update-pixels im) (comment \"draw image twice\") (q/image im 0 0) (q/image im 50 50)))",
  :setup "()",
  :target :cljs}
 {:fns ["resize-sketch"],
  :ns "quil.snippets.environment",
  :name "resize-sketch",
  :opts {:settings nil},
  :draw
  "((q/frame-rate 1) (comment \"each frame increase size of sketch\") (q/resize-sketch (inc (q/width)) (inc (q/height))) (q/background 255) (q/fill 0) (q/text (str \"width: \" (q/width) \", height: \" (q/height)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["pixel-density"],
  :ns "quil.snippets.environment",
  :name "pixel-density",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/ellipse 102 102 200 200) (q/triangle 200 200 400 300 300 400))",
  :setup "()",
  :target :cljs}
 {:fns ["display-density"],
  :ns "quil.snippets.environment",
  :name "display-density",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"display density: \" (q/display-density)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["height" "width"],
  :ns "quil.snippets.environment",
  :name "height-width",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"width: \" (q/width) \", height: \" (q/height)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["frame-rate"],
  :ns "quil.snippets.environment",
  :name "frame-rate",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"Frame rate: \" (q/target-frame-rate)) 10 20) (let [frame (q/frame-count)] (comment \"draw moving box\") (q/rect (rem frame (q/width)) 50 50 50) (comment \"every 10 frames change frame rate\") (comment \"frame rate cycles through [1, 6, 11, 16, 21]\") (when (zero? (rem frame 10)) (q/frame-rate (inc (* 5 (rem (quot frame 10) 5)))))))",
  :setup "()",
  :target :cljs}
 {:fns ["frame-count"],
  :ns "quil.snippets.environment",
  :name "frame-count",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"Frame count: \" (q/frame-count)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["focused"],
  :ns "quil.snippets.environment",
  :name "focused",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"Focused: \" (q/focused)) 10 20))",
  :setup "()",
  :target :cljs}
 {:fns ["cursor" "no-cursor"],
  :ns "quil.snippets.environment",
  :name "cursor-no-cursor",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/rect-mode :corners) (q/text-align :center :center) (comment \"iterate through all types of cursors\") (let [types [:arrow :cross :hand :move :text :wait :no-cursor :default] box-width (/ (q/width) 4.1) box-height (/ (q/height) 2.1)] (dotimes [ind (count types)] (let [type (nth types ind) _ (comment \"calculate corners of current box\") x (* box-width (rem ind 4)) y (* box-height (quot ind 4)) n-x (+ x box-width) n-y (+ y box-height)] (comment \"draw a box for current type with its name in center\") (q/stroke 127) (q/no-fill) (q/rect x y n-x n-y) (q/no-stroke) (q/fill 0) (q/text (str type) (/ (+ x n-x) 2) (/ (+ y n-y) 2)) (comment \"if mouse is inside the box - enable this type\") (when (and (<= x (q/mouse-x) n-x) (<= y (q/mouse-y) n-y)) (condp = type :default (q/cursor) :no-cursor (q/no-cursor) (q/cursor type)))))))",
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
  "((q/background 255) (q/fill 0) (q/text (str \"(q/current-frame-rate) = \" (q/current-frame-rate)) 10 20) (q/text (str \"(q/target-frame-rate) = \" (q/target-frame-rate)) 10 40))",
  :setup "()",
  :target :cljs}
 {:fns ["with-translation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-translation-3d",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/stroke 0) (comment \"set camera and draw XYZ axis\") (q/camera 200 200 200 0 0 0 0 0 -1) (q/line 0 0 0 100 0 0) (q/line 0 0 0 0 100 0) (q/line 0 0 0 0 0 100) (q/fill 0) (q/no-fill) (q/stroke 255 0 0) (comment \"draw 3 boxes using with-translation\") (q/box 50) (q/with-translation [100 0 0] (q/box 50)) (q/with-translation [100 0 100] (q/box 50)))",
  :setup "()",
  :target :cljs}
 {:fns ["with-translation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-translation-2d",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/rect 0 0 50 50) (q/with-translation [150 0] (q/rect 0 0 50 50)) (q/with-translation [150 150] (q/rect 0 0 50 50)))",
  :setup "()",
  :target :cljs}
 {:fns ["with-rotation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-rotation-3d-around-xy",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/stroke 0) (comment \"set camera and draw XYZ axis\") (q/camera 200 200 200 0 0 0 0 0 -1) (q/line 0 0 0 100 0 0) (q/line 0 0 0 0 100 0) (q/line 0 0 0 0 0 100) (q/fill 0) (q/no-fill) (q/stroke 255 0 0) (comment \"draw box without rotation\") (q/box 50) (comment \"draw box with 45° rotation around \") (comment \"[1, 1, 0] vector.\") (q/with-translation [100 0 0] (q/with-rotation [(/ q/PI 4) 1 1 0] (q/box 50))))",
  :setup "()",
  :target :cljs}
 {:fns ["with-rotation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-rotation-3d-around-x",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/stroke 0) (comment \"set camera and draw XYZ axis\") (q/camera 200 200 200 0 0 0 0 0 -1) (q/line 0 0 0 100 0 0) (q/line 0 0 0 0 100 0) (q/line 0 0 0 0 0 100) (q/fill 0) (q/no-fill) (q/stroke 255 0 0) (comment \"draw box without rotation\") (q/box 50) (comment \"draw box with 45° rotation around \") (comment \"[1, 0, 0] vector.\") (q/with-translation [100 0 0] (q/with-rotation [(/ q/PI 4) 1 0 0] (q/box 50))))",
  :setup "()",
  :target :cljs}
 {:fns ["with-rotation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-rotation-2d",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"draw rectangle without rotation\") (q/with-translation [50 50] (q/rect 0 0 100 200)) (comment \"draw rectangle with 45° rotation\") (q/with-translation [300 50] (q/with-rotation [(/ q/PI 4)] (q/rect 0 0 100 200))))",
  :setup "()",
  :target :cljs}
 {:fns ["curve-tightness"],
  :ns "quil.snippets.shape.curves",
  :name "curve-tightness",
  :opts {:settings nil},
  :draw
  "((q/no-fill) (comment \"try different tightnesses\") (doseq [[ind t] [[0 -5] [1 -1] [2 0] [3 1] [4 5]]] (q/curve-tightness t) (q/with-translation [100 (+ 50 (* ind 70))] (q/curve 0 0 0 0 50 30 100 -30) (q/curve 0 0 50 30 100 -30 150 0) (q/curve 50 30 100 -30 150 0 150 0))))",
  :setup "()",
  :target :cljs}
 {:fns ["curve-tangent"],
  :ns "quil.snippets.shape.curves",
  :name "curve-tangent",
  :opts {:settings nil},
  :draw
  "((comment \"see https://p5js.org/reference/#/p5/curveTangent for better example\") (q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/curve-tangent 0 5 7 0 v) txt (str \"(q/curve-tangent 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :cljs}
 {:fns ["curve-point"],
  :ns "quil.snippets.shape.curves",
  :name "curve-point",
  :opts {:settings nil},
  :draw
  "((comment \"see https://p5js.org/reference/#/p5/curvePoint for better example\") (q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/curve-point 0 5 7 0 v) txt (str \"(q/curve-point 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
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
  "((comment \"see https://p5js.org/reference/#/p5/bezierTangent for better example\") (q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/bezier-tangent 0 5 7 0 v) txt (str \"(q/bezier-tangent 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :cljs}
 {:fns ["bezier-point"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-point",
  :opts {:settings nil},
  :draw
  "((comment \"see https://p5js.org/reference/#/p5/bezierPoint for better example\") (q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/bezier-point 0 5 7 0 v) txt (str \"(q/bezier-point 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :cljs}
 {:fns ["bezier-detail" "bezier"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-detail",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 0 0 300 0 0 0 0 1 0) (q/no-fill) (q/bezier-detail 5) (q/bezier 0 0 0 0 100 0 0 100 0 100 0 0))",
  :setup "()",
  :target :cljs}
 {:fns ["bezier"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-3d",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/bezier 0 0 0 0 100 0 0 100 0 100 0 0))",
  :setup "()",
  :target :cljs}
 {:fns ["bezier"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-2d",
  :opts {:settings nil},
  :draw
  "((q/no-fill) (q/with-translation [100 100] (q/bezier 0 0 50 100 100 -100 150 0)))",
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
  "((q/rect-mode :center) (q/stroke-weight 12) (comment \"use :miter join\") (q/stroke-join :miter) (q/rect 125 125 100 100) (comment \"use :bevel join\") (q/stroke-join :bevel) (q/rect 375 125 100 100) (comment \"use :round join\") (q/stroke-join :round) (q/rect 125 375 100 100))",
  :setup "()",
  :target :cljs}
 {:fns ["stroke-cap"],
  :ns "quil.snippets.shape.attributes",
  :name "stroke-cap",
  :opts {:settings nil},
  :draw
  "((q/stroke-weight 12) (comment \"use :square cap\") (q/stroke-cap :square) (q/line 230 200 270 200) (comment \"use :project cap\") (q/stroke-cap :project) (q/line 230 250 270 250) (comment \"use :round cap\") (q/stroke-cap :round) (q/line 230 300 270 300))",
  :setup "()",
  :target :cljs}
 {:fns ["rect-mode"],
  :ns "quil.snippets.shape.attributes",
  :name "rect-mode",
  :opts {:settings nil},
  :draw
  "((q/stroke-weight 5) (comment \"use :center mode\") (q/rect-mode :center) (q/with-translation [125 125] (q/stroke 0) (q/rect 0 0 100 70) (q/stroke 255 0 0) (q/point 0 0)) (comment \"use :radius mode\") (q/rect-mode :radius) (q/with-translation [375 125] (q/stroke 0) (q/rect 0 0 100 70) (q/stroke 255 0 0) (q/point 0 0)) (comment \"use :corner mode\") (q/rect-mode :corner) (q/with-translation [125 375] (q/stroke 0) (q/rect 0 0 100 70) (q/stroke 255 0 0) (q/point 0 0)) (comment \"use :corners mode\") (q/rect-mode :corners) (q/with-translation [375 375] (q/stroke 0) (q/rect -50 -35 50 35) (q/stroke 255 0 0) (q/point -50 -35) (q/point 50 35)))",
  :setup "()",
  :target :cljs}
 {:fns ["smooth" "no-smooth"],
  :ns "quil.snippets.shape.attributes",
  :name "smooth-no-smooth",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((comment \"that's a bad example. smooth is odd\") (q/with-translation [125 125] (q/ellipse 0 0 200 200)))",
  :setup "()",
  :target :cljs}
 {:fns ["ellipse-mode"],
  :ns "quil.snippets.shape.attributes",
  :name "ellipse-mode",
  :opts {:settings nil},
  :draw
  "((q/stroke-weight 5) (comment \"use :center mode\") (q/ellipse-mode :center) (q/with-translation [125 125] (q/ellipse 0 0 100 70) (q/point 0 0)) (comment \"use :radius mode\") (q/ellipse-mode :radius) (q/with-translation [375 125] (q/ellipse 0 0 100 70) (q/point 0 0)) (comment \"use :corner mode\") (q/ellipse-mode :corner) (q/with-translation [125 375] (q/ellipse 0 0 100 70) (q/point 0 0)) (comment \"use :corners mode\") (q/ellipse-mode :corners) (q/with-translation [375 375] (q/ellipse -50 -35 50 35) (q/point -50 -35) (q/point 50 35)))",
  :setup "()",
  :target :cljs}
 {:fns ["text-font"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "text-font",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (let [font \"Courier New\"] (q/text-font font 20) (q/text \"(print :hello)\" 20 30) (q/text-font font 30) (q/text \"(print-bigger :hello)\" 20 100)))",
  :setup "()",
  :target :cljs}
 {:fns ["text"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "text-2d",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (comment \"draw text\") (q/text \"word\" 10 30) (comment \"draw text in a 'box'\") (q/text \"a long sentence wrapping inside a box\" 60 20 120 60))",
  :setup "()",
  :target :cljs}
 {:fns ["load-font"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "load-font",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (let [font (q/state :font)] (q/text-font font) (q/text \"CoMiC SaNs HeRe\" 20 100)))",
  :setup
  "(let [_ (comment \"create url to load font\") url \"https://www.fontsquirrel.com/fonts/download/roboto\"] (q/set-state! :font (q/load-font url)))",
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
  "((q/background 255) (q/fill 0) (let [font (q/create-font \"Courier New\" 20)] (q/text-font font 20) (q/text \"(print :hello)\" 20 30) (q/text-font font 30) (q/text \"(print-bigger :hello)\" 20 100)))",
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
  :name "text-3d",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/camera 50 50 50 0 0 0 0 0 -1) (comment \"draw x/y/z axis\") (q/line 0 0 0 0 0 20) (q/line 0 0 0 0 20 0) (q/line 0 0 0 20 0 0) (comment \"draw text '2D'\") (q/text \"2D\" 0 15) (q/rotate-x (- q/HALF-PI)) (comment \"draw text '3D'\") (q/text \"3D\" 0 -5 0) (comment \"draw text 'box'\") (q/rotate-y q/HALF-PI) (q/rect-mode :corners) (q/text \"box\" -30 0 30 -15))",
  :setup "()",
  :target :clj}
 {:fns ["text"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "text-2d",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (comment \"draw text\") (q/text \"word\" 10 30) (comment \"draw text in a 'box'\") (q/text \"a long sentence wrapping inside a box\" 60 20 120 60))",
  :setup "()",
  :target :clj}
 {:fns ["load-font"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "load-font",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (let [font (q/state :font)] (q/text-font font) (q/text \"CoMiC SaNs HeRe\" 20 100)))",
  :setup
  "(let [_ (comment \"create url to load font\") url (.getPath (clojure.java.io/resource \"ComicSansMS-48.vlw\"))] (q/set-state! :font (q/load-font url)))",
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
  "((q/background 255) (q/fill 0) (comment \"create font by name and size\") (q/text-font (q/create-font \"Courier New\" 30)) (q/text \"(print :hello)\" 20 50) (comment \"create font by name and size and using smooth\") (q/text-font (q/create-font \"Georgia\" 30 true)) (q/text \"(print :hello)\" 20 100) (comment \"create font with all parameters\") (q/text-font (q/create-font \"Georgia\" 30 false (char-array \"what is it for?\"))) (q/text \"(print :hello)\" 20 150))",
  :setup "()",
  :target :clj}
 {:fns ["available-fonts"],
  :ns "quil.snippets.typography.loading-and-displaying",
  :name "available-fonts",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text-size 10) (doseq [[col fonts] (->> (q/available-fonts) (partition-all 50) (map-indexed vector)) [row font] (map-indexed vector fonts)] (q/text font (+ 20 (* col 100)) (+ 20 (* row 10)))))",
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
  "((q/fill 0) (let [h-align [:left :center :right] v-align [:top :bottom :center :baseline]] (comment \"text-align with single argument\") (doseq [ind (range (count h-align)) :let [x 50 y (+ 20 (* ind 50))]] (q/text-align (h-align ind)) (q/text (name (h-align ind)) x y) (q/push-style) (q/stroke 255 0 0) (q/stroke-weight 5) (q/point x y) (q/pop-style)) (comment \"text-align with multiple arguments\") (doseq [ind-h (range (count h-align)) ind-v (range (count v-align)) :let [x (+ 70 (* ind-v 100)) y (+ 250 (* ind-h 50)) h-al (h-align ind-h) v-al (v-align ind-v) txt (str (name h-al) \"+\" (name v-al))]] (q/text-align h-al v-al) (q/text txt x y) (q/push-style) (q/stroke 255 0 0) (q/stroke-weight 5) (q/point x y) (q/pop-style))))",
  :setup "()",
  :target :clj}
 {:fns ["with-translation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-translation-3d",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/stroke 0) (comment \"set camera and draw XYZ axis\") (q/camera 200 200 200 0 0 0 0 0 -1) (q/line 0 0 0 100 0 0) (q/line 0 0 0 0 100 0) (q/line 0 0 0 0 0 100) (q/fill 0) (q/text \"x\" 100 0 0) (q/text \"y\" 0 100 0) (q/text \"z\" 0 0 100) (q/no-fill) (q/stroke 255 0 0) (comment \"draw 3 boxes using with-translation\") (q/box 50) (q/with-translation [100 0 0] (q/box 50)) (q/with-translation [100 0 100] (q/box 50)))",
  :setup "()",
  :target :clj}
 {:fns ["with-translation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-translation-2d",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/rect 0 0 50 50) (q/with-translation [150 0] (q/rect 0 0 50 50)) (q/with-translation [150 150] (q/rect 0 0 50 50)))",
  :setup "()",
  :target :clj}
 {:fns ["with-rotation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-rotation-3d-around-xy",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/stroke 0) (comment \"set camera and draw XYZ axis\") (q/camera 200 200 200 0 0 0 0 0 -1) (q/line 0 0 0 100 0 0) (q/line 0 0 0 0 100 0) (q/line 0 0 0 0 0 100) (q/fill 0) (q/text \"x\" 100 0 0) (q/text \"y\" 0 100 0) (q/text \"z\" 0 0 100) (q/no-fill) (q/stroke 255 0 0) (comment \"draw box without rotation\") (q/box 50) (comment \"draw box with 45° rotation around \") (comment \"[1, 1, 0] vector.\") (q/with-translation [100 0 0] (q/with-rotation [(/ q/PI 4) 1 1 0] (q/box 50))))",
  :setup "()",
  :target :clj}
 {:fns ["with-rotation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-rotation-3d-around-x",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/stroke 0) (comment \"set camera and draw XYZ axis\") (q/camera 200 200 200 0 0 0 0 0 -1) (q/line 0 0 0 100 0 0) (q/line 0 0 0 0 100 0) (q/line 0 0 0 0 0 100) (q/fill 0) (q/text \"x\" 100 0 0) (q/text \"y\" 0 100 0) (q/text \"z\" 0 0 100) (q/no-fill) (q/stroke 255 0 0) (comment \"draw box without rotation\") (q/box 50) (comment \"draw box with 45° rotation around \") (comment \"[1, 0, 0] vector.\") (q/with-translation [100 0 0] (q/with-rotation [(/ q/PI 4) 1 0 0] (q/box 50))))",
  :setup "()",
  :target :clj}
 {:fns ["with-rotation"],
  :ns "quil.snippets.transform.utility-macros",
  :name "with-rotation-2d",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"draw rectangle without rotation\") (q/with-translation [50 50] (q/rect 0 0 100 200)) (comment \"draw rectangle with 45° rotation\") (q/with-translation [300 50] (q/with-rotation [(/ q/PI 4)] (q/rect 0 0 100 200))))",
  :setup "()",
  :target :clj}
 {:fns ["vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 100 400 200 100 0 0 0 0 -1) (q/line 0 0 0 0 0 150) (q/line 0 0 0 0 150 0) (q/line 0 0 0 150 0 0) (let [txtr (q/create-graphics 100 100)] (q/with-graphics txtr (q/background 255) (comment \"draw belarusian flag, kinda\") (q/fill 255 0 0) (q/rect 0 60 100 40) (q/fill 0 150 0) (q/rect 0 0 100 60)) (comment \"draw blue rect\") (q/fill 0 0 127) (q/begin-shape) (q/vertex 0 0) (q/vertex 100 0) (q/vertex 100 100) (q/vertex 0 100) (q/end-shape :close) (comment \"draw another blue rect\") (q/begin-shape) (q/vertex 0 0 0) (q/vertex 100 0 0) (q/vertex 100 0 100) (q/vertex 0 0 100) (q/end-shape :close) (comment \"draw rect using our custom texture\") (q/begin-shape) (q/texture txtr) (q/vertex 100 0 0 0) (q/vertex 200 0 100 0) (q/vertex 200 100 100 100) (q/vertex 100 100 0 100) (q/end-shape :close) (comment \"draw another rect using our custom texture\") (q/begin-shape) (q/texture txtr) (q/vertex 100 0 0 0 0) (q/vertex 200 0 0 100 0) (q/vertex 200 0 100 100 100) (q/vertex 100 0 100 0 100) (q/end-shape :close)))",
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
  "((let [gr (q/create-graphics 100 100)] (comment \"draw something on graphics that will be texture\") (q/with-graphics gr (q/background 255) (q/fill 255 0 0) (q/rect 0 60 100 40) (q/fill 0 150 0) (q/rect 0 0 100 60)) (comment \"draw graphics to see what we got\") (q/image gr 0 0) (comment \"draw custom shape using texture we created above\") (q/with-translation [250 250] (q/begin-shape) (q/texture gr) (q/vertex 50 100 75 100) (q/vertex 100 50 100 75) (q/vertex 100 -50 100 25) (q/vertex 50 -100 75 0) (q/vertex -50 -100 25 0) (q/vertex -100 -50 0 25) (q/vertex -100 50 0 75) (q/vertex -50 100 25 100) (q/end-shape :close))))",
  :setup "()",
  :target :clj}
 {:fns ["quadratic-vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "quadratic-vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((comment \"setup camera and draw axes\") (q/camera 50 200 50 50 0 0 0 0 -1) (q/line 0 0 0 0 0 100) (q/line 0 0 0 0 100 0) (q/line 0 0 0 100 0 0) (comment \"draw first shape\") (q/begin-shape) (q/vertex 0 0) (q/quadratic-vertex 30 50 10 100) (q/quadratic-vertex 50 -50 90 100) (q/quadratic-vertex 80 50 100 0) (q/end-shape :close) (comment \"draw second shape\") (q/begin-shape) (q/vertex 0 0 0) (q/quadratic-vertex 30 0 50 10 0 100) (q/quadratic-vertex 50 0 -50 90 0 100) (q/quadratic-vertex 80 0 50 100 0 0) (q/end-shape :close))",
  :setup "()",
  :target :clj}
 {:fns ["curve-vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "curve-vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 50 200 50 50 0 0 0 0 1) (comment \"draw first shape\") (q/begin-shape) (q/curve-vertex 0 0) (q/curve-vertex 0 0) (q/curve-vertex 100 20) (q/curve-vertex 100 80) (q/curve-vertex 20 80) (q/curve-vertex 0 0) (q/curve-vertex 0 0) (q/end-shape :close) (comment \"draw second shape\") (q/begin-shape) (q/curve-vertex 0 0 0) (q/curve-vertex 0 0 0) (q/curve-vertex 100 0 20) (q/curve-vertex 100 0 80) (q/curve-vertex 20 0 80) (q/curve-vertex 0 0 0) (q/curve-vertex 0 0 0) (q/end-shape :close))",
  :setup "()",
  :target :clj}
 {:fns ["bezier-vertex"],
  :ns "quil.snippets.shape.vertex",
  :name "bezier-vertex",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera -400 250 -100 500 250 0 0 0 1) (comment \"draw first shape\") (q/begin-shape) (q/vertex 30 20) (q/bezier-vertex 480 0 480 475 30 475) (q/bezier-vertex 250 380 360 125 30 20) (q/end-shape :close) (comment \"draw second shape\") (q/begin-shape) (q/vertex 30 20 0) (q/bezier-vertex 480 0 20 480 475 30 30 475 40) (q/bezier-vertex 250 380 40 360 125 10 30 20 0) (q/end-shape :close))",
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
  "((q/stroke 255 0 0) (comment \"try all kinds of begin modes\") (doseq [[ind begin-mode close-mode] [[0 nil nil] [1 nil :close] [2 :points] [3 :lines] [4 :triangles] [5 :triangle-fan] [6 :triangle-strip] [7 :quads] [8 :quad-strip]] :let [base-x (* 150 (mod ind 3)) base-y (* 150 (quot ind 3))]] (if begin-mode (q/begin-shape begin-mode) (q/begin-shape)) (q/vertex (+ base-x 50) (+ base-y 10)) (q/vertex (+ base-x 80) (+ base-y 30)) (q/vertex (+ base-x 80) (+ base-y 70)) (q/vertex (+ base-x 50) (+ base-y 90)) (q/vertex (+ base-x 20) (+ base-y 70)) (q/vertex (+ base-x 20) (+ base-y 30)) (if close-mode (q/end-shape close-mode) (q/end-shape))))",
  :setup "()",
  :target :clj}
 {:fns ["begin-contour" "end-contour"],
  :ns "quil.snippets.shape.vertex",
  :name "begin-contour-end-contour",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/stroke 255 0 0) (q/fill 0 127 0) (q/begin-shape) (comment \"outer shape\") (q/vertex 250 20) (q/vertex 400 400) (q/vertex 50 400) (comment \"inner shape\") (q/begin-contour) (q/vertex 200 200) (q/vertex 250 380) (q/vertex 300 200) (q/end-contour) (q/end-shape :close))",
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
  "((q/background 255) (q/fill 220 200 255) (comment \"normal rect\") (q/rect 50 50 150 100) (comment \"rect with rounded corners\") (q/rect 300 50 150 100 20) (comment \"rect with rounded corners where each corner is different\") (q/rect 50 300 150 100 5 10 20 30))",
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
  "((q/background 255) (q/stroke-weight 10) (comment \"red ponit\") (q/stroke 255 0 0) (q/point 10 10) (comment \"blue point\") (q/stroke 0 0 255) (q/point 50 50 -200))",
  :setup "()",
  :target :clj}
 {:fns ["line"],
  :ns "quil.snippets.shape.primitives-2d",
  :name "line",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (q/camera 250 250 250 0 0 0 0 0 -1) (comment \"red line\") (q/stroke 255 0 0) (q/line [0 0] [100 100]) (comment \"green line\") (q/stroke 0 255 0) (q/line 100 0 0 100) (comment \"three blue lines\") (q/stroke 0 0 255) (q/line 0 0 0 170 120 100) (q/line 170 120 100 50 -50 20) (q/line 50 -50 20 0 0 0))",
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
  "((q/background 255) (q/stroke 0) (q/fill 220 200 255) (comment \"draw default arc\") (q/arc 50 100 200 170 0 q/QUARTER-PI) (comment \"draw different arc modes\") (doseq [[ind mode] [[0 :open] [1 :chord] [2 :pie]]] (q/arc (+ 50 (* ind 150)) 300 200 170 0 q/QUARTER-PI mode)))",
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
 {:fns ["shape" "load-shape"],
  :ns "quil.snippets.shape.loading-and-displaying",
  :name "shape",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((let [sh (q/state :shp)] (q/shape sh) (q/shape sh 100 100) (q/shape sh 300 300 200 200)))",
  :setup
  "(let [sh (q/load-shape \"https://upload.wikimedia.org/wikipedia/en/2/22/Heckert_GNU_white.svg\")] (q/set-state! :shp sh))",
  :target :clj}
 {:fns ["curve-tightness"],
  :ns "quil.snippets.shape.curves",
  :name "curve-tightness",
  :opts {:settings nil},
  :draw
  "((q/no-fill) (comment \"try different tightnesses\") (doseq [[ind t] [[0 -5] [1 -1] [2 0] [3 1] [4 5]]] (q/curve-tightness t) (q/with-translation [100 (+ 50 (* ind 70))] (q/curve 0 0 0 0 50 30 100 -30) (q/curve 0 0 50 30 100 -30 150 0) (q/curve 50 30 100 -30 150 0 150 0))))",
  :setup "()",
  :target :clj}
 {:fns ["curve-tangent"],
  :ns "quil.snippets.shape.curves",
  :name "curve-tangent",
  :opts {:settings nil},
  :draw
  "((comment \"see https://p5js.org/reference/#/p5/curveTangent for better example\") (q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/curve-tangent 0 5 7 0 v) txt (str \"(q/curve-tangent 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :clj}
 {:fns ["curve-point"],
  :ns "quil.snippets.shape.curves",
  :name "curve-point",
  :opts {:settings nil},
  :draw
  "((comment \"see https://p5js.org/reference/#/p5/curvePoint for better example\") (q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/curve-point 0 5 7 0 v) txt (str \"(q/curve-point 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
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
  "((comment \"see https://p5js.org/reference/#/p5/bezierTangent for better example\") (q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/bezier-tangent 0 5 7 0 v) txt (str \"(q/bezier-tangent 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :clj}
 {:fns ["bezier-point"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-point",
  :opts {:settings nil},
  :draw
  "((comment \"see https://p5js.org/reference/#/p5/bezierPoint for better example\") (q/fill 0) (dotimes [i 5] (let [v (/ i 4) res (q/bezier-point 0 5 7 0 v) txt (str \"(q/bezier-point 0 5 7 0 \" v \") = \" res)] (q/text txt 10 (+ 20 (* i 20))))))",
  :setup "()",
  :target :clj}
 {:fns ["bezier-detail" "bezier"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-detail",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 0 0 300 0 0 0 0 1 0) (q/no-fill) (q/bezier-detail 5) (q/bezier 0 0 0 0 100 0 0 100 0 100 0 0))",
  :setup "()",
  :target :clj}
 {:fns ["bezier"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-3d",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/bezier 0 0 0 0 100 0 0 100 0 100 0 0))",
  :setup "()",
  :target :clj}
 {:fns ["bezier"],
  :ns "quil.snippets.shape.curves",
  :name "bezier-2d",
  :opts {:settings nil},
  :draw
  "((q/no-fill) (q/with-translation [100 100] (q/bezier 0 0 50 100 100 -100 150 0)))",
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
  "((q/rect-mode :center) (q/stroke-weight 12) (comment \"use :miter join\") (q/stroke-join :miter) (q/rect 125 125 100 100) (comment \"use :bevel join\") (q/stroke-join :bevel) (q/rect 375 125 100 100) (comment \"use :round join\") (q/stroke-join :round) (q/rect 125 375 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["stroke-cap"],
  :ns "quil.snippets.shape.attributes",
  :name "stroke-cap",
  :opts {:settings nil},
  :draw
  "((q/stroke-weight 12) (comment \"use :square cap\") (q/stroke-cap :square) (q/line 230 200 270 200) (comment \"use :project cap\") (q/stroke-cap :project) (q/line 230 250 270 250) (comment \"use :round cap\") (q/stroke-cap :round) (q/line 230 300 270 300))",
  :setup "()",
  :target :clj}
 {:fns ["rect-mode"],
  :ns "quil.snippets.shape.attributes",
  :name "rect-mode",
  :opts {:settings nil},
  :draw
  "((q/stroke-weight 5) (comment \"use :center mode\") (q/rect-mode :center) (q/with-translation [125 125] (q/stroke 0) (q/rect 0 0 100 70) (q/stroke 255 0 0) (q/point 0 0)) (comment \"use :radius mode\") (q/rect-mode :radius) (q/with-translation [375 125] (q/stroke 0) (q/rect 0 0 100 70) (q/stroke 255 0 0) (q/point 0 0)) (comment \"use :corner mode\") (q/rect-mode :corner) (q/with-translation [125 375] (q/stroke 0) (q/rect 0 0 100 70) (q/stroke 255 0 0) (q/point 0 0)) (comment \"use :corners mode\") (q/rect-mode :corners) (q/with-translation [375 375] (q/stroke 0) (q/rect -50 -35 50 35) (q/stroke 255 0 0) (q/point -50 -35) (q/point 50 35)))",
  :setup "()",
  :target :clj}
 {:fns ["smooth" "no-smooth"],
  :ns "quil.snippets.shape.attributes",
  :name "smooth-no-smooth",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((comment \"that's a bad example. smooth is odd\") (q/with-translation [125 125] (q/ellipse 0 0 200 200)))",
  :setup "()",
  :target :clj}
 {:fns ["ellipse-mode"],
  :ns "quil.snippets.shape.attributes",
  :name "ellipse-mode",
  :opts {:settings nil},
  :draw
  "((q/stroke-weight 5) (comment \"use :center mode\") (q/ellipse-mode :center) (q/with-translation [125 125] (q/ellipse 0 0 100 70) (q/point 0 0)) (comment \"use :radius mode\") (q/ellipse-mode :radius) (q/with-translation [375 125] (q/ellipse 0 0 100 70) (q/point 0 0)) (comment \"use :corner mode\") (q/ellipse-mode :corner) (q/with-translation [125 375] (q/ellipse 0 0 100 70) (q/point 0 0)) (comment \"use :corners mode\") (q/ellipse-mode :corners) (q/with-translation [375 375] (q/ellipse -50 -35 50 35) (q/point -50 -35) (q/point 50 35)))",
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
  "((q/fill 255) (q/background 0) (q/camera 150 150 150 0 25 0 0 0 -1) (q/ambient-light 60 60 60) (q/no-stroke) (q/fill 0 51 102) (q/light-specular 255 255 255) (q/directional-light 255 255 255 0 0 -1) (q/specular 255) (q/sphere 50) (q/translate 0 100 0) (q/specular 204 0 0) (q/sphere 40))",
  :setup "()",
  :target :clj}
 {:fns ["shininess"],
  :ns "quil.snippets.lights-camera.material-properties",
  :name "shininess",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 150 150 150 0 25 0 0 0 -1) (q/fill 127 0 255) (q/no-stroke) (q/light-specular 204 204 204) (q/directional-light 102 102 102 -1 -1 -1) (q/specular 255 255 255) (comment \"draw two spheres with different shininess\") (q/shininess 2) (q/sphere 50) (q/translate 0 100 0) (q/shininess 10) (q/sphere 40))",
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
  "((q/background 0) (q/camera 150 150 150 0 0 0 0 0 -1) (comment \"set light to kinda pink\") (q/ambient-light 255 127 127) (comment \"first box has full reflectance\") (q/ambient 255) (q/translate 0 -50 0) (q/box 50) (comment \"second box has abmient material with blue-only component\") (q/translate 0 75 0) (q/ambient 0 0 255) (q/box 50) (comment \"third box has gray ambient material\") (q/translate 0 75 0) (q/ambient 127) (q/box 50))",
  :setup "()",
  :target :clj}
 {:fns ["spot-light"],
  :ns "quil.snippets.lights-camera.lights",
  :name "spot-light",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (comment \"use two different ways to call spot-light\") (comment \"one light is red and another is blue\") (q/spot-light 255 0 0 50 0 50 -1 0 -1 q/PI 1) (q/spot-light [0 0 255] [0 100 100] [0 -1 -1] q/PI 1) (q/box 50))",
  :setup "()",
  :target :clj}
 {:fns ["point-light"],
  :ns "quil.snippets.lights-camera.lights",
  :name "point-light",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (comment \"set light from the same point as camera [100, 100, 100]\") (q/point-light 255 150 150 100 100 100) (q/box 50))",
  :setup "()",
  :target :clj}
 {:fns ["no-lights"],
  :ns "quil.snippets.lights-camera.lights",
  :name "no-lights",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (comment \"draw box with lights\") (q/directional-light 255 150 150 -1 -0.76 -0.5) (q/box 50) (comment \"draw sphere without lights\") (q/no-lights) (q/translate 0 50 0) (q/sphere 20))",
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
  "((q/background 0) (q/camera 100 100 100 0 0 0 0 0 -1) (comment \"use red-ish color with direction [-1, -0.76, -0.5]\") (q/directional-light 255 150 150 -1 -0.76 -0.5) (q/box 50))",
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
 {:fns ["ortho" "perspective"],
  :ns "quil.snippets.lights-camera.camera",
  :name "ortho-perspective",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 240) (comment \"flip between ortho and perspective camera every frame\") (comment \"enable ortho camera\") (comment \"in ortho all figures will look the same regardless distance\") (comment \"in perspective (default) all figures will look smaller the farther they are\") (if (even? (q/frame-count)) (q/ortho) (q/perspective)) (comment \"set camera to look from [300, 0, 300] at point [100, 0, 0]\") (q/camera 300 0 300 100 0 0 0 0 -1) (q/fill 0 127 127) (comment \"draw 3 boxes with x coordinates 0, 100 and 200\") (doseq [x [0 100 200]] (q/with-translation [x 0 0] (q/box 50))))",
  :setup "(q/frame-rate 1)",
  :target :clj}
 {:fns ["frustum"],
  :ns "quil.snippets.lights-camera.camera",
  :name "frustum",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (comment \"set camera in point [200, 200, 200]\") (comment \"the camera looks in direction of point [0, 0, 0]\") (comment \"\\\"up\\\" vector is [0, 0, -1]\") (q/camera 200 200 200 0 0 0 0 0 -1) (comment \"set camera to show only part of the scene according to following condition\") (comment \"between -100 and 100 left to right\") (comment \"between -100 and 100 top to bottm\") (comment \"between 300 and 350 points in front\") (q/frustum -100 100 -100 100 300 350) (comment \"draw box, it will appear cut as we frustum \") (comment \"limits to 300-350 region in fron of camera\") (q/stroke-weight 2) (q/stroke 0) (q/fill 127) (q/box 100) (comment \"draw red X axis\") (q/stroke 255 0 0) (q/line 0 0 0 100 0 0) (comment \"draw green Y axis\") (q/stroke 0 255 0) (q/line 0 0 0 0 100 0) (comment \"draw blue Z axis\") (q/stroke 0 0 255) (q/line 0 0 0 0 0 100))",
  :setup "()",
  :target :clj}
 {:fns ["camera"],
  :ns "quil.snippets.lights-camera.camera",
  :name "camera",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/background 255) (comment \"set camera in point [200, 200, 200]\") (comment \"the camera looks in direction of point [0, 0, 0]\") (comment \"\\\"up\\\" vector is [0, 0, -1]\") (q/camera 200 200 200 0 0 0 0 0 -1) (comment \"draw a box of size 100 at the [0, 0, 0] point\") (q/stroke-weight 2) (q/stroke 0) (q/fill 127) (q/box 100) (comment \"draw red X axis\") (q/stroke 255 0 0) (q/line 0 0 0 100 0 0) (comment \"draw green Y axis\") (q/stroke 0 255 0) (q/line 0 0 0 0 100 0) (comment \"draw blue Z axis\") (q/stroke 0 0 255) (q/line 0 0 0 0 0 100))",
  :setup "()",
  :target :clj}
 {:fns ["unhex"],
  :ns "quil.snippets.data.conversion",
  :name "unhex",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/unhex \\\"2A\\\") = \" (q/unhex \"2A\")) 10 10))",
  :setup "()",
  :target :clj}
 {:fns ["unbinary"],
  :ns "quil.snippets.data.conversion",
  :name "unbinary",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/unbinary \\\"0101010\\\") = \" (q/unbinary \"0101010\")) 10 10))",
  :setup "()",
  :target :clj}
 {:fns ["hex"],
  :ns "quil.snippets.data.conversion",
  :name "hex",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/hex 42) = \" (q/hex 42)) 10 10) (q/text (str \"(q/hex 42 5) = \" (q/hex 42 5)) 10 30))",
  :setup "()",
  :target :clj}
 {:fns ["binary"],
  :ns "quil.snippets.data.conversion",
  :name "binary",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"(q/binary 42) = \" (q/binary 42)) 10 10) (q/text (str \"(q/binary 42 5) = \" (q/binary 42 5)) 10 30))",
  :setup "()",
  :target :clj}
 {:fns ["with-stroke"],
  :ns "quil.snippets.color.utility-macros",
  :name "with-stroke",
  :opts {:settings nil},
  :draw
  "((comment \"set fill to white, stroke to black and draw a square\") (q/fill 255) (q/stroke-weight 10) (q/stroke 0) (q/rect 30 30 60 60) (comment \"set border to red and draw 2 squares\") (q/with-stroke [255 0 0] (q/rect 60 60 90 90) (q/rect 90 90 120 120)) (comment \"draw another square, should have black borders\") (q/rect 120 120 150 150))",
  :setup "()",
  :target :clj}
 {:fns ["with-fill"],
  :ns "quil.snippets.color.utility-macros",
  :name "with-fill",
  :opts {:settings nil},
  :draw
  "((comment \"set fill to white and draw a square\") (q/fill 255) (q/rect 30 30 60 60) (comment \"set fill to red and draw 2 squares\") (q/with-fill [255 0 0] (q/rect 60 60 90 90) (q/rect 90 90 120 120)) (comment \"draw square, it'll use white color\") (q/rect 120 120 150 150))",
  :setup "()",
  :target :clj}
 {:fns ["clear"],
  :ns "quil.snippets.color.setting",
  :name "clear",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((comment \"reusing the same graphics to draw 3 things\") (let [g (q/create-graphics 200 200 :p2d)] (q/background 255) (comment \"draw red square\") (q/with-graphics g (q/fill 255 0 0) (q/rect 25 25 150 150)) (q/image g 0 0) (comment \"draw circle without clearing\") (comment \"red square is still present\") (q/with-graphics g (q/fill 0 255 0) (q/ellipse 100 100 150 150)) (q/image g 50 50) (comment \"draw triangle but with clear\") (q/with-graphics g (q/clear) (q/fill 0 0 255) (q/triangle 25 25 175 25 25 175)) (q/image g 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["stroke"],
  :ns "quil.snippets.color.setting",
  :name "stroke",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke-weight 10) (comment \"grey\") (q/stroke 120) (q/rect 10 10 100 100) (comment \"semitransparent light grey\") (q/stroke 80 120) (q/rect 80 80 100 100) (comment \"green\") (q/stroke 0 255 0) (q/rect 150 150 100 100) (comment \"semitransparent red\") (q/stroke 255 0 0 120) (q/rect 220 220 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["no-stroke"],
  :ns "quil.snippets.color.setting",
  :name "no-stroke",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/stroke-weight 10) (comment \"set stroke to black\") (q/fill 120) (q/stroke 0) (q/rect 30 30 100 100) (comment \"remove stroke, no border around square\") (q/no-stroke) (q/rect 100 100 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["no-fill"],
  :ns "quil.snippets.color.setting",
  :name "no-fill",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"set background to grey\") (q/stroke 0) (q/fill 120) (q/rect 0 0 100 100) (comment \"remove background, only border left\") (q/no-fill) (q/rect 70 70 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["fill"],
  :ns "quil.snippets.color.setting",
  :name "fill",
  :opts {:settings nil},
  :draw
  "((comment \"blue background\") (q/background 0 0 255) (comment \"grey\") (q/fill 120) (q/rect 0 0 100 100) (comment \"semitransparent light grey\") (q/fill 80 120) (q/rect 70 70 100 100) (comment \"green\") (q/fill 0 255 0) (q/rect 140 140 100 100) (comment \"semitransparent red\") (q/fill 255 0 0 120) (q/rect 210 210 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["background-image"],
  :ns "quil.snippets.color.setting",
  :name "background-image",
  :opts {:settings nil},
  :draw
  "((let [im (q/state :image)] (comment \"check if image is loaded by checking its size matches sketch size\") (when (= (.-width im) (q/width)) (q/background-image im))))",
  :setup
  "(let [_ (comment \"create url to image to used as background\") url (str \"https://dummyimage.com/\" (q/width) \"x\" (q/height) \"/2c3e50/ffffff.png\")] (q/set-state! :image (q/load-image url)))",
  :target :clj}
 {:fns ["background"],
  :ns "quil.snippets.color.setting",
  :name "background",
  :opts {:settings nil},
  :draw
  "((comment \"red\") (q/background 255 0 0) (let [_ (comment \"create graphics to test backgrounds\") gr (q/create-graphics 100 100)] (q/with-graphics gr (comment \"grey\") (q/background 120)) (q/image gr 0 0) (q/with-graphics gr (comment \"light-grey transparent\") (q/background 70 120)) (q/image gr 70 70) (q/with-graphics gr (comment \"cyan\") (q/background 0 255 255)) (q/image gr 140 140) (q/with-graphics gr (comment \"semitransparent blue\") (q/background 0 0 255 120)) (q/image gr 210 210)))",
  :setup "()",
  :target :clj}
 {:fns [],
  :ns "quil.snippets.color.creating-and-reading",
  :name "use-hex-colors",
  :opts {:settings nil},
  :draw
  "((q/lerp-color 4278255360 4278190335 0.5) (q/hue 4279312947) (q/saturation 4279312947) (q/brightness 4279312947) (q/red 4279312947) (q/green 4279312947) (q/blue 4279312947) (q/blend-color 4278255360 4294901760 :blend) (q/background 4279312947))",
  :setup "()",
  :target :clj}
 {:fns ["lerp-color"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "lerp-color",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [red (q/color 255 0 0) blue (q/color 0 0 255)] (comment \"draw colors that transition from red to blue\") (dotimes [i 6] (q/fill (q/lerp-color red blue (/ i 5))) (q/rect (* i 70) (* i 70) 100 100))))",
  :setup "()",
  :target :clj}
 {:fns ["current-stroke"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "current-stroke",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"set to red\") (q/stroke 255 0 0) (q/rect 0 0 100 100) (let [_ (comment \"remember current color\") cur-stroke (q/current-stroke)] (comment \"change to blue\") (q/stroke 0 0 255) (q/rect 70 70 100 100) (comment \"change back to the original color\") (q/stroke cur-stroke) (q/rect 140 140 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["current-fill"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "current-fill",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"set to red\") (q/fill 255 0 0) (q/rect 0 0 100 100) (let [_ (comment \"remember current color\") cur-fill (q/current-fill)] (comment \"change to blue\") (q/fill 0 0 255) (q/rect 70 70 100 100) (comment \"change back to the original color\") (q/fill cur-fill) (q/rect 140 140 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["color-mode"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "color-mode",
  :opts {:settings nil},
  :draw
  "((q/color-mode :rgb 255) (q/background 255) (comment \"use HSB and draw red\") (q/color-mode :hsb) (q/fill 255 255 255) (q/rect 0 0 100 100) (comment \"use HSB with different max and draw dark green\") (q/color-mode :hsb 5 10 20) (q/fill 2 10 5) (q/rect 70 70 100 100) (comment \"use RGB with 42 max value and draw 75% transparent blue\") (q/color-mode :rgb 40) (q/fill 0 0 40 30) (q/rect 140 140 100 100) (comment \"use RGB with different max values and draw semitransparent cyan\") (q/color-mode :rgb 5 10 20 30) (q/fill 0 10 20 15) (q/rect 210 210 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["color"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "color",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"black\") (q/fill (q/color 0)) (q/rect 0 0 100 100) (comment \"semitransparent gray\") (q/fill (q/color 128 128)) (q/rect 70 70 100 100) (comment \"purple\") (q/fill (q/color 255 0 255)) (q/rect 140 140 100 100) (comment \"semitransparent cyan\") (q/fill (q/color 0 255 255 120)) (q/rect 210 210 100 100))",
  :setup "()",
  :target :clj}
 {:fns ["brightness"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "brightness",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/color-mode :hsb) (let [dark-green (q/color 100 230 100)] (q/fill dark-green) (q/rect 0 0 100 100) (comment \"use the same brightness but different color\") (q/fill 255 255 (q/brightness dark-green)) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["saturation"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "saturation",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/color-mode :hsb) (let [dark-green (q/color 100 230 100)] (q/fill dark-green) (q/rect 0 0 100 100) (comment \"use the same saturation but different color\") (q/fill 255 (q/saturation dark-green) 255) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["hue"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "hue",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/color-mode :hsb) (let [dark-green (q/color 100 230 100)] (q/fill dark-green) (q/rect 0 0 100 100) (comment \"use the hue (green) but make it bright\") (q/fill (q/hue dark-green) 255 255) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["blue"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "blue",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [purple (q/color 123 50 220)] (q/fill purple) (q/rect 0 0 100 100) (comment \"use only blue component of purple\") (q/fill 0 0 (q/blue purple)) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["green"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "green",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [purple (q/color 123 50 220)] (q/fill purple) (q/rect 0 0 100 100) (comment \"use only green component of purple\") (q/fill 0 (q/green purple) 0) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["red"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "red",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [purple (q/color 123 50 220)] (q/fill purple) (q/rect 0 0 100 100) (comment \"use only red component of purple\") (q/fill (q/red purple) 0 0) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["blend-color"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "blend-color",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [_ (comment \"very transparent red\") c1 (q/color 255 100 20 50) _ (comment \"not very transparent blue\") c2 (q/color 40 200 255 200) modes [:blend :add :subtract :darkest :lightest :difference :exclusion :multiply :screen :overlay :hard-light :soft-light :dodge :burn] splitted (partition-all 3 modes)] (comment \"draw 2 rectangles with colors c1 and c2\") (q/fill c1) (q/rect 0 0 70 70) (q/fill c2) (q/rect 100 0 70 70) (comment \"draw all possible blended colors\") (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col)] (q/fill (q/blend-color c1 c2 mode))) (q/rect (* col 100) (* (inc row) 100) 70 70)))))",
  :setup "()",
  :target :clj}
 {:fns ["alpha"],
  :ns "quil.snippets.color.creating-and-reading",
  :name "alpha",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [_ (comment \"create semitransparent red\") semi-red (q/color 255 0 0 120) _ (comment \"extract alpha value from it\") alph (q/alpha semi-red) _ (comment \"create semitransparent blue using the alpha\") semi-blue (q/color 0 0 255 alph)] (q/fill semi-red) (q/rect 0 0 100 100) (q/fill semi-blue) (q/rect 70 70 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["tint"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "tint",
  :opts {:settings nil},
  :draw
  "((q/background 127) (let [gr (q/create-graphics 100 100)] (comment \"draw 4 circles of different color on the graphics\") (q/with-graphics gr (q/background 0 0) (q/fill 255) (q/ellipse 25 25 40 40) (q/fill 255 0 0) (q/ellipse 75 25 40 40) (q/fill 0 255 0) (q/ellipse 25 75 40 40) (q/fill 0 0 255) (q/ellipse 75 75 40 40)) (comment \"apply different types of tint\") (q/no-tint) (q/image gr 0 0) (q/tint 127) (q/image gr 120 0) (q/tint 255 127) (q/image gr 240 0) (q/tint 200 127 180) (q/image gr 0 120) (q/tint 200 127 180 127) (q/image gr 120 120)))",
  :setup "()",
  :target :clj}
 {:fns ["no-tint"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "no-tint",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"create graphics with white circle\") (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 0 0) (q/fill 255) (q/ellipse 50 50 70 70)) (comment \"apply cyan tint\") (q/image gr 0 0) (q/tint 127 255 255) (q/image gr 100 0) (comment \"remove tint\") (q/no-tint) (q/image gr 200 0)))",
  :setup "()",
  :target :clj}
 {:fns ["mask-image"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "mask-image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"define 2 images and a mask to apply to them\") (let [im (q/create-image 100 100 :argb) im2 (q/create-image 100 100 :argb) mask (q/create-image 100 100 :argb)] (comment \"first image is a blue square with a red cross\") (dotimes [x 100] (dotimes [y 100] (if (or (< 0 (- x y) 5) (< 95 (+ x y) 100)) (q/set-pixel im x y (q/color 255 0 0 255)) (q/set-pixel im x y (q/color 0 0 255))))) (comment \"second image is a green cross\") (dotimes [x 100] (dotimes [y 5] (q/set-pixel im2 (+ y 47) x (q/color 0 255 0)) (q/set-pixel im2 x (+ y 47) (q/color 0 255 0)))) (comment \"mask is rectangles with different shades of gray\") (dotimes [x 100] (dotimes [y 100] (q/set-pixel mask x y (q/color 0 (* 40 (+ (quot x 20) (quot y 20))))))) (comment \"draw first image, mask and image with mask applied\") (q/image im 20 20) (q/image mask 140 20) (q/mask-image im mask) (q/image im 260 20) (comment \"draw second image, mask and image with mask applied\") (q/image im2 20 140) (q/image mask 140 140) (q/mask-image im2 mask) (q/image im2 260 140)))",
  :setup "()",
  :target :clj}
 {:fns ["load-image"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "load-image",
  :opts {:settings nil},
  :draw
  "((let [im (q/state :image)] (comment \"check if image is loaded using function loaded?\") (when (q/loaded? im) (q/image im 0 0))))",
  :setup
  "(let [_ (comment \"create url to load image 100x100\") url \"https://dummyimage.com/100x100/2c3e50/ffffff.png\"] (q/set-state! :image (q/load-image url)))",
  :target :clj}
 {:fns ["image-mode"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "image-mode",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/fill 0 0 255) (q/stroke 0 0 255) (q/rect 0 0 100 100)) (q/stroke-weight 10) (comment \"use :corner mode\") (q/image-mode :corner) (q/image gr 50 50) (q/point 50 50) (comment \"use :center mode\") (q/image-mode :center) (q/image gr 250 100) (q/point 250 100) (comment \"use :corners mode\") (q/image-mode :corners) (q/image gr 350 50 400 150) (q/point 350 50) (q/point 400 150)))",
  :setup "()",
  :target :clj}
 {:fns ["image"],
  :ns "quil.snippets.image.loading-and-displaying",
  :name "image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"create graphics with circle\") (let [gr (q/create-graphics 70 70)] (q/with-graphics gr (q/ellipse 35 35 70 70)) (comment \"draw graphics twice\") (q/image gr 0 0) (q/image gr 100 0 100 70)))",
  :setup "()",
  :target :clj}
 {:fns ["set-image" "set-pixel"],
  :ns "quil.snippets.image.pixels",
  :name "set-image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [im (q/create-image 100 100 :rgb)] (comment \"draw gradient on the image\") (dotimes [x 100] (dotimes [y 100] (q/set-pixel im x y (q/color (* 2 x) (* 2 y) (+ x y))))) (comment \"draw image on sketch\") (q/set-image 10 10 im)))",
  :setup "()",
  :target :clj}
 {:fns ["pixels" "update-pixels"],
  :ns "quil.snippets.image.pixels",
  :name "pixels-update-pixels",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/background 255) (let [size 50 gr (q/create-graphics size size :p2d)] (comment \"draw red circle on the graphics\") (q/with-graphics gr (q/background 255) (q/fill 255 0 0) (q/ellipse (/ size 2) (/ size 2) (* size (/ 2 3)) (* size (/ 2 3)))) (comment \"draw original graphics\") (q/image gr 0 0) (comment \"get pixels of the graphics and copy\") (comment \"the first half of all pixels to the second half\") (let [px (q/pixels gr) half (/ (* size size) 2)] (dotimes [i half] (aset-int px (+ i half) (aget px i)))) (q/update-pixels gr) (q/image gr (+ size 20) 0) (comment \"get pixels of the sketch itself and copy\") (comment \"the first half of all pixels to the second half\") (let [px (q/pixels) half (/ (* (q/width) (q/height)) 10)] (dotimes [i half] (aset-int px (+ i half) (aget px i)))) (q/update-pixels)))",
  :setup "()",
  :target :clj}
 {:fns ["get-pixel"],
  :ns "quil.snippets.image.pixels",
  :name "get-pixel",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (comment \"draw circle on the graphics\") (q/with-graphics gr (q/background 255) (q/fill 127 255 180) (q/ellipse 50 50 70 70)) (comment \"draw original graphics\") (q/image gr 0 0) (comment \"copy graphics and draw it\") (q/image (q/get-pixel gr) 0 120) (comment \"use get-pixel to get color of specific pixel\") (comment \"and draw square\") (q/fill (q/get-pixel gr 50 50)) (q/rect 120 120 100 100) (comment \"use get-pixel to copy part of the graphics\") (q/image (q/get-pixel gr 0 0 50 50) 240 120) (comment \"use get-pixel to copy part of the sketch itself\") (q/image (q/get-pixel) 400 400) (q/fill (q/get-pixel 50 50)) (q/rect 120 240 100 100) (q/image (q/get-pixel 0 0 50 50) 240 240)))",
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
  "((q/background 255) (let [orig (q/create-graphics 100 100) modes [[:threshold] [:threshold 0.2] [:gray] [:invert] [:posterize 20] [:blur] [:blur 3] [:opaque] [:erode] [:dilate]] splitted (partition-all 4 modes)] (comment \"draw 10x10 square from circles of different color\") (q/with-graphics orig (q/color-mode :rgb 1.0) (q/background 1) (q/no-stroke) (q/ellipse-mode :corner) (doseq [r (range 0 1 0.1) b (range 0 1 0.1)] (q/fill r 0 b) (q/ellipse (* r 100) (* b 100) 10 10))) (comment \"apply different filters, four filters per row\") (q/image orig 0 0) (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col) dest (q/create-graphics 100 100)] (q/with-graphics dest (q/image orig 0 0) (apply q/display-filter mode)) (q/image dest (* col 120) (* 120 (inc row))))))))",
  :setup "()",
  :target :clj}
 {:fns ["image-filter"],
  :ns "quil.snippets.image.pixels",
  :name "image-filter",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [orig (q/create-graphics 100 100) modes [[:threshold] [:threshold 0.2] [:gray] [:invert] [:posterize 20] [:blur] [:blur 3] [:opaque] [:erode] [:dilate]] splitted (partition-all 4 modes)] (comment \"draw 10x10 square from circles of different color\") (q/with-graphics orig (q/color-mode :rgb 1.0) (q/background 1) (q/no-stroke) (q/ellipse-mode :corner) (doseq [r (range 0 1 0.1) b (range 0 1 0.1)] (q/fill r 0 b) (q/ellipse (* r 100) (* b 100) 10 10))) (comment \"apply different filters, four filters per row\") (q/image orig 0 0) (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col) clone (q/get-pixel orig)] (apply q/image-filter clone mode) (q/image clone (* col 120) (* 120 (inc row))))))))",
  :setup "()",
  :target :clj}
 {:fns ["copy"],
  :ns "quil.snippets.image.pixels",
  :name "copy",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [im (q/create-image 100 100 :rgb)] (comment \" gradient on the image\") (dotimes [x 100] (dotimes [y 100] (q/set-pixel im x y (q/color (* 2 x) (* 2 y) (+ x y))))) (comment \"draw original image\") (q/image im 0 0) (comment \"copy left top quarter to the right top quarter\") (q/copy im im [0 0 50 50] [50 0 50 50]) (comment \"copy the whole image to the sketch, essentially just draw it\") (q/copy im [0 0 100 100] [120 0 100 100]) (comment \"copy top left 50x50 square of sketch \") (comment \"to the 100x100 square at [240, 0] position\") (q/copy [0 0 50 50] [240 0 100 100])))",
  :setup "()",
  :target :clj}
 {:fns ["blend"],
  :ns "quil.snippets.image.pixels",
  :name "blend",
  :opts {:settings nil},
  :draw
  "((q/background 255 100 20 50) (let [im (q/create-image 50 50 :rgb) modes [:blend :add :subtract :darkest :lightest :difference :exclusion :multiply :screen :overlay :hard-light :soft-light :dodge :burn] splitted (partition-all 5 modes)] (comment \"draw 3 squares of different color on the graphics\") (dotimes [x 10] (dotimes [y 10] (q/set-pixel im (+ x 10) (+ y 10) (q/color 255 0 0)) (q/set-pixel im (+ x 30) (+ y 10) (q/color 0 255 0)) (q/set-pixel im (+ x 20) (+ y 30) (q/color 0 0 255)))) (comment \"draw all possible blended modes\") (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col)] (comment \"blend with sketch itself\") (q/blend 400 0 50 50 (* col 55) (* row 55) 50 50 mode) (comment \"blend with image\") (q/blend im 0 0 50 50 (* col 55) (+ 170 (* row 55)) 50 50 mode) (comment \"blend image to image\") (q/blend im (q/current-graphics) 0 0 50 50 (* col 55) (+ 340 (* row 55)) 50 50 mode))))))",
  :setup "(q/no-loop)",
  :target :clj}
 {:fns ["create-graphics"],
  :ns "quil.snippets.image.rendering",
  :name "create-graphics",
  :opts {:settings nil},
  :draw
  "((q/background 255) (let [gr (q/create-graphics 100 100)] (q/with-graphics gr (q/background 127) (q/ellipse 50 50 80 40)) (q/image gr 0 0)) (comment \"use different renderer\") (let [gr (q/create-graphics 100 100 :java2d)] (q/with-graphics gr (q/background 127) (q/ellipse 50 50 40 80)) (q/image gr 100 100)) (comment \"write output to pdf file\") (let [gr (q/create-graphics 100 100 :pdf \"generated/create-graphics.pdf\")] (q/with-graphics gr (q/background 127) (q/ellipse 50 50 80 40) (.dispose gr))))",
  :setup "()",
  :target :clj}
 {:fns ["blend-mode"],
  :ns "quil.snippets.image.rendering",
  :name "blend-mode",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((q/background 255) (let [modes [:replace :blend :add :subtract :darkest :lightest :difference :exclusion :multiply :screen] splitted (partition-all 4 modes)] (dotimes [row (count splitted)] (dotimes [col (count (nth splitted row))] (let [mode (nth (nth splitted row) col) gr (q/create-graphics 100 100 :p2d)] (q/with-graphics gr (q/background 127) (q/blend-mode mode) (q/no-stroke) (q/fill 255 0 0) (q/rect 10 20 80 20) (q/fill 50 170 255 127) (q/rect 60 10 20 80) (q/fill 200 130 150 200) (q/rect 10 60 80 20) (q/fill 20 240 50 50) (q/rect 20 10 20 80)) (q/image gr (* col 120) (* row 120)))))))",
  :setup "()",
  :target :clj}
 {:fns ["translate"],
  :ns "quil.snippets.transform",
  :name "translate",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((comment \"setup camera and draw box at [0 0 0]\") (q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (comment \"draw 3 identical boxes in 3 different positions\") (comment \"using different translate calls\") (q/translate 100 0) (q/box 50) (q/translate [-100 100]) (q/box 50) (q/translate 0 -100 100) (q/box 50))",
  :setup "()",
  :target :clj}
 {:fns ["shear-x" "shear-y"],
  :ns "quil.snippets.transform",
  :name "shear-x-y",
  :opts {:settings nil},
  :draw
  "((comment \"draw normal rect\") (q/with-translation [125 125] (q/rect 0 0 100 50)) (comment \"draw rect sheared by y\") (q/with-translation [375 125] (q/shear-y 0.5) (q/rect 0 0 100 50)) (comment \"draw rect sheared by x\") (q/with-translation [125 375] (q/shear-x 0.5) (q/rect 0 0 100 50)))",
  :setup "()",
  :target :clj}
 {:fns ["scale"],
  :ns "quil.snippets.transform",
  :name "scale",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((comment \"setup camera and draw box at [0 0 0]\") (q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (comment \"draw box 50% smaller\") (q/with-translation [100 0 0] (q/scale 0.5) (q/box 50) (q/scale 2)) (comment \"draw box 50% narrower but same length/height\") (q/with-translation [0 100 0] (q/scale 1 0.5) (q/box 50) (q/scale 1 2)) (comment \"draw box 50% shorter and 150% taller, but same width\") (q/with-translation [0 0 100] (q/scale 0.5 1 1.5) (q/box 50) (q/scale 2 1 0.75)))",
  :setup "()",
  :target :clj}
 {:fns ["rotate-x" "rotate-y" "rotate-z"],
  :ns "quil.snippets.transform",
  :name "rotate-x-y-z",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((comment \"setup camera and draw box at [0 0 0]\") (q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (q/box 50) (q/push-matrix) (comment \"move, rotate x axis and draw box\") (q/translate 100 0 0) (q/rotate-x 0.5) (q/box 50) (q/pop-matrix) (q/push-matrix) (comment \"move, rotate y axis and draw box\") (q/translate 0 100 0) (q/rotate-y 0.5) (q/box 50) (q/pop-matrix) (q/push-matrix) (comment \"move, rotate z axis and draw box\") (q/translate 0 0 100) (q/rotate-z 0.5) (q/box 50) (q/pop-matrix))",
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
  "((q/rect 0 0 100 50) (q/translate 250 250) (q/rect 0 0 50 50) (comment \"resetting brings us back to [0, 0]\") (q/reset-matrix) (q/rect 0 0 50 100))",
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
  "((q/fill 255 0 0) (comment \"draw rect at [20, 20]\") (q/translate 20 20) (q/rect 0 0 50 50) (comment \"move by 150 to right and save matrix\") (q/translate 150 0) (q/push-matrix) (comment \"rotate matrix and draw rect\") (q/rotate 1) (q/rect 0 0 50 50) (comment \"pop matrix should revert rotation\") (q/pop-matrix) (comment \"move by another 150 pixels and draw rect\") (q/translate 150 0) (q/rect 0 0 50 50))",
  :setup "()",
  :target :clj}
 {:fns ["apply-matrix"],
  :ns "quil.snippets.transform",
  :name "apply-matrix",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((comment \"setup camera\") (q/camera 200 200 200 0 0 0 0 0 -1) (q/no-fill) (comment \"draw box at [0 0 0]\") (q/box 50) (comment \"move positiion by [50 -50 0] and draw box\") (q/apply-matrix 1 0 50 0 1 -50) (q/box 50) (comment \"rotate position and move by [0 50 -50] and draw box\") (let [s (q/sin 1) c (q/cos 1)] (q/apply-matrix 1 0 0 0 0 c s 50 0 (- s) c -50 0 0 0 1)) (q/box 50))",
  :setup "()",
  :target :clj}
 {:fns ["redraw"],
  :ns "quil.snippets.structure",
  :name "redraw",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text \"click to move\" 10 20) (q/rect (* (q/frame-count) 10) (+ (* (q/frame-count) 10) 40) 50 50))",
  :setup "(q/no-loop)",
  :target :clj}
 {:fns ["no-loop" "start-loop" "looping?"],
  :ns "quil.snippets.structure",
  :name "no-loop-start-loop",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (comment \"pause sketch on every 10th frame\") (when (zero? (rem (q/frame-count) 10)) (q/no-loop) (q/text \"paused, click to unpause\" 10 20)) (q/text (str \"(q/looping?) = \" (q/looping?)) 10 40) (q/text (str \"frame: \" (q/frame-count)) 10 60))",
  :setup "()",
  :target :clj}
 {:fns ["exit"],
  :ns "quil.snippets.structure",
  :name "exit",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (comment \"exit sketch on 50th frame\") (q/text (str \"countdown \" (- 50 (q/frame-count))) 20 20) (when (= 50 (q/frame-count)) (q/exit)))",
  :setup "()",
  :target :clj}
 {:fns ["delay-frame"],
  :ns "quil.snippets.structure",
  :name "delay",
  :opts {:settings nil},
  :draw
  "((q/background 127) (q/ellipse (* 5 (q/frame-count)) (* 5 (q/frame-count)) 50 50) (comment \"delay frame for random duration between 0 and 2s\") (q/delay-frame (rand-int (* 500 (rand-int 4)))))",
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
  "((q/background 255) (q/fill 0) (q/text (q/state :text) 10 20) (q/text (str \"Full state: \" (q/state)) 10 40))",
  :setup "(q/set-state! :text \"I'm state!\" :year (q/year))",
  :target :clj}
 {:fns ["clip" "no-clip"],
  :ns "quil.snippets.rendering",
  :name "clip-no-clip",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (comment \"clip rendering so that triangle will be incomplete\") (q/clip 50 100 100 100) (q/triangle 100 70 170 180 30 180) (comment \"draw normal unclipped triangle\") (q/no-clip) (q/with-translation [(/ (q/width) 2) (/ (q/height) 2)] (q/triangle 100 70 170 180 30 180)))",
  :setup "()",
  :target :clj}
 {:fns ["load-shader" "loaded?" "reset-shader" "shader"],
  :ns "quil.snippets.rendering",
  :name "load-shader",
  :opts {:renderer :p2d, :settings nil},
  :draw
  "((let [gr (q/create-graphics 250 250) shd (q/state :shader)] (when (q/loaded? shd) (q/with-graphics gr (q/background 255) (q/fill 255 0 0) (q/triangle 50 30 220 120 20 180)) (q/image gr 0 0) (q/image gr 250 0) (q/shader shd) (q/image gr 0 250) (q/reset-shader) (q/image gr 250 250))))",
  :setup
  "(let [path (clojure.java.io/resource \"SimpleShader.glsl\") shd (q/load-shader (.getPath path))] (q/set-state! :shader shd))",
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
  "((q/camera 150 150 150 0 0 0 0 0 1) (q/background 127) (q/with-rotation [(/ (q/frame-count) 10)] (q/box 100)) (q/save-frame \"generated/rotating-box-####.png\"))",
  :setup "()",
  :target :clj}
 {:fns ["save"],
  :ns "quil.snippets.output",
  :name "save",
  :opts {:renderer :p3d, :settings nil},
  :draw
  "((q/camera 150 150 150 0 0 0 0 0 1) (q/box 100) (q/save \"generated/box.png\") (comment \"stop sketch after saving image\") (comment \"otherwise it will show save dialog\") (comment \"on every iteration\") (q/exit))",
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
  "((q/background 255) (q/fill 0) (comment \"iterate through all time-related functions\") (comment \"and print their values\") (doseq [[ind capt fn] [[0 \"millis\" q/millis] [1 \"seconds\" q/seconds] [2 \"minute\" q/minute] [3 \"hour\" q/hour] [4 \"day\" q/day] [5 \"month\" q/month] [6 \"year\" q/year]]] (q/text (str capt \" \" (fn)) 10 (+ (* 20 ind) 20))))",
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
  "((q/background 255) (q/fill 0) (comment \"iterate through all mouse-related functions\") (comment \"and print their values\") (doseq [[ind capt fn] [[0 \"mouse-button\" q/mouse-button] [1 \"mouse-pressed?\" q/mouse-pressed?] [2 \"mouse-x\" q/mouse-x] [3 \"mouse-y\" q/mouse-y] [4 \"pmouse-x\" q/pmouse-x] [5 \"pmouse-y\" q/pmouse-y]]] (q/text (str capt \" \" (fn)) 10 (+ (* 20 ind) 20))))",
  :setup "()",
  :target :clj}
 {:fns
  ["key-as-keyword"
   "key-code"
   "key-coded?"
   "key-pressed?"
   "raw-key"
   "key-modifiers"],
  :ns "quil.snippets.input",
  :name "keyboard",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (comment \"iterate through all key-related functions\") (comment \"and print their values\") (doseq [[ind capt fn] [[0 \"key-as-keyword\" q/key-as-keyword] [1 \"key-code\" q/key-code] [2 \"key-coded?\" (fn* [] (q/key-coded? (q/raw-key)))] [3 \"key-pressed?\" q/key-pressed?] [4 \"raw-key\" q/raw-key] [5 \"key-modifiers\" q/key-modifiers]]] (q/text (str capt \" \" (fn)) 10 (+ (* 20 ind) 20))))",
  :setup "()",
  :target :clj}
 {:fns ["resize-sketch"],
  :ns "quil.snippets.environment",
  :name "resize-sketch",
  :opts {:settings nil},
  :draw
  "((q/frame-rate 1) (comment \"each frame increase size of sketch\") (q/resize-sketch (inc (q/width)) (inc (q/height))) (q/background 255) (q/fill 0) (q/text (str \"width: \" (q/width) \", height: \" (q/height)) 10 20))",
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
  "((q/background 255) (q/fill 0) (q/text (str \"display density: \" (q/display-density)) 10 20))",
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
 {:fns ["height" "width"],
  :ns "quil.snippets.environment",
  :name "height-width",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"width: \" (q/width) \", height: \" (q/height)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["frame-rate"],
  :ns "quil.snippets.environment",
  :name "frame-rate",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"Frame rate: \" (q/target-frame-rate)) 10 20) (let [frame (q/frame-count)] (comment \"draw moving box\") (q/rect (rem frame (q/width)) 50 50 50) (comment \"every 10 frames change frame rate\") (comment \"frame rate cycles through [1, 6, 11, 16, 21]\") (when (zero? (rem frame 10)) (q/frame-rate (inc (* 5 (rem (quot frame 10) 5)))))))",
  :setup "()",
  :target :clj}
 {:fns ["frame-count"],
  :ns "quil.snippets.environment",
  :name "frame-count",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"Frame count: \" (q/frame-count)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["focused"],
  :ns "quil.snippets.environment",
  :name "focused",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/fill 0) (q/text (str \"Focused: \" (q/focused)) 10 20))",
  :setup "()",
  :target :clj}
 {:fns ["cursor-image"],
  :ns "quil.snippets.environment",
  :name "cursor-image",
  :opts {:settings nil},
  :draw
  "((if (zero? (.-width (q/state :image))) (q/text \"Loading\" 10 10) (do (q/cursor-image (q/state :image)) (q/cursor-image (q/state :image) 16 16) (q/image (q/state :image) 0 0))))",
  :setup
  "(q/set-state! :image (q/load-image \"test/html/cursor.jpg\"))",
  :target :clj}
 {:fns ["cursor" "no-cursor"],
  :ns "quil.snippets.environment",
  :name "cursor-no-cursor",
  :opts {:settings nil},
  :draw
  "((q/background 255) (q/rect-mode :corners) (q/text-align :center :center) (comment \"iterate through all types of cursors\") (let [types [:arrow :cross :hand :move :text :wait :no-cursor :default] box-width (/ (q/width) 4.1) box-height (/ (q/height) 2.1)] (dotimes [ind (count types)] (let [type (nth types ind) _ (comment \"calculate corners of current box\") x (* box-width (rem ind 4)) y (* box-height (quot ind 4)) n-x (+ x box-width) n-y (+ y box-height)] (comment \"draw a box for current type with its name in center\") (q/stroke 127) (q/no-fill) (q/rect x y n-x n-y) (q/no-stroke) (q/fill 0) (q/text (str type) (/ (+ x n-x) 2) (/ (+ y n-y) 2)) (comment \"if mouse is inside the box - enable this type\") (when (and (<= x (q/mouse-x) n-x) (<= y (q/mouse-y) n-y)) (condp = type :default (q/cursor) :no-cursor (q/no-cursor) (q/cursor type)))))))",
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
  "((q/background 255) (q/fill 0) (q/text (str \"(q/current-frame-rate) = \" (q/current-frame-rate)) 10 20) (q/text (str \"(q/target-frame-rate) = \" (q/target-frame-rate)) 10 40))",
  :setup "()",
  :target :clj}
 {:fns ["resize"],
  :ns "quil.snippets.image",
  :name "resize-image",
  :opts {:settings nil},
  :draw
  "((comment \"create image and draw gradient on it\") (let [im (q/create-image 100 100 :rgb)] (dotimes [x 100] (dotimes [y 100] (q/set-pixel im x y (q/color (* 2 x) (* 2 y) (+ x y))))) (q/image im 0 0) (comment \"resize image from 100x100 to 50x50 and draw again\") (q/resize im 50 50) (q/image im 100 100)))",
  :setup "()",
  :target :clj}
 {:fns ["create-image" "set-pixel"],
  :ns "quil.snippets.image",
  :name "create-image",
  :opts {:settings nil},
  :draw
  "((q/background 255) (comment \"create image and draw gradient on it\") (let [im (q/create-image 100 100 :rgb)] (dotimes [x 100] (dotimes [y 100] (q/set-pixel im x y (q/color (* 2 x) (* 2 y) (+ x y))))) (comment \"draw image twice\") (q/image im 0 0) (q/image im 50 50)))",
  :setup "()",
  :target :clj})
