package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AnyProductPage;
import pages.CartPage;
import pages.ProductsPage;

public class ProductsStep extends BaseStep {
    private ProductsPage productsPage;
    private AnyProductPage anyProductPage;

    public ProductsStep(WebDriver driver) {
        super(driver);

        productsPage = new ProductsPage(driver);
        anyProductPage = new AnyProductPage(driver);
    }

    public AnyProductPage switchToFirstProductPage() {
        driver.findElement(productsPage.getFirstProductNameLocator()).click();
        return new AnyProductPage(driver);
    }
    public void addFirstProductToCart() { driver.findElement(productsPage.getFirstProductAddButtonLocator()).click(); }
    public void removeFirstProductFromCart() { driver.findElement(productsPage.getFirstProductRemoveButtonLocator()).click(); }

    public AnyProductPage switchToSecondProductPage() {
        driver.findElement(productsPage.getSecondProductNameLocator()).click();
        return new AnyProductPage(driver);
    }
    public void addSecondProductToCart() { driver.findElement(productsPage.getSecondProductAddButtonLocator()).click(); }
    public void removeSecondProductFromCart() { driver.findElement(productsPage.getSecondProductRemoveButtonLocator()).click(); }

    public AnyProductPage switchToThirdProductPage() {
        driver.findElement(productsPage.getThirdProductNameLocator()).click();
        return new AnyProductPage(driver);
    }
    public void addThirdProductToCart() { driver.findElement(productsPage.getThirdProductAddButtonLocator()).click(); }
    public void removeThirdProductFromCart() { driver.findElement(productsPage.getThirdProductRemoveButtonLocator()).click(); }

    public CartPage switchToCart() {
        driver.findElement(productsPage.getCartButtonLocator()).click();
        return new CartPage(driver);
    }

    public ProductsPage backToProducts() {
        driver.findElement(anyProductPage.getBackToProductsLocator()).click();
        return new ProductsPage(driver);
    }

    public String getBadgeText() {
        return driver.findElement(productsPage.getCartBadgeLocator()).getText();
    }


}
