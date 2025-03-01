package com.example.client

import com.example.model.User
import com.example.util.{Logger, ThreadPool}
import scala.concurrent.Future
import scala.util.{Failure, Success}

class ParallelRestApiClient(baseUrl: String) extends Logger {
  private val restApiClient = new RestApiClient(baseUrl)

  def createUsersInParallel(users: List[User]): Future[Unit] = {
    val futures = users.map { user =>
      Future {
        restApiClient.createUser(user) match {
          case Success(_) => logger.info(s"User created successfully: ${user.id}")
          case Failure(e) => logger.error(s"Failed to create user: ${user.id}, Error: ${e.getMessage}")
        }
      }
    }

    Future.sequence(futures).map(_ => ())
  }
}