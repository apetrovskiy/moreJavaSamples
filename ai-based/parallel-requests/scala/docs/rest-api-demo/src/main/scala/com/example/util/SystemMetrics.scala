package com.example.util

import java.lang.management.ManagementFactory
import com.sun.management.OperatingSystemMXBean

object SystemMetrics {
  private val osBean = ManagementFactory.getOperatingSystemMXBean.asInstanceOf[OperatingSystemMXBean]

  def getCpuUsage: Double = osBean.getCpuLoad
  def getMemoryUsage: Double = {
    val totalMemory = osBean.getTotalMemorySize
    val freeMemory = osBean.getFreeMemorySize
    (totalMemory - freeMemory).toDouble / totalMemory
  }
}