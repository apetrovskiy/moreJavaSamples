name := "rest-api-parallel"
version := "1.0"
scalaVersion := "3.3.0"

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client3" %% "core" % "3.8.11",
  "com.softwaremill.sttp.client3" %% "httpclient-backend" % "3.8.11",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
  "ch.qos.logback" % "logback-classic" % "1.4.7",
  "org.scalamock" %% "scalamock" % "5.2.0" % Test,
  "com.github.javafaker" % "javafaker" % "1.0.2"
)