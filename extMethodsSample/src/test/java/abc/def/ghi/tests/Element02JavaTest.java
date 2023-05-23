package abc.def.ghi.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import abc.def.ghi.Element02;
import abc.def.ghi.Extensions02;

import org.junit.jupiter.api.Test;
import lombok.experimental.ExtensionMethod;
import lombok.val;

@ExtensionMethod({  Extensions02.class})
public class Element02JavaTest {
    @Test
    void element01AddThreeTest() {
        val element002 = new Element02("aaa");
        assertEquals("aaabbb", element002.addString("bbb"), "Does not equal 'aaabbb'");
        System.out.println(element002.addString("bbb"));
    }
}