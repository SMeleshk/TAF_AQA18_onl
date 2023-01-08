package baseEntities;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.CartStep;
import steps.CheckoutStep;
import steps.ProductsStep;
import steps.UserStep;

public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected ProductsStep productsStep;
    protected CartStep cartStep;
    protected CheckoutStep checkoutStep;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
        driver.get(ReadProperties.getUrl());

        userStep = new UserStep(driver);
        productsStep = new ProductsStep(driver);
        cartStep = new CartStep(driver);
        checkoutStep = new CheckoutStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
