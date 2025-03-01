plugins {
    scala
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.scala-lang:scala3-library_3:3.3.0")
    implementation("ch.qos.logback:logback-classic:1.4.7") // Logging
    testImplementation("org.scalatest:scalatest_3:3.2.15") // Testing
}

application {
    mainClass.set("com.example.Main")
}