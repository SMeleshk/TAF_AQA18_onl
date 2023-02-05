package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage {

    private final static String pagePath = "/checkout-complete.html";
    private final By pageNameLocator = By.xpath("//span[text()='Checkout: Complete!']");
    private final By thankYouLocator = By.className("complete-header");
    private final By backHomeButtonLocator = By.id("back-to-products");


    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageIdentifier() {
        return driver.findElement(pageNameLocator);
    }

    public By getThankYouLocator() { return thankYouLocator; }

    public By getBackHomeButtonLocator() { return backHomeButtonLocator; }
}
