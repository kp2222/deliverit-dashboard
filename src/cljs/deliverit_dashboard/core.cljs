(ns deliverit-dashboard.core
  (:require [dashboard-clj.core :as d]
            [dashboard-clj.layouts.grid-layout :as grid]
            [dashboard-clj.widgets.simple-text :as s]
            [re-frame.core :as rf]))



;; update app-state with random values

(.setInterval js/window
              #(rf/dispatch [:update-data-source
                             (rand-nth [:kochi-weather :bangalore-weather])
                             {:value (rand-int 100)}]) 500)




(def dashboard {:layout :grid-layout
                :widgets [
                          {
                           :type :simple-text
                           :name :first-widget
                           :data-source :bangalore-weather
                           :title "the second one"
                           :text "Hello World!!"
                           :layout-opts {:position {:x 0 :y 1 :h 1 :w 2 }}}

                          {
                           :type :simple-text
                           :name :second-widget
                           :data-source :kochi-weather
                           :title "the second one"
                           :text "Hello World!!"
                           :layout-opts {:position {:x 0 :y 1 :h 1 :w 2 }}}]})



(d/start-dashboard dashboard "app")


