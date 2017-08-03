package firefox.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TutByTest {

	static final String LOGIN = "marina.liavitskaya@gmail.com";
	static final String PASSWORD = "3042430mmM";
	static final String SITE_URL = "https://jobs.tut.by/";

	WebDriver driver;

	@Test(enabled = false)
	public void test_tutBy_fireFox() {

		WebElement login = driver.findElement(By.cssSelector("label.login-input:nth-child(1) > input:nth-child(1)"));
		login.sendKeys(LOGIN);

		WebElement password = driver.findElement(By.cssSelector("label.login-input:nth-child(2) > input:nth-child(1)"));
		password.sendKeys(PASSWORD);

		WebElement button = driver.findElement(By.cssSelector("input.bloko-button_primary-minor"));
		button.click();

		WebElement buttonDropDown = driver.findElement(By.cssSelector(".navi-item__employer-info"));
		buttonDropDown.click();

		WebElement buttonQuit = driver.findElement(By.cssSelector("button.navi-dropdown-link"));
		buttonQuit.click();

	}

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", "d:/Soft/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1680, 1050));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(SITE_URL);
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
