(defproject hellocljs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "MIT" }
  :plugins [[lein-cljsbuild "1.0.3"] [lein-typed "0.3.5"]]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2311"]
                 [org.clojure/core.async "0.1.319.0-6b1aca-alpha"]
                 [org.clojure/core.typed "0.2.67"]
                 [jayq "2.5.2"]
                 [om "0.7.1"]]
  :core.typed {:check-cljs [foo.t]}
  :cljsbuild {
    :builds [{
        :source-paths ["src"]
        :compiler {
          :output-to "public/main.js"
          :optimizations :whitespace
          :pretty-print true}}]})
