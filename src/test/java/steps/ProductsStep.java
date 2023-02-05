package steps;

import pages.AnyProductPage;
import pages.CartPage;
import pages.ProductsPage;

import static com.codeborne.selenide.Selenide.$;

public class ProductsStep {
    private ProductsPage productsPage;
    private AnyProductPage anyProductPage;

    public ProductsStep() {
        productsPage = new ProductsPage();
        anyProductPage = new AnyProductPage();
    }

    public AnyProductPage switchToFirstProductPage() {
        $(productsPage.getFirstProductNameLocator()).click();
        return new AnyProductPage();
    }
    public void addFirstProductToCart() { $(productsPage.getFirstProductAddButtonLocator()).click(); }
    public void removeFirstProductFromCart() { $(productsPage.getFirstProductRemoveButtonLocator()).click(); }

    public AnyProductPage switchToSecondProductPage() {
        $(productsPage.getSecondProductNameLocator()).click();
        return new AnyProductPage();
    }
    public void addSecondProductToCart() { $(productsPage.getSecondProductAddButtonLocator()).click(); }
    public void removeSecondProductFromCart() { $(productsPage.getSecondProductRemoveButtonLocator()).click(); }

    public AnyProductPage switchToThirdProductPage() {
        $(productsPage.getThirdProductNameLocator()).click();
        return new AnyProductPage();
    }
    public void addThirdProductToCart() { $(productsPage.getThirdProductAddButtonLocator()).click(); }
    public void removeThirdProductFromCart() { $(productsPage.getThirdProductRemoveButtonLocator()).click(); }

    public CartPage switchToCart() {
        $(productsPage.getCartButtonLocator()).click();
        return new CartPage();
    }

    public ProductsPage backToProducts() {
        $(anyProductPage.getBackToProductsLocator()).click();
        return new ProductsPage();
    }

    public String getBadgeText() {
        return $(productsPage.getCartBadgeLocator()).getText();
    }


}
