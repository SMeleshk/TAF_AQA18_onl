package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssSelectorsTest {
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
    public void cssLocatorsTest() {
        driver.get("E:\\JavaProjects\\Testing\\TAF_AQA18_onl\\TAF_AQA18_onl\\src\\test\\resources\\index.html");

        //поиск по id
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("my-Address")).isDisplayed());
        //+ [id='my-Address']

        //поиск по class name
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("newsletter")).isDisplayed());

        //поиск по нескольким значениям в аттрибуте class name
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter.noSel")).isDisplayed()); //без пробела, порядок неважен

        //поиск по tagname
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed()); //в devtool нужно ставить // перед тэгом
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());

        //поиск по tagname и class name
        Assert.assertTrue(driver.findElement(By.cssSelector("div.noSel.newsletter")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("p#my-Address")).isDisplayed()); //так можно, но не длается, тк id и так уникален

        //поиск по tagname родителя и дочерний class name
        Assert.assertEquals(driver.findElements(By.cssSelector("#Lastname .markup")).size(), 2);//элемент до пробела родитель (неважно какого уровня)
        Assert.assertTrue(driver.findElement(By.cssSelector(".intro .markup")).isDisplayed());

        //поиск всех элементов с tagname h1 или p
        Assert.assertEquals(driver.findElements(By.cssSelector("#h1, p")).size(), 8);

        //поиск элементов c tagname p с непосредственным родителем div
        Assert.assertEquals(driver.findElements(By.cssSelector("div > p")).size(), 6);

        //поиск элементов c tagname p которые идут сразу за элементом с tagname ul
        Assert.assertEquals(driver.findElements(By.cssSelector("ul + p")).size(), 1);

        //поиск элементов c аттрибутом lang у которого значение it
        Assert.assertEquals(driver.findElements(By.cssSelector("[lang='it']")).size(), 1);

        // Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size()); //тут пробел - имвол значения, не более

        //поиск элементов c аттрибутом lang
        Assert.assertEquals(driver.findElements(By.cssSelector("p[lang]")).size(), 1);

        //поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
        Assert.assertEquals(driver.findElements(By.cssSelector("[id$='ess']")).size(), 1);

        //поиск элементов c аттрибутом lang
        Assert.assertEquals(driver.findElements(By.cssSelector("p[lang]")).size(), 1);

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[id^=L]")).size());//одинарные кавычки не влияют на результат

        // Поиск всех элементов у которых присутствует аттрибут id с начинающимся словом value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size()); //одинарные кавычки не влияют на результат

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим слово целиком
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим подстроку
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*='o beautiful']")).size());


//СВОЙСТВА

        // Поиск всех disabled элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());

        // Поиск всех enabled элементов
        Assert.assertEquals(8, driver.findElements(By.cssSelector(":enabled")).size());

        // Поиск всех выборанных элементов
        Assert.assertEquals(2, driver.findElements(By.cssSelector(":checked")).size());

        // Поиск всех элементов c пустым телом (нет никакого вложения)
        Assert.assertEquals(16, driver.findElements(By.cssSelector(":empty")).size());


//ДОПОЛНИТЕЛЬНО

        // Поиск элемента с тэгом p и которым является первым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:first-child")).size());

        // Поиск элемента с тэгом p и которым является последним дочерним элементом
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p:last-child")).size());

        // Поиск элемента с тэгом p и которым является n-ым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(2)")).size());
    }
}
