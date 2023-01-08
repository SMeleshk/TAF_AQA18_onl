package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final static String pagePath = "/inventory.html";

    //блок описания локаторов для элементов
    private final By pageNameLocator = By.xpath("//span[text()='Products']");

    private final By firstProductNameLocator = By.xpath("//div[text()='Sauce Labs Backpack']");
    private final By firstProductAddButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By firstProductRemoveButtonLocator = By.id("remove-sauce-labs-backpack");
    private final By secondProductNameLocator = By.xpath("//div[text()='Sauce Labs Bike Light']");
    private final By secondProductAddButtonLocator = By.id("add-to-cart-sauce-labs-bike-light");
    private final By secondProductRemoveButtonLocator = By.id("remove-sauce-labs-bike-light");

    private final By thirdProductNameLocator = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");
    private final By thirdProductAddButtonLocator = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By thirdProductRemoveButtonLocator = By.id("remove-sauce-labs-bolt-t-shirt");
    private final By forthProductNameLocator = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    private final By forthProductAddButtonLocator = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By forthProductRemoveButtonLocator = By.id("remove-sauce-labs-fleece-jacket");
    private final By fifthProductNameLocator = By.xpath("//div[text()='Sauce Labs Onesie']");
    private final By fifthProductAddButtonLocator = By.id("add-to-cart-sauce-labs-onesie");
    private final By fifthProductRemoveButtonLocator = By.id("remove-sauce-labs-onesie");
    private final By sixthProductNameLocator = By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']");
    private final By sixthProductAddButtonLocator = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private final By sixthProductRemoveButtonLocator = By.id("remove-test.allthethings()-t-shirt-(red)");

    private final By cartButtonLocator = By.className("shopping_cart_link");
    private final By cartBadgeLocator = By.className("shopping_cart_badge");

    //блок инициализации страницы
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return pageNameLocator;
    }

    //блок атомарных методов
    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
    public By getFirstProductNameLocator() { return firstProductNameLocator; }

    public By getFirstProductAddButtonLocator() {
        return firstProductAddButtonLocator;
    }

    public By getFirstProductRemoveButtonLocator() {
        return firstProductRemoveButtonLocator;
    }

    public By getSecondProductNameLocator() {
        return secondProductNameLocator;
    }

    public By getSecondProductAddButtonLocator() {
        return secondProductAddButtonLocator;
    }

    public By getSecondProductRemoveButtonLocator() {
        return secondProductRemoveButtonLocator;
    }

    public By getThirdProductNameLocator() {
        return thirdProductNameLocator;
    }

    public By getThirdProductAddButtonLocator() {
        return thirdProductAddButtonLocator;
    }

    public By getThirdProductRemoveButtonLocator() {
        return thirdProductRemoveButtonLocator;
    }

    public By getCartButtonLocator() {
        return cartButtonLocator;
    }

    public By getCartBadgeLocator() { return cartBadgeLocator; }
}
