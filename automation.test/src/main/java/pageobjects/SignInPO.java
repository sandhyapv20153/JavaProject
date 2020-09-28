package pageobjects;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPO {
	
	private WebElement elem;
	private WebDriver driver;
	private String signInButtonLocatorText="//button[@data-auto='login']";
	
	public SignInPO(WebDriver driver) throws MalformedURLException
	{
		this.driver = driver;
		waitForElement(signInButtonLocatorText);
	}
	

	public WebElement getUserNameTextLocator(){
		elem = driver.findElement(By.name("username"));
		return elem;
	}
	
	public WebElement getPasswordTextLocator(){
		elem = driver.findElement(By.name("password"));
		return elem;
	}
	

	public WebElement getSignInButtonLocator(){
		elem = driver.findElement(By.xpath("//button[@data-auto='login']"));
		return elem;
	}
	
	public void waitForElement(String Text)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Text)));
	}
	
	
}
