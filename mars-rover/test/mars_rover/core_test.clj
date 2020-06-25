(ns mars-rover.core-test
  (:require [clojure.test :refer :all]
            [mars-rover.core :refer :all]))

(deftest rotate-right-changes-direction
  (is (= "E" (rotate-right "N")))
  (is (= "S" (rotate-right "E")))
  (is (= "W" (rotate-right "S")))
  (is (= "N" (rotate-right "W"))))
