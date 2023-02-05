package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;

public class CheckoutInfoPage extends BasePage {

    private final static String pagePath = "/cart.html";
    private final By pageNameLocator = By.xpath("//span[text()='Checkout: Your Information']");
    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By zipInputLocator = By.id("postal-code");
    private final By continueButtonLocator = By.id("continue");
    private final By cancelButtonLocator = By.id("cancel");

    @Override
    protected By getPageIdentifier() {
        return pageNameLocator;
    }

    public By getFirstNameInputLocator() { return firstNameInputLocator; }

    public By getLastNameInputLocator() { return lastNameInputLocator; }

    public By getZipInputLocator() { return zipInputLocator; }

    public By getContinueButtonLocator() {
        return continueButtonLocator;
    }

    public By getCancelButtonLocator() {
        return cancelButtonLocator;
    }
}
