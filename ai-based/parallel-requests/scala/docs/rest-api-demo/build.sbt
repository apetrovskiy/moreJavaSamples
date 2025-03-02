name := "rest-api-demo"
version := "0.1.0"
scalaVersion := "3.3.5"

libraryDependencies ++= Seq(
  // Placeholder for dependencies (e.g., logging, faker, REST client, etc.)
  "ch.qos.logback" % "logback-classic" % "1.5.17", // Logging
  "org.scalatest" %% "scalatest" % "3.2.19" % Test // Testing
)
libraryDependencies += "net.datafaker" % "datafaker" % "2.4.2"
libraryDependencies += "org.wiremock" % "wiremock" % "3.12.0" % Test
libraryDependencies += "com.h2database" % "h2" % "2.3.232" % Test
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.18.2"
libraryDependencies += "com.softwaremill.sttp.client3" %% "core" % "3.10.3"
libraryDependencies += "com.softwaremill.sttp.client3" %% "circe" % "3.10.3"
libraryDependencies += "io.circe" %% "circe-generic" % "0.14.10"
libraryDependencies += ("org.mongodb.scala" %% "mongo-scala-driver" % "5.3.1").cross(CrossVersion.for3Use2_13)
libraryDependencies += "com.typesafe" % "config" % "1.4.3"
libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0"

libraryDependencies += "io.micrometer" % "micrometer-core" % "1.10.5"
libraryDependencies += "io.micrometer" % "micrometer-registry-prometheus" % "1.10.5"

//
// libraryDependencies += "io.micrometer" % "micrometer-registry-prometheus-simpleclient" % "1.10.5"
// https://mvnrepository.com/artifact/io.micrometer/micrometer-java21
// libraryDependencies += "io.micrometer" % "micrometer-java21" % "1.10.5"
//

// libraryDependencies += "io.micrometer" % "micrometer-core" % "1.14.4"
// libraryDependencies += "io.micrometer" % "micrometer-registry-prometheus" % "1.14.4"

// // https://mvnrepository.com/artifact/io.micrometer/micrometer-registry-prometheus-simpleclient
// libraryDependencies += "io.micrometer" % "micrometer-registry-prometheus-simpleclient" % "1.14.4"
// // https://mvnrepository.com/artifact/io.micrometer/micrometer-java21
// libraryDependencies += "io.micrometer" % "micrometer-java21" % "1.14.4"



// https://mvnrepository.com/artifact/com.softwaremill.sttp.tapir/tapir-server
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-server" % "1.11.16"
// https://mvnrepository.com/artifact/com.softwaremill.sttp.tapir/tapir-netty-server
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-netty-server" % "1.11.16"

// https://mvnrepository.com/artifact/com.softwaremill.sttp.tapir/tapir-sttp-client
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-sttp-client" % "1.11.16"
// https://mvnrepository.com/artifact/com.softwaremill.sttp.tapir/tapir-netty-server
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-netty-server" % "1.11.16"
// https://mvnrepository.com/artifact/com.softwaremill.sttp.tapir/tapir-sttp-stub-server
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-sttp-stub-server" % "1.11.16"
// https://mvnrepository.com/artifact/com.softwaremill.sttp.tapir/tapir-client
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-client" % "1.11.16"
// https://mvnrepository.com/artifact/com.softwaremill.sttp.tapir/tapir-prometheus-metrics
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-prometheus-metrics" % "1.11.16"
// https://mvnrepository.com/artifact/com.softwaremill.sttp.tapir/tapir-netty-server-sync
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-netty-server-sync" % "1.11.16"
// https://mvnrepository.com/artifact/com.softwaremill.sttp.tapir/sttp-mock-server
libraryDependencies += "com.softwaremill.sttp.tapir" %% "sttp-mock-server" % "1.11.16"
