(ns deliverit-dashboard.core
  (:require [dashboard-clj.core :as d]
            [dashboard-clj.layouts.grid-layout-responsive :as grid]
            [deliverit-dashboard.widgets.simple-text]
            [deliverit-dashboard.widgets.github-repo-stats]
            [re-frame.core :as rf]))

(def dashboard {:layout      :responsive-grid-layout
                :layout-opts {:cols {:lg 6 :md 4 :sm 2 :xs 1 :xxs 1}}
                :widgets     [
                              {
                               :type :github-repo-stats
                               :name :widget-four
                               :data-source :good-karma
                               :options { :color "#ea8888"}
                               :repo-name  "Good Karma"
                               :text "history"

                               :layout-opts {:position {:lg {:x 0 :y 0  :h 3 :w 2 }
                                                        :md {:x 0 :y 0 :h 3 :w 2}
                                                        :sm {:x 0 :y 0 :h 3 :w 2 :static true}}}
                               :style {:background-color "#ffffff"
                                       :font-family "Times New Roman, Times, serif"
                                       :font-size "20px"}}

                              {
                               :type :github-repo-stats
                               :name :second-widget
                               :data-source :onemdm-library
                               :repo-name  "One MDM"
                               :options {:color "#ccf2c4"}
                               :text "commit history"
                               :layout-opts {:position {:lg {:x 2 :y 0  :h 3 :w 2 }
                                                        :md {:x 2 :y 0 :h 3 :w 2}
                                                        :sm {:x 0 :y 0 :h 3 :w 2 :static true}}}
                               :style {
                                       :background-color "#ffffff"
                                       :font-family "Helvetica"
                                       :font-size "20px"}}
                              {
                               :type :github-repo-stats
                               :name :third-widget
                               :data-source :multunus-website
                               :options { :color "#ea8888"}
                               :repo-name  "Multunus Website"
                               :text "history"

                               :layout-opts {:position {:lg {:x 4 :y 0  :h 3 :w 2 }
                                                        :md {:x 0 :y 3 :h 3 :w 2}
                                                        :sm {:x 0 :y 0 :h 3 :w 2 :static true}}}
                               :style {:background-color "#ffffff"
                                       :font-family "Times New Roman, Times, serif"
                                       :font-size "20px"}}

                              {
                               :type :github-repo-stats
                               :name :first-widget
                               :data-source :dashboard-clj-repo-stats
                               :repo-name "Dashboard (Clojure)"
                               :title "commits"
                               :options { :color "#44b8e4"  }
                               :text "commit history"
                               :layout-opts {:position {:lg {:x 0 :y 3  :h 3 :w 2 }
                                                        :md {:x 0 :y 6 :h 3 :w 2}
                                                        :sm {:x 0 :y 0 :h 3 :w 2 :static true}}}
                               :style {
                                       :background-color "#ffffff"
                                       :font-family      "Helvetica"
                                       :font-size        "20px"}}
                              ]})

(d/start-dashboard dashboard "app")
