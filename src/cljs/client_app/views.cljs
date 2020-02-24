(ns client-app.views
  (:require
   [re-frame.core :as rf]
   [client-app.subs :as subs]
   [re-frame-datatable.core :as dt]))

(defn form []
  [:div 
   [:div "test"]
   [:h1 "small form"]
   [:input :type "text"]])

(defn data-table []
  [:div [dt/datatable
         :customers
         [:get-customers]
         [{::dt/column-key   [:name]
           ::dt/column-label "Name"}
          {::dt/column-key   [:phone]
           ::dt/column-label "Phone"}]]])

(defn main-panel []
  [:div
   [:h1 "hello"]
   [:span "name :"]
   [:input {:type "text" :id "name" :value @(rf/subscribe [:get-name]) :on-change #(rf/dispatch [:update-properties :name (-> % .-target .-value)])}]
   [:span "phone :"]
   [:input {:type "text" :id "phone" :value @(rf/subscribe [:get-phone]) :on-change #(rf/dispatch [:update-properties :phone (-> % .-target .-value)])}]
   [:br]
   [:input {:type "submit" :on-click #(rf/dispatch [:save-customer])}]
   [:br]
   [:br]
   [:div [dt/datatable
          :customers
          [:get-customers]
          [{::dt/column-key   [:name]
            ::dt/column-label "Name"}
           {::dt/column-key   [:phone]
            ::dt/column-label "Phone"}]]]])



