package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private final static String pagePath = "/cart.html";
    private final By pageNameLocator = By.xpath("//span[text()='Your Cart']");
    private final By continueShoppingButtonLocator = By.id("continue-shopping");;
    private final By checkoutButtonLocator = By.id("checkout");
    private final By firstProductNameLocator = By.xpath("//a[@id='item_4_title_link']/child::div");
    private final By secondProductNameLocator = By.xpath("//a[@id='item_0_title_link']/child::div");

    private final By firstProductRemoveButtonLocator = By.id("remove-sauce-labs-backpack");
    private final By secondProductRemoveButtonLocator = By.id("remove-sauce-labs-bike-light");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return driver.findElement(pageNameLocator);
    }


    public By getContinueShoppingButtonLocator() {
        return continueShoppingButtonLocator;
    }

    public By getCheckoutButtonLocator() { return checkoutButtonLocator; }

    public By getFirstProductNameLocator() { return firstProductNameLocator; }

    public By getSecondProductNameLocator() { return secondProductNameLocator; }

    public By getFirstProductRemoveButtonLocator() {
        return firstProductRemoveButtonLocator;
    }

    public By getSecondProductRemoveButtonLocator() {
        return secondProductRemoveButtonLocator;
    }
}
