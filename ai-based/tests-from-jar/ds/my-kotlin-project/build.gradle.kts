plugins {
    kotlin("jvm") version "1.8.0" // Kotlin version 1.8.0
    id("java")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11 // Java 11
    targetCompatibility = JavaVersion.VERSION_11 // Java 11
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "11" // Target JVM version for Kotlin compilation
    }
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.example.MathUtilsKt"
    }
    from(sourceSets.main.get().output)
    archiveClassifier.set("all")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}