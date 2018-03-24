(ns uuid-generator.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[uuid-generator started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[uuid-generator has shut down successfully]=-"))
   :middleware identity})
