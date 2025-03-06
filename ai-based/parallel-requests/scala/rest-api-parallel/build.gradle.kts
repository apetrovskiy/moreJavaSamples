plugins {
    scala
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.softwaremill.sttp.client3:core_3:3.8.11")
    implementation("com.softwaremill.sttp.client3:httpclient-backend_3:3.8.11")
    implementation("com.typesafe.scala-logging:scala-logging_3:3.9.5")
    implementation("ch.qos.logback:logback-classic:1.4.7")
    testImplementation("org.scalamock:scalamock_3:5.2.0")
}