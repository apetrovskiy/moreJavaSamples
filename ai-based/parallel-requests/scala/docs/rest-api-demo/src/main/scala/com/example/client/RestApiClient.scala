package com.example.client

import sttp.client3._
import sttp.client3.circe._
import io.circe.generic.auto._
import com.example.model.User
import com.example.util.Logger
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}

class RestApiClient(baseUrl: String) extends Logger {
  private val backend = HttpURLConnectionBackend()
  private val maxRetries = 3
  private val initialDelay = 1.second

  def createUser(user: User): Try[Unit] = {
    val request = basicRequest
      .post(uri"$baseUrl/users")
      .body(user)
      .contentType("application/json")
      .readTimeout(5.seconds)

    sendWithRetries(request, maxRetries, initialDelay)
  }

  private def sendWithRetries(request: Request[Either[String, String], Any], retries: Int, delay: Duration): Try[Unit] = {
    if (retries <= 0) {
      Failure(new RuntimeException("Max retries exceeded"))
    } else {
      val response = request.send(backend)
      response.body match {
        case Right(_) =>
          logger.info(s"User created successfully: ${user.id}")
          Success(())
        case Left(error) =>
          logger.error(s"Failed to create user: $error. Retrying in $delay...")
          Thread.sleep(delay.toMillis)
          sendWithRetries(request, retries - 1, delay * 2)
      }
    }
  }
}