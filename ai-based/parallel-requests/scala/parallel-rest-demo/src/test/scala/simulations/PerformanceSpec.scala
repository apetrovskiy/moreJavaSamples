import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {
  val httpProtocol = http
    .baseUrl("http://localhost:8080")
    .acceptHeader("application/json")

  val scn = scenario("Basic Simulation")
    .exec(http("root_endpoint")
    .get("/"))

  setUp(
    scn.inject(
      constantUsersPerSec(10).during(15.seconds)
    )
  ).protocols(httpProtocol)
}