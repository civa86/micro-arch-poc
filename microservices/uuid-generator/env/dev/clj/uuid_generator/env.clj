(ns uuid-generator.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [uuid-generator.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[uuid-generator started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[uuid-generator has shut down successfully]=-"))
   :middleware wrap-dev})
