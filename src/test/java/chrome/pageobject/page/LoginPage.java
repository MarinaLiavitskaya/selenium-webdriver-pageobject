package chrome.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage {

	By loginLocator = By.cssSelector("label.login-input:nth-child(1) > input:nth-child(1)");
	By passwordLocator = By.cssSelector("label.login-input:nth-child(2) > input:nth-child(1)");
	By buttonLocator = By.cssSelector("input.bloko-button_primary-minor");

	public LoginPage(WebDriver driver) {
		
		super(driver);
	}

	public LoginPage fillLoginField(String login) {

		waitForElementEnabled(loginLocator);
		WebElement loginField = driver.findElement(loginLocator);
		loginField.sendKeys(login);
		return this;
	}

	private LoginPage fillPasswordField(String password) {

		waitForElementEnabled(passwordLocator);
		WebElement passwordField = driver.findElement(passwordLocator);
		passwordField.sendKeys(password);
		return this;
	}

	private LoginPage clikSignIn() {
		
		waitForElementEnabled(buttonLocator);
		WebElement buttonSignIn = driver.findElement(buttonLocator);
		buttonSignIn.click();
		return this;
	}
	
	public LoginPage openUrl(String url) {
		
		driver.get(url);
		return this;
	}

	public SearchPage logInTutBy(String login, String password) {

		fillLoginField(login);
		fillPasswordField(password);
		clikSignIn();
		return new SearchPage(driver);

	}
}
