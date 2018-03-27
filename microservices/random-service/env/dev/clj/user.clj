(ns user
  (:require 
            [mount.core :as mount]
            [random-service.core :refer [start-app]]))

(defn start []
  (mount/start-without #'random-service.core/repl-server))

(defn stop []
  (mount/stop-except #'random-service.core/repl-server))

(defn restart []
  (stop)
  (start))


