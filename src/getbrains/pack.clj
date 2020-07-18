(ns getbrains.pack)

(defn pack [coll]  
  (loop [current [[(first coll)]]  remain (rest coll)]
    (if (empty? remain)
      current
      (if (= (peek (peek current))  (first remain))
        (recur (conj (pop current) (conj (peek current) (first remain))) (rest remain))
        (recur (conj current [(first remain)]) (rest remain))))))

(pack [1 1 2 1 1 1 3 3])
(= (pack [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))

(pack '(1 1 2 1 1 1 3 3))