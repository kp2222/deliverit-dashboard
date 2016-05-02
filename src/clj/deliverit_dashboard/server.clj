(ns deliverit-dashboard.server
  (:require [dashboard-clj.core :as dash]
            [environ.core :refer [env]]
            [deliverit-dashboard.fetcher]))



(def datasources [{
                   :name :bangalore-weather
                   :read-fn :deliverit-dashboard.fetcher/fetch 
                   :params []
                   :schedule {
                              :in [0 :seconds]
                              :every [10 :seconds]
                              }
                   }
                  {
                   :name :kochi-weather
                   :read-fn :deliverit-dashboard.fetcher/fetch 
                   :params []
                   :schedule {
                              :in [0 :seconds]
                              :every [5 :seconds]
                              }
                   }])


(defn start-dashboard[]
  (dash/start datasources {:port (Integer. (or (env :port) 5000))}))


(defn -main [& [port]]
  (start-dashboard))
