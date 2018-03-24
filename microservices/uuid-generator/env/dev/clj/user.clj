(ns user
  (:require 
            [mount.core :as mount]
            [uuid-generator.core :refer [start-app]]))

(defn start []
  (mount/start-without #'uuid-generator.core/repl-server))

(defn stop []
  (mount/stop-except #'uuid-generator.core/repl-server))

(defn restart []
  (stop)
  (start))


