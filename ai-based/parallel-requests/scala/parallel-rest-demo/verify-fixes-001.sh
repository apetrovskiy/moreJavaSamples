#!/bin/bash
set -e

rm -rf project/target project/project target
sbt reload
./run-performance.sh
