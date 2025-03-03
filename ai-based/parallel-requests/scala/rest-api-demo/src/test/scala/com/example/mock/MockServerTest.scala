package com.example.mock

import com.example.model.User
import com.example.util.UserGenerator
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MockServerTest extends AnyFlatSpec with Matchers with BeforeAndAfterAll {
  override def beforeAll(): Unit = {
    MockServer.start()
    MockServer.simulateErrorScenarios()
    MockServer.simulateServerErrors()
  }

  override def afterAll(): Unit = {
    MockServer.stop()
  }

  "MockServer" should "return success for valid user creation" in {
    val user = UserGenerator.generateUser()
    // Send POST request to /users and validate response
  }

  it should "return error for every 10th user" in {
    val users = UserGenerator.generateUsers(10)
    // Send POST requests and validate error response for the 10th user
  }

  it should "simulate server errors" in {
    // Send POST requests and validate occasional server errors
  }
}