import sttp.client3._

object RestApiClient {
  val backend = HttpClientSyncBackend()

  def createUser(user: User): Either[String, User] = {
    val request = basicRequest
      .post(uri"http://wiremock:8080/users")
      .body(user)
      .response(asJson[User])

    val response = request.send(backend)
    if (response.code.isSuccess) response.body match {
      case Right(u) => Right(u)
      case Left(e) => Left(e)
    } else Left(response.body.toString)
  }
}