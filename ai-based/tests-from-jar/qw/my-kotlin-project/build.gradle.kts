plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testRuntimeOnly("org.junit.platform:junit-platform-console:1.9.2")
    testImplementation("org.junit.platform:junit-platform-console-standalone:1.9.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    mainClass.set("com.example.AppKt")
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "com.example.AppKt",
            "Class-Path" to configurations.runtimeClasspath.get().joinToString(separator = " ") { it.name }
        )
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })
}