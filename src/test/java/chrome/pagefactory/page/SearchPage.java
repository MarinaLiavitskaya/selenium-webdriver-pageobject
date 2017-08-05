package chrome.pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {	

	@FindBy(css = "body > div.navi.HH-VacancyMainSearchInfoTip-Navi.navi_index > div.navi__top.HH-Navi-StickyMenu-TopBlock > div > div > div > div.navi-cell.navi-cell_search > form.HH-Navi-SearchSelector-Tab.HH-Navi-SearchSelector-Form.HH-VacancyMap-Form > div > div.bloko-control-group__main > input")
	WebElement searchField;

	@FindBy(css = "body > div.navi.HH-VacancyMainSearchInfoTip-Navi.navi_index > div.navi__top.HH-Navi-StickyMenu-TopBlock > div > div > div > div.navi-cell.navi-cell_search > form.HH-Navi-SearchSelector-Tab.HH-Navi-SearchSelector-Form.HH-VacancyMap-Form > div > div.navi-search-button > button")
	WebElement searchButton;

	public SearchPage(WebDriver driver) {

		super(driver);
	}

	private SearchPage fillSearch(String position) {

		searchField.sendKeys(position);
		return this;
	}

	private SearchPage clickSearch() {

		searchButton.click();
		return this;
	}

	public ResultPage searchJob(String position) {

		fillSearch(position);
		clickSearch();
		return new ResultPage(getDriver());
	}

}
