name := "scalaExamples"

version := "0.1"

scalaVersion := "2.12.7"

val json4sNative = "org.json4s" %% "json4s-native" % "3.6.3"

libraryDependencies += json4sNative
libraryDependencies += "org.json4s" %% "json4s-xml" % "3.6.3"

libraryDependencies ++= Seq(
  "io.github.mkotsur" %% "aws-lambda-scala" % "0.1.1",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.mockito" % "mockito-core" % "2.23.0" % "test"
)

// jdbc
// Scala 2.10, 2.11, 2.12
libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc" % "3.3.+",
  "com.h2database" % "h2" % "1.4.197",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "org.scalikejdbc" %% "scalikejdbc-config" % "3.3.2",
  "mysql" % "mysql-connector-java" % "5.1.29",
)

enablePlugins(ScalikejdbcPlugin)
