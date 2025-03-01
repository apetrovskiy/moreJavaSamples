package com.example.util

import com.typesafe.config.ConfigFactory

object Config {
  private val config = ConfigFactory.load()

  val storageType: String = config.getString("storage.type")
  val mongoUri: String = config.getString("storage.mongodb.uri")
}