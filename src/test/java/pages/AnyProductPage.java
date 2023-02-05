package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AnyProductPage extends BasePage {

    private final By backToProductsLocator = By.id("back-to-products");

    public AnyProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageIdentifier() {
        return driver.findElement(backToProductsLocator);
    }

    public By getBackToProductsLocator() {
        return backToProductsLocator;
    }
}
