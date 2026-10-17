package stepDefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.*;

public class TestCase001 {

    private String selectedProductName;

    @Given("I open shop website")
    public void openShopWebsite() {
        ShopHomePage.openHomepage();
        ShopHomePage.acceptEssentialCookies();
    }

    @When("I open first category")
    public void openFirstCategory() {
        ShopHomePage.openSimpleProductsCategory();
    }

    @And("I choose first product")
    public void openFirstProduct() {
        ShopProductsPage.openFirstProduct();
        selectedProductName = ShopFirstProductPage.getProductName();
    }

    @And("I click Add to cart button")
    public void addProductToCart() {
        ShopFirstProductPage.addProductToCart();
    }

    @And("I click check my cart")
    public void openCart() {
        ShopHeader.openCart();
    }

    @Then("I see added product in my cart")
    public void verifyProductIsPresentInMyCart() {
        ShoppingCartPage.assertProductIsPresent(selectedProductName);
    }
}
