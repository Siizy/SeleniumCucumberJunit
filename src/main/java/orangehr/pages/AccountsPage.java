package orangehr.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;
	private By accountSections = By.cssSelector("div#center_column span");

	public int getAccountSectionCount() {
		return driver.findElements(accountSections).size() - 1;
	}

	public List<String> getAccountsSectionList() {
		List<String> accountList = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(accountSections);

		for (WebElement e : accountsHeaderList) {
			accountList.add(e.getText());
		}

		return accountList;
	}

	public String getAccountPageTitle() {
		return driver.getTitle();
	}

}
