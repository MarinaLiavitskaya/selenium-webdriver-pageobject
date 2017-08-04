package chrome.pagefactory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navi-item__employer-info")));
		dropDownMenu.click();		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.navi-dropdown-link")));
		quitButton.click();
		return this;
	}

	public LoginPage logOutTutBy() {

		clickOn();
		return new LoginPage(getDriver());
	}
}
