package chrome.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage extends AbstractPage {

	By dropDownMenuLocator = By.cssSelector(".navi-item__employer-info");
	By quitButtonLocator = By.cssSelector("button.navi-dropdown-link");

	public ResultPage(WebDriver driver) {
		
		super(driver);
	}

	private ResultPage findDropDownMenu() {

		waitForElementEnabled(dropDownMenuLocator);
		WebElement dropDownMenu = driver.findElement(dropDownMenuLocator);
		dropDownMenu.click();
		return this;
	}

	private ResultPage clickDropDownMenu() {

		waitForElementEnabled(quitButtonLocator);
		WebElement quitButton = driver.findElement(dropDownMenuLocator);
		quitButton.click();
		return this;
	}

	public LoginPage logOutTutBy() {

		findDropDownMenu();
		clickDropDownMenu();
		return new LoginPage(driver);
	}
}
