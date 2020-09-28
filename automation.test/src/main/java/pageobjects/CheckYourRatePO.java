package pageobjects;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckYourRatePO {
	
	private WebElement elem;
	private WebDriver driver;
	private String checkYourRateButtonLocator="//*[@data-auto='CheckYourRate']";
	
	public CheckYourRatePO(WebDriver driver) throws MalformedURLException
	{
		this.driver = driver;
		waitForElement(checkYourRateButtonLocator);
	}
	

	public WebElement getLoanAmountTextBoxLocator(){
		elem = driver.findElement(By.name("desiredAmount"));
		return elem;
	}
	
	public Select getLoanPurposeDropDownLocator(){
		
		  Select elemDropdown = new Select(driver.findElement(By.xpath("//select[@data-auto='dropLoanPurpose']"))); 
		  return elemDropdown;
	}
	
	public WebElement getCheckYourRateButtonLocator(){
		elem = driver.findElement(By.xpath(checkYourRateButtonLocator));
		return elem;
	}
	
	
	public WebElement getMandatoryFieldTextLocator(){
		elem = driver.findElement(By.xpath("//*[text()='This field is required']"));
		return elem;
	}
	
	public void waitForElement(String Text)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Text)));
	}
}
