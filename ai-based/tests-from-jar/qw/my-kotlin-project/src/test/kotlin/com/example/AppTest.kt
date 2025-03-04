package com.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.platform.console.ConsoleLauncher

class AppTest {

    @Test
    fun testGreet() {
        val app = App()
        assertEquals("Hello, World!", app.greet("World"))
    }
}