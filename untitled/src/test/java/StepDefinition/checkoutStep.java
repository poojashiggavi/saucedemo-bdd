package StepDefinition;

import PageObject.AddtoCartPage;
import PageObject.CheckoutPage;
import PageObject.LoginPage;
import com.BaseClass.BaseClass;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class checkoutStep extends BaseClass {


    LoginPage lp = new LoginPage(BaseClass.driver);
    AddtoCartPage addproduct = new AddtoCartPage(BaseClass.driver);
    CheckoutPage check = new CheckoutPage(BaseClass.driver);



    @Then("click on checkout button")
    public void click_on_checkout_button() {
        check.clickoncheckout();

    }

    @Then("fill firstname {string}, lastname {string} and postalcode {string}")
    public void fill_firstname_lastname_and_postalcode(String firstname, String lastname, String postalcode) {
        check.enterfirstname(firstname);
        check.enterlastname(lastname);
        check.enterpostalcode(postalcode);
    }

    @Then("click on continue button")
    public void click_on_continue_button() {
        check.clickoncontinue();
    }

    @Then("verify all the details as displayed")
    public void verify_all_the_details_as_displayed() {
        Assert.assertFalse(check.getQuantityText().isEmpty());
        Assert.assertFalse(check.getDescriptionText().isEmpty());
        Assert.assertFalse(check.getPaymentInfoText().isEmpty());
        Assert.assertFalse(check.getShippingInfoText().isEmpty());
        Assert.assertFalse(check.getPriceTotalText().isEmpty());

    }

    @Then("click on finish button")
    public void click_on_finish_button() {
        check.clickonfinish();

    }

    @Then("user can see the successful message")
    public void user_can_see_the_successful_message() {
        String successMsg = check.getcheckoutsucess();
        Assert.assertEquals("Thank you for your order!", successMsg);
    }

    @Then("User should get error message {string}")
    public void user_should_get_error_message(String expectedMessage) {
        String actualMessage = check.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }








}
