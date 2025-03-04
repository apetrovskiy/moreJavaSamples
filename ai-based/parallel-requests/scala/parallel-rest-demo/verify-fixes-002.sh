#!/bin/bash
set -e

rm -rf project/target project/project target
sbt clean reload
./run-performance.sh
