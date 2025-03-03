package com.example

import org.scalatest._
import com.dimafeng.testcontainers._
import org.testcontainers.containers.MockServerContainer
import sttp.client3._
import com.example.models.User

class UserSpec extends AnyFlatSpec with BeforeAndAfterAll with TestContainerForAll {
  override val containerDef = MockServerContainer.Def()

  "User API" should "create users" in withContainers { container =>
    implicit val backend = HttpURLConnectionBackend()
    val client = new ParallelClient(backend)
    
    val testUser = User(
      firstName = "John",
      lastName = "Doe",
      position = "Developer",
      age = 30
    )

    val result = client.createUsersParallel(List(testUser))
    assert(result.isCompleted)
  }
}