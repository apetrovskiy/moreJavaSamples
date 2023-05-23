package abc.def.ghi.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import abc.def.ghi.Element01;
import abc.def.ghi.Extensions01;

import org.junit.jupiter.api.Test;
import lombok.experimental.ExtensionMethod;
import lombok.val;

@ExtensionMethod({  Extensions01.class})
public class Element01JavaTest {
     @Test
     void element01AddTwoTest() {
        val element001 = new Element01(2);
        assertEquals(4, element001.addTwo(), "Does not equal 4");
        System.out.println(element001.addTwo());
    }

    @Test
    void element01AddThreeTest() {
        val element001 = new Element01(3);
        assertEquals(6, element001.addNumber(3), "Does not equal 6");
        System.out.println(element001.addNumber(3));
    }
}