(ns mars-rover.core
  (:gen-class))

(defn rotate-right
  [direction]
  (cond
    (= "N" direction) "E"
    (= "E" direction) "S"))
