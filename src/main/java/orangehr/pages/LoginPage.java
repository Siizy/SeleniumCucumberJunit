package orangehr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTtitle() {
		System.out.println("I am fine");
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkAvailable() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pswd) {
		driver.findElement(password).sendKeys(pswd);
	}

	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}

	public AccountsPage Login(String username, String pswd) {
		enterUserName(username);
		enterPassword(pswd);
		clickOnLogin();

		return new AccountsPage(driver);
	}

}
