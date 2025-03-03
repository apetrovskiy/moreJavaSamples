package com.example

import akka.actor.ActorSystem
import com.example.config.AppConfig
import com.example.api.UserApi
import com.example.repository.{DatabaseFactory, UserRepository}
import sttp.tapir.server.akkahttp.AkkaHttpServerInterpreter
import scala.util.{Success, Failure}

object Main extends App {
  implicit val system: ActorSystem = ActorSystem("RestApiSystem")
  import system.dispatcher
  
  val config = AppConfig.load()
  val userRepository = DatabaseFactory.createRepository(config.database)
  
  // Initialize database
  DatabaseFactory.initialize(userRepository)

  // Start server
  val server = AkkaHttpServerInterpreter()
    .toRoute(UserApi.endpoints(userRepository))
    .bind(config.server.port)

  server.onComplete {
    case Success(binding) =>
      println(s"Server online at ${binding.localAddress}")
      sys.addShutdownHook {
        binding.unbind()
        system.terminate()
        DatabaseFactory.cleanup(userRepository)
      }
    case Failure(ex) =>
      println(s"Failed to bind: ${ex.getMessage}")
      system.terminate()
  }
}