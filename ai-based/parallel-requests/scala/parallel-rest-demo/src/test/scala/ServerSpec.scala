import cats.effect.unsafe.implicits.global
import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import com.comcast.ip4s._
import org.http4s.client.Client
import org.http4s.ember.client.EmberClientBuilder
import org.scalatest.freespec.AsyncFreeSpec
import org.scalatest.matchers.should.Matchers

class ServerSpec extends AsyncFreeSpec with AsyncIOSpec with Matchers {
  "Server" - {
    "should respond to health check" in {
      EmberClientBuilder.default[IO].build.use { client =>
        Server.create(port"8080").use { server =>
          client.expect[String](s"http://${server.address}/health")
            .asserting(_ shouldBe "OK")
        }
      }
    }
  }
}