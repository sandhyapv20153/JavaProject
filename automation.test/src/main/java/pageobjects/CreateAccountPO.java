package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPO {
	
	@FindBy (name = "username")
	private WebElement UserName;
	
	@FindBy( name = "password")
	private WebElement Password;
	
	@FindBy ( xpath = "//*[@name='agreements']/../div")
	private WebElement Checkbox;
	
	@FindBy ( xpath ="//button[@data-auto='submitPersonalInfo']")
	private WebElement CreateAccountButton;
		
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	public CreateAccountPO(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement UserName()
	{
		return UserName;
	}
	
	public WebElement Password()
	{
		return Password;
	}
	
	public WebElement Checkbox()
	{
		return Checkbox;
	}
	
	public WebElement CreateAccountButton()
	{
		return CreateAccountButton;
	}
	
	public void setUserName(String uName) {
		UserName.sendKeys(uName);
	}
	
	public void setPassword(String passWord)
	{
		Password.sendKeys(passWord);
	}
	
	public void clickCheckbox()
	{
		Checkbox.click();
	}
	
	public void clickCreateAccountButton()
	{
		CreateAccountButton.sendKeys(Keys.ENTER);
	}
	
	public void waitForCheckBox()
	{
		wait.until(ExpectedConditions.elementToBeClickable(Checkbox));
	}
	
	public void waitForElements() {
		wait.until(ExpectedConditions.elementToBeClickable(CreateAccountButton));
	}
	
}
