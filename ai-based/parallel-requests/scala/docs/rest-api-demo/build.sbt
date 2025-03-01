name := "rest-api-demo"
version := "0.1.0"
scalaVersion := "3.3.0"

libraryDependencies ++= Seq(
  // Placeholder for dependencies (e.g., logging, faker, REST client, etc.)
  "ch.qos.logback" % "logback-classic" % "1.4.7", // Logging
  "org.scalatest" %% "scalatest" % "3.2.15" % Test // Testing
)
libraryDependencies += "com.github.javafaker" % "javafaker" % "1.0.2"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.4.7"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test