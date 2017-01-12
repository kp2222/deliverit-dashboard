(ns deliverit-dashboard.server
  (:require [dashboard-clj.core :as dash]
            [environ.core :refer [env]]
            [deliverit-dashboard.fetcher]
            [deliverit-dashboard.pusher])
  (:gen-class))

(def datasources [
                  {
                   :name :dashboard-clj-repo-stats
                   :read-fn :deliverit-dashboard.fetcher/fetch
                   :params [ "multunus" "dashboard-clj"]
                   :schedule {
                              :in [0 :seconds]
                              :every [5 :minutes]}}
                  {
                   :name :multunus-website
                   :read-fn :deliverit-dashboard.fetcher/fetch
                   :params [ "multunus" "multunus-website"]
                   :schedule {
                              :in [0 :seconds]
                              :every [5 :minutes]}}

                  {
                   :name :onemdm-library
                   :read-fn :deliverit-dashboard.fetcher/fetch
                   :params [ "multunus" "onemdm-library"]
                   :schedule {
                              :in [0 :seconds]
                              :every [5 :minutes]}}
                  {
                   :name :good-karma
                   :read-fn :deliverit-dashboard.fetcher/fetch
                   :params [ "multunus" "good-karma"]
                   :schedule {
                              :in [0 :seconds]
                              :every [5 :minutes]}}

                  {:name    :push-example
                   :init-fn :deliverit-dashboard.pusher/init
                   :type    :push}
                  ])

(defn start-dashboard[]
  (dash/start datasources {:port (Integer. (or (env :port) 5000))}))

(defn -main [& [port]]
  (start-dashboard))
