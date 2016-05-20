(ns deliverit-dashboard.fetcher
  (:require [tentacles.repos :as repos]
            [clj-time.coerce :as c]
            [clj-time.format :as f]
            [environ.core :refer [env]]
            [again.core :as again]))

(defn sum [sequence-to-be-summed]
  (reduce + sequence-to-be-summed))

(defn format-unix-timestamp [epoch-time]
  (let [custom-formatter (f/formatter "dd/MM")
        converted-time (c/from-long (* 1000 epoch-time))]
    (f/unparse custom-formatter converted-time)))

(defn total-number-of-commits [contributor-statistics]
  (sum (map #(:total %) contributor-statistics)))

(defn list-of-contributors [contributor-statistics]
  (map #(:login %) (map #(:author %) contributor-statistics)))

(defn extract-commit-summary-for-week [commit-data]
  (let [week-start (format-unix-timestamp (first (map #(:w %) commit-data)))
        sum-of-commits (sum (map #(:c %) commit-data))]
    [week-start sum-of-commits]))

(defn weekly-commit-breakdown [contributor-statistics]
  (let [commit-data-for-month (map #(:weeks %) contributor-statistics)]
    (map extract-commit-summary-for-week (apply map vector commit-data-for-month))))

(defn fetch-contributor-stats [username repository]
  (repos/contributor-statistics username
                                repository
                                {:auth (System/getenv "GITAUTH")}))

(defn fetch [username repository]
  (let [contributor-stats (fetch-contributor-stats username repository)]
    (if (= contributor-stats :tentacles.core/accepted)
      (throw (Exception. "could not fetch data"))
      {
       :total-commits (total-number-of-commits contributor-stats)
       :weekly-commit-breakdown (weekly-commit-breakdown contributor-stats)
       :contributors (list-of-contributors contributor-stats)
       })))


(defn fetch-with-retry [username repository]
  (again/with-retries
    [100 1000 2000]
    (fetch username repository)))
