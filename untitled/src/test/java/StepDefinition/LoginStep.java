package StepDefinition;

import com.BaseClass.BaseClass;
import PageObject.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class LoginStep extends BaseClass {


    LoginPage lp = new LoginPage(BaseClass.driver);
    @Given("user is on login page")
    public void user_is_on_login_page() throws IOException, InterruptedException {
        Thread.sleep(5000); // if needed, otherwise use wait logic
        lp = new LoginPage(driver);
        setupbrowser();

    }

    @When("user enters valid email address {string}")
    public void user_enters_valid_email_address(String username) {
        lp.email(username);

    }

    @When("user enters valid password {string}")
    public void user_enters_valid_password(String password1) {
         lp.password(password1);
    }

    @When("click on login button")
    public void click_on_login_button() {
        lp.clickonloginbutton();

    }

    @Then("user should successfully logged in")
    public void user_should_successfully_logged_in() {
        Assert.assertTrue(lp.productpageisdiapyed());


    }

    @And("click on logout button")
    public void click_on_logout_button() {
         lp.clickonlogout();
    }

    @When("user enters invalid email address {string}")
    public void user_enters_invalid_email_address(String invalidemail) {
        lp.email(invalidemail);

    }

    @When("user enters invalid password {string}")
    public void user_enters_invalid_password(String invalidpassword) {
          lp.password(invalidpassword);
    }

    @Then("user should get error message")
    public void user_should_get_error_message() {
        Assert.assertTrue(lp.errormessagedisplay());


    }

    @When("user does not enter any email address {string}")
    public void user_does_not_enter_any_email_address(String string) {
        lp.email("");

    }

    @When("user does not enter any password {string}")
    public void user_does_not_enter_any_password(String string) {
        lp.password("");

    }





}
