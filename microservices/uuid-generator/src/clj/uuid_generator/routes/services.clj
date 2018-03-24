(ns uuid-generator.routes.services
  (:require [ring.util.http-response :refer :all]
            [compojure.api.sweet :refer :all]
            [schema.core :as s]
            [clojure.tools.logging :as log]))

(defapi service-routes
  {:swagger {:ui "/swagger-ui"
             :spec "/swagger.json"
             :data {:info {:version "1.0.0"
                           :title "UUID Random Generator API"
                           :description "MicroService to genrate a random UUID"}}}}

  (context "/" []
    :tags [""]

    (GET "/" []
          :return       s/Any
          :summary      "usage."
          (ok {
            :result "/uuid to generate one."
          }))

    (GET "/uuid" []
      :return       s/Any
      :summary      "generate a random uuid."
      (let [uuid (str (java.util.UUID/randomUUID))]
        (log/info "Generated UUID" uuid)
        (ok {:result uuid})))))
