(ns backlog-importer.core
  (:require backlog
            [backlog.config :as config]
            [clojure.java.io :as jio]
            [clojure.data.csv :as csv])
  (:gen-class))

(def csv-keys [:summary
               :description
               :start-date
               :due-date
               :estimated-hours
               :actual-hours
               :issue-type
               :component
               :version
               :milestone
               :priority
               :assigner-id])

(defn create-issues
  [project-id filename]
  (let [users (backlog/get-users project-id)
        get-user-id (fn [users name]
                      (:id (first (filter #(= name (:name %)) users))))]
    (with-open [reader (jio/reader filename)]
      ; ignore header line
      (.readLine reader)
      (doseq [csv-vals (csv/read-csv reader)]
        (let [csv-map (into {} (zipmap csv-keys csv-vals))
              summary (csv-map :summary)
              user-id (get-user-id users (csv-map :assigner-id))
              new-map (merge csv-map {:assigner-id user-id})
              options (into {} (remove (fn [e]
                                         (or (= :summary (key e))
                                             (nil? (val e))
                                             (= "" (val e))))
                                       new-map))]
          (apply backlog/create-issue project-id summary (flatten (seq options))))))))

(defn -main
  [& args]
  (let [[spacename username password project-key filename] args]
    (binding [config/*backlog-auth* {:spacename spacename
                                     :username username
                                     :password password}]
      (let [project-id (:id (backlog/get-project project-key))]
        (create-issues project-id filename)))))

