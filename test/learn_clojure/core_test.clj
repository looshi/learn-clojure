(ns learn-clojure.core-test
  (:require [clojure.test :refer :all]
            [learn-clojure.core :refer :all]))

(deftest is-operator-test
  (testing "*" (is (= (is-operator *) true)))
  (testing "-" (is (= (is-operator -) true)))
  (testing "/" (is (= (is-operator /) true)))
  (testing "+" (is (= (is-operator +) true)))
  (testing 3 (not (is-operator 3)))
  (testing \a (not (is-operator \a)))
  (testing "string" (not (is-operator "string"))))

(deftest prefix-test
  (testing "2 operands"
    (is (= (prefix '(2 + 3)) '(+ 2 3))))
  (testing "4 operands"
    (is (= (prefix '(2 + 3 - 4 * 5)) '(+ 2 (- 3 (* 4 5))))))
  (testing "list operands"
    (is (= (prefix '(2 + (4 * 5))) '(+ 2 (* 4 5))))))
