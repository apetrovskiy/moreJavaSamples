#!/bin/bash
set -e

# Unit tests
sbt test

# Integration tests
sbt it:test

# Start server (for manual testing)
sbt "runMain com.example.Main"
