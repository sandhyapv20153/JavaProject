package webapp.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.*;


public class BrowserActionsForValidatingOffer extends Browser{
	
	public void openWebPage()
	{	
		String WebUrl = PropertyFileUtility.readPropertyFile(Constants.PROJECT_PROPERTYFILE_PATH,"loginPortal");
		System.out.println("\nOpening WebUrl :"+WebUrl);
		if(browserDriver!=null)
		{
			browserDriver.get(WebUrl);
			browserDriver.manage().window().maximize(); 
		}
		else
		{
			System.out.println("driver is null");
		}
		 
	}
	
	
	
	
	public void signIn(WebElement userName, WebElement password, WebElement continueButton)
	{
		JSONObject jObj = new JSONObject();
		jObj = Utilities.readJSONFile(Constants.USER_JSON_PATH);	
		
		if(jObj!=null) {
			userName.sendKeys(jObj.get("emailAddress").toString());
			password.sendKeys(jObj.get("password").toString());
		}
		continueButton.sendKeys(Keys.ENTER);
	}
	
	public void ValidateOfferValues(HashMap<String,WebElement> offerWebElements)
	{
		JSONObject offerObj = new JSONObject();
		offerObj = Utilities.readJSONFile(Constants.OFFERVALUE_JSON_PATH);
		String actual="";
		String expected="";
		Iterator<String> keys = offerObj.keys();
		while(keys. hasNext()) {
			String key = keys.next();
			actual = offerWebElements.get(key).getText();
			expected = offerObj.get(key).toString();
			validateValues(actual,expected);
		}
		System.out.println("\nOffer values are have been validated after sign in and are correct!!");
		
	}
	
	public void validateValues(String actual, String expected)
	{
		assertEquals(actual,expected);
		
	}
	
	public void closeDriver()
	{
		driverClose();
	}

}
