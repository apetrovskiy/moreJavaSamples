import scala.concurrent.Future
import scala.util.{Failure, Success}

object ParallelExecution {
  def createUsers(users: List[User]): Unit = {
    val futures = users.map { user =>
      Future {
        val result = RestApiClient.createUser(user)
        result match {
          case Right(u) => println(s"[Thread ${Thread.currentThread().getId}] Created user: $u")
          case Left(e) => println(s"[Thread ${Thread.currentThread().getId}] Error: $e")
        }
      }
    }

    Future.sequence(futures).onComplete {
      case Success(_) => println("All users created.")
      case Failure(ex) => println(s"Error: ${ex.getMessage}")
    }
  }
}