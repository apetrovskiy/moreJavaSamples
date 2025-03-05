package service

import cats.effect.IO
import cats.implicits._
import doobie.implicits._
import doobie.util.transactor.Transactor

class ParallelService(xa: Transactor[IO]) {
  def parallelQueries(ids: List[Int]): IO[List[String]] = 
    ids.parTraverse { id =>
      sql"SELECT name FROM users WHERE id = $id"
        .query[String]
        .option
        .transact(xa)
        .map(_.getOrElse("Unknown"))
    }
}