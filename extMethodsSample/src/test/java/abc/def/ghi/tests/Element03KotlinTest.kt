package abc.def.ghi.tests

import org.junit.jupiter.api.Assertions.assertEquals;
import abc.def.ghi.Element03
import abc.def.ghi.addNumber

import org.junit.jupiter.api.Test

class Element03KotlinTest {
    @Test
    fun element03AddThreeTest() {
        val element003 = Element03(3);
        assertEquals(6, element003.addNumber(3), "Does not equal 6");
        println(element003.addNumber(3));
    }
}