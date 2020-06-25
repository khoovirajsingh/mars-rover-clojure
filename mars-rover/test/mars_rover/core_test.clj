(ns mars-rover.core-test
  (:require [clojure.test :refer :all]
            [mars-rover.core :refer :all]))

(deftest rotate-right-returns-a-new-direction
  (is (= "E" (rotate-right "N")))
  (is (= "S" (rotate-right "E")))
  (is (= "W" (rotate-right "S")))
  (is (= "N" (rotate-right "W"))))

(deftest rotate-left-returns-a-new-direction
  (is (= "W" (rotate-left "N")))
  (is (= "S" (rotate-left "W")))
  (is (= "E" (rotate-left "S")))
  (is (= "N" (rotate-left "E"))))

(deftest move-returns-a-new-coordinate
  (is (= {:x 0 :y 1} (move {:x 0 :y 0} "N"))))
