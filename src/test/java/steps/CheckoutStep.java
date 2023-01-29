package steps;

import baseEntities.BaseStep;
import models.Customer;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.*;

public class CheckoutStep extends BaseStep {
    private CheckoutInfoPage checkoutInfoPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;
    private Logger logger = LogManager.getLogger();
    public CheckoutStep(WebDriver driver) {
        super(driver);

        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    public void fillYourInformation(String firstName, String lastName, String zipCode) {
        driver.findElement(checkoutInfoPage.getFirstNameInputLocator()).sendKeys(firstName);
        driver.findElement(checkoutInfoPage.getLastNameInputLocator()).sendKeys(lastName);
        driver.findElement(checkoutInfoPage.getZipInputLocator()).sendKeys(zipCode);
    }

    public void fillYourInformation(Customer customer) {
        driver.findElement(checkoutInfoPage.getFirstNameInputLocator()).sendKeys(customer.getFirstName());
        driver.findElement(checkoutInfoPage.getLastNameInputLocator()).sendKeys(customer.getLastName());
        driver.findElement(checkoutInfoPage.getZipInputLocator()).sendKeys(customer.getZipCode());
        logger.info("[Info] Value Object pattern is used");
    }

    public void fillYourInformation(User user) {
        driver.findElement(checkoutInfoPage.getFirstNameInputLocator()).sendKeys(user.getFirstName());
        driver.findElement(checkoutInfoPage.getLastNameInputLocator()).sendKeys(user.getLastName());
        driver.findElement(checkoutInfoPage.getZipInputLocator()).sendKeys(user.getZipCode());
        logger.info("[Info] Lombok Builder is used");
    }

    public CheckoutOverviewPage continueCheckout() {
        driver.findElement(checkoutInfoPage.getContinueButtonLocator()).click();
        return new CheckoutOverviewPage(driver);
    }

    public String getFirstProductName() {
        return driver.findElement(checkoutOverviewPage.getFirstProductNameLocator()).getText();
    }

    public String getSecondProductName() {
        return driver.findElement(checkoutOverviewPage.getSecondProductNameLocator()).getText();
    }

    public String getItemTotalText() {
        return driver.findElement(checkoutOverviewPage.getItemTotalPrice()).getText();
    }

    public String getTotalText() {
        return driver.findElement(checkoutOverviewPage.getTotalPrice()).getText();
    }

    public CheckoutCompletePage finishShopping() {
        driver.findElement(checkoutOverviewPage.getFinishButtonLocator()).click();
        return new CheckoutCompletePage(driver);
    }

    public String getCompleteText() {
        return driver.findElement(checkoutCompletePage.getThankYouLocator()).getText();
    }

    public ProductsPage backHome() {
        driver.findElement(checkoutCompletePage.getBackHomeButtonLocator()).click();
        return new ProductsPage(driver);
    }
}
