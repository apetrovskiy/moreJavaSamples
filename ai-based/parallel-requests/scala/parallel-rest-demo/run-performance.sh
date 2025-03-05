#!/bin/bash

# sbt 'Jmh/run -i 3 -wi 3 -f1 -t1 .*PerformanceTest'
# Performance tests
sbt benchmark