package com.example.model

import java.util.UUID

case class User(
  id: UUID,
  firstName: String,
  lastName: String,
  age: Int,
  position: String
)

object User {
  // Validation for firstName, lastName, and position
  def validateName(name: String): Option[String] = {
    if (name.nonEmpty && name.length <= 255) Some(name) else None
  }

  // Validation for age
  def validateAge(age: Int): Option[Int] = {
    if (age >= 18 && age <= 100) Some(age) else None
  }
}