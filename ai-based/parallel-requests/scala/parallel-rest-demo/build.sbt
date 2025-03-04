ThisBuild / scalaVersion := "3.3.5"
ThisBuild / version := "0.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "parallel-rest-demo",
    libraryDependencies ++= Seq(
      // Logging
      "ch.qos.logback" % "logback-classic" % "1.4.14",
      
      // Testing
      "org.scalatest" %% "scalatest" % "3.2.17" % Test,
      "com.github.tomakehurst" % "wiremock" % "3.0.1" % Test,
      "org.testcontainers" % "testcontainers" % "1.19.3" % Test,
      
      "com.dimafeng" %% "testcontainers-scala-scalatest" % "0.41.0" % Test,
      "com.dimafeng" %% "testcontainers-scala-postgresql" % "0.41.0" % Test,
      "org.postgresql" % "postgresql" % "42.7.3" % Test,
      "io.gatling" % "gatling-core" % "3.10.3" % Test,
      "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.10.3" % Test
    )
  )

// Integration test configuration
lazy val IntegrationTest = config("it") extend Test
configs(IntegrationTest)
Defaults.itSettings