package chrome.pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends AbstractPage {

	// By dropDownMenuLocator = By.cssSelector(".navi-item__employer-info");
	// By quitButtonLocator = By.cssSelector("button.navi-dropdown-link");

	@FindBy(css = ".navi-item__employer-info")
	WebElement dropDownMenu;

	@FindBy(css = "button.navi-dropdown-link")
	WebElement quitButton;

	public ResultPage(WebDriver driver) {

		super(driver);
	}

	private ResultPage clickOn() {

		dropDownMenu.click();
		quitButton.click();
		return this;
	}

	public LoginPage logOutTutBy() {

		clickOn();
		return new LoginPage(getDriver());
	}
}
