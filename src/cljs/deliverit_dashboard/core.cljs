(ns deliverit-dashboard.core
  (:require [dashboard-clj.core :as d]
            [dashboard-clj.layouts.grid-layout :as grid]
            [dashboard-clj.widgets.simple-text :as s]
            [re-frame.core :as rf]))

(def dashboard {:layout :grid-layout
                :layout-opts { :rowHeight 500 :cols 6}
                :widgets [
                          {
                           :type :simple-text
                           :name :first-widget
                           :data-source :dashboard-clj
                           :title "Clojure Dashboard"
                           :text " commits to date"
                           :layout-opts {:position {:x 0 :y 0 :h 1 :w 2 }}
                           :style {:background-color "#12b0c5"
                                   :font-family "Lucida Console, Monaco, monospace"
                                   :font-size "30"} }
                          {
                           :type :simple-text
                           :name :second-widget
                           :data-source :moveit-mobile
                           :title "MoveIt Mobile"
                           :text " commits to date"
                           :layout-opts {:position {:x 2 :y 0  :h 1 :w 2 }}
                           :style {:background-color "#9c4274"
                                   :font-family "Comic Sans MS, cursive, sans-serif"
                                   :font-size "30"}}]})

(d/start-dashboard dashboard "app")
