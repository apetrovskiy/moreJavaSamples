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
      "org.testcontainers" % "testcontainers" % "1.19.3" % Test
    )
  )

// Integration test configuration
lazy val IntegrationTest = config("it") extend Test
// configs(IntegrationTest)
Defaults.itSettings