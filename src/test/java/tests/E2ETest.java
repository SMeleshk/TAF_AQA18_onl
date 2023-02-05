package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class E2ETest extends BaseTest {

    @Test
    public void e2eTest() {
        open("/");
        userStep.login(ReadProperties.username(), ReadProperties.password());

        productsStep.addFirstProductToCart();
        productsStep.addSecondProductToCart();
        productsStep.switchToCart();

        cartStep.checkout();

        checkoutStep.fillYourInformation("1", "1", "1");
        checkoutStep.continueCheckout();
        checkoutStep.finishShopping();

        checkoutStep.getThankYou().shouldHave(text("THANK YOU FOR YOUR ORDER"));
    }
}
