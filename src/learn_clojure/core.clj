(ns learn-clojure.core
  (:use [clojure.math.combinatorics]))

(defn is-operator [val]
  (boolean (some #{(str (type val))} '("class clojure.lang.Symbol"
                                       "class clojure.core$_STAR_"
                                       "class clojure.core$_PLUS_"
                                       "class clojure.core$_"
                                       "class clojure.core$_SLASH_"))))
(defn prefix
  [[head second & tail]]
  (cond
    (empty?  tail) head
    (list? (first tail)) (list second head (prefix tail)) ; not working
    (not (is-operator head)) (list second head (prefix tail))
    :else (list head tail)))
