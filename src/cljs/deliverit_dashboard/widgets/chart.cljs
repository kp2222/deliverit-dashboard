(ns deliverit-dashboard.widgets.chart
  (:require [reagent.core    :as    r]
            [reagent.ratom   :refer-macros [reaction]]
            [cljsjs.highcharts]
            [cljsjs.jquery]
            [dashboard-clj.widgets.core :as widget-common]))


(defn render
  []
  [:div { :style {:width "100%" :height "100%"}}])

(def bar-chart-config
  {:chart {:type "column"
           :backgroundColor "transparent"

           :style {:labels {
                            :fontFamily "monospace"
                            :color "#FFFFFF"}}}
   :yAxis {:title {:style {:color "#000000"}}
           :labels { :color "#ffffff"}}
   :xAxis {:labels {:style {:color "#fff"}}}})


(def line-chart-config
  {:chart {:type            "line"
           :backgroundColor "transparent"

           :style           {:labels {
                                      :fontFamily "monospace"
                                      :color "#FFFFFF"}}}
   :yAxis {:title {:style {:color "#000000"}}
           :labels { :color "#ffffff"}}
   :xAxis {:labels {:style {:color "#fff"}}}})


(defn plot-bar [this]
  (let [config     (-> this r/props :chart-options)
        all-config (merge bar-chart-config config)]
    (.highcharts (js/$ (r/dom-node this))
                 (clj->js all-config))))


(defn plot-line [this]
  (let [config     (-> this r/props :chart-options)
        all-config (merge line-chart-config config)]
    (.highcharts (js/$ (r/dom-node this))
                 (clj->js all-config))))

(defn bar-chart
  [chart-options]
  (r/create-class {:reagent-render       render
                   :component-did-mount  plot-bar
                   :component-did-update plot-bar}))


(defn line-chart
  [chart-options]
  (r/create-class {:reagent-render       render
                   :component-did-mount  plot-line
                   :component-did-update plot-line}))

(doseq [{:keys [name render-fn]} [{:name :bar-chart :render-fn bar-chart}
                                  {:name :line-chart :render-fn line-chart}]]
  (widget-common/register-widget
   name
   (fn [data options]
     [:div {:class "chart"}
      [:div.header
       [:h2 {:class "title" } (:title options)]]
      [:div {:class (str (:style-name options)) :style { :width "95%" :height "40%"}}
       [render-fn {
                   :chart-options
                   {
                    :title  {:text nil}
                    :xAxis  {
                             :title      {:text (:x-title options)}
                             :categories (mapv first (get-in data [:data :weekly-commit-breakdown]))}
                    :yAxis  {:title {:text (:y-title options)}}
                    :series [{
                              :name (:chart-title options)
                              :data (mapv second (get-in data [:data :weekly-commit-breakdown]))}]}}]]])))
