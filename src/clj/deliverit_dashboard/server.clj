(ns deliverit-dashboard.server
  (:require [dashboard-clj.core :as dash]
            [environ.core :refer [env]]
            [deliverit-dashboard.fetcher]))

(def datasources [{
                   :name :dashboard-clj
                   :read-fn :deliverit-dashboard.fetcher/fetch
                   :params ["multunus" "dashboard-clj"]
                   :schedule {
                              :in [0 :seconds]
                              :every [5 :seconds]
                              }
                   }
                  {
                   :name :moveit-mobile
                   :read-fn :deliverit-dashboard.fetcher/fetch
                   :params ["multunus" "moveit-mobile"]
                   :schedule {
                              :in [0 :seconds]
                              :every [5 :seconds]
                              }
                   }])

(defn start-dashboard[]
  (dash/start datasources {:port (Integer. (or (env :port) 5000))}))

(defn -main [& [port]]
  (start-dashboard))
