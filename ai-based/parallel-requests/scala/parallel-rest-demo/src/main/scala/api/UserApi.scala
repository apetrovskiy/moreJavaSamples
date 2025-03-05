package api

import cats.effect.IO
import org.http4s.HttpRoutes
import org.http4s.dsl.io._
import doobie.util.transactor.Transactor
import service.ParallelService
import org.http4s.circe.CirceEntityDecoder._
import io.circe.generic.auto._

class UserApi(xa: Transactor[IO]) {
  private val service = new ParallelService(xa)

  val routes: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case GET -> Root / "users" / IntVar(id) =>
      service.parallelQueries(List(id))
        .flatMap {
          case head :: Nil => Ok(head)
          case _ => NotFound()
        }

    case req @ POST -> Root / "batch-requests" =>
      req.as[List[Int]].flatMap { ids =>
        service.parallelQueries(ids)
          .flatMap(Ok(_))
      }
  }
}