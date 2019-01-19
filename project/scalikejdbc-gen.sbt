// JDBC ドライバーの指定を忘れずに
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.+"

addSbtPlugin("org.scalikejdbc" %% "scalikejdbc-mapper-generator" % "3.2.+")

