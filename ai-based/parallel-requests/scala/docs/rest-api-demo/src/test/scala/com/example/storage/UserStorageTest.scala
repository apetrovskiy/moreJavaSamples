package com.example.storage

import com.example.model.User
import com.example.util.UserGenerator
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import de.flapdoodle.embed.mongo.MongodExecutable
import de.flapdoodle.embed.mongo.MongodStarter
import de.flapdoodle.embed.mongo.config.MongodConfig
import de.flapdoodle.embed.mongo.config.Net

class UserStorageTest extends AnyFlatSpec with Matchers with BeforeAndAfterAll {
  private var mongodExecutable: MongodExecutable = _
  private val mongoUri = "mongodb://localhost:27017"

  override def beforeAll(): Unit = {
    val starter = MongodStarter.getDefaultInstance
    val mongodConfig = MongodConfig.builder()
      .net(new Net("localhost", 27017, false))
      .build()
    mongodExecutable = starter.prepare(mongodConfig)
    mongodExecutable.start()
  }

  override def afterAll(): Unit = {
    mongodExecutable.stop()
  }

  "UserStorage" should "save and retrieve a user" in {
    val storage = new UserStorage(mongoUri)
    val user = UserGenerator.generateUser()
    storage.saveUser(user)
    val retrievedUser = storage.getUserById(user.id.toString)
    retrievedUser shouldBe Some(user)
  }
}