(ns getbrains.interp-functions)

(defn interp [val coll]
  (let [interl (fn [a b]
     (lazy-seq (loop [r1 a r2 b out []]
                 (if (or (empty? r1) (empty? r2))
                   out
                   (recur (rest r1) (rest r2) (conj out (first r1) (first r2)))))))]
    (drop 1 (interl (repeat val) coll))))

(interp 0 [1 2 3])
(= (interp 0 [1 2 3]) [1 0 2 0 3])


(defn myrange [start finish]
  (take (- finish start) (iterate #(+ 1 %) start)))

(myrange 1 4)