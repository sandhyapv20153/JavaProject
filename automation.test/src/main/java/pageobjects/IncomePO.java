package pageobjects;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IncomePO {
	
	private WebElement elem;
	private WebDriver driver;
	private String continueButtonText="//button[text()='Continue']";
	
	public IncomePO(WebDriver driver) throws MalformedURLException
	{
		this.driver = driver;
		waitForElement(continueButtonText);
	}
	

	public WebElement getAnnualIncomeTextLocator(){
		elem = driver.findElement(By.name("borrowerIncome"));
		return elem;
	}
	
	public WebElement getAdditionalIncomeTextLocator(){
		elem = driver.findElement(By.name("borrowerAdditionalIncome"));
		return elem;
	}
	
	public WebElement getIncomeContinueButtonLocator(){
		elem = driver.findElement(By.xpath(continueButtonText));
		return elem;
	}
	
	public void waitForElement(String Text)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Text)));
	}
	
}
