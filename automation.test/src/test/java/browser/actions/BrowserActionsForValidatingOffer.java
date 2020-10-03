package browser.actions;


import java.util.Iterator;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import main.*;
import pageobjects.*;


public class BrowserActionsForValidatingOffer extends Browser{
	
	SignInPO loginObj;
	OfferAfterSignInPO offerValidateObj;
	WebDriver driver;
	
	public BrowserActionsForValidatingOffer()
	{
		this.driver = getDriverValue();
	}
	
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
	
	public void ValidateOffer()
	{
		openWebPage(); 
		signIn();	  
		ValidateOfferValues();
				  
	}
	
	

	public void signIn()
	{
		this.loginObj = new SignInPO(driver);
		JSONObject jObj = new JSONObject();
		jObj = Utilities.readJSONFile(Constants.USER_JSON_PATH);	
		
		if(jObj!=null) {
			loginObj.setUserName(jObj.get("emailAddress").toString());
			loginObj.setPassword(jObj.get("password").toString());
		}
		loginObj.clickSignInButton();
		
	}
	
	
	public void ValidateOfferValues()
	{
		this.offerValidateObj = new OfferAfterSignInPO(getDriverValue());
		JSONObject offerObj = new JSONObject();
		offerObj = Utilities.readJSONFile(Constants.OFFERVALUE_JSON_PATH);
		String actual="";
		String expected="";
		Iterator<String> keys = offerObj.keys();
		while(keys. hasNext()) {
			String key = keys.next();
			actual = offerValidateObj.getOfferValuesAfterSignIn().get(key);
			expected = offerObj.get(key).toString();
			validateValues(actual,expected);
		}
		
	}
	
	public void validateValues(String actual, String expected)
	{
		Assert.assertEquals(actual,expected);
		
	}
	
	public void closeDriver()
	{
		driverClose();
	}

}
