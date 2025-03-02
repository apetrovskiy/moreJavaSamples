plugins {
    scala
    application
    id("com.github.johnrengelman.shadow") version("8.1.1")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.scala-lang:scala3-library_3:3.3.5")
    implementation("ch.qos.logback:logback-classic:1.5.17")
    implementation("net.datafaker:datafaker:2.4.2")
    testImplementation("org.wiremock:wiremock:3.12.0")
    testImplementation("com.h2database:h2:2.3.232")
    implementation("com.fasterxml.jackson.module:jackson-module-scala_3:2.18.2")
    implementation("com.softwaremill.sttp.client3:core_3:3.10.3")
    implementation("com.softwaremill.sttp.client3:circe_3:3.10.3")
    implementation("io.circe:circe-generic_3:0.14.10")
    implementation("org.mongodb.scala:mongo-scala-driver_2.13:5.3.1")
    implementation("com.typesafe:config:1.4.3")
    implementation("org.scala-lang.modules:scala-parallel-collections_3:1.2.0")
    // implementation("io.micrometer:micrometer-core:1.14.4")
    // implementation("io.micrometer:micrometer-registry-prometheus:1.14.4")
    implementation("com.softwaremill.sttp.tapir:tapir-core_3:1.11.16")
    implementation("com.softwaremill.sttp.tapir:tapir-netty-server_3:1.11.16")
    // implementation("com.softwaremill.sttp.tapir:tapir-prometheus-metrics_3:1.11.16")
    testImplementation("org.scalatest:scalatest_3:3.2.19")
    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo:4.18.1")
    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo:4.18.1")
    testImplementation("org.slf4j:slf4j-simple:2.0.17") // this to avoid SLF4J warnings
}

application {
    mainClass.set("com.example.Main")
}

shadowJar {
    archiveBaseName.set("rest-api-demo")
    archiveVersion.set("0.1.0")
    mergeServiceFiles()
}