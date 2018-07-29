package com.test.kko;

/**
 * Created by apetr on 29.07.2018.
 */
public class SomeReader {
    private final String data = "asdfasdfasdfagewertewreergewr";
    private static int counter = 0;

    public int getCounter(){
        return counter;
    }

    public void read(){
        System.out.println("reading.....");
        counter++;
        System.out.println(counter);
    }
}
