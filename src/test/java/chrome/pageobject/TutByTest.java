package chrome.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TutByTest {

	static final String LOGIN = "marina.liavitskaya@gmail.com";
	static final String PASSWORD = "3042430mmM";
	static final String SITE_URL = "https://jobs.tut.by/";

	WebDriver driver;

	@Test
	public void test_tutBy_chrome() {

		WebElement login = driver.findElement(By.cssSelector("label.login-input:nth-child(1) > input:nth-child(1)"));
		login.sendKeys(LOGIN);

		WebElement password = driver.findElement(By.cssSelector("label.login-input:nth-child(2) > input:nth-child(1)"));
		password.sendKeys(PASSWORD);

		WebElement button = driver.findElement(By.cssSelector("input.bloko-button_primary-minor"));
		button.click();

		WebElement buttonDropDown = driver.findElement(By.cssSelector(".navi-item__employer-info"));
		buttonDropDown.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement buttonQuit = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.navi-dropdown-link")));
		buttonQuit.click();
	}

	@BeforeClass
	public void beforeClass() {

		//System.setProperty("webdriver.chrome.driver", "c:/MARINA/Soft/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "d:/Soft/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(SITE_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
