import cats.effect.IO
import cats.effect.unsafe.implicits.global
import doobie.implicits._
import doobie.postgres.implicits._
import doobie.util.transactor.Transactor
import org.scalatest.freespec.AsyncFreeSpec
import org.scalatest.matchers.should.Matchers
import service.ParallelService

class ParallelServiceSpec extends AsyncFreeSpec with Matchers {
  val testTransactor = Transactor.fromDriverManager[IO](
    driver = "org.postgresql.Driver",
    url = "jdbc:postgresql://localhost:5432/test",
    user = "postgres",
    password = "postgres"
  )
  
  "ParallelService" - {
    "should process queries in parallel" in {
      val service = new ParallelService(testTransactor)
      
      (for {
        _ <- sql"CREATE TEMPORARY TABLE users(id SERIAL PRIMARY KEY, name TEXT)".update.run.transact(testTransactor)
        _ <- sql"INSERT INTO users(name) VALUES ('Alice'), ('Bob')".update.run.transact(testTransactor)
        result <- service.parallelQueries(List(1, 2))
      } yield result).asserting { names =>
        names shouldBe List("Alice", "Bob")
      }
    }
  }
}