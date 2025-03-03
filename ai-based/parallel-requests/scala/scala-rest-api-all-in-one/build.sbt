ThisBuild / scalaVersion := "3.3.5"
ThisBuild / version := "1.0.0"

lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging, DockerPlugin)
  .settings(
    name := "scala-rest-api",
    libraryDependencies ++= Seq(
      // HTTP
      "com.softwaremill.sttp.tapir" %% "tapir-akka-http-server" % "1.9.7",
      "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % "1.9.7",
      "com.softwaremill.sttp.client3" %% "circe" % "3.9.5",
      
      // Database
      "org.xerial" % "sqlite-jdbc" % "3.45.1.0",
      "org.mongodb.scala" %% "mongo-scala-driver" % "4.11.1",
      
      // Config
      "com.typesafe" % "config" % "1.4.3",
      
      // Logging
      "ch.qos.logback" % "logback-classic" % "1.4.14",
      "io.micrometer" % "micrometer-core" % "1.12.0",
      
      // Testing
      "org.scalatest" %% "scalatest" % "3.2.18" % Test,
      "com.dimafeng" %% "testcontainers-scala-scalatest" % "0.41.0" % Test,
      "com.dimafeng" %% "testcontainers-scala-mockserver" % "0.41.0" % Test,
      "org.gnieh" %% "fs2-data-json-circe" % "1.8.0" % Test,
      "com.github.javafaker" % "javafaker" % "1.0.2" % Test
    ),
    dockerBaseImage := "eclipse-temurin:17-jre-jammy",
    dockerExposedPorts := Seq(8080)
  )