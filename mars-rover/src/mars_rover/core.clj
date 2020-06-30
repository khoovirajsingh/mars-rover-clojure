(ns mars-rover.core
  (:gen-class)
  (:require [clojure.string :as str]))

(def rover (atom {:x 0 :y 0 :direction "N"}))

(defn rotate-right
  [direction]
  (cond
    (= "N" direction) "E"
    (= "E" direction) "S"
    (= "S" direction) "W"
    (= "W" direction) "N"))

(defn rotate-left
  [direction]
  (cond
    (= "N" direction) "W"
    (= "W" direction) "S"
    (= "S" direction) "E"
    (= "E" direction) "N"))


(defn move
  [mars-rover]
  (let [x (:x mars-rover)
        y (:y mars-rover)
        direction (:direction mars-rover)]
    (cond
      (= "N" direction) {:x x :y (+ y 1) :direction direction}
      (= "E" direction) {:x (+ x 1) :y y :direction direction}
      (= "S" direction) {:x x :y (- y 1) :direction direction}
      (= "W" direction) {:x (- x 1) :y y :direction direction})))

(defn parse-commands
  [input]
  (str/split input #""))

(defn rotate-right
  [mars-rover]
  (let [x (:x mars-rover)
        y (:y mars-rover)
        direction (:direction mars-rover)]
    {:x x :y y :direction (rotate-right direction)}))

(defn rotate-left
  [mars-rover]
  (let [x (:x mars-rover)
        y (:y mars-rover)
        direction (:direction mars-rover)]
    {:x x :y y :direction (rotate-left direction)}))

(defn run-command
  [mars-rover command]
  (cond 
    (= "M" command) (swap! rover move)
    (= "R" command) (swap! rover rotate-right)
    (= "L" command) (swap! rover rotate-left)
    :else rover))


(defn execute
  [input mars-rover]
  (let [commands (parse-commands input)]
    (loop [num (count commands)]
      (if (<= num 0)
        @rover
        (do (run-command mars-rover "M")
           (recur (dec num)))))))

