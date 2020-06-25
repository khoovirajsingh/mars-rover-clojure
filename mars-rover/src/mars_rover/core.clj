(ns mars-rover.core
  (:gen-class))

(defn rotate-right
  [direction]
  (cond
    (= "N" direction) "E"
    (= "E" direction) "S"
    (= "S" direction) "W"
    (= "W" direction) "N"))
    
