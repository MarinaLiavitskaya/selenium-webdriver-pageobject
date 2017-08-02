package pageobject;

import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebWindow;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TutByTest {

	static final String LOGIN = "marina.liavitskaya@gmail.com";
	static final String PASSWORD = "3042430mmM";

	static final String SITE_URL = "https://jobs.tut.by/";

	WebDriver driver;

	@Test
	public void test_tutBy() {

		WebElement login = driver.findElement(By.cssSelector("label.login-input:nth-child(1) > input:nth-child(1)"));
		// WebElement login = driver.findElement(By.cssSelector("html.desktop
		// body.l-tutby.s-friendly.custom-font-allowed
		// div.index-dashboard.index-dashboard_domain-jobs-tut-by
		// div.bloko-columns-wrapper
		// div.bloko-column.bloko-column_s-0.bloko-column_m-4.bloko-column_l-4
		// div.substrate div.login-with.Bloko-Tabs-Container div.Bloko-Tabs-Body
		// form.login-form label.login-input input.bloko-input"));
		System.out.println("login" + login);
		login.sendKeys(LOGIN);
		// /html/body/div[6]/div/div[3]/div/div/div[2]/form/label[1]/input

		WebElement password = driver.findElement(By.cssSelector("label.login-input:nth-child(2) > input:nth-child(1)"));
		System.out.println("password" + password);
		password.sendKeys(PASSWORD);

		WebElement button = driver.findElement(By.cssSelector("input.bloko-button_primary-minor"));
		button.click();

		WebElement buttonDropDown = driver.findElement(By.cssSelector(".navi-item__employer-info"));
		buttonDropDown.click();

		WebElement buttonQuit = driver.findElement(By.cssSelector("button.navi-dropdown-link"));
		//buttonQuit.click();
		// /html.desktop body.l-tutby.s-friendly.custom-font-allowed
		// div.navi.HH-VacancyMainSearchInfoTip-Navi.navi_index div.navi__menu
		// div.bloko-columns-wrapper
		// div.bloko-column.bloko-column_l-16.bloko-column_m-12.bloko-column_s-8.bloko-column_xs-4
		// div.navi-row.navi-row_menu.HH-Navi-MenuResizer-Menu
		// ul.navi-cell.navi-cell_line-container
		// li.navi-item.navi-item_user.navi-item_level-1.HH-Navi-MenuItems-Item.HH-Navi-MenuResizer-StaticItem
		// div.navi-item__dropdown.navi-item__dropdown_right.HH-Navi-MenuItems-Dropdown.HH-Navi-MenuItems-StaticDropdown.g-hidden
		// div.navi-dropdown ul.navi-dropdown__list
		// li.navi-item.navi-item_level-2 form button.navi-dropdown-link
	}

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", "c:/MARINA/Soft/geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();			
		//WebClient w = new WebClient();
		//WebWindow currentWindow = w.getCurrentWindow();
		//WebWindow topWindow = currentWindow.getTopWindow();		
		//driver.manage().window().setSize(new Dimension(topWindow.getOuterWidth(), topWindow.getOuterHeight()));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(SITE_URL);
	}

	@AfterClass
	public void afterClass() {
//		try {
//			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		//driver.close();
		driver.quit();
	}

}
