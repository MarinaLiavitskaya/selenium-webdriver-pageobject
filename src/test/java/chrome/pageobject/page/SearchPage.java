package chrome.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends AbstractPage {

	By searchTextField = By.cssSelector(
			"body > div.navi.HH-VacancyMainSearchInfoTip-Navi.navi_index > div.navi__top.HH-Navi-StickyMenu-TopBlock > div > div > div > div.navi-cell.navi-cell_search > form.HH-Navi-SearchSelector-Tab.HH-Navi-SearchSelector-Form.HH-VacancyMap-Form > div > div.bloko-control-group__main > input");

	By searchTextButton = By.cssSelector(
			"body > div.navi.HH-VacancyMainSearchInfoTip-Navi.navi_index > div.navi__top.HH-Navi-StickyMenu-TopBlock > div > div > div > div.navi-cell.navi-cell_search > form.HH-Navi-SearchSelector-Tab.HH-Navi-SearchSelector-Form.HH-VacancyMap-Form > div > div.navi-search-button > button");

	public SearchPage(WebDriver driver) {

		super(driver);
	}

	private SearchPage fillSearch(String position) {

		waitForElementEnabled(searchTextField);
		WebElement searchField = driver.findElement(searchTextField);
		searchField.sendKeys(position);
		return this;
	}

	private SearchPage clickSearch() {

		waitForElementEnabled(searchTextButton);
		WebElement searchButton = driver.findElement(searchTextButton);
		searchButton.click();
		return this;
	}

	public ResultPage searchJob(String position) {

		fillSearch(position);
		clickSearch();
		return new ResultPage(driver);
	}

}
