package com.test.kko;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

/**
 * Created by apetr on 29.07.2018.
 */
public class DepInj02Tests {
    // private final SomeReader reader;

    /*
    public DepInj02Tests(SomeReader readerParam){
        reader = readerParam;
    }

    @Test
    public void test0001(){
        reader.read();
        reader.getCounter();
    }

    @Test
    public void test0002(SomeReader readerParam){
        readerParam.read();
        readerParam.getCounter();
    }
    */

    @Test
    public void test0003(TestInfo testInfo){
        System.out.println(testInfo.getDisplayName());
    }

    @Test
    public void test0004(TestReporter testReporter){
        testReporter.publishEntry("aaa", "bbb");
    }
}