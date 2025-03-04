plugins {
    kotlin("jvm") version "1.7.20" // Use the latest Kotlin version
    java
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks {
    test {
        useJUnitPlatform()
    }

    jar {
        manifest {
            attributes["Main-Class"] = "com.example.ExampleKt"
        }
        from(sourceSets.main.get().output)

        dependsOn(configurations.runtimeClasspath)
        from({
            configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
        })
    }
}

tasks.register("downloadJUnitConsole") {
    doLast {
        val junitConsoleVersion = "1.9.0"
        val url = "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$junitConsoleVersion/junit-platform-console-standalone-$junitConsoleVersion.jar"
        val destination = File("$buildDir/libs/junit-platform-console-standalone-$junitConsoleVersion.jar")

        destination.parentFile.mkdirs()
        ant.invokeMethod("get", mapOf("src" to url, "dest" to destination))
        println("JUnit Platform Console Standalone downloaded to: ${destination.absolutePath}")
    }
}