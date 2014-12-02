(ns string-compressor.core
  (:gen-class))

(defn get-string [] 
  (println "Enter string: ")
  (let [string-input (read-line)] string-input))

(defn string-to-array [user-string]
  (seq user-string))

(defn this-character [string-array]
  (first string-array))

(defn dup-count [seq]
  (for [[id freq] (frequencies seq)]
    {id freq}))

(defn split-by-like-chars [user-string]
  (partition-by identity user-string))

(defn count-chars [string-partition]
  (dup-count string-partition))

(defn count-by-group [array-of-groups]
  (map count-chars array-of-groups))

(defn go []
  (let [user-string (get-string)]
    (println "You said:" user-string)
    (println (split-by-like-chars user-string))
    (println (flatten (map count-chars (split-by-like-chars user-string))))))

(defn -main []
    (go))

