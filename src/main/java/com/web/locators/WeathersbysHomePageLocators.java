package com.web.locators;

import org.openqa.selenium.By;

public interface WeathersbysHomePageLocators {

    public static final By COOKIES_DIV = By.cssSelector("._cookies-cookies-bar");

    public static final By COOKIES_CLOSE_BTN = By.cssSelector("._cookies-stats-accept>span");

	
    public static final By FOAL_REGISTRATION_LINK = By.cssSelector("#paginate-slider-ul .last");
    
    public static final By FOAL_REGISTRATION_PAGE = By.cssSelector("a[href*='studbook/registrations/']");   
    
    public static final By SHOP_ITEM_TEXT = By.cssSelector(".shopitems .shopitemtext>a");
    

}
