(ns deliverit-dashboard.core
  (:require [dashboard-clj.core :as d]
            [dashboard-clj.layouts.grid-layout :as grid]
            [dashboard-clj.widgets.simple-text :as s]
            [dashboard-clj.widgets.github-repo-stats]
            [re-frame.core :as rf]))





(def dashboard {:layout :grid-layout
                :layout-opts { :rowHeight 500 :cols 6}
                :widgets [
                          {
                           :type :github-repo-stats
                           :name :first-widget
                           :data-source :dashboard-clj-repo-stats
                           :repo-name "One MDM"
                           :title "commits"
                           :text "commit summary (last 4 weeks)"
                           :layout-opts {:position {:x 0 :y 0  :h 1 :w 2 }}
                           :style {:background-color "#ffffff"
                                   :font-family "Times New Roman, Times, serif"
                                   :font-size "20"}}

                          {
                           :type :github-repo-stats
                           :name :second-widget
                           :data-source :dashboard-clj-repo-stats
                           :repo-name  "Dashboard-CLJ"
                           :text "commit summary (last 4 weeks)"
                           :layout-opts {:position {:x 2 :y 0  :h 1 :w 2 }}
                           :style {:background-color "#ffffff"
                                   :font-family "Times New Roman, Times, serif"
                                   :font-size "20"}}
                          {
                           :type :github-repo-stats
                           :name :third-widget
                           :data-source :dashboard-clj-repo-stats
                           :repo-name  "Project x"
                           :text "commit summary (last 4 weeks)"
                           :layout-opts {:position {:x 4 :y 0  :h 1 :w 2 }}
                           :style {:background-color "#ffffff"
                                   :font-family "Times New Roman, Times, serif"
                                   :font-size "20"}}]})


(d/start-dashboard dashboard "app")


