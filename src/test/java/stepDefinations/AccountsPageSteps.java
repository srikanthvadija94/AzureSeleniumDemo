package stepDefinations;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("User has already login into the Application")
	public void user_has_already_login_into_the_application(DataTable credTable) {
	    
		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(userName, password);
		
	}

	@Given("User is on Accounts page")
	public void user_is_on_accounts_page() {
	   String title = accountsPage.getAccountsPageTitle();	
		System.out.println("Accounts page title is: " + title);
	}

	@Then("User gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {

		List<String> expAccountSectionsList = sectionsTable.asList();
		System.out.println("expected account section List: " + expAccountSectionsList);
		
		List<String> actualAcountSectionsList = accountsPage.getAccountsSectionsList();
		System.out.println("actual account section List: " + actualAcountSectionsList);
		
		Assert.assertTrue(expAccountSectionsList.containsAll(actualAcountSectionsList));
	}

	@Then("Accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
	   
		Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
		
	}
	
	
	
	
}
