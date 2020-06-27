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
  [mars-rover]
  (let [x (:x mars-rover)
        y (:y mars-rover)
        direction (:direction mars-rover)]
    (cond
      (= "N" direction) {:x x :y (inc y) :direction direction}
      (= "E" direction) {:x (inc x) :y y :direction direction}
      (= "S" direction) {:x x :y (dec y) :direction direction}
      (= "W" direction) {:x (dec x) :y y :direction direction})))

(defn commands
  [input]
  (str/split input #""))

(defn execute
  [commands mars-rover]
  ("0:0:N"))

    

