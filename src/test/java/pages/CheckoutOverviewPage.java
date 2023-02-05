package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;

public class CheckoutOverviewPage extends BasePage {

    private final static String pagePath = "/cart.html";
    private final By pageNameLocator = By.xpath("//span[text()='Checkout: Overview']");
    private final By finishButtonLocator = By.id("finish");
    private final By cancelButtonLocator = By.id("cancel");
    private final By firstProductNameLocator = By.xpath("//a[@id='item_4_title_link']/child::div");
    private final By secondProductNameLocator = By.xpath("//a[@id='item_0_title_link']/child::div");


    private final By itemTotalPrice = By.className("summary_subtotal_label");
    private final By totalPrice = By.className("summary_total_label");

    @Override
    protected By getPageIdentifier() {
        return pageNameLocator;
    }

    public By getFinishButtonLocator() {
        return finishButtonLocator;
    }

    public By getCancelButtonLocator() {
        return cancelButtonLocator;
    }

    public By getFirstProductNameLocator() { return firstProductNameLocator; }

    public By getSecondProductNameLocator() { return secondProductNameLocator; }

    public By getItemTotalPrice() { return itemTotalPrice; }

    public By getTotalPrice() { return totalPrice; }
}
