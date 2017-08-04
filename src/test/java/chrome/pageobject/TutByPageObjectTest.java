package chrome.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import chrome.pageobject.page.ResultPage;
import chrome.pageobject.page.LoginPage;
import chrome.pageobject.page.SearchPage;

public class TutByPageObjectTest {

	static final String DRIVER_NAME = "webdriver.chrome.driver";
	//static final String DRIVER_PATH = "c:/MARINA/Soft/chromedriver.exe";
	static final String DRIVER_PATH = "d:/Soft/chromedriver.exe";
	static final String SITE_URL = "https://jobs.tut.by/";	
	static final String LOGIN = "marina.liavitskaya@gmail.com";
	static final String PASSWORD = "3042430mmM";

	WebDriver driver;

	@Test
	public void test_tutBy_chrome() {

		SearchPage searchPage = new LoginPage(driver).openUrl(SITE_URL).logInTutBy(LOGIN, PASSWORD);
		ResultPage result = searchPage.searchJob("Java developer");
		LoginPage logOut = result.logOutTutBy();

		Assert.assertNotNull(searchPage);
		Assert.assertNotNull(result);
		Assert.assertNotNull(logOut);
	}

	@BeforeClass
	public void beforeClass() {

		System.setProperty(DRIVER_NAME, DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
