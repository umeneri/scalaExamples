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
