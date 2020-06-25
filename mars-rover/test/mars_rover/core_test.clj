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

(deftest move-increments-y-when-direction-is-north
  (is (= {:x 0 :y 1} (move {:x 0 :y 0} "N")))
  (is (= {:x 0 :y 2} (move {:x 0 :y 1} "N"))))

(deftest move-decrements-y-when-direction-is-south
  (is (= {:x 0 :y 1} (move {:x 0 :y 2} "S")))
  (is (= {:x 0 :y 0} (move {:x 0 :y 1} "S"))))

(deftest move-increments-x-when-direction-is-east
  (is (= {:x 1 :y 0} (move {:x 0 :y 0} "E")))
  (is (= {:x 2 :y 0} (move {:x 1 :y 0} "E"))))

(deftest move-decrements-x-when-direction-is-west
  (is (= {:x 0 :y 0} (move {:x 1 :y 0} "W")))
  (is (= {:x 1 :y 0} (move {:x 2 :y 0} "W"))))

(deftest commands-returns-a-sequence-of-command
  (is (= ["R"] (commands "R"))))
