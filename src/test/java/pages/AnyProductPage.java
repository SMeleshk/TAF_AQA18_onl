package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;

public class AnyProductPage extends BasePage {

    private final By backToProductsLocator = By.id("back-to-products");


    @Override
    protected By getPageIdentifier() {
        return backToProductsLocator;
    }

    public By getBackToProductsLocator() {
        return backToProductsLocator;
    }
}
