package stepDefs;

import configuration.ReadProperties;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckoutInfoPage;
import pages.LoginPage;
import pages.ProductsPage;
import steps.CartStep;
import steps.CheckoutStep;
import steps.ProductsStep;

public class E2EStepDefs {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ProductsStep productsStep;
    private CartStep cartStep;
    private CheckoutInfoPage checkoutInfoPage;
    private CheckoutStep checkoutStep;


    @Given("Browser is opened")
    public void startBrowser() {
        driver = new BrowserFactory().getDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("Login Page is opened")
    public void openLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.openPageByUrl("/");
    }

    @When("User {string} with password {string} logged in")
    public void login(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.logInButton.click();
    }

    @When("Successful login")
    public void successfulLogin() {
        loginPage.successfulLogin(ReadProperties.username(), ReadProperties.password());
    }

    @Then("Product page is opened")
    public void isProductsPageOpened() {
        productsPage = new ProductsPage(driver);
        productsPage.getPageIdentifier().isDisplayed();
    }

    @When("First product is added to cart")
    public void addFirstProductToCart() {
        productsStep = new ProductsStep(driver);
        productsStep.addFirstProductToCart();
    }

    @When("Switch to Cart")
    public void switchToCart() {
        productsStep.switchToCart();
    }

    @When("Checkout")
    public void checkout() {
        cartStep = new CartStep(driver);
        cartStep.checkout();
    }

    @When("Fill first name {string}, last name {string} and zip {string}")
    public void fillYourInfo(String firstName, String lastName, String zip) {
        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.firstNameInput(firstName).lastNameInput(lastName).zipInput(zip).continueCheckout();
    }

    @When("Finish shopping")
    public void finish() {
        checkoutStep = new CheckoutStep(driver);
        checkoutStep.finishShopping();
    }

    @Then("Correct text about completion is displayed")
    public void correctTextAboutCompletionIsDisplayed() {
        Assert.assertEquals(checkoutStep.getCompleteText(), "THANK YOU FOR YOUR ORDER");
    }

}
