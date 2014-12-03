(ns string-compressor.core
  (:gen-class))

(defn get-string
  "Gets a user inputted string to be compressed, for example
  'aaaabbbcccdddeeef'. Returns the user inputted string."
  [] 
  (println "Enter string: ")
  (let [string-input (read-line)] string-input))

(defn split-by-like-chars
  "Take a user inputted string and split into a list of lists of 
  similar characters. Eg: ((aaa) (bbb) (ccc) (dd) (ee) (f))." 
  [user-string]
  (partition-by identity user-string))

(defn count-chars-by-group
  "Take a list of character lists and count the number of characters
  in each list.  Returns a list of maps of each character and its count,
  eg ({a 3} {b 3} ...)."
  [list-of-character-groups]
  (flatten (map (fn [group] {(first group) (count group)})
                list-of-character-groups)))

(defn hashmaps-of-counts-to-single-string
  "Take a list of character counts and convert into a single string. 
  Returns a string like 'a3b3c2d1'"
  [list-of-hashmaps]
  (apply str (flatten (map concat list-of-hashmaps))))

(defn compare-compressed-to-original
  "Compare the length of a compressed string to the original string and
  return which ever is shorter."
  [original compressed]
  (if (< (count original) (count compressed)) original compressed))

(defn compress-string
  "Compresses a user entered string like 'aaaabbccddeeeeff' and returns 
  a string that replaces repeat characters with counts, eg 'a4b2c2d2e4f2'"
  [user-string]
  (-> user-string split-by-like-chars count-chars-by-group hashmaps-of-counts-to-single-string))
  
(defn go
  []
  (let [user-string (get-string)]
    (let [compressed-string (compress-string user-string)]
    (println "You said:" user-string)
    (println "Compressed this is:" compressed-string)
    (println "The optimal compressed string is:" (compare-compressed-to-original user-string compressed-string)))))

(defn -main
  []
  (go))

