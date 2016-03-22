(ns quil-site.parser
  (:require [#?(:clj clojure.tools.reader.reader-types
                :cljs cljs.tools.reader.reader-types)
             :as rt]
            [#?(:clj clojure.tools.reader
                :cljs cljs.tools.reader)
             :as r]
            [clojure.string :as cstr]))

(defn convert-error [error]
  #?(:cljs (if (nil? error)
             nil
             (let [{:keys [line column]} (ex-data error)]
               (if (or line column)
                 {:message (ex-message error)
                  :type :error
                  :line line
                  :column (dec column)}
                 (recur (ex-cause error)))))
     :clj {}))

(defn dec-point [[a b]]
  [(dec a) (dec b)])

(defn- find-in-form [form point]
  (let [{:keys [end-line end-column]} (meta form)]
    (cond
      (and (coll? form)
           (= point (dec-point [end-line end-column]))) form
      (coll? form) (->> form
                        (map #(find-in-form % point))
                        (some identity))
      :default nil)))

(defn point-precedes? [a b]
  (let [[r-a c-a] a
        [r-b c-b] b]
    (or (< r-a r-b)
        (and (= r-a r-b)
             (<= c-a c-b)))))

(defn substring [source from to]
  (let [lines (cstr/split-lines source)
        [row-f col-f] from
        [row-t col-t] to]
    (if (= row-f row-t)
      (subs (nth lines row-f) col-f col-t)
      (->> (concat [(subs (nth lines row-f) col-f)]
                   (->> lines (take row-t) (drop (inc row-f)))
                   [(subs (nth lines row-t) 0 col-t)])
           (cstr/join \newline)))))

(defn get-form-ends-at-point [source point]
  (let [reader (rt/indexing-push-back-reader source)
        eof (gensym "eof")
        read-next #(r/read {:eof eof} reader)
        [row col] point]
    (try
      (loop [form (read-next)]
        (let [{:keys [end-line end-column]} (meta form)]
          (cond
            (= eof form) {}

            (point-precedes? point (dec-point [end-line end-column]))
            (if-let [form (find-in-form form point)]
              (let [{:keys [line column]} (meta form)
                    start (dec-point [line column])]
                {:form (substring source start point)
                 :start start})
              {})

            :default (recur (read-next)))))
      (catch #?(:cljs :default
                :clj Exception) e
        (println (convert-error e))
        {:error (convert-error e)}))))

(defn get-ns-form [code]
  (loop [[fst & rst] (cstr/trim code)
         accum ""
         balance 0]
    (if (or (and (zero? balance) (not (empty? accum)))
            (nil? fst))
      accum
      (recur rst (str accum fst)
             (+ balance
                (condp contains? fst
                  #{\[ \( \{} 1
                  #{\] \) \}} -1
                  0))))))
