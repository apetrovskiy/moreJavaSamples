#!/bin/bash
docker-compose -f docker/docker-compose.yml up -d wiremock
echo "WireMock running at http://localhost:8081"