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
  (flatten (map count-chars array-of-groups)))

(defn hashes-to-string [list-of-hashes]
  (apply str (flatten (map concat list-of-hashes))))

(defn optimal-compressed-string [original compressed]
  (if (< (count original) (count compressed)) original compressed))
  
(defn go []
  (let [user-string (get-string)]
    (println "You said:" user-string)
    (println "Compressed this is:" (hashes-to-string (count-by-group (split-by-like-chars user-string))))
    (println "The optimal compressed string is:" (optimal-compressed-string (hashes-to-string (count-by-group (split-by-like-chars user-string))) user-string))))

(defn -main []
    (go))

