(ns deliverit-dashboard.widgets.simple-text
  (:require [reagent.core :as r :refer [atom]]
            [dashboard-clj.widgets.core :as widget-common]))


(widget-common/register-widget
 :simple-text
 (fn [data options]
   [:div {:class "simple-text-widget"}
    [:span {:class "title"} (:title options)]
    [:div {:class "data"}
     [:span
      (get-in data [:data]) (:text options)]]
    ]))
