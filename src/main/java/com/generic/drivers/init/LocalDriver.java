package com.generic.drivers.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.generic.enums.BrowserType;

public class LocalDriver  {

    public WebDriver getDriver(Browser browser) {

    	WebDriver driver = null;
        System.out.println("** "+browser.getName()+ " Browser**");        

        if (BrowserType.INTERNETEXPLORER.getBrowserValue().equals(browser.getName())) {
            System.setProperty("webdriver.ie.driver",
                    "src/main/resources/com/drivers/IEDriverServer.exe");
         
            DesiredCapabilities capabilities = WebCapabilities.getDesiredCapability(browser);
            
            driver = new InternetExplorerDriver(capabilities);
            
        } else if (BrowserType.FIREFOX.getBrowserValue().equals(browser.getName())) {
            
            DesiredCapabilities capabilities = WebCapabilities.getDesiredCapability(browser);
           
            driver = new FirefoxDriver(capabilities);
        } else if (BrowserType.CHROME.getBrowserValue().equals(browser.getName())) {

            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/com/drivers/chromedriver.exe");
            DesiredCapabilities capabilities = WebCapabilities.getDesiredCapability(browser);
            
            driver = new ChromeDriver(capabilities);
        }
        
        System.out.println("Instantiating/Launching the "+browser.getName()+" Browser");
        if(driver!= null)
        	 System.out.println("Returning the local instance of:" + driver.toString());
        else
        	 System.out.println("Driver is not initialised, null returned!");
        return driver;
    }
}