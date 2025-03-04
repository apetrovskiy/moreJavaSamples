#!/bin/sh

java -cp build/libs/my-kotlin-project-1.0-SNAPSHOT.jar \
     org.junit.platform.console.ConsoleLauncher \
     --classpath build/classes/kotlin/test \
     --scan-classpath
