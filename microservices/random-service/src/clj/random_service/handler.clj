(ns random-service.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [random-service.routes.services :refer [service-routes]]
            [compojure.route :as route]
            [random-service.env :refer [defaults]]
            [mount.core :as mount]
            [random-service.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
          #'service-routes
      (route/not-found
        "page not found"))))
