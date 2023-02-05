package steps;

import com.codeborne.selenide.SelenideElement;
import pages.*;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutStep {
    private CheckoutInfoPage checkoutInfoPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;

    public CheckoutStep() {
        checkoutInfoPage = new CheckoutInfoPage();
        checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutCompletePage = new CheckoutCompletePage();
    }


    public void fillYourInformation(String firstName, String lastName, String zipCode) {
        $(checkoutInfoPage.getFirstNameInputLocator()).sendKeys(firstName);
        $(checkoutInfoPage.getLastNameInputLocator()).sendKeys(lastName);
        $(checkoutInfoPage.getZipInputLocator()).sendKeys(zipCode);
    }

    public CheckoutOverviewPage continueCheckout() {
        $(checkoutInfoPage.getContinueButtonLocator()).click();
        return new CheckoutOverviewPage();
    }

    public String getFirstProductName() {
        return $(checkoutOverviewPage.getFirstProductNameLocator()).getText();
    }

    public String getSecondProductName() {
        return $(checkoutOverviewPage.getSecondProductNameLocator()).getText();
    }

    public String getItemTotalText() {
        return $(checkoutOverviewPage.getItemTotalPrice()).getText();
    }

    public String getTotalText() {
        return $(checkoutOverviewPage.getTotalPrice()).getText();
    }

    public CheckoutCompletePage finishShopping() {
        $(checkoutOverviewPage.getFinishButtonLocator()).click();
        return new CheckoutCompletePage();
    }

    public String getCompleteText() {
        return $(checkoutCompletePage.getThankYouLocator()).getText();
    }

    public SelenideElement getThankYou() {
        return $(checkoutCompletePage.getThankYouLocator());
    }

    public ProductsPage backHome() {
        $(checkoutCompletePage.getBackHomeButtonLocator()).click();
        return new ProductsPage();
    }
}
