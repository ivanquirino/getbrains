(ns getbrains.dropnth-test
  (:require [clojure.test :refer :all]
            [getbrains.dropnth :refer :all]))

(deftest dropnth-test
  (testing "Drop Every Nth Item. Write a function which drops every Nth item from a sequence."
    (is (= (dropnth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
    (is (= (dropnth [:a :b :c :d :e :f] 2) [:a :c :e]))
    (is (= (dropnth [1 2 3 4 5 6] 4) [1 2 3 5 6]))))
