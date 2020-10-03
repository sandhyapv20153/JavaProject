package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckYourRatePO {
	
	@FindBy (name= "desiredAmount")
	private WebElement LoanAmount;
	
	@FindBy (xpath= "//select[@data-auto='dropLoanPurpose']")
	private WebElement LoanPurpose;
	
	@FindBy (xpath ="//*[@data-auto='CheckYourRate']")
	private WebElement CheckYourRateButton;
	
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public CheckYourRatePO(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
		waitForElement();
	}
	
	public WebElement LoanAmount()
	{
		return LoanAmount;
	}
	
	public Select LoanPurpose() {
		Select elemDropdown = new Select(LoanPurpose);
		return elemDropdown;
	}
	
	public WebElement CheckYourRateButton()
	{
		return CheckYourRateButton;
	}
	
	public void setLoanAmount(String loanAmt)
	{
		LoanAmount.sendKeys(loanAmt);
	}
	
	public void setLoanPurpose(String loanPurposeText)
	{
		LoanPurpose().selectByVisibleText(loanPurposeText);
	}
	
	public void clickCheckYourRateButton()
	{
		CheckYourRateButton.click();
	}
	
	public void waitForElement()
	{
		//WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(CheckYourRateButton));
	}
	
}
