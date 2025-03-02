package com.example.client

import com.example.model.User
import com.example.util.UserGenerator
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ParallelRestApiClientTest extends AnyFlatSpec with Matchers {
  val client = new ParallelRestApiClient("http://localhost:8081")

  "ParallelRestApiClient" should "create users in parallel" in {
    val users = UserGenerator.generateUsers(10)
    val result = client.createUsersInParallel(users)
    // Await and validate result
  }
}