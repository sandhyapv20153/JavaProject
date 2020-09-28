package pageobjects;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicInformationPO {
	
	private WebElement elem;
	private WebDriver driver;
	private String continueButtonText="//*[@data-auto='continuePersonalInfo']";
	
	public BasicInformationPO(WebDriver driver) throws MalformedURLException
	{
		this.driver = driver;
		waitForElement(continueButtonText);
	}
	

	public WebElement getIndividualRadioLocator(){
		elem = driver.findElement(By.xpath("//input[@name='jointApplicationToggle']/../div[text()='Individual']"));
		return elem;
	}
	
	public WebElement getJointApplicationRadioLocator(){
		elem = driver.findElement(By.xpath("//input[@name='jointApplicationToggle']/../div[text()='Joint Application']"));
		return elem;
	}
	
	public WebElement getFirstNameTextLocator(){
		elem = driver.findElement(By.name("borrowerFirstName"));
		return elem;
	}
	
	public WebElement getLastNameTextLocator(){
		elem = driver.findElement(By.name("borrowerLastName"));
		return elem;
	}
	
	public WebElement getHomeAddressTextLocator(){
		elem = driver.findElement(By.name("borrowerStreet"));
		return elem;
	}
	
	public WebElement getCityTextLocator(){
		elem = driver.findElement(By.name("borrowerCity"));
		return elem;
	}
	
	public WebElement getStateTextLocator(){
		elem = driver.findElement(By.name("borrowerState"));
		return elem;
	}
	
	public WebElement getZipCodeTextLocator(){
		elem = driver.findElement(By.name("borrowerZipCode"));
		return elem;
	}
	
	public WebElement getDOBTextLocator(){
		elem = driver.findElement(By.name("borrowerDateOfBirth"));
		return elem;
	}
	
	public WebElement getBasicInfoContinueButtonLocator(){
		elem = driver.findElement(By.xpath(continueButtonText));
		return elem;
	}
	
	public void waitForElement(String Text)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Text)));
	}
	
}
