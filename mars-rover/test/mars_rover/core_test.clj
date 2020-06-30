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
  (is (= {:x 0 :y 1 :direction "N"} (move {:x 0 :y 0 :direction "N"})))
  (is (= {:x 0 :y 2 :direction "N"} (move {:x 0 :y 1 :direction "N"}))))

(deftest move-decrements-y-when-direction-is-south
  (is (= {:x 0 :y 1 :direction "S"} (move {:x 0 :y 2 :direction "S"})))
  (is (= {:x 0 :y 0 :direction "S"} (move {:x 0 :y 1 :direction "S"}))))

(deftest move-increments-x-when-direction-is-east
  (is (= {:x 1 :y 0 :direction "E"} (move {:x 0 :y 0 :direction "E"})))
  (is (= {:x 2 :y 0 :direction "E"} (move {:x 1 :y 0 :direction "E"}))))

(deftest move-decrements-x-when-direction-is-west
  (is (= {:x 0 :y 0 :direction "W"} (move {:x 1 :y 0 :direction "W"})))
  (is (= {:x 1 :y 0 :direction "W"} (move {:x 2 :y 0 :direction "W"}))))

(deftest commands-returns-a-sequence-of-command
  (is (= ["R"] (parse-commands "R")))
  (is (= ["R" "M"] (parse-commands "RM"))))

(deftest execute-move-commands-returns-new-position-for-mars-rover
  (is (= {:x 0 :y 3 :direction "N"} (execute "MM" {:x 0 :y 0 :direction "N"}))))


