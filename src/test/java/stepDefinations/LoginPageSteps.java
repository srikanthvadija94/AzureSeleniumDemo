package stepDefinations;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	//driver will get from DriverFactory by using "getDriver()" method
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;

	@Given("User is on login page")
	public void user_is_on_login_page() {
 
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@Then("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
   
		title = loginPage.getLoginPageTitle();
		System.out.println("Page Title is: " + title);
	
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
   
		Assert.assertTrue(title.contains(expectedTitleName));
	} 

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
    
		Assert.assertTrue(loginPage.isForogotPwdLinkExist());
		
	}

	@When("User enters username as {string} in username field")
	public void user_enters_username_as_in_username_field(String username) {
    
		loginPage.enterUserName(username);
	}

	@When("User enters password as {string} in password field")
	public void user_enters_password_as_in_password_field(String password) {
   
		loginPage.enterPassword(password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
    
		loginPage.ClickOnLogin();
	}

	

}
