#!/bin/bash

# Build and run
sbt clean stage
docker-compose -f docker/docker-compose.yml up --build

# Run tests
sbt test

# Performance test
k6 run --vus 10 --duration 30s src/test/k6/load-test.js