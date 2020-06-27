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
  (is (= {:x 0 :y 1 :direction "N"} (move {:x 0 :y 0 :direction "N"} 1)))
  (is (= {:x 0 :y 2 :direction "N"} (move {:x 0 :y 1 :direction "N"} 1))))

(deftest move-decrements-y-when-direction-is-south
  (is (= {:x 0 :y 1 :direction "S"} (move {:x 0 :y 2 :direction "S"} 1)))
  (is (= {:x 0 :y 0 :direction "S"} (move {:x 0 :y 1 :direction "S"} 1))))

(deftest move-increments-x-when-direction-is-east
  (is (= {:x 1 :y 0 :direction "E"} (move {:x 0 :y 0 :direction "E"} 1)))
  (is (= {:x 2 :y 0 :direction "E"} (move {:x 1 :y 0 :direction "E"} 1))))

(deftest move-decrements-x-when-direction-is-west
  (is (= {:x 0 :y 0 :direction "W"} (move {:x 1 :y 0 :direction "W"} 1)))
  (is (= {:x 1 :y 0 :direction "W"} (move {:x 2 :y 0 :direction "W"} 1))))

(deftest commands-returns-a-sequence-of-command
  (is (= ["R"] (commands "R")))
  (is (= ["R" "M"] (commands "RM"))))

(deftest execute-move-commands-returns-new-position-for-mars-rover
  (is (= "0:1:N" (execute "M" {:x 0 :y 0 :direction "N"})))
  (is (= "0:2:N" (execute "MM" {:x 0 :y 0 :direction "N"}))))


