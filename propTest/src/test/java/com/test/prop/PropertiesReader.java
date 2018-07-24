package com.test.prop;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// http://www.baeldung.com/java-properties
public class PropertiesReader {

    Properties props01 = new Properties();
    Properties props02 = new Properties();
    Properties props03 = new Properties();
    Properties props04 = new Properties();

    public PropertiesReader() throws IOException {

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        String pathTestResources = rootPath + "pathTestResources.properties";
        props01.load(new FileInputStream(pathTestResources));

        // String pathTest = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "pathTopResources.properties";
        // props02.load(new FileInputStream(pathTest));

        // String pathTestResources2 = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "pathTestResources2.properties";
        // props03.load(new FileInputStream(pathTestResources2));

        // String pathTestResources2Resources3 = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "pathTestResources2Resources3.properties";
        // props04.load(new FileInputStream(pathTestResources2Resources3));
    }

    public String getProperty(String key) {
        return null == props01.getProperty(key) ? (null == props02.getProperty(key) ? (null == props03.getProperty(key) ? props04.getProperty(key) : props03.getProperty(key)) : props02.getProperty(key)) : props01.getProperty(key);
    }
}
