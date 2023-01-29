package pages;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private Logger logger = LogManager.getLogger();


    public CheckoutInfoPage firstNameInput(String firstName) {
        driver.findElement(getFirstNameInputLocator()).sendKeys(firstName);
        logger.info("[Info] Chain of Invocations pattern is used to fill the first name: " + firstName);
        return new CheckoutInfoPage(driver);
    }

    public CheckoutInfoPage lastNameInput(String lastName) {
        driver.findElement(getLastNameInputLocator()).sendKeys(lastName);
        logger.info("[Info] Chain of Invocations pattern is used to fill the last name: " + lastName);
        return new CheckoutInfoPage(driver);
    }

    public CheckoutInfoPage zipInput(String zip) {
        driver.findElement(getZipInputLocator()).sendKeys(zip);
        logger.info("[Info] Chain of Invocations pattern is used to fill the zip code: " + zip);
        return new CheckoutInfoPage(driver);
    }

    public CheckoutOverviewPage continueCheckout() {
        driver.findElement(getContinueButtonLocator()).click();
        return new CheckoutOverviewPage(driver);
    }

}
