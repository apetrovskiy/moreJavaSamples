package com.test.prop;

import java.io.IOException;

public class Starter {
    public static void main(String[] args)throws IOException {
        PropertiesReader reader = new PropertiesReader();
        System.out.println(reader.getProperty("key1"));
        System.out.println(reader.getProperty("key2"));
        System.out.println(reader.getProperty("key3"));
        System.out.println(reader.getProperty("\"key4\""));

        System.out.println(reader.getProperty("key5"));
        System.out.println(reader.getProperty("key6"));
        System.out.println(reader.getProperty("key7"));
        System.out.println(reader.getProperty("\"key8\""));

        System.out.println(reader.getProperty("key9"));
        System.out.println(reader.getProperty("key10"));
        System.out.println(reader.getProperty("key11"));
        System.out.println(reader.getProperty("\"key12\""));

        System.out.println(reader.getProperty("key13"));
        System.out.println(reader.getProperty("key14"));
        System.out.println(reader.getProperty("key15"));
        System.out.println(reader.getProperty("\"key16\""));
    }
}
