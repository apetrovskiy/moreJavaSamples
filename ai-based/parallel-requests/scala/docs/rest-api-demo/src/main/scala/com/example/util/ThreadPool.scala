package com.example.util

import java.util.concurrent.{Executors, ThreadPoolExecutor, TimeUnit}
import scala.concurrent.ExecutionContext

object ThreadPool {
  private val minThreads = sys.env.getOrElse("MIN_THREADS", "1").toInt
  private val maxThreads = sys.env.getOrElse("MAX_THREADS", "10").toInt

  private val threadPool = Executors.newCachedThreadPool().asInstanceOf[ThreadPoolExecutor]
  threadPool.setCorePoolSize(minThreads)
  threadPool.setMaximumPoolSize(maxThreads)

  implicit val executionContext: ExecutionContext = ExecutionContext.fromExecutorService(threadPool)

  def shutdown(): Unit = {
    threadPool.shutdown()
    threadPool.awaitTermination(10, TimeUnit.SECONDS)
  }
}