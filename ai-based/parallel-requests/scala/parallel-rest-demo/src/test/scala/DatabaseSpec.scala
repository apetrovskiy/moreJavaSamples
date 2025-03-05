import com.dimafeng.testcontainers.PostgreSQLContainer
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.BeforeAndAfterAll
import java.sql.DriverManager
import cats.effect.IO
import cats.effect.unsafe.implicits.global
import doobie.implicits._
import org.scalatest.matchers.should.Matchers

class DatabaseSpec extends AnyFlatSpec with BeforeAndAfterAll {
  private val container = PostgreSQLContainer()
  
  override def beforeAll(): Unit = {
    super.beforeAll()
    container.start()
  }

  override def afterAll(): Unit = {
    container.stop()
    super.afterAll()
  }

  "PostgreSQL container" should "be available" in {
    val conn = DriverManager.getConnection(
      container.jdbcUrl,
      container.username,
      container.password
    )
    
    val stmt = conn.createStatement()
    val rs = stmt.executeQuery("SELECT 1")
    assert(rs.next())
    conn.close()
  }
}