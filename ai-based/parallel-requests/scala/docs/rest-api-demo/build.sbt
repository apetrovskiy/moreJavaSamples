name := "rest-api-demo"
version := "0.1.0"
scalaVersion := "3.3.5"

libraryDependencies ++= Seq(
  // Placeholder for dependencies (e.g., logging, faker, REST client, etc.)
  "ch.qos.logback" % "logback-classic" % "1.5.17", // Logging
  "org.scalatest" %% "scalatest" % "3.2.15" % Test // Testing
)
// libraryDependencies += "com.github.javafaker" % "javafaker" % "1.0.2"
libraryDependencies += "net.datafaker" % "datafaker" % "2.4.2"
// libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.5.17"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
// libraryDependencies += "com.github.tomakehurst" % "wiremock" % "2.35.0" % Test
// https://mvnrepository.com/artifact/com.github.tomakehurst/wiremock
// libraryDependencies += "com.github.tomakehurst" % "wiremock" % "2.27.2" % Test pomOnly()
// libraryDependencies += "org.wiremock" % "wiremock" % "3.12.0" % Test
libraryDependencies += "org.wiremock" % "wiremock" % "3.12.0" % Test
// libraryDependencies += "com.h2database" % "h2" % "2.1.214"
// libraryDependencies += "com.h2database" % "h2" % "2.3.232" % Test
// https://mvnrepository.com/artifact/pl.droidsonroids.yaml/snakeyaml
// libraryDependencies += "pl.droidsonroids.yaml" % "snakeyaml" % "1.18.2" % Test
// libraryDependencies += "org.yaml" % "snakeyaml" % "2.4" % Test
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.18.2"

