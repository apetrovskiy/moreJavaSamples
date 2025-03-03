package com.example.client

import sttp.client3._
import sttp.tapir.client.sttp.SttpClientInterpreter
import com.example.api.UserApi
import com.example.models.User
import scala.concurrent.{ExecutionContext, Future}

class ParallelClient(backend: SttpBackend[Future, Any]) {
  private val client = SttpClientInterpreter().toClient(UserApi.createUserEndpoint, None, backend)

  def createUsersParallel(users: List[User])(implicit ec: ExecutionContext): Future[List[Either[String, User]]] = {
    val futures = users.map { user =>
      client(user).map {
        case Right(created) => Right(created)
        case Left(err) => Left(s"Failed: $err")
      }.recover {
        case ex => Left(s"Exception: ${ex.getMessage}")
      }
    }
    
    Future.sequence(futures)
  }
}