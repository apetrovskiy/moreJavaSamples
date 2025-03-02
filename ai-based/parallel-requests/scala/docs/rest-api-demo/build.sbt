name := "rest-api-demo"
version := "0.1.0"
scalaVersion := "3.3.5"

libraryDependencies ++= Seq(
  // Logging
  "ch.qos.logback" % "logback-classic" % "1.5.17",
  // Testing
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
  // Faker for generating user data
  "net.datafaker" % "datafaker" % "2.4.2",
  // WireMock for mocking service
  "org.wiremock" % "wiremock" % "3.12.0" % Test,
  // H2 database for persistence
  "com.h2database" % "h2" % "2.3.232" % Test,
  // JSON serialization
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.18.2",
  // STTP for REST API client
  "com.softwaremill.sttp.client3" %% "core" % "3.10.3",
  "com.softwaremill.sttp.client3" %% "circe" % "3.10.3",
  "io.circe" %% "circe-generic" % "0.14.10",
  // MongoDB for storage
  ("org.mongodb.scala" %% "mongo-scala-driver" % "5.3.1").cross(CrossVersion.for3Use2_13),
  // Configuration
  "com.typesafe" % "config" % "1.4.3",
  // Parallel collections
  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0",
  // Micrometer for metrics
  "io.micrometer" % "micrometer-core" % "1.14.4",
  "io.micrometer" % "micrometer-registry-prometheus" % "1.14.4",
)
// Remove all other Tapir dependencies and keep only:
libraryDependencies ++= Seq(
  "com.softwaremill.sttp.tapir" %% "tapir-core" % "1.11.16",
  "com.softwaremill.sttp.tapir" %% "tapir-netty-server" % "1.11.16",
  "com.softwaremill.sttp.tapir" %% "tapir-prometheus-metrics" % "1.11.16"
)