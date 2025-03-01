package com.example.util

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MetricsTest extends AnyFlatSpec with Matchers {
  "Metrics" should "record request latency" in {
    val timer = Metrics.requestTimer
    timer.record(100, TimeUnit.MILLISECONDS)
    timer.count() shouldBe 1
  }
}