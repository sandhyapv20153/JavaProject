package pageobjects;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPO {
	
	@FindBy(name= "username")
	WebElement UserName;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(xpath="//button[@data-auto='login']")
	WebElement SignInButton;
		
	public WebDriver driver;
	public WebDriverWait wait;
	
	public SignInPO(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
		waitForElements();
	}
	
	public WebElement UserName()
	{
		return UserName;
	}
	
	public WebElement Password()
	{
		return Password;
	}
	
	public WebElement SignInButton()
	{
		return SignInButton;
	}
	
	public void setUserName(String uName)
	{
		UserName.sendKeys(uName);
	}
	
	public void setPassword(String passWord) 
	{
		Password.sendKeys(passWord);
	}
	
	public void clickSignInButton()
	{
		SignInButton.sendKeys(Keys.ENTER);;
	}
	
	public void waitForElements()
	{
		wait.until(ExpectedConditions.elementToBeClickable(SignInButton));
	}
		
	
}
