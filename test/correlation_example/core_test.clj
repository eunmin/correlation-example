(ns correlation-example.core-test
  (:require [clojure.test :refer :all]
            [correlation-example.core :refer :all]))

(deftest core-test
  (testing "correlation"
    (let [xs [1.0 2.0 3.0 4.0 5.0]
          ys [8.0 7.0 6.0 4.0 5.0]]
      (is (= -0.9 (correlation xs ys))))))
