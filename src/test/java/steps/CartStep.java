package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.*;

public class CartStep extends BaseStep {
    private CartPage cartPage;

    public CartStep(WebDriver driver) {
        super(driver);

        cartPage = new CartPage(driver);
    }

    // Work with cart:
    //   3.1. Check first product
    //   3.2. Check second product
    //   3.3. Remove second product
    //   3.4. Continue shopping
    //   3.5. Add second product to cart
    //   3.6. Switch to cart
    //   3.7. Check first product
    //   3.8. Check second product
    //   3.9. Checkout

    public String getFirstProductName() {
        return driver.findElement(cartPage.getFirstProductNameLocator()).getText();
    }

    public String getSecondProductName() {
        return driver.findElement(cartPage.getSecondProductNameLocator()).getText();
    }

    public void removeFirstProduct() {
        driver.findElement(cartPage.getFirstProductRemoveButtonLocator()).click();
    }

    public void removeSecondProduct() {
        driver.findElement(cartPage.getSecondProductRemoveButtonLocator()).click();
    }

    public By getFirstProductRemoveButtonLocator() { return cartPage.getFirstProductRemoveButtonLocator(); }

    public By getSecondProductRemoveButtonLocator() { return cartPage.getSecondProductRemoveButtonLocator(); }

    public ProductsPage continueShopping() {
        driver.findElement(cartPage.getContinueShoppingButtonLocator()).click();
        return new ProductsPage(driver);
    }

    public CheckoutInfoPage checkout() {
        driver.findElement(cartPage.getCheckoutButtonLocator()).click();
        return new CheckoutInfoPage(driver);
    }

}
