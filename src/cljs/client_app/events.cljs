(ns client-app.events
  (:require
   [re-frame.core :as re-frame]
   [client-app.db :as db]
   ))


(re-frame/reg-event-db
 :update-properties
 (fn [db [_ property value]]
   (db/set-property db property value)))


(re-frame/reg-event-db
 :save-customer
 (fn [db [_]]
   (db/save-customer db)))