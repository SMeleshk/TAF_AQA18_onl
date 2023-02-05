package steps;

import org.openqa.selenium.By;
import pages.*;

import static com.codeborne.selenide.Selenide.$;

public class CartStep {
    private CartPage cartPage;

    public CartStep() {
        this.cartPage = new CartPage();
    }

    public String getFirstProductName() {
        return $(cartPage.getFirstProductNameLocator()).getText();
    }

    public String getSecondProductName() {
        return $(cartPage.getSecondProductNameLocator()).getText();
    }

    public void removeFirstProduct() {
        $(cartPage.getFirstProductRemoveButtonLocator()).click();
    }

    public void removeSecondProduct() {
        $(cartPage.getSecondProductRemoveButtonLocator()).click();
    }

    public By getFirstProductRemoveButtonLocator() { return cartPage.getFirstProductRemoveButtonLocator(); }

    public By getSecondProductRemoveButtonLocator() { return cartPage.getSecondProductRemoveButtonLocator(); }

    public ProductsPage continueShopping() {
        $(cartPage.getContinueShoppingButtonLocator()).click();
        return new ProductsPage();
    }

    public CheckoutInfoPage checkout() {
        $(cartPage.getCheckoutButtonLocator()).click();
        return new CheckoutInfoPage();
    }

}
