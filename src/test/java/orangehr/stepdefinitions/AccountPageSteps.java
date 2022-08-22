package orangehr.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import orangehr.factory.DriverFactory;
import orangehr.pages.AccountsPage;
import orangehr.pages.LoginPage;

public class AccountPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;

	@Given("user has already logged into application")
	public void user_has_already_logged_into_application(DataTable dataTable) {
		List<Map<String, String>> credentials = dataTable.asMaps();
		String userName = credentials.get(0).get("username");
		String pswd = credentials.get(0).get("password");

		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		DriverFactory.getDriver().manage().window().maximize();
		accountsPage = loginPage.Login(userName, pswd);
	}

	@Given("user is on Account page")
	public void user_is_on_account_page() {
		accountsPage.getAccountPageTitle();
	}

	@SuppressWarnings("unlikely-arg-type")
	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		List<String> expAccountSectionList = sectionTable.asList();
		List<String> actualAccountSectionList = accountsPage.getAccountsSectionList();

		Assert.assertTrue(expAccountSectionList.contains(actualAccountSectionList));

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer count) {
		Assert.assertTrue(accountsPage.getAccountSectionCount() == count);
	}

}
