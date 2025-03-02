package com.example

import com.example.client.ParallelRestApiClient
import com.example.model.User
import com.example.util.{ThreadPool, ThreadPoolManager, UserGenerator}
import sttp.tapir.server.netty.{NettyFutureServer}
import scala.concurrent.ExecutionContext

object Main extends App {
  implicit val ec: ExecutionContext = ThreadPool.executionContext

  // Start thread pool monitoring
  ThreadPoolManager.monitorAndAdjustThreadPool()

  // Create users in parallel
  val users = UserGenerator.generateUsers(100)
  val client = new ParallelRestApiClient("http://localhost:8081")
  client.createUsersInParallel(users)

  // Start the server (metrics temporarily disabled)
  NettyFutureServer()
    .port(8080)
    .start()
}