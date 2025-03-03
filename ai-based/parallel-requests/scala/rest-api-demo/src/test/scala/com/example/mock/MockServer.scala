package com.example.mock

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock._
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.options
import com.example.model.User
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

object MockServer {
  private val wireMockServer = new WireMockServer(options().port(8081))
  private val objectMapper = new ObjectMapper().registerModule(DefaultScalaModule)

  def start(): Unit = {
    wireMockServer.start()
    configureFor("localhost", 8081)

    // Mock endpoint for creating users
    stubFor(post(urlEqualTo("/users"))
      .willReturn(aResponse()
        .withStatus(201)
        .withHeader("Content-Type", "application/json")
        .withBody("""{"status": "success"}""")))
  }

  def stop(): Unit = {
    wireMockServer.stop()
  }

  def simulateErrorScenarios(): Unit = {
    // Random delays
    stubFor(post(urlEqualTo("/users"))
      .willReturn(aResponse()
        .withFixedDelay(500) // 500ms delay
        .withStatus(201)
        .withBody("""{"status": "success"}""")))

    // Error response for every 10th user
    stubFor(post(urlEqualTo("/users"))
      .willReturn(aResponse()
        .withStatus(400)
        .withBody("""{"error": "Bad Request"}"""))
      .atPriority(1)
      .withRequestBody(matchingJsonPath("$.id")))
  }

  def simulateServerErrors(): Unit = {
    // Occasional server errors
    stubFor(post(urlEqualTo("/users"))
      .willReturn(aResponse()
        .withStatus(500)
        .withBody("""{"error": "Internal Server Error"}""")))
  }
}