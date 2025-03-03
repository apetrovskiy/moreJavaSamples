package com.example.util

import net.datafaker.Faker
import com.example.model.User
import java.util.UUID
import com.example.util.Logger

object UserGenerator extends Logger {
  private val faker = new Faker()

  def generateUser(): User = {
    User(
      id = UUID.randomUUID(),
      firstName = faker.name().firstName(),
      lastName = faker.name().lastName(),
      age = faker.number().numberBetween(18, 100),
      position = faker.job().title()
    )
  }

  def generateUsers(count: Int): List[User] = {
    logger.info(s"Generating $count users...")
    val users = (1 to count).map(_ => generateUser()).toList
    logger.info(s"Generated ${users.size} users.")
    users
  }
}