name := "rest-api-demo"
version := "0.1.0"
scalaVersion := "3.3.5"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.5.17",
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
  "net.datafaker" % "datafaker" % "2.4.2",
  "org.wiremock" % "wiremock" % "3.12.0" % Test,
  "com.h2database" % "h2" % "2.3.232" % Test,
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.18.2",
  "com.softwaremill.sttp.client3" %% "core" % "3.10.3",
  "com.softwaremill.sttp.client3" %% "circe" % "3.10.3",
  "io.circe" %% "circe-generic" % "0.14.10",
  ("org.mongodb.scala" %% "mongo-scala-driver" % "5.3.1").cross(CrossVersion.for3Use2_13),
  "com.typesafe" % "config" % "1.4.3",
  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0",
  "com.softwaremill.sttp.tapir" %% "tapir-core" % "1.11.16",
  "com.softwaremill.sttp.tapir" %% "tapir-netty-server" % "1.11.16"
)