// package com.example.util

// import io.micrometer.prometheus.{PrometheusConfig, PrometheusMeterRegistry}
// import io.micrometer.core.instrument.{MeterRegistry, Timer}

// object Metrics {
//   private val registry: PrometheusMeterRegistry = 
//     new PrometheusMeterRegistry(PrometheusConfig.DEFAULT)

//   val requestTimer: Timer = Timer.builder("api.requests")
//     .description("Time taken to process API requests")
//     .register(registry)

//   def getMetrics: String = registry.scrape()
// }