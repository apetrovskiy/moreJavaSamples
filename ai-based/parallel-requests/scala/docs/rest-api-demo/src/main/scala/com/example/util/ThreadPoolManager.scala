package com.example.util

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object ThreadPoolManager {
  private val checkInterval = 5.seconds

  def monitorAndAdjustThreadPool(): Future[Unit] = {
    Future {
      while (true) {
        val cpuUsage = SystemMetrics.getCpuUsage
        val memoryUsage = SystemMetrics.getMemoryUsage

        val currentThreads = ThreadPool.threadPool.getPoolSize
        val newThreads = calculateOptimalThreads(cpuUsage, memoryUsage, currentThreads)

        if (newThreads != currentThreads) {
          ThreadPool.threadPool.setCorePoolSize(newThreads)
          ThreadPool.threadPool.setMaximumPoolSize(newThreads)
        }

        Thread.sleep(checkInterval.toMillis)
      }
    }
  }

  private def calculateOptimalThreads(cpuUsage: Double, memoryUsage: Double, currentThreads: Int): Int = {
    if (cpuUsage > 0.8 || memoryUsage > 0.8) {
      currentThreads - 1
    } else if (cpuUsage < 0.5 && memoryUsage < 0.5) {
      currentThreads + 1
    } else {
      currentThreads
    }
  }
}