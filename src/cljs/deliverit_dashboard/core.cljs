(ns deliverit-dashboard.core
  (:require [dashboard-clj.core :as d]
            [dashboard-clj.layouts.grid-layout-responsive :as grid]
            [dashboard-clj.widgets.simple-text :as s]
            [dashboard-clj.widgets.github-repo-stats]
            [re-frame.core :as rf]))

(def dashboard {:layout :responsive-grid-layout
                :layout-opts {:cols {:lg 6 :md 4 :sm 2 :xs 1 :xxs 1}}
                :widgets [
                          {
                           :type :github-repo-stats
                           :name :first-widget
                           :data-source :dashboard-clj-repo-stats
                           :repo-name "Dashboard (Clojure)"
                           :title "commits"
                           :text "commit history"
                           :layout-opts {:position {:lg {:x 0 :y 0  :h 3 :w 2 :static true }
                                                    :md {:x 0 :y 0 :h 3 :w 2}
                                                    :sm {:x 0 :y 0 :h 3 :w 2 :static true}}}
                           :style {:background-image "linear-gradient(120deg, #b8ce9a, #08701a)"
                                   :background-color "#b8ce9a"
                                   :font-family "Times New Roman, Times, serif"
                                   :font-size "20"}}
                          {
                           :type :github-repo-stats
                           :name :second-widget
                           :data-source :onemdm-library
                           :repo-name  "One MDM"
                           :text "commit history"
                           :layout-opts {:position {:lg {:x 2 :y 0  :h 3 :w 2 }
                                                    :md {:x 2 :y 0 :h 3 :w 2}
                                                    :sm {:x 0 :y 0 :h 3 :w 2 :static true}}}
                           :style {:background-image "linear-gradient(120deg, #155799, #159957)"
                                   :background-color "#ffffff"
                                   :font-family "Times New Roman, Times, serif"
                                   :font-size "20"}}
                          {
                           :type :github-repo-stats
                           :name :third-widget
                           :data-source :multunus-website
                           :repo-name  "Multunus Website"
                           :text "history"
                           :layout-opts {:position {:lg {:x 4 :y 0  :h 3 :w 2 }
                                                    :md {:x 0 :y 3 :h 3 :w 2}
                                                    :sm {:x 0 :y 0 :h 3 :w 2 :static true}}}
                           :style {:background-image "linear-gradient(120deg, #f4164d, #7f1010)"
                                   :font-family "Times New Roman, Times, serif"
                                   :font-size "20"}}]})

(d/start-dashboard dashboard "app")
