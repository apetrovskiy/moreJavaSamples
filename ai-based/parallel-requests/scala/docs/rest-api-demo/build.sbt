name := "rest-api-demo"
version := "0.1.0"
scalaVersion := "3.3.5"

libraryDependencies ++= Seq(
  // Placeholder for dependencies (e.g., logging, faker, REST client, etc.)
  "ch.qos.logback" % "logback-classic" % "1.5.17", // Logging
  "org.scalatest" %% "scalatest" % "3.2.15" % Test // Testing
)
libraryDependencies += "net.datafaker" % "datafaker" % "2.4.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
libraryDependencies += "org.wiremock" % "wiremock" % "3.12.0" % Test
libraryDependencies += "com.h2database" % "h2" % "2.3.232" % Test
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.18.2"
libraryDependencies += "com.softwaremill.sttp.client3" %% "core" % "3.8.15"
libraryDependencies += "com.softwaremill.sttp.client3" %% "circe" % "3.8.15" // For JSON support
libraryDependencies += "io.circe" %% "circe-generic" % "0.14.5" // For JSON serialization
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.9.0"
