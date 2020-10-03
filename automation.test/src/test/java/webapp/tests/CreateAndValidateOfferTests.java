package webapp.tests;

import org.testng.annotations.Test;

import browser.actions.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;


public class CreateAndValidateOfferTests {
	
	WebDriver driver;
	BrowserActionsForCreatingOffer bActions;
	BrowserActionsForValidatingOffer vActions;

  @BeforeTest
	public void setUp() { 

  }
  
  
  @Test
  @Parameters({"rateValue"})
   public void CreateOfferTest(@Optional("rateValue") String rateValue) {
	  
	 this.bActions = new BrowserActionsForCreatingOffer();
	 bActions.createAccountAndOffer(rateValue);
	 bActions.closeDriver();
	  
	 this.vActions = new BrowserActionsForValidatingOffer();
	 vActions.ValidateOffer();
  }
  
 
   @AfterTest 
	public void afterTest()
	{
	  vActions.closeDriver();
	}

}
