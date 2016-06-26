(ns deliverit-dashboard.widgets.github-repo-stats
  (:require [reagent.core :as r :refer [atom]]
            [dashboard-clj.widgets.core :as widget-common]
            [deliverit-dashboard.widgets.chart :as charts]))


(widget-common/register-widget
 :github-repo-stats
 (fn [{:keys [data options]}]
   [:div {:class (str "github-repo-stats " (:style-name options))}
    [:div.header {:style {:background  (:color options)}}
     [:img {:class "github-logo" :src "/images/github_mark.png"}]
     [:h2 {:class "title" } (:repo-name options)]]
    [:div#total-commits
     [:p {:class "subheading"} "Total commits"]
     [:h4 {:class "total-commits" :style {:background (:color options)}} (get-in @data [:data :total-commits])]]
    [:table {:class "contributors"}
     [:tbody
      [:tr
       [:th {:class "subheading" }"contributors"]]
      (doall (for [contributor (get-in @data [:data :contributors])]
               [:tr {:key contributor}
                [:td (str contributor)]]))]]
    [:div {:class "commit-chart" :style { :width "95%" :height "40%"}}
     [charts/bar-chart {:chart-options
                        {:title  {:text "commits"}
                         :xAxis  {
                                  :title {:text "date"}
                                  :categories (mapv first (get-in @data [:data :weekly-commit-breakdown]))}
                         :yAxis {:title {:text "commits"}}
                         :series [{:name "commits"
                                   :data (mapv second (get-in @data [:data :weekly-commit-breakdown]))}]}}]]]))
