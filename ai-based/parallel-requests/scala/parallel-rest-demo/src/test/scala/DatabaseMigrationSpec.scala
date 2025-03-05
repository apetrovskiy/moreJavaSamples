import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import com.dimafeng.testcontainers.PostgreSQLContainer
import org.scalatest.freespec.AsyncFreeSpec
import org.testcontainers.utility.DockerImageName
import cats.effect.unsafe.implicits.global
import doobie.implicits._
import org.scalatest.matchers.should.Matchers

class DatabaseMigrationSpec extends AsyncFreeSpec with AsyncIOSpec {
  "Database migrations" - {
    "should apply successfully" in {
      val container = PostgreSQLContainer.Def(
        dockerImageName = DockerImageName.parse("postgres:16")
      ).createContainer()
      
      container.start()
      
      Database.migrate(Database.Config(
        container.jdbcUrl,
        container.username,
        container.password,
        2
      )).attempt.asserting { result =>
        container.stop()
        assert(result.isRight)
      }
    }
  }
}