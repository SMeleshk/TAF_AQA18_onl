package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2ETest extends BaseTest {

    @Test
    public void fullTest() {
        Assert.assertTrue(
                userStep.login(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened()
        );

    //2.1. Add first product to cart
    //   2.2. Open page with second product
    //   2.3. Add second product to cart
    //   2.4. Back to products
    //   2.5. Add third product to cart
    //   2.6. Open page with third product
    //   2.7. Remove third product
    //   2.8. Back to products
    //   2.9. Switch to cart
        productsStep.addFirstProductToCart();
        Assert.assertEquals(productsStep.getBadgeText(), "1");
        Assert.assertTrue(productsStep.switchToSecondProductPage().isPageOpened());
        productsStep.addSecondProductToCart();
        Assert.assertEquals(productsStep.getBadgeText(), "2");
        Assert.assertTrue(productsStep.backToProducts().isPageOpened());
        productsStep.addThirdProductToCart();
        Assert.assertEquals(productsStep.getBadgeText(), "3");
        Assert.assertTrue(productsStep.switchToThirdProductPage().isPageOpened());
        productsStep.removeThirdProductFromCart();
        Assert.assertEquals(productsStep.getBadgeText(), "2");
        Assert.assertTrue(productsStep.backToProducts().isPageOpened());
        Assert.assertTrue(productsStep.switchToCart().isPageOpened());

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
       Assert.assertEquals(cartStep.getFirstProductName(), "Sauce Labs Backpack");
       Assert.assertEquals(cartStep.getSecondProductName(), "Sauce Labs Bike Light");
       cartStep.removeSecondProduct();
       Assert.assertEquals(productsStep.getBadgeText(), "1");
       Assert.assertTrue(cartStep.continueShopping().isPageOpened());
       productsStep.addSecondProductToCart();
       productsStep.switchToCart();
       Assert.assertEquals(cartStep.getFirstProductName(), "Sauce Labs Backpack");
       Assert.assertEquals(cartStep.getSecondProductName(), "Sauce Labs Bike Light");
       Assert.assertTrue(cartStep.checkout().isPageOpened());

    //4. CHECKOUT: YOUR INFORMATION:
    //   4.1. First name input
    //   4.2. Last name input
    //   4.3. Zip/Postal code name input
    //   4.4. Continue
        checkoutStep.fillYourInformation("1", "1", "1");
        Assert.assertTrue(checkoutStep.continueCheckout().isPageOpened());

    //5. CHECKOUT: OVERVIEW, payment:
    //   5.1. Check first product
    //   5.2. Check second product
    //   5.3. Check Item total
    //   5.4. Check Total
    //   5.5. Finish
        Assert.assertEquals(checkoutStep.getFirstProductName(), "Sauce Labs Backpack");
        Assert.assertEquals(checkoutStep.getSecondProductName(), "Sauce Labs Bike Light");
        Assert.assertEquals(checkoutStep.getItemTotalText(), "Item total: $39.98");
        Assert.assertEquals(checkoutStep.getTotalText(), "Total: $43.18");
        Assert.assertTrue(checkoutStep.finishShopping().isPageOpened());

    //6. CHECKOUT: COMPLETE!:
    //   6.1. Check info "THANK YOU FOR YOUR ORDER"
    //   6.2. Back home
        Assert.assertEquals(checkoutStep.getCompleteText(), "THANK YOU FOR YOUR ORDER");
        Assert.assertTrue(checkoutStep.backHome().isPageOpened());

    //7. Logout:
        Assert.assertTrue(userStep.logout().isPageOpened());
    }

    @Test
    public void e2eTest() {
        userStep.login(ReadProperties.username(), ReadProperties.password());

        productsStep.addFirstProductToCart();
        productsStep.addSecondProductToCart();
        productsStep.switchToCart();

        cartStep.checkout();

        checkoutStep.fillYourInformation("1", "1", "1");
        checkoutStep.continueCheckout();
        checkoutStep.finishShopping();

        Assert.assertEquals(checkoutStep.getCompleteText(), "THANK YOU FOR YOUR ORDER");
    }




}
