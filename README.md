# oracle-ucp
Use the Oracle UCP for JDBC (Sample)

UCP for JDBC を使って簡単なアプリケーションを作成してみた。

Oracle Database 11g を使用。

## 1) データベースを準備する

データベースに mydb というユーザーを作成。その SQLスクリプトは sql/createUserMydb.sql。

また、サンプルデータは、sql/makeTableandInsertData.sql。

mydbユーザーで Oracleデータベースにログインして、サンプルデータを 読み込む。
このスクリプトは、テーブルも作成している。


## 2) サンプル・コードを入力する。

今回は Maven で作成した。

$ mvn archetype:generate <Enter>

archetype-artifactId に maven-archetype-webapp を指定。

groupId に com.billies_works。

package名に com.billies_works.demo を指定した。



