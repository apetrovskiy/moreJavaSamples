import cats.effect.testing.scalatest.AsyncIOSpec
import org.http4s.client.Client
import org.http4s.ember.client.EmberClientBuilder
import org.scalatest.freespec.AsyncFreeSpec

class ServerSpec extends AsyncFreeSpec with AsyncIOSpec {
  "Server" - {
    "should respond to health check" in {
      EmberClientBuilder.default[IO].build.use { client =>
        Server.create(8080).use { server =>
          client.expect[String](s"http://${server.address}/health")
            .asserting(_ shouldBe "OK")
        }
      }
    }
  }
}