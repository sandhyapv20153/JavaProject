package pageobjects;

import java.net.MalformedURLException;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfferAfterSignInPO {
	
	private WebElement elem;
	private WebDriver driver;
	private String userLoanAmountLocatorText="//*[@data-auto='userLoanAmount']";
	
	public OfferAfterSignInPO(WebDriver driver) throws MalformedURLException
	{
		this.driver = driver;
		waitForElement(userLoanAmountLocatorText);
	}
	

	public WebElement getLoanAmountLocators(){
		elem = driver.findElement(By.xpath(userLoanAmountLocatorText));
		return elem;
	}
	
	public WebElement getMonthlyPaymentAmtLocator(){
		elem = driver.findElement(By.xpath("//*[@data-auto='defaultMonthlyPayment']"));
		return elem;
	}
	
	public WebElement getTermLocator(){
		elem = driver.findElement(By.xpath("//*[@data-auto='defaultLoanTerm']"));
		return elem;
	}
	
	public WebElement getInterestRateLocator(){
		elem = driver.findElement(By.xpath("//*[@data-auto='defaultLoanInterestRate']"));
		return elem;
	}
	
	public WebElement getAPRLocator(){
		elem = driver.findElement(By.xpath("//*[@data-auto='defaultMoreInfoAPR']/div"));
		return elem;
	}
	
	public HashMap<String,WebElement> getOfferAfterSignInLocators(){
		
		HashMap<String,WebElement> map = new HashMap<String,WebElement>();
		map.put("LoanAmount", getLoanAmountLocators());
		map.put("MonthlyPaymentAmt", getMonthlyPaymentAmtLocator());
		map.put("Term", getTermLocator());
		map.put("InterestRate", getInterestRateLocator());
		map.put("APR", getAPRLocator());
		return map;
	}
	
	public void waitForElement(String Text)
	{
		WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Text)));
	}
	
	
}
