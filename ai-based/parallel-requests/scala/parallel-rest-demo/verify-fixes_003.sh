#!/bin/bash
set -e

rm -rf project/target target it/target
sbt clean test

# Unit tests
sbt test

# Integration tests
sbt it:test

# Start server (for manual testing)
sbt "runMain com.example.Main"
