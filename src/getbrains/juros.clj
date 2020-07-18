(ns getbrains.juros)

(defn jurosc 
  "Calcula juros compostos como uma lista lazy"
  [valor taxa]  
  (if-not (and (double? valor) (double? taxa))
    (throw (Exception. "Ambos os argumentos devem ser double."))
    (cons valor (lazy-seq (jurosc (+ valor (* valor taxa)) taxa)))))

(defn mytake [n coll]
  (when (pos? n)
              (when-let [s (seq coll)]
                (cons (first s) (lazy-seq (mytake (dec n) (rest s)))))))

(defn jurosc-periodo [valor taxa periodo]
  (mytake periodo (jurosc valor taxa)))

(take 3 (jurosc 1000.0 0.01))
(jurosc-periodo 1000.0 0.01 3)

(mytake 6 (jurosc 100.0 0.2))