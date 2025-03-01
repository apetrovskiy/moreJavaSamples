package com.example.util

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry

object Metrics {
  private val registry: MeterRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT)

  val requestTimer: Timer = Timer.builder("api.requests")
    .description("Time taken to process API requests")
    .register(registry)

  def getMetrics: String = registry.scrape()
}