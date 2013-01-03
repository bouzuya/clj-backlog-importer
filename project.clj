(defproject backlog-importer "0.1.0"
  :description "Backlog Importer is command-line utility to import some issues from text file."
  :url "http://github.com/bouzuya/clj-backlog-importer"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/data.csv "0.1.2"]
                 [org.clojars.bouzuya/backlog "0.3.1"]]
  :main backlog-importer.core)
