package com.example

import com.example.client.ParallelRestApiClient
import com.example.model.User
import com.example.util.{Metrics, ThreadPool, ThreadPoolManager, UserGenerator}
import sttp.tapir._
import sttp.tapir.server.netty.NettyServerInterpreter
import scala.concurrent.Future

object Main extends App {
  implicit val ec = ThreadPool.executionContext

  // Start thread pool monitoring
  ThreadPoolManager.monitorAndAdjustThreadPool()

  // Create users in parallel
  val users = UserGenerator.generateUsers(100)
  val client = new ParallelRestApiClient("http://localhost:8081")
  client.createUsersInParallel(users)

  // Expose metrics endpoint
  val metricsEndpoint = endpoint.get.in("metrics").out(stringBody).serverLogicSuccess(_ => Future.successful(Metrics.getMetrics))
  NettyServerInterpreter().toHandler(List(metricsEndpoint)).start()
}