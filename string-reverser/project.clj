(defproject string-reverser "0.1.0-SNAPSHOT"
  :description "Reverse a string with Clojure!"
  :url "http://github.com/codyduval/clojure_playground"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot string-reverser.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
