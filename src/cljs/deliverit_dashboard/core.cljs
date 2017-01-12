(ns deliverit-dashboard.core
  (:require [dashboard-clj.core :as d]
            [dashboard-clj.layouts.grid-layout-responsive :as grid]
            [deliverit-dashboard.widgets.simple-text]
            [deliverit-dashboard.widgets.chart]
            [deliverit-dashboard.widgets.github-repo-stats]
            [re-frame.core :as rf]))

(def widgets [{:type :simple-text
               :name :push-example
               :data-source :push-example
               :options {:title "Text"}}
              {
               :type        :github-repo-stats
               :name        :widget-four
               :data-source :good-karma
               :options     {:repo-name  "Good Karma"
                             :color      "#ea8888"
                             :style-name "widget"}}
              {
               :type        :github-repo-stats
               :name        :widget-two
               :data-source :onemdm-library
               :options     {:repo-name  "One MDM"
                             :color      "#ccf2c4"
                             :style-name "widget"}}
              {
               :type        :github-repo-stats
               :name        :widget-three
               :data-source :multunus-website
               :options     {:repo-name  "Multunus Website"
                             :color      "#ea8888"
                             :style-name "widget"}}
              {
               :type        :github-repo-stats
               :name        :widget-one
               :data-source :dashboard-clj-repo-stats
               :options     {:repo-name  "Dashboard (Clojure)"
                             :title      "commits"
                             :color      "#44b8e4"
                             :style-name "widget"}}
              {
               :type        :bar-chart
               :name        :widget-six
               :data-source :dashboard-clj-repo-stats
               :options     {:title       "Dashboard(Clojure)"
                             :chart-title "commits"
                             :y-title     "commits"
                             :x-title     "date"
                             :color       "#ea8888"
                             :style-name "widget"}}
              {
               :type        :line-chart
               :name        :widget-five
               :data-source :dashboard-clj-repo-stats
               :options     {:title       "Dashboard(Clojure)"
                             :chart-title "commits"
                             :y-title     "commits"
                             :x-title     "date"
                             :color       "#ea8888"
                             :style-name  "widget"}}])

(def widget-layout {
                    :push-example {:layout-opts {:position {:lg {:x 0 :y 0 :w 2 :h 3}
                                                            :md {:x 0 :y 0 :w 2 :h 3}
                                                            :sm {:x 0 :y 0 :w 2 :h 3 :static true}}}}
                    :widget-one   {:layout-opts {:position {:lg {:x 0 :y 0 :w 2 :h 3}
                                                            :md {:x 0 :y 0 :w 2 :h 3}
                                                            :sm {:x 0 :y 0 :w 2 :h 3 :static true}}}}

                    :widget-two   {:layout-opts {:position {:lg {:x 2 :y 0 :w 2 :h 3}
                                                            :md {:x 2 :y 0 :w 2 :h 3}
                                                            :sm {:x 0 :y 0 :w 2 :h 3 :static true}}}}

                    :widget-three {:layout-opts {:position {:lg {:x 4 :y 0 :w 2 :h 3}
                                                            :md {:x 0 :y 3 :w 2 :h 3}
                                                            :sm {:x 0 :y 0 :w 2 :h 3 :static true}}}}

                    :widget-four  {:layout-opts {:position {:lg {:x 6 :y 0 :w 2 :h 3}
                                                            :md {:x 2 :y 3 :w 2 :h 3}
                                                            :sm {:x 0 :y 0 :w 2 :h 3 :static true}}}}

                    :widget-five  {:layout-opts {:position {:lg {:x 0 :y 3 :w 2 :h 3}
                                                            :md {:x 0 :y 6 :w 2 :h 3}
                                                            :sm {:x 0 :y 0 :w 2 :h 3 :static true}}}}

                    :widget-six   {:layout-opts {:position {:lg {:x 2 :y 3 :w 2 :h 3}
                                                            :md {:x 2 :y 6 :w 2 :h 3}
                                                            :sm {:x 0 :y 0 :w 2 :h 3 :static true}}}}})
(def dashboard {
                :layout  :responsive-grid-layout
                :options {:layout-opts {:cols {:lg 6 :md 4 :sm 2 :xs 1 :xxs 1}}}
                :widgets (mapv #(merge % (get widget-layout (:name %))) widgets)
                })

(d/start-dashboard dashboard "app")
