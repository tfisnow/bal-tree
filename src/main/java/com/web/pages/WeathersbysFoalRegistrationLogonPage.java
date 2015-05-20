package com.web.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.generic.page.base.PageBase;

import com.web.locators.WeathersbysHomePageLocators;

public class WeathersbysFoalRegistrationLogonPage extends PageBase implements WeathersbysHomePageLocators{

	public WeathersbysFoalRegistrationLogonPage(WebDriver driver) throws WebDriverException {
		super(driver);
	}
	
	public WeathersbysFoalRegistrationLogonPage goToFoalRegistrationPage(){

		try {
			
			driver.findElement(FOAL_REGISTRATION_LINK).click();
			
			WebElement element = null;
            WebDriverWait wait = new WebDriverWait(driver,Integer.parseInt("90"));

            element = wait.until(ExpectedConditions.visibilityOfElementLocated(FOAL_REGISTRATION_PAGE));
			
            
            element.click();
          
			return new WeathersbysFoalRegistrationLogonPage(driver);
		} catch (TimeoutException e) {
			System.out.println(e.getStackTrace());
			
		} catch (WebDriverException e) {
			System.out.println(e.getStackTrace());
		}
		return null;		
	}
	
}
