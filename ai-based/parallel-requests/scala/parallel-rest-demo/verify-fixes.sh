#!/bin/bash
set -e

rm -rf project/target target it/target
sbt clean test it/test
