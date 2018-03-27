(ns random-service.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [random-service.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[random-service started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[random-service has shut down successfully]=-"))
   :middleware wrap-dev})
