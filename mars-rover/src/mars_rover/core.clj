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


(defn execute
  [input mars-rover]
  (let [commands (parse-commands input)]
    (loop [num (count (parse-commands "MMM"))]
      (if (<= num 0)
        @rover
        (do (swap! rover move)
           (recur (dec num)))))))


