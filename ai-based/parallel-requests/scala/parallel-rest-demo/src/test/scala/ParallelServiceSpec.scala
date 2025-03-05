import cats.effect.IO
import doobie.implicits._
import doobie.util.transactor.Transactor
import org.scalatest.freespec.AsyncFreeSpec

class ParallelServiceSpec extends AsyncFreeSpec {
  val testTransactor = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver",
    "jdbc:postgresql://localhost:5432/test",
    "postgres",
    "postgres"
  )
  
  "ParallelService" - {
    "should process queries in parallel" in {
      val service = new ParallelService(testTransactor)
      
      (for {
        _ <- sql"CREATE TEMPORARY TABLE users(id SERIAL PRIMARY KEY, name TEXT)"
          .update.run.transact(testTransactor)
        _ <- sql"INSERT INTO users(name) VALUES ('Alice'), ('Bob')"
          .update.run.transact(testTransactor)
        result <- service.parallelQueries(List(1, 2))
      } yield result).asserting { names =>
        assert(names == List("Alice", "Bob"))
      }
    }
  }
}