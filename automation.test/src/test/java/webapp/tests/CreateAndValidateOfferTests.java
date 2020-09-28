package webapp.tests;

import org.testng.annotations.Test;

import pageobjects.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;


public class CreateAndValidateOfferTests {
	
	WebDriver driver;
	BrowserActionsForCreatingOffer bActions;
	CheckYourRatePO rateObj;
	BasicInformationPO basicInfoObj;
	IncomePO incomeObj;
	CreateAccountPO accountObj;
	OfferPagePO offerObj;
	BrowserActionsForValidatingOffer vActions;
	SignInPO loginObj;
	OfferAfterSignInPO offerValidateObj;

  @BeforeTest
	public void setUp() { 
		this.bActions = new BrowserActionsForCreatingOffer();
		bActions.openWebPage(); 
		this.driver = bActions.getDriverValue();
	 
	}
  
  
  @Test
  @Parameters({"rateValue"})
  public void CreateOfferTest(@Optional("rateValue") String rateValue) {
	  
	  try {
			this.rateObj = new CheckYourRatePO(driver);
			bActions.GetRate(rateObj.getLoanAmountTextBoxLocator(), rateValue, rateObj.getLoanPurposeDropDownLocator(), rateObj.getCheckYourRateButtonLocator());
	  
			this.basicInfoObj = new BasicInformationPO(driver);
			bActions.SetBasicInfo(basicInfoObj.getIndividualRadioLocator(),
			  basicInfoObj.getFirstNameTextLocator(),
			  basicInfoObj.getLastNameTextLocator(), 
			  basicInfoObj.getHomeAddressTextLocator(),
			  basicInfoObj.getCityTextLocator(),
			  basicInfoObj.getStateTextLocator(),
			  basicInfoObj.getZipCodeTextLocator(),
			  basicInfoObj.getDOBTextLocator(),
			  basicInfoObj.getBasicInfoContinueButtonLocator());	  
	
			this.incomeObj = new IncomePO(driver);
			bActions.setIncome(incomeObj.getAnnualIncomeTextLocator(), incomeObj.getAdditionalIncomeTextLocator(), incomeObj.getIncomeContinueButtonLocator());
	  
			this.accountObj = new CreateAccountPO(driver);
			bActions.createAccount(accountObj.getUserNameTextLocator(), accountObj.getPasswordTextLocator(), accountObj.getCheckboxLocator(), accountObj.getCreateAccountButtonLocator());

			this.offerObj = new OfferPagePO(driver);
			bActions.ValidateOfferPage(offerObj.getLoanAmountLocator(),
			  offerObj.getMonthlyPaymentAmtLocator(),
			  offerObj.getInterestRateLocator(),
			  offerObj.getTermLocator(),
			  offerObj.getAPRLocator(),
			  offerObj.getSelectButtonLocator(),
			  offerObj.getHamburgerMenuLocator(),
			  offerObj.getSignOutLocator());
	  } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  bActions.closeDriver();
  }
  
  @Test
  public void ValidateOfferTests() {
	  
	  	this.vActions = new BrowserActionsForValidatingOffer();
		vActions.openWebPage(); 
		this.driver = vActions.getDriverValue();
	  
	  try {
			this.loginObj = new SignInPO(driver);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  vActions.signIn(loginObj.getUserNameTextLocator(), loginObj.getPasswordTextLocator(), loginObj.getSignInButtonLocator());
		  
	  try {
			this.offerValidateObj = new OfferAfterSignInPO(vActions.getDriverValue());
			} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  vActions.ValidateOfferValues(offerValidateObj.getOfferAfterSignInLocators());
	  
  }
  
  @AfterTest 
	public void afterTest()
	{
	  vActions.closeDriver();
	}


}
