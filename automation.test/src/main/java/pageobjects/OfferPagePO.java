package pageobjects;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfferPagePO {
	
	@FindBy(xpath ="//*[@data-auto='userLoanAmount']")
	private WebElement LoanAmount;
	
	@FindBy(xpath= "//*[@data-auto='defaultMonthlyPayment']")
	private WebElement MonthlyPaymentAmt;
	
	@FindBy(xpath="//*[@data-auto='defaultLoanTerm']")
	private WebElement Term;
	
	@FindBy(xpath="//*[@data-auto='defaultLoanInterestRate']")
	private WebElement InterestRate;
	
	@FindBy(xpath="//*[@data-auto='defaultMoreInfoAPR']/div")
	private WebElement APR;
	
	@FindBy(xpath="//*[@data-auto='getDefaultLoan']")
	private WebElement SelectButton;
	
	@FindBy(xpath = "//*[@id='header-nav-toggle']/../*[@class='header-nav__toggle']")
	private WebElement HamburgerMenu;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignOut;
		
	public WebDriver driver;
	public WebDriverWait wait;
	
	public OfferPagePO(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,120);
		PageFactory.initElements(driver, this);
		waitForElements();
	}
	
	public WebElement LoanAmount()
	{
		return LoanAmount;
	}
	
	public WebElement MonthlyPaymentAmt()
	{
		return MonthlyPaymentAmt;
	}
	
	public WebElement Term()
	{
		return Term;
	}
	
	public WebElement InterestRate()
	{
		return InterestRate;
	}
	
	public WebElement APR()
	{
		return APR;
	}
	
	public WebElement SelectButton()
	{
		return SelectButton;
	}
	
	public WebElement HamburgerMenu()
	{
		return HamburgerMenu;
	}
	
	public WebElement SignOut()
	{
		return SignOut;
	}
	
	public String getLoanAmount()
	{
		return LoanAmount.getText();
	}
	
	public String getMonthlyPaymentAmt()
	{
		return MonthlyPaymentAmt.getText();
	}
	
	public String getTerm()
	{
		return Term.getText();
	}
	
	public String getInterestRate()
	{
		return InterestRate.getText();
	}
	
	public String getAPR()
	{
		return APR.getText();
	}
	
	public void clickSelectButton()
	{
		SelectButton.click();
	}
	
	public void clickHamburgerMenu()
	{
		HamburgerMenu.click();
	}
	
	public void clickSignOut()
	{
		SignOut.click();
	}
	
	
	public void waitForElements()
	{
		wait.until(ExpectedConditions.elementToBeClickable(SelectButton));
		wait.until(ExpectedConditions.elementToBeClickable(HamburgerMenu));
	}
	
	public void waitForSignOut()
	{
		wait.until(ExpectedConditions.elementToBeClickable(SignOut));
	}
	
	
	
}
