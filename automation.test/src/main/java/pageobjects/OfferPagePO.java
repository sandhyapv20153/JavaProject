package pageobjects;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfferPagePO {
	
	private WebElement elem;
	private WebDriver driver;
	private String userLoanAmountLocatorText="//*[@data-auto='userLoanAmount']";
	private String hamburgerMenuLocatorText="//*[@id='header-nav-toggle']/../*[@class='header-nav__toggle']";
	
	public OfferPagePO(WebDriver driver) throws MalformedURLException
	{
		this.driver = driver;
		waitForElement(userLoanAmountLocatorText);
		waitForElement(hamburgerMenuLocatorText);
	}
	

	public WebElement getLoanAmountLocator(){
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
	
	public WebElement getSelectButtonLocator(){
		elem = driver.findElement(By.xpath("//*[@data-auto='getDefaultLoan']"));
		return elem;
	}
	
	public WebElement getHamburgerMenuLocator(){
		elem = driver.findElement(By.xpath(hamburgerMenuLocatorText));
		return elem;
	}
	
	public WebElement getSignOutLocator(){
		elem = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		return elem;
	}
	
	public void waitForElement(String Text)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Text)));
	}
	
	
	
}
