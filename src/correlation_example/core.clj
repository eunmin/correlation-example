(ns correlation-example.core)

(defn correlation [xs ys]
  (let [avg #(/ (reduce + %) (count %))
        f1 (fn [xs]
             (let [xa (avg xs)]
               (reduce #(+ %1 (java.lang.Math/pow (- %2 xa) 2)) 0 xs)))
        f2 (fn [xs ys]
             (let [xa (avg xs)
                   ya (avg ys)]
               (reduce (fn [r [x y]]
                         (+ r (* (- x xa) (- y ya))))
                       0
                       (partition 2 (interleave xs ys)))))]
    (/ (f2 xs ys) (java.lang.Math/sqrt (* (f1 xs) (f1 ys))))))
