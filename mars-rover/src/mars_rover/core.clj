(ns mars-rover.core
  (:gen-class))

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
    (= "S" direction) {:x (dec (:x position)) :y (:y position)}))
    
