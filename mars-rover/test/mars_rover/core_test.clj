(ns mars-rover.core-test
  (:require [clojure.test :refer :all]
            [mars-rover.core :refer :all]))

(deftest rotate-right-changes-direction
  (is (= "E" (rotate-right "N"))))
