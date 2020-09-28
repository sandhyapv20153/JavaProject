package webapp.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import main.*;


public class BrowserActionsForCreatingOffer extends Browser{
	

	public BrowserActionsForCreatingOffer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public void openWebPage()
	{	
		String WebUrl = PropertyFileUtility.readPropertyFile(Constants.PROJECT_PROPERTYFILE_PATH,"websiteHomepage");
		System.out.println("\nOpening WebUrl : "+WebUrl);
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
	
	public void clickButton(WebElement elem)
	{
		elem.click();
	}
	
	public void verifyText(WebElement elem)
	{
		String expText = "This field is required";
		String actualText = elem.getText();
		assertEquals(expText,actualText);
	}
	
	public void GetRate(WebElement rateAmount, String rateValue, Select purposeOptions, WebElement submitButton)
	{
		rateAmount.sendKeys(rateValue);
		purposeOptions.selectByVisibleText("Home Improvement"); 
		submitButton.click();
	}
	  
	public void SetBasicInfo(WebElement RadioLocator,
			WebElement firstNameLocator,
			WebElement lastNameLocator, 
			WebElement homeAddressLocator,
			WebElement cityLocator,
			WebElement stateLocator,
			WebElement zipCodeLocator,
			WebElement dobLocator,
			WebElement basicInfoButton)
	{
		firstNameLocator.sendKeys("John");
		lastNameLocator.sendKeys("Doe");
		homeAddressLocator.sendKeys("Test Address");
		cityLocator.sendKeys("Arlington Heights");
		stateLocator.sendKeys("Illinois");
		zipCodeLocator.sendKeys("60004");
		dobLocator.sendKeys("01/01/1975");
		basicInfoButton.click();
	}
	
	public void setIncome(WebElement basicIncome, WebElement additionalIncome, WebElement incomeContinue)
	{
		basicIncome.sendKeys("130000");
		additionalIncome.sendKeys("6000");
		incomeContinue.sendKeys(Keys.ENTER);
		
	}
	
	
	public void createAccount(WebElement userName, WebElement password, WebElement checkBox, WebElement continueButton)
	{
		String userNameText ="JohnDoe" +Utilities.randomGenerator()+"@upgrade-challenge.com";
		System.out.println("User Name Created" + userNameText);
		userName.sendKeys(userNameText);
		password.sendKeys("Summer2020");
		Utilities.waitFor();
		checkBox.click();
		continueButton.click();
				
		JSONObject jObj = new JSONObject();
		jObj.put("emailAddress", userNameText);
		jObj.put("password", "Summer2020");
		Utilities.writeJSONFile(jObj, Constants.USER_JSON_PATH);
		System.out.println("\nAccount has been created!");
		
	}
	
	public void ValidateOfferPage(WebElement getLoanAmount,
			WebElement monthlyPaymentAmt,
			WebElement interestRate,
			WebElement term,
			WebElement apr,
			WebElement selectButton,
			WebElement hamburgerMenu,
			WebElement signOut)
	{
		
		
		JSONObject jObj = new JSONObject();
		jObj.put("LoanAmount", getLoanAmount.getText());
		jObj.put("MonthlyPaymentAmt", monthlyPaymentAmt.getText());
		jObj.put("InterestRate", interestRate.getText());
		jObj.put("Term", term.getText());
		jObj.put("APR", apr.getText());
				
		Utilities.writeJSONFile(jObj, Constants.OFFERVALUE_JSON_PATH);
		System.out.println("\nOffer values have been added to JSON after account creation.");
		hamburgerMenu.click();
		Utilities.waitFor();
		signOut.click();
		
	}
	

	public void closeDriver()
	{
		driverClose();
	}

}
