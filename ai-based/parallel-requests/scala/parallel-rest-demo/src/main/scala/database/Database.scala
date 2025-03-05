import cats.effect._
import doobie.hikari.HikariTransactor
import doobie.util.ExecutionContexts
import org.flywaydb.core.Flyway

object Database {
  case class Config(
    url: String, 
    user: String, 
    password: String, 
    poolSize: Int
  )

  def transactor(config: Config): Resource[IO, HikariTransactor[IO]] =
    for {
      ce <- ExecutionContexts.fixedThreadPool[IO](config.poolSize)
      xa <- HikariTransactor.newHikariTransactor[IO](
        "org.postgresql.Driver",
        config.url,
        config.user,
        config.password,
        ce
      )
    } yield xa

  def migrate(config: Config): IO[Unit] = IO {
    Flyway.configure()
      .dataSource(config.url, config.user, config.password)
      .load()
      .migrate()
  }.void
}