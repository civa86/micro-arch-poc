(ns random-service.routes.services
  (:require [ring.util.http-response :refer :all]
            [compojure.api.sweet :refer :all]
            [clojure.tools.logging :as log]
            [schema.core :as s]))

(defapi service-routes
  {:swagger {:ui "/swagger-ui"
             :spec "/swagger.json"
             :data {:info {:version "1.0.0"
                           :title "Random Number Generator Service API"
                           :description "Service to generate random numbers"}}}}

  (context "/" []
    (GET "/:n" []
      :tags         ["Random Integer from 0 to n"]
      :summary      "Returns a random integer between 0 (inclusive) and n (exclusive)."
      :path-params  [n :- s/Int]
      :return       {:result Integer}
      (let [generated-int (rand-int n)]
        (log/info "Range:" [0 n] "-" "Random Integer:" generated-int)
        (ok {:result generated-int})))))
