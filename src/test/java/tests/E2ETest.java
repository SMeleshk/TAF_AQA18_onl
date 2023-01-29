package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.Customer;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutInfoPage;

public class E2ETest extends BaseTest {

    private Logger logger = LogManager.getLogger();
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
        logger.info("[Info] Value Object pattern is used to create a customer: " + customer);
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
        logger.info("[Info] Chain of Invocations pattern is used");

        checkoutStep.finishShopping();
        Assert.assertEquals(checkoutStep.getCompleteText(), "THANK YOU FOR YOUR ORDER");
    }

    @Test
    public void builderTest() {
        userStep.login(ReadProperties.username(), ReadProperties.password());
        productsStep.addFirstProductToCart();
        productsStep.switchToCart();
        cartStep.checkout();

        //Lombok Builder
        User user = User.builder()
                .firstName("1")
                .lastName("2")
                .zipCode("3")
                .build();

        logger.info("[Info] Lombok Builder is used to create a user: " + user.toString());

        checkoutStep.fillYourInformation(user);

        checkoutStep.continueCheckout();
        checkoutStep.finishShopping();
        Assert.assertEquals(checkoutStep.getCompleteText(), "THANK YOU FOR YOUR ORDER");
    }




}
