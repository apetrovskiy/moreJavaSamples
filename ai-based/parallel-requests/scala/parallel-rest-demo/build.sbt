ThisBuild / scalaVersion := "3.3.5"
ThisBuild / version := "0.1.0"
ThisBuild / organization := "com.example"

// Dependency version management
ThisBuild / libraryDependencySchemes ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always,
  "com.dimafeng" %% "testcontainers-scala-core" % VersionScheme.Always
)

lazy val IntegrationTest = config("it") extend Test

lazy val root = (project in file("."))
  .enablePlugins(JmhPlugin)
  .configs(IntegrationTest)
  .settings(
    name := "parallel-rest-demo",
    Test / fork := true,
    IntegrationTest / fork := true,
    
    // Main settings
    libraryDependencies ++= Seq(
      // Logging
      "ch.qos.logback" % "logback-classic" % "1.4.14",
      
      // Testcontainers with Scala 3 compatibility
      "com.dimafeng" %% "testcontainers-scala-core" % "0.41.8" % Test cross CrossVersion.for3Use2_13,
      "com.dimafeng" %% "testcontainers-scala-postgresql" % "0.41.8" % Test cross CrossVersion.for3Use2_13,
      "com.dimafeng" %% "testcontainers-scala-scalatest" % "0.41.8" % Test cross CrossVersion.for3Use2_13,
      
      // Testing
      "org.scalatest" %% "scalatest" % "3.2.19" % Test,
      "com.github.tomakehurst" % "wiremock" % "3.0.1" % Test,
      "org.testcontainers" % "testcontainers" % "1.19.3" % Test,
      "org.postgresql" % "postgresql" % "42.7.3" % Test,

      // HTTP client
      "com.softwaremill.sttp.client3" %% "core" % "3.9.5"

      // In build.sbt, add to libraryDependencies:
      "com.comcast" %% "ip4s-core" % "3.4.0"
    ),
    
    // Integration test configuration
    Defaults.itSettings,
    IntegrationTest / testOptions += Tests.Argument("-l", "org.scalatest.tags.Slow"),
    IntegrationTest / parallelExecution := false,
    
    // JMH configuration
    Jmh / sourceDirectory := (Compile / sourceDirectory).value,
    Jmh / classDirectory := (Compile / classDirectory).value,
    Jmh / dependencyClasspath := (Compile / dependencyClasspath).value,
    Jmh / compile := (Jmh / compile).dependsOn(Compile / compile).value,
    
    // Aliases
    addCommandAlias("benchmark", "Jmh/run -i 3 -wi 3 -f1 -t1")
  )

val Http4sVersion = "0.23.26"
val CirceVersion = "0.14.6"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-ember-server" % Http4sVersion,
  "org.http4s" %% "http4s-dsl"          % Http4sVersion,
  "org.http4s" %% "http4s-circe"        % Http4sVersion,
  "io.circe"   %% "circe-generic"       % CirceVersion
)

val DoobieVersion = "1.0.0-RC4"
val FlywayVersion = "10.7.1"

libraryDependencies ++= Seq(
  "org.flywaydb"   % "flyway-core"  % FlywayVersion,
  "org.tpolecat"  %% "doobie-core"  % DoobieVersion,
  "org.tpolecat"  %% "doobie-hikari"% DoobieVersion,
  "org.postgresql" % "postgresql"   % "42.7.3"
)
