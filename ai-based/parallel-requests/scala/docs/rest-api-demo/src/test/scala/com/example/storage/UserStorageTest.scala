package com.example.storage

import com.example.model.User
import com.example.util.UserGenerator
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class UserStorageTest extends AnyFlatSpec with Matchers with BeforeAndAfterAll {
  val storage = new UserStorage("mongodb://localhost:27017")

  override def beforeAll(): Unit = {
    // Initialize MongoDB
  }

  override def afterAll(): Unit = {
    // Clean up MongoDB
  }

  "UserStorage" should "save and retrieve a user" in {
    val user = UserGenerator.generateUser()
    storage.saveUser(user)
    val retrievedUser = storage.getUserById(user.id.toString)
    retrievedUser shouldBe Some(user)
  }
}