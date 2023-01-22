package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInfoPage extends BasePage {

    private final static String pagePath = "/cart.html";
    private final By pageNameLocator = By.xpath("//span[text()='Checkout: Your Information']");
    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By zipInputLocator = By.id("postal-code");
    private final By continueButtonLocator = By.id("continue");
    private final By cancelButtonLocator = By.id("cancel");


    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return driver.findElement(pageNameLocator);
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


    public CheckoutInfoPage firstNameInput(String firstName) {
        driver.findElement(getFirstNameInputLocator()).sendKeys(firstName);
        return new CheckoutInfoPage(driver);
    }

    public CheckoutInfoPage lastNameInput(String lastName) {
        driver.findElement(getLastNameInputLocator()).sendKeys(lastName);
        return new CheckoutInfoPage(driver);
    }

    public CheckoutInfoPage zipInput(String zip) {
        driver.findElement(getZipInputLocator()).sendKeys(zip);
        return new CheckoutInfoPage(driver);
    }

    public CheckoutOverviewPage continueCheckout() {
        driver.findElement(getContinueButtonLocator()).click();
        return new CheckoutOverviewPage(driver);
    }

}
