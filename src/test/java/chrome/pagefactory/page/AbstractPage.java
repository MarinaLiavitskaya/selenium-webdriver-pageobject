package chrome.pagefactory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 10;

	private WebDriver driver;

	public AbstractPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	protected WebDriver getDriver() {
		
		return this.driver;
	}

	public boolean isElementPresent(By locator) {

		return !driver.findElements(locator).isEmpty();
	}

	public void waitForElementPresent(By locator) {

		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void waitForElementVisible(By locator) {

		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void waitForElementEnabled(By locator) {

		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
