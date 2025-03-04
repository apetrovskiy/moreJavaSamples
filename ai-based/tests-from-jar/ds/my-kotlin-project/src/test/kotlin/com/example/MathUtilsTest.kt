package com.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MathUtilsTest {

    @Test
    fun testAdd() {
        val mathUtils = MathUtils()
        assertEquals(5, mathUtils.add(2, 3))
    }
}