package benchmark

import org.openjdk.jmh.annotations._
import sttp.client3._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.Throughput))
class PerformanceTest {
  private val client = HttpURLConnectionBackend()
  
  @Benchmark
  def testRootEndpoint(): sttp.model.StatusCode = {
    basicRequest
      .get(uri"http://localhost:8080")
      .send(client)
      .code
  }
}