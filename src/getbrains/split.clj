(ns getbrains.split)

(defn splitter [n coll]
  [(take n coll) (drop n coll)])

(splitter 3 [1 2 3 4 5 6])

(defn myrange [start finish]
  (lazy-seq (loop [end (dec finish) l '()]
              (if (< end start)
                l
                (recur (dec end) (cons end l))))))

(myrange -2 2)
(= (myrange -2 2) '(-2 -1 0 1))
(->> (myrange -2 2) (take 2))

(defn interl [a b]
  (lazy-seq (loop [r1 a r2 b out []]
              (if (or (empty? r1) (empty? r2))
                out
                (recur (rest r1) (rest r2) (conj out (first r1) (first r2)))))))


(interl [1 2 3] [:a :b :c])
(= (interl [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
(= (interl [1 2 3 4] [5]) [1 5])


(defn interp [val coll]
  ((fn interl [a b]
     (lazy-seq (loop [r1 a r2 b out []]
                 (if (or (empty? r1) (empty? r2))
                   out
                   (recur (rest r1) (rest r2) (conj out (first r1) (first r2))))))))
  (rest (interl (repeat val) coll)))

(interp 0 [1 2 3])
(= (interp 0 [1 2 3]) [1 0 2 0 3])
