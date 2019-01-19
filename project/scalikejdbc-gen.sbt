// JDBC ドライバーの指定を忘れずに
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.29"
addSbtPlugin("org.scalikejdbc" %% "scalikejdbc-mapper-generator" % "3.2.+")

