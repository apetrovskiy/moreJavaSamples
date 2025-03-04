#!/bin/sh

./gradlew downloadJUnitConsole
./gradlew jar
java -jar build/libs/junit-platform-console-standalone-1.9.0.jar --classpath build/libs/my-kotlin-project-1.0-SNAPSHOT.jar --select-package com.example
