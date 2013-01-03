# Backlog Importer

Backlog Importer is command-line utility to import some issues from text file.

## Installation

1. Install [Leiningen][] to build Backlog Importer.

Please refer to [Leiningen#installation][].

2. Download Backlog Importer from GitHub.

You can use `git clone` command.

    $ cd
    $ git clone git://github.com/bouzuya/clj-backlog-importer

3. Build Backlog Importer.

    $ cd ~/clj-backlog-importer
    $ lein uberjar
    $ cp target/backlog-importer-0.1.0-standalone.jar [directory]

[Leiningen]: https://github.com/technomancy/leiningen
[Leiningen#installation]: https://github.com/technomancy/leiningen#installation

## Usage

### Command-line

    $ java -jar backlog-importer-0.1.0-standalone.jar \
        SPACE USER PASS PJKEY FILE

### File format

CSV(RFC4180) format. line 1 is header (ignore).

    "件名(summary)/Required","詳細(description)","開始日(start-date)/Premium+ only","期限日(due-date)","予定時間(estimated-hours)/Premium+ only","実績時間(actual-hours)/Premium+ only","種別名(issue-type)","カテゴリ名(component)","発生バージョン名(version)","マイルストーン名(milestone)","優先度(priority)","担当者ID(assigner-id)"
    "新しい課題1","新しい課題1の詳細","","20130131","","","タスク","カテゴリ","0.3.0","0.4.0","中","bouzuya"
    "新しい課題2","新しい課題2の詳細","","20130110","","","タスク","カテゴリ","0.2.0","0.4.0","高","emanon001"
    "新しい課題3"

## License

Copyright © 2012 bouzuya.

Distributed under the Eclipse Public License, the same as Clojure.

