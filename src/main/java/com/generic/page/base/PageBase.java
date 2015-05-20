package com.generic.page.base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class PageBase {

    protected static final String VISIBILITY = "visibility";
    protected static final String PRESENCE = "presence";
    protected static final String CLICKABILITY = "clickability";
    protected static Properties APPLICATIONPROPERTY = null;
    protected static final String APPLICATIONURL = "applicationURL";
    protected WebDriver driver;


    public PageBase(WebDriver driver){
        this.driver = driver;

    }

}
