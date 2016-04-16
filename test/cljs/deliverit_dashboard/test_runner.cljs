(ns deliverit-dashboard.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [deliverit-dashboard.core-test]))

(enable-console-print!)

(doo-tests 'deliverit-dashboard.core-test)
