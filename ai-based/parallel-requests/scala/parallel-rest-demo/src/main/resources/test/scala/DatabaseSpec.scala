import com.dimafeng.testcontainers.ScalaTestContainer
import com.dimafeng.testcontainers.PostgreSQLContainer
import org.scalatest.flatspec.AnyFlatSpec
import java.sql.DriverManager

class DatabaseSpec extends AnyFlatSpec with ScalaTestContainer {
  override val containerDef = PostgreSQLContainer.Def()

  "PostgreSQL container" should "be available" in withContainers { postgres =>
    val conn = DriverManager.getConnection(
      postgres.jdbcUrl,
      postgres.username,
      postgres.password
    )
    
    val stmt = conn.createStatement()
    val rs = stmt.executeQuery("SELECT 1")
    assert(rs.next())
    conn.close()
  }
}