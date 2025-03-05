ThisBuild / scalaVersion := "3.3.5"
ThisBuild / version := "0.1.0"
ThisBuild / organization := "com.example"

// Dependency version management
ThisBuild / libraryDependencySchemes ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always,
  "com.dimafeng" %% "testcontainers-scala-core" % VersionScheme.Always
)


val Http4sVersion = "0.23.26"
val CirceVersion = "0.14.6"
val FlywayVersion = "10.7.1"

val DoobieVersion = "1.0.0-RC5"
val CatsEffectVersion = "3.5.7"

lazy val root = (project in file("."))
  .enablePlugins(JmhPlugin)
  .configs(IntegrationTest)
  .settings(
    name := "parallel-rest-demo",
    Test / fork := true,
    IntegrationTest / fork := true,
    
    libraryDependencies ++= Seq(
      // HTTP & JSON
      "org.http4s" %% "http4s-ember-server" % "0.23.26",
      "org.http4s" %% "http4s-dsl"          % "0.23.26",
      "org.http4s" %% "http4s-circe"        % "0.23.26",
      "io.circe"   %% "circe-generic"       % "0.14.6",
      "com.comcast" %% "ip4s-core"          % "3.4.0",
      "com.softwaremill.sttp.client3" %% "core" % "3.9.5",
      
      // Database
      "org.flywaydb"   % "flyway-core"     % "10.7.1",
      "org.tpolecat" %% "doobie-core" % DoobieVersion,
      "org.tpolecat" %% "doobie-hikari" % DoobieVersion,
      "org.tpolecat" %% "doobie-postgres" % DoobieVersion,
      "org.typelevel" %% "cats-effect" % CatsEffectVersion,
      "org.tpolecat"  %% "doobie-scalatest" % DoobieVersion % Test,
      "org.postgresql" % "postgresql"      % "42.7.3",
      
      // Testing
      "ch.qos.logback" % "logback-classic" % "1.4.14",
      "com.dimafeng" %% "testcontainers-scala-core" % "0.41.8" % Test cross CrossVersion.for3Use2_13,
      "com.dimafeng" %% "testcontainers-scala-postgresql" % "0.41.8" % Test cross CrossVersion.for3Use2_13,
      "com.dimafeng" %% "testcontainers-scala-scalatest" % "0.41.8" % Test cross CrossVersion.for3Use2_13,
      "org.scalatest" %% "scalatest" % "3.2.19" % Test,
      // "org.scalatestplus" %% "scalacheck-1-17" % "3.2.19.0" % Test,
      "org.scalatestplus" %% "scalacheck-1-18" % "3.2.19.0" % "test",
      "org.typelevel" %% "cats-effect-testing-scalatest" % "1.5.0" % Test,
      "com.github.tomakehurst" % "wiremock" % "3.0.1" % Test,
      "org.testcontainers" % "testcontainers" % "1.19.3" % Test,
      "org.http4s" %% "http4s-ember-client" % Http4sVersion % Test,
      "org.typelevel" %% "cats-effect-testing-scalatest" % "1.5.0" % Test

    ),
    
    // Integration test config
    Defaults.itSettings,
    IntegrationTest / testOptions += Tests.Argument("-l", "org.scalatest.tags.Slow"),
    IntegrationTest / parallelExecution := false,
    
    // JMH config
    Jmh / sourceDirectory := (Compile / sourceDirectory).value,
    Jmh / classDirectory := (Compile / classDirectory).value,
    Jmh / dependencyClasspath := (Compile / dependencyClasspath).value,
    Jmh / compile := (Jmh / compile).dependsOn(Compile / compile).value,
    
    addCommandAlias("benchmark", "Jmh/run -i 3 -wi 3 -f1 -t1")
  )

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-server" % Http4sVersion
)


// Keep existing config and add:
Test / scalacOptions ++= Seq(
  "-Yresolve-term-conflict:object" 
)
// Add this line to Test/scalacOptions
Test / scalacOptions += "-Yimports:java.lang,scala,scala.Predef,cats,cats.implicits,doobie,doobie.implicits"

lazy val it = (project in file("integration-tests"))
  .dependsOn(root % "test->test;compile->compile")
  .settings(
    Defaults.testSettings,
    Test / fork := true,
    Test / parallelExecution := false
  )
