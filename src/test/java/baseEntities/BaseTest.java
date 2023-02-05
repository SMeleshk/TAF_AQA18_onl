package baseEntities;

import com.codeborne.selenide.Configuration;
import configuration.ReadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import steps.CartStep;
import steps.CheckoutStep;
import steps.ProductsStep;
import steps.UserStep;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    protected UserStep userStep;
    protected ProductsStep productsStep;
    protected CartStep cartStep;
    protected CheckoutStep checkoutStep;

    @BeforeSuite
    public void setUp() {
        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 15000;

        userStep = new UserStep();
        productsStep = new ProductsStep();
        cartStep = new CartStep();
        checkoutStep = new CheckoutStep();
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
