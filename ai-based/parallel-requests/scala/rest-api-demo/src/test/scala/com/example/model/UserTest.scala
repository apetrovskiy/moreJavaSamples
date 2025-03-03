package com.example.model

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class UserTest extends AnyFlatSpec with Matchers {
  "User.validateName" should "accept valid names" in {
    User.validateName("John") shouldBe Some("John")
    User.validateName("A".repeat(255)) shouldBe Some("A".repeat(255))
  }

  it should "reject invalid names" in {
    User.validateName("") shouldBe None
    User.validateName("A".repeat(256)) shouldBe None
  }

  "User.validateAge" should "accept valid ages" in {
    User.validateAge(18) shouldBe Some(18)
    User.validateAge(100) shouldBe Some(100)
  }

  it should "reject invalid ages" in {
    User.validateAge(17) shouldBe None
    User.validateAge(101) shouldBe None
  }
}