package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.Customer;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutInfoPage;

public class E2ETest extends BaseTest {

    @Test
    public void valueObjectTest() {
        userStep.login(ReadProperties.username(), ReadProperties.password());
        productsStep.addFirstProductToCart();
        productsStep.addSecondProductToCart();
        productsStep.switchToCart();

        cartStep.checkout();

        //Value Object
        Customer customer = new Customer();
        customer.setFirstName("2");
        customer.setLastName("3");
        customer.setZipCode("4");
        checkoutStep.fillYourInformation(customer);

        checkoutStep.continueCheckout();
        checkoutStep.finishShopping();
        Assert.assertEquals(checkoutStep.getCompleteText(), "THANK YOU FOR YOUR ORDER");
    }

    @Test
    public void chainTest() {
        userStep.login(ReadProperties.username(), ReadProperties.password());
        productsStep.addFirstProductToCart();
        productsStep.switchToCart();
        cartStep.checkout();

        //Chain of Invocation
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.firstNameInput("1").lastNameInput("1").zipInput("1").continueCheckout();

        checkoutStep.finishShopping();
        Assert.assertEquals(checkoutStep.getCompleteText(), "THANK YOU FOR YOUR ORDER");
    }

    @Test
    public void builderTest() {
        userStep.login(ReadProperties.username(), ReadProperties.password());
        productsStep.addFirstProductToCart();
        productsStep.switchToCart();
        cartStep.checkout();

        //Builder
        User user = new User.Builder()
                .withFirstName("1")
                .withLastName("2")
                .withZipCode("3")
                .build();

        checkoutStep.fillYourInformation(user);

        checkoutStep.continueCheckout();
        checkoutStep.finishShopping();
        Assert.assertEquals(checkoutStep.getCompleteText(), "THANK YOU FOR YOUR ORDER");
    }




}
