(ns client-app.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]
   [client-app.events :as events]
   [client-app.views :as views]
   [client-app.config :as config]
   ))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn init []
  (dev-setup)
  (mount-root))
