(ns getbrains.core
  (:gen-class))

(defn my-flatten [coll]
  (reduce (fn flat [a b]
            (if (sequential? b)
              (reduce flat a b)
              (conj a b)))
          [] coll))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (my-flatten '((1 2) 3 [4 [5 6]]))))

(my-flatten '((1 2) 3 [4 [5 6]]))

(defn get-caps [words]
  (clojure.string/join (re-seq #"[A-Z]+" words)))

(get-caps "aaaAB")

(defn compress [s]
  (reduce (fn [a b] (if (= (last a) b) a (conj a b))) [] s))

(def leroy "Leeeeeerrroyyy")

(= (apply str (compress leroy)) "Leroy")

(defn maxv [& args] (reduce (fn [a b] (if (> b a) b a)) args))

(maxv 10 20 30 40 5 60 1)

(defn duplicate [values] (reduce (fn [a b] (concat a (take 2 (repeat b)))) [] values))

(duplicate [1 2 3])

(defn replic [values n]
  (reduce (fn [a b]
            (concat a (take n (repeat b))))
          [] values))

(replic [1 2 3] 3)