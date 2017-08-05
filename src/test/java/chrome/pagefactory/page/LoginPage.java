package chrome.pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

	static final String SITE_URL = "https://jobs.tut.by/";	

	@FindBy(css = "label.login-input:nth-child(1) > input:nth-child(1)")
	WebElement loginField;

	@FindBy(css = "label.login-input:nth-child(2) > input:nth-child(1)")
	WebElement passwordField;

	@FindBy(css = "input.bloko-button_primary-minor")
	WebElement buttonSignIn;

	public LoginPage(WebDriver driver) {

		super(driver);
	}

	public LoginPage openUrl() {

		getDriver().get(SITE_URL);		
		return this;
	}

	private LoginPage sendKeys(String login, String password) {

		loginField.sendKeys(login);
		passwordField.sendKeys(password);
		return this;
	}

	private LoginPage clikOn() {

		buttonSignIn.click();
		return this;
	}

	public SearchPage logInTutBy(String login, String password) {

		sendKeys(login, password);
		clikOn();
		return new SearchPage(getDriver());

	}
}
