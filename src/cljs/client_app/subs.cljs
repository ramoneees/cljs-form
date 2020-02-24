(ns client-app.subs
  (:require
   [re-frame.core :as re-frame]
   [client-app.db :as db]))

(re-frame/reg-sub
 :get-name
 (fn [db]
   (get-in db [:current :name])))


(re-frame/reg-sub
 :get-phone
 (fn [db]
   (get-in db [:current :phone])))

(re-frame/reg-sub
 :get-customers
 (fn [db]
   (:customers db)))




