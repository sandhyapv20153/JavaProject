package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfferAfterSignInPO {
	
	@FindBy(xpath = "//*[@data-auto='userLoanAmount']")
	private WebElement LoanAmount;
	
	@FindBy(xpath= "//*[@data-auto='defaultMonthlyPayment']")
	private WebElement MonthlyPaymentAmt;
	
	@FindBy(xpath="//*[@data-auto='defaultLoanTerm']")
	private WebElement Term;
	
	@FindBy(xpath = "//*[@data-auto='defaultLoanInterestRate']")
	private WebElement InterestRate;
	
	@FindBy(xpath= "//*[@data-auto='defaultMoreInfoAPR']/div")
	private WebElement APR;
		
	public WebDriver driver;
	public WebDriverWait wait;
	
	public OfferAfterSignInPO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,60);
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
	
	public HashMap<String,String> getOfferValuesAfterSignIn(){
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("LoanAmount", getLoanAmount());
		map.put("MonthlyPaymentAmt", getMonthlyPaymentAmt());
		map.put("Term", getTerm());
		map.put("InterestRate", getInterestRate());
		map.put("APR", getAPR());
		return map;
	}
	
	public void waitForElements()
	{
		wait.until(ExpectedConditions.visibilityOf(InterestRate));
	}
	
	
}
