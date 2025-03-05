import cats.effect.{IO, Resource}
import com.comcast.ip4s._
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.Server
import org.http4s.HttpRoutes
import org.http4s.dsl.io._

object Server {
  def create(port: Port): Resource[IO, Server] = {
    val routes = HttpRoutes.of[IO] {
      case GET -> Root / "health" => Ok("OK")
    }

    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"0.0.0.0")
      .withPort(port)
      .withHttpApp(routes.orNotFound)
      .build
  }
}