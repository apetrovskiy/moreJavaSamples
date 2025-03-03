package com.example.storage

import com.example.model.User
import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import scala.concurrent.Await
import scala.concurrent.duration._

class UserStorage(mongoUri: String) {
  private val client = MongoClient(mongoUri)
  private val database = client.getDatabase("user-db")
  private val collection = database.getCollection[User]("users")

  def saveUser(user: User): Unit = {
    Await.result(collection.insertOne(user).toFuture(), 10.seconds)
  }

  def getUserById(id: String): Option[User] = {
    val future = collection.find(equal("id", id)).first().toFuture()
    Await.result(future, 10.seconds) match {
      case user: User => Some(user)
      // case userDoc: Document => Some(userDoc)
      // case _ => None
      case null => None
    }
  }
}