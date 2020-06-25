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
  [position direction]
  (cond
    (= "N" direction) {:x (:x position) :y (inc (:y position))}
    (= "E" direction) {:x (inc (:x position)) :y (:y position)}
    (= "S" direction) {:x (:x position) :y (dec (:y position))}
    (= "W" direction) {:x (dec (:x position)) :y (:y position)}))

(defn commands
  [input]
  (str/split input #""))
    
    
