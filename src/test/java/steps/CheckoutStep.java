package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.*;

public class CheckoutStep extends BaseStep {
    private CheckoutInfoPage checkoutInfoPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;

    public CheckoutStep(WebDriver driver) {
        super(driver);

        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }


    //4. CHECKOUT: YOUR INFORMATION:
    //   4.1. First name input
    //   4.2. Last name input
    //   4.3. Zip/Postal code name input
    //   4.4. Continue
    //5. CHECKOUT: OVERVIEW, payment:
    //   5.1. Check first product
    //   5.2. Check second product
    //   5.3. Check Item total
    //   5.4. Check Total
    //   5.5. Finish
    //6. CHECKOUT: COMPLETE!:
    //   6.1. Check info "THANK YOU FOR YOUR ORDER"
    //   6.2. Back home

    public void fillYourInformation(String firstName, String lastName, String zipCode) {
        driver.findElement(checkoutInfoPage.getFirstNameInputLocator()).sendKeys(firstName);
        driver.findElement(checkoutInfoPage.getLastNameInputLocator()).sendKeys(lastName);
        driver.findElement(checkoutInfoPage.getZipInputLocator()).sendKeys(zipCode);
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
