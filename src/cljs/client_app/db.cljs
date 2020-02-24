(ns client-app.db)



(defn set-property [db property value]
  (println db)
  (assoc-in db [:current property] value))

(defn save-customer [db]
  (println db)
  (let [current (:current db)
        current-list (:customer-list db)] 
       (assoc db :customer-list (conj current-list current))))