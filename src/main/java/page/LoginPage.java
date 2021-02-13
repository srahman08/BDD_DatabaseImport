package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.TestBase;

public class LoginPage extends TestBase {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement UserName;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement Password;
	@FindBy(how = How.XPATH, using = "//button[@name='login']")
	WebElement SignInButton;

	// Methods to interact with the elements
	public void enterUserName(String userName) {
		UserName.sendKeys(userName);
	}

	public void enterPassword(String password) {
		Password.sendKeys(password);
	}

	public void clickSignInButton() {
		SignInButton.click();
	}

	public void login(String userName, String password) {
		UserName.sendKeys(userName);
		Password.sendKeys(password);
		SignInButton.click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

}
