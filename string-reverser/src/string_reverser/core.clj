(ns string-reverser.core
  (:gen-class))

(defn get-string [] ; bad naming? 
  (println "Enter string: ")
  (let [string-input (read-line)] string-input))
  
(defn output-string [user-inputted-string] 
  (println "You said " user-inputted-string))

(defn string-to-array [user-inputted-string] 
  (seq user-inputted-string))

(defn array-to-string [string-as-array]
  (apply str string-as-array))

(defn reverse-array [string-as-array]
  (reverse string-as-array))

(defn reverse-string [user-inputted-string] 
  (array-to-string (reverse-array (string-to-array user-inputted-string))))

(defn go []
  (let [user-string (get-string)]
    (println "You said:" user-string)
    (println "Reversed this is:" (reverse-string user-string))))

(defn -main []
    (go))

