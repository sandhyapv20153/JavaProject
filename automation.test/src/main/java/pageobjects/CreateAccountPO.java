package pageobjects;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPO {
	
	private WebElement elem;
	private WebDriver driver;
	private String accountButtonLocatorText="//button[@data-auto='submitPersonalInfo']";
	
	public CreateAccountPO(WebDriver driver) throws MalformedURLException
	{
		this.driver = driver;
		waitForElement(accountButtonLocatorText);
	}
	

	public WebElement getUserNameTextLocator(){
		elem = driver.findElement(By.name("username"));
		return elem;
	}
	
	public WebElement getPasswordTextLocator(){
		elem = driver.findElement(By.name("password"));
		return elem;
	}
	
	public WebElement getCheckboxLocator(){
		elem = driver.findElement(By.xpath("//*[@name='agreements']/../div"));
		return elem;
	}
	
	public WebElement getCreateAccountButtonLocator(){
		elem = driver.findElement(By.xpath(accountButtonLocatorText));
		return elem;
	}
	
	public void waitForElement(String Text)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Text)));
	}
	
	
	
}
