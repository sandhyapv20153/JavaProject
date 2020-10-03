package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicInformationPO {
	
	@FindBy(xpath = "//input[@name='jointApplicationToggle']/../div[text()='Individual']" )
	private WebElement IndividualRadioButton;
	
	@FindBy(xpath = "//input[@name='jointApplicationToggle']/../div[text()='Joint Application']" )
	private WebElement JointApplicationRadioButton;
		
	@FindBy(name = "borrowerFirstName" )
	private WebElement FirstName;
	
	@FindBy(name = "borrowerLastName" )
	private WebElement LastName;
	
	@FindBy(name = "borrowerStreet" )
	private WebElement HomeAddress;
	
	@FindBy(name = "borrowerCity" )
	private WebElement City;
	
	@FindBy(name = "borrowerState" )
	private WebElement State;
	
	@FindBy(name = "borrowerZipCode")
	private WebElement ZipCode;
	
	@FindBy(name = "borrowerDateOfBirth" )
	private WebElement DOB;
	
	@FindBy(xpath = "//*[@data-auto='continuePersonalInfo']" )
	private WebElement BasicInfoContinue;
		
	public WebDriver driver;
	private WebDriverWait wait;
	
    public BasicInformationPO(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
        waitForElement();
    } 

	public WebElement IndividualRadioButton(){
		return IndividualRadioButton;
	}
	
	public WebElement JointApplicationRadioButton(){
		return JointApplicationRadioButton;
	}
	
	public WebElement FirstName(){
		return FirstName;
	}
	
	public WebElement LastName(){
		return LastName;
	}
	
	public WebElement HomeAddress(){
		return HomeAddress;
	}
	
	public WebElement City(){
		return City;
	}
	
	public WebElement State(){
		return State;
	}
	
	public WebElement ZipCode(){
		return ZipCode;
	}
	
	public WebElement DOB(){
		return DOB;
	}
	
	public WebElement BasicInfoContinue(){
		return BasicInfoContinue;
	}
	
	public void setFirstName(String fName)
	{
		FirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName)
	{
		LastName.sendKeys(lName);
	}
	
	public void setHomeAddress(String hAddress)
	{
		HomeAddress.sendKeys(hAddress);
	}
	
	public void setCity(String city)
	{
		City.sendKeys(city);
	}
	
	public void setState(String state)
	{
		State.sendKeys(state);
	}
	
	public void setZipCode(String zipCode)
	{
		ZipCode.sendKeys(zipCode);
	}
	
	public void setDOB(String dob)
	{
		DOB.sendKeys(dob);
	}
	
	public void clickBasicInfoContinue()
	{
		BasicInfoContinue.click();
	}
	
	public void waitForElement()
	{
		wait.until(ExpectedConditions.elementToBeClickable(BasicInfoContinue));
	}
	
}
