(ns deliverit-dashboard.pusher
  (:require [clojure.core.async :as async]
            [dashboard-clj.utils :refer [data->event]]))

(defn init
  [datasource]
  (.start (Thread.
           (fn[]
             (while true
               (do
                 (Thread/sleep 1000)
                 (reset! (:data datasource) (rand-int 100))))))))
