package com.example.util

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class UserGeneratorTest extends AnyFlatSpec with Matchers {
  "UserGenerator.generateUser" should "generate a valid user" in {
    val user = UserGenerator.generateUser()
    user.firstName should not be empty
    user.lastName should not be empty
    user.age should (be >= 18 and be <= 100)
    user.position should not be empty
  }

  "UserGenerator.generateUsers" should "generate the correct number of users" in {
    val users = UserGenerator.generateUsers(10)
    users.size shouldBe 10
  }
}