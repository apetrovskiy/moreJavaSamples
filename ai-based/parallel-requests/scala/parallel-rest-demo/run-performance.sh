#!/bin/bash
sbt -Dgatling.core.directory.binaries="src/test/scala" "gatling:test"