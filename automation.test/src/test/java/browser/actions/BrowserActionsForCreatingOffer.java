package browser.actions;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import main.*;
import pageobjects.*;


public class BrowserActionsForCreatingOffer extends Browser{
	
	CheckYourRatePO rateObj;
	BasicInformationPO basicInfoObj;
	IncomePO incomeObj;
	CreateAccountPO accountObj;
	OfferPagePO offerObj;
	WebDriver driver;

	public BrowserActionsForCreatingOffer() {
		super();
		this.driver = getDriverValue();
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
	
	public void createAccountAndOffer(String rateValue)
	{	
		openWebPage();
		getRate(rateValue);
		setBasicInfo();
		setIncome();
		createAccount();
		ValidateOfferPage();

	}
	
	
	public void getRate(String rateValue)
	{
		this.rateObj = new CheckYourRatePO(driver);
		rateObj.setLoanAmount(rateValue);
		rateObj.setLoanPurpose("Home Improvement");
		rateObj.clickCheckYourRateButton();
	}
	  
	public void setBasicInfo() {
		BasicInformationPO basicInfoObj = new BasicInformationPO(driver);
		basicInfoObj.setFirstName("John");
		basicInfoObj.setLastName("Doe");
		basicInfoObj.setHomeAddress("Test Address");
		basicInfoObj.setCity("Arlington Heights");
		basicInfoObj.setState("Illinois");
		basicInfoObj.setZipCode("60004");
		basicInfoObj.setDOB("01/01/1975");
		basicInfoObj.clickBasicInfoContinue();
	}
	
	public void setIncome()
	{
		this.incomeObj = new IncomePO(driver);
		incomeObj.setAnnualIncome("130000");
		incomeObj.setAdditionalIncome("6000");
		incomeObj.clickIncomeContinueButton();
	}
	
	
	public void createAccount()
	{
		this.accountObj = new CreateAccountPO(driver);
		String userNameText ="JohnDoe" +Utilities.randomGenerator()+"@upgrade-challenge.com";
		System.out.println("User Name Created" + userNameText);
		accountObj.setUserName(userNameText);
		accountObj.setPassword("Summer2020");
		accountObj.waitForCheckBox();
		accountObj.clickCheckbox();
		accountObj.clickCreateAccountButton();
		
		JSONObject jObj = new JSONObject();
		jObj.put("emailAddress", userNameText);
		jObj.put("password", "Summer2020");
		Utilities.writeJSONFile(jObj, Constants.USER_JSON_PATH);
		System.out.println("\nAccount has been created!");
	}
	
	
	public void ValidateOfferPage()
	{
		this.offerObj = new OfferPagePO(driver);
		JSONObject jObj = new JSONObject();
		jObj.put("LoanAmount", offerObj.getLoanAmount());
		jObj.put("MonthlyPaymentAmt", offerObj.getMonthlyPaymentAmt());
		jObj.put("InterestRate", offerObj.getInterestRate());
		jObj.put("Term", offerObj.getTerm());
		jObj.put("APR", offerObj.getAPR());
				
		Utilities.writeJSONFile(jObj, Constants.OFFERVALUE_JSON_PATH);
		System.out.println("\nOffer values have been added to JSON after account creation.");
		offerObj.clickHamburgerMenu();
		offerObj.waitForSignOut();
		offerObj.clickSignOut();
		
	}
	

	public void closeDriver()
	{
		driverClose();
	}

}
