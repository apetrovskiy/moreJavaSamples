package com.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExampleTest {
    @Test
    fun testAdd() {
        val example = Example()
        assertEquals(3, example.add(1, 2))
    }
}