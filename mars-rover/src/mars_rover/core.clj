(ns mars-rover.core
  (:gen-class)
  (:require [clojure.string :as str]))

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
  [mars-rover moves]
  (let [x (:x mars-rover)
        y (:y mars-rover)
        direction (:direction mars-rover)]
    (cond
      (= "N" direction) {:x x :y (+ y moves) :direction direction}
      (= "E" direction) {:x (+ x moves) :y y :direction direction}
      (= "S" direction) {:x x :y (- y moves) :direction direction}
      (= "W" direction) {:x (- x moves) :y y :direction direction})))

(defn commands
  [input]
  (str/split input #""))

(defn execute
  [commands mars-rover]
  "0:1:N")

