(ns foo.t
  (:require [cljs.core.typed :as t])
  (:require-macros [cljs.core.typed :as t :refer [ann]]))

(ann foo t/Number)
(def foo 1)

(ann bar [t/Number -> t/Number])
(defn bar [n] n)

(ann _bar [t/Number -> t/Number])
(defn _bar [n] foo)

(ann baz [t/Number t/String -> t/String])
(defn baz [n str] str)

(ann x-point [(HMap :mandatory {:x t/Number :y t/Number}) -> t/Number])
(defn x-point [p] (:x p))

(ann fst [(t/Seqable t/Number) -> t/Number])
(defn fst [l] (nth l 0))

(fst [1 2 3])

(ann l (t/Seqable t/Number))
(def l [1 2 3])
(fst l)
