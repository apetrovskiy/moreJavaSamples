package com.test.gjunit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class MyTests {

    @Test
    public void simpleTest(){
        int i = 1;
        int j = 2;
        System.out.println("simple test");
        assertTrue(i <= j);
    }


    @ParameterizedTest
    @ValueSource(strings = { "aaa", "bbb", "ccc" })
    public void paramTest(String word) {
        System.out.println("parameterized test: " + word);
        assertTrue("aaabbb".contains(word));
    }

}
