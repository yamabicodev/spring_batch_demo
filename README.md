# spring_batch_demo
## 概要
- このアプリケーションは間違った実装例を再現のため、意図的にバグの含んだ実装がされています。
  よって、この実装方法を実際の開発の参考にはしないようお願いします。
- バッチを実行すると、一部のデータが正しく集計されない事象が再現されます。

## 実行環境
- Java 11
- DB: MySQL

## 環境構築
1. `resources/spring-batch-tables`配下のSQLを全て実行し、Spring Batch用のテーブル作成を行ってください。
1. `src/main/resources/ddl``src/main/resources/dml`を実行しテストデータを投入してください。

