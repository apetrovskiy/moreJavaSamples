// UserStorageTest.scala
package com.example.storage

import com.example.model.User
import com.example.util.UserGenerator
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import de.flapdoodle.embed.mongo.{MongodStarter, MongodExecutable}
import de.flapdoodle.embed.mongo.config.{MongodConfig, Net}
import de.flapdoodle.embed.process.runtime.Network

class UserStorageTest extends AnyFlatSpec with Matchers with BeforeAndAfterAll {
  private var mongodExecutable: MongodExecutable = _
  private val mongoUri = "mongodb://localhost:27017"

  override def beforeAll(): Unit = {
    val starter = MongodStarter.getDefaultInstance()
    val mongodConfig = MongodConfig.builder()
      .version(de.flapdoodle.embed.mongo.distribution.Version.Main.V4_4)
      .net(new Net("localhost", 27017, Network.localhostIsIPv6()))
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