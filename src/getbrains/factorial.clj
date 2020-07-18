(ns getbrains.factorial)


(defn factorial [n]
  (loop [i n sum n]
    (if (= i 1)
      sum
      (let [idec (dec i)]
        (recur idec (* sum idec))))))

(factorial 8)