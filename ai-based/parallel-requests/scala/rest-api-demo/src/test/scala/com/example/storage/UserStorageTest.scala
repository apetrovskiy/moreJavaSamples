package com.example.storage

import com.example.model.User
import com.example.util.UserGenerator
import de.flapdoodle.embed.mongo.config.{MongodConfig, Net}
import de.flapdoodle.embed.mongo.distribution.Version
import de.flapdoodle.embed.mongo.{MongodProcess, MongodStarter}
import de.flapdoodle.embed.process.runtime.Network
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class UserStorageTest extends AnyFlatSpec with Matchers with BeforeAndAfterAll {
  private var mongodProcess: MongodProcess = _
  private val mongoUri = "mongodb://localhost:27017"

  override def beforeAll(): Unit = {
    val starter = MongodStarter.getDefaultInstance
    val mongodConfig = MongodConfig.builder()
      .version(Version.Main.V7_0)
      .net(new Net("localhost", 27017, Network.localhostIsIPv6()))
      .build()

    mongodProcess = starter.prepare(mongodConfig).start()
  }

  override def afterAll(): Unit = {
    mongodProcess.stop()
  }

  "UserStorage" should "save and retrieve a user" in {
    val storage = new UserStorage(mongoUri)
    val user = UserGenerator.generateUser()
    storage.saveUser(user)
    val retrievedUser = storage.getUserById(user.id.toString)
    retrievedUser shouldBe Some(user)
  }
}