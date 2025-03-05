import cats.effect.IO
import com.dimafeng.testcontainers.PostgreSQLContainer
import org.scalatest.freespec.AsyncFreeSpec
import org.testcontainers.utility.DockerImageName

class DatabaseMigrationSpec extends AsyncFreeSpec {
  "Database migrations" - {
    "should apply successfully" in {
      val container = PostgreSQLContainer(
        dockerImageName = DockerImageName.parse("postgres:16")
      )
      
      container.start()
      
      try {
        Database.migrate(Database.Config(
          container.jdbcUrl,
          container.username,
          container.password,
          2
        )).attempt.asserting { result =>
          container.stop()
          assert(result.isRight)
        }
      } catch {
        case t: Throwable => 
          container.stop()
          throw t
      }
    }
  }
}