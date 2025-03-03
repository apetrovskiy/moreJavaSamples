package com.example.client

import com.example.model.User
import com.example.util.UserGenerator
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.example.mock.MockServer

class RestApiClientTest extends AnyFlatSpec with Matchers with BeforeAndAfterAll {
  val client = new RestApiClient("http://localhost:8081")

  override def beforeAll(): Unit = {
    MockServer.start()
    MockServer.simulateErrorScenarios()
  }

  override def afterAll(): Unit = {
    MockServer.stop()
  }

  "RestApiClient" should "create a user successfully" in {
    val user = UserGenerator.generateUser()
    val result = client.createUser(user)
    result.isSuccess shouldBe true
  }
}