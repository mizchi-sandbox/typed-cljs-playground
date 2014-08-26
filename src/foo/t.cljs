(ns foo.t
  (:require [cljs.core.typed :refer-macros [ann check-ns]]))

(ann foo number)
(def foo 1)
