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
<<<<<<< HEAD

        // String pathTest = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "pathTopResources.properties";
        // props02.load(new FileInputStream(pathTest));
=======
/*
        String pathTest = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "pathTopResources.properties";
        props02.load(new FileInputStream(pathTest));
>>>>>>> 5bc2e9da49b4f23dcdf685f7c2ec3a072c4c004d

        // String pathTestResources2 = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "pathTestResources2.properties";
        // props03.load(new FileInputStream(pathTestResources2));

<<<<<<< HEAD
        // String pathTestResources2Resources3 = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "pathTestResources2Resources3.properties";
        // props04.load(new FileInputStream(pathTestResources2Resources3));
=======
        String pathTestResources2Resources3 = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "pathTestResources2Resources3.properties";
        props04.load(new FileInputStream(pathTestResources2Resources3));
        */
>>>>>>> 5bc2e9da49b4f23dcdf685f7c2ec3a072c4c004d
    }

    public String getProperty(String key) {
        return null == props01.getProperty(key) ? (null == props02.getProperty(key) ? (null == props03.getProperty(key) ? props04.getProperty(key) : props03.getProperty(key)) : props02.getProperty(key)) : props01.getProperty(key);
    }
}
