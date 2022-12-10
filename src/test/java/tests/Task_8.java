package tests;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_8 {

//Создать отдельный тестовый Java-класс Task_8 с тестом, сценарий:
//Залогиниться https://www.saucedemo.com/
//Добавить товар в корзину
//Перейти в корзину
//Проверить (assertEquals) стоимость товара и его имя в корзине
//Выполнить поиск локаторов по следующим критериям (тест должен включать хотя  бы один локатор из списка и из подсписка):
// id +
//name +
//classname +
//tagname +
//linktext +
//partiallinktext +

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void cssLocatorsTest() throws InterruptedException {
        driver.get(ReadProperties.getUrl());
        String username = ReadProperties.username();
        String password = ReadProperties.password();
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), "Sauce Labs Backpack");
        Assert.assertEquals(driver.findElement(By.className("inventory_item_price")).getText(), "$29.99");
        Assert.assertEquals(driver.findElements(By.tagName("button")).size(), 5);
        Assert.assertTrue(driver.findElement(By.linkText("Twitter")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.partialLinkText("Linked")).isDisplayed());


//xpath
        //Поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class]")).isDisplayed());

        //Поиск по тексту, например By.xpath("//tag[text()='text']");
        Assert.assertTrue(driver.findElement(By.xpath("//*[text() = 'DESCRIPTION']")).isDisplayed());

        //Поиск по частичному совпадению атрибута, например By.xpath("//tag[contains(@attribute,'text')]");
        Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@alt,'Swag')]")).isDisplayed());

        //Поиск по частичному совпадению текста, например By.xpath("//tag[contains(text(),'text')]");
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'streamlined')]")).isDisplayed());

        //ancestor, например //*[text()='Enterprise Testing']//ancestor::div
        Assert.assertEquals(driver.findElements(By.xpath("//li/ancestor::footer")).size(), 1);

        //descendant
        Assert.assertEquals(driver.findElements(By.xpath("//footer/descendant::li")).size(), 3);

        //following
        Assert.assertEquals(driver.findElements(By.xpath("//ul[@class='social']/following::div")).size(), 1);

        //parent
        Assert.assertEquals(driver.findElements(By.xpath("//ul/parent::footer")).size(), 1);

        //preceding
        Assert.assertEquals(driver.findElements(By.xpath("//*[@class=\"bm-cross-button\"]/preceding::a")).size(), 4);

        //*поиск элемента с условием AND, например //input[@class='_2zrpKA _1dBPDZ' and @type='text']
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Facebook' and @target='_blank']")).isDisplayed());

//css
        //.class
        Assert.assertTrue(driver.findElement(By.cssSelector(".social_facebook")).isDisplayed());

        //.class1.class2
        Assert.assertTrue(driver.findElement(By.cssSelector(".btn.checkout_button")).isDisplayed());

        //.class1 .class2
        Assert.assertTrue(driver.findElement(By.cssSelector(".social .social_twitter")).isDisplayed());

        //#id
        Assert.assertTrue(driver.findElement(By.cssSelector("#remove-sauce-labs-backpack")).isDisplayed());

        //tagname
        Assert.assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());

        //tagname.class
        Assert.assertTrue(driver.findElement(By.cssSelector("div.inventory_item_price")).isDisplayed());

        //[attribute=value]
        Assert.assertEquals(driver.findElements(By.cssSelector("[data-test]")).size(), 3);

        //[attribute~=value]
        Assert.assertEquals(driver.findElements(By.cssSelector("[content~=Labs]")).size(), 1);

        //[attribute|=value]
        Assert.assertEquals(driver.findElements(By.cssSelector("[data-test|=remove]")).size(), 1);

        //[attribute^=value]
        Assert.assertEquals(driver.findElements(By.cssSelector("[data-test^=che]")).size(), 1);

        //[attribute$=value]
        Assert.assertEquals(driver.findElements(By.cssSelector("[data-test$=ing]")).size(), 1);

        //[attribute*=value]
        Assert.assertEquals(driver.findElements(By.cssSelector("[data-test*='sauce']")).size(), 1);
    }
}
