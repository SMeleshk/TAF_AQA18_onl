package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AnyProductPage extends BasePage {

    private final By backToProductsLocator = By.id("back-to-products");

    public AnyProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return backToProductsLocator;
    }

    public By getBackToProductsLocator() {
        return backToProductsLocator;
    }
}
