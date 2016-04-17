(ns deliverit-dashboard.core
  (:require [dashboard-clj.core :as d]
            [dashboard-clj.layouts.grid-layout :as grid]
            [dashboard-clj.widgets.simple-text :as s]))



(def layout (grid/grid-layout [[s/simple-text-widget {:name :widget-one :text "Hello world" :pos {:x 0 :y 0 :h 1 :w 2 }}]
                               [s/simple-text-widget {:name :widget-two :text "World!!" :pos {:x 0 :y 1 :h 1 :w 2}}]]))


(d/render-dashboard layout "app")


