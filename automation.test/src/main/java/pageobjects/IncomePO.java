package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IncomePO {
	
	@FindBy (name= "borrowerIncome")
	private WebElement AnnualIncome;
	
	@FindBy (name = "borrowerAdditionalIncome")
	private WebElement AdditionalIncome;
	
	@FindBy (xpath = "//button[text()='Continue']")
	private WebElement IncomeContinueButton;
		
	public WebDriver driver;
	private WebDriverWait wait;
	
	public IncomePO(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement AnnualIncome()
	{
		return AnnualIncome;
	}
	
	public WebElement AdditionalIncome()
	{
		return AdditionalIncome;
	}
	
	public WebElement IncomeContinueButton()
	{
		return IncomeContinueButton;
	}
	
	public void setAnnualIncome(String income)
	{
		AnnualIncome.sendKeys(income);
	}
	
	public void setAdditionalIncome(String addIncome)
	{
		AdditionalIncome.sendKeys(addIncome);
	}
	
	public void clickIncomeContinueButton()
	{
		IncomeContinueButton.sendKeys(Keys.ENTER);
	}
	
	public void waitForElement()
	{
		wait.until(ExpectedConditions.elementToBeClickable(IncomeContinueButton));
	}
	
	
	
}
