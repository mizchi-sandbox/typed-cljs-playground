(ns foo.t
  (:require [cljs.core.typed :as t])
  (:require-macros [cljs.core.typed :as t :refer [ann]]))

(ann foo t/Number)
(def foo 1)

(ann bar [t/Number -> t/Number])
(defn bar [n] n)

(ann baz [t/Number t/String -> t/String])
(defn baz [n str] str)

; (ann x-point [{:x t/Number :y t/Number} -> t/Number])
; (defn x-point [p] 1)

; (ann-form #(+ 1 %) [t/Number -> t/Number])
; (ann-form (fn [n] n) [t/Number -> t/Number])

; (ann id (t/U -> t/U))
; (defn id [x] x)
