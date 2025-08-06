package StepDefinition;

import PageObject.AddtoCartPage;
import com.BaseClass.BaseClass;
import PageObject.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static org.apache.poi.xwpf.usermodel.XWPFRun.FontCharRange.cs;

public class AddtoCartStep extends BaseClass {


    LoginPage lp = new LoginPage(BaseClass.driver);
    AddtoCartPage addproduct = new AddtoCartPage(BaseClass.driver);



    @When("user adds product {string} to the cart")
    public void user_adds_product_to_the_cart(String productName) throws InterruptedException {
        Thread.sleep(5000);

        addproduct.clickOnProductByName(productName);
        addproduct.addproducttocart();


    }

    @When("user clicks on cart icon")
    public void user_clicks_on_cart_icon() {
        addproduct.clickoncart();

    }

    @And("user goes back to products page")
    public void user_goes_back_to_products_page() {
       addproduct.clickonbacktoproductpage();
    }

    @Then("user should be on cart page")
    public void user_should_be_on_cart_page() {
        addproduct.clickoncart();

    }

    @Then("the product {string} should be listed in the cart")
    public void the_product_should_be_listed_in_the_cart(String productName) {
        addproduct.clickoncart();
        Assert.assertTrue(addproduct.isProductDisplayed(productName));

    }

    @When("user adds {string} item to the cart")
    public void user_adds_item_to_the_cart(String productName) throws InterruptedException {
        addproduct.clickOnProductByName(productName);
        addproduct.addproducttocart();


    }

    @Then("cart should display {string} item")
    public void cart_should_display_item(String productName) {
        addproduct.clickoncart();


        Assert.assertTrue("Product '" + productName + "' is not displayed in the cart!",
                addproduct.isProductDisplayed(productName));


    }

    @Then("{string} should be visible in the cart")
    public void should_be_visible_in_the_cart(String productName) {
        Assert.assertTrue(addproduct.isProductDisplayed(productName));

    }

    @Then("the cart icon should show {string}")
    public void the_cart_icon_should_show(String expectedCount) {
        int actualCount = addproduct.itemsInCart();
        Assert.assertEquals(Integer.parseInt(expectedCount), actualCount);

    }

    @Then("both products {string} and {string} should be visible in the cart")
    public void both_products_and_should_be_visible_in_the_cart(String product1, String product2) {
        addproduct.clickoncart();
        Assert.assertTrue(addproduct.isProductDisplayed(product1));
        Assert.assertTrue(addproduct.isProductDisplayed(product2));
    }

    @When("user removes product {string} from the cart")
    public void user_removes_product_from_the_cart(String productName) {
        addproduct.removeproduct(productName);

    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        int actualCount = addproduct.itemsInCart();
        Assert.assertEquals(0, actualCount);


    }


}
