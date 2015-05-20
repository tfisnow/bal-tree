package com.generic.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private static final Properties PROPERTY = new Properties();
    private static final String APPLICATIONPROPERTIESPATH = "/src/test/resources/com/test/properties/";
        
    private PropertyManager() {
    }
  
    public static Properties loadApplicationPropertyFile(){
        try {
            PROPERTY.load(new FileInputStream(System.getProperty("user.dir")
                    + APPLICATIONPROPERTIESPATH + "application.properties"));
        } catch (IOException io) {
            System.out.println(
                    "IOException in the loadFrameworkPropertyFile() method of the PropertyManager class : " + io.getStackTrace());
            Runtime.getRuntime().halt(0);
        }
        return PROPERTY;
    }
}
