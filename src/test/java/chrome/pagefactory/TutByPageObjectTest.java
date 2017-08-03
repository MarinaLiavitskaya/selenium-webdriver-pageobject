package chrome.pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import chrome.pagefactory.page.LoginPage;
import chrome.pagefactory.page.ResultPage;

public class TutByPageObjectTest {

	static final String LOGIN = "marina.liavitskaya@gmail.com";
	static final String PASSWORD = "3042430mmM";	

	private WebDriver driver;

	@Test
	public void test_tutBy_chrome() {

		ResultPage res = new LoginPage(driver).openUrl().logInTutBy(LOGIN, PASSWORD);
		// ResultPage result = searchPage.searchJob("Java developer");
		LoginPage logOut = res.logOutTutBy();

		Assert.assertNotNull(res);
		Assert.assertNotNull(logOut);
	}

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "c:/MARINA/Soft/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "d:/Soft/chromedriver.exe");
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
