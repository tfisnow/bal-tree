package com.web.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.generic.page.base.PageBase;
import com.generic.property.PropertyManager;
import com.web.locators.WeathersbysHomePageLocators;

public class WeathersbysHomePage extends PageBase implements WeathersbysHomePageLocators{

	
	public WeathersbysHomePage(WebDriver driver) throws WebDriverException {
		super(driver);
		APPLICATIONPROPERTY = PropertyManager.loadApplicationPropertyFile();
		if(APPLICATIONPROPERTY != null)
	   {
			String s = APPLICATIONPROPERTY.getProperty("applicationURL");
			System.out.println("Base URL : " + s);
			driver.get(s);
	   }
		else
		{
			System.out.println("APPLICATIONPROPERTY is NULL");
		}
	}	
	
	public WeathersbysHomePage closeCookiesBar(){
		
		WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver,Integer.parseInt("90"));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(COOKIES_DIV));
        if(element != null)
        {
        	driver.findElement(COOKIES_CLOSE_BTN).click();
        }
		return null;			
	} 
	
	public WeathersbysFoalRegistrationTCPage goToFoalRegistrationPage() {

		try {			
			driver.findElement(FOAL_REGISTRATION_LINK).click();
			
			WebElement element = null;
            WebDriverWait wait = new WebDriverWait(driver,Integer.parseInt("90"));

            element = wait.until(ExpectedConditions.visibilityOfElementLocated(FOAL_REGISTRATION_PAGE));		
            
            element.click();
          
			return new WeathersbysFoalRegistrationTCPage(driver);
		} catch (TimeoutException e) {
			System.out.println(e.getStackTrace());
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return null;		
	}
	
	
	public List<String> GetTopSellersBooksTitle(){

		List<String> listOfBooks = new ArrayList<String>();

		for(WebElement bookName: driver.findElements(SHOP_ITEM_TEXT) ){
			listOfBooks.add(bookName.getText());
		}
		return listOfBooks;

	}
	
}
