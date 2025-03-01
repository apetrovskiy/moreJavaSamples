package com.example.client

import com.example.model.User
import com.example.util.UserGenerator
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RestApiClientTest extends AnyFlatSpec with Matchers {
  val client = new RestApiClient("http://localhost:8081")

  "RestApiClient" should "create a user successfully" in {
    val user = UserGenerator.generateUser()
    val result = client.createUser(user)
    result.isSuccess shouldBe true
  }

  it should "handle retries on failure" in {
    // Test retry logic with a failing request
  }
}