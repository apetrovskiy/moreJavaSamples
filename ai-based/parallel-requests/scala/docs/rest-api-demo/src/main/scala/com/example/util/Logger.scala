package com.example.util

import org.slf4j.{Logger, LoggerFactory}

trait Logger {
  protected val logger: org.slf4j.Logger = LoggerFactory.getLogger(getClass)
}