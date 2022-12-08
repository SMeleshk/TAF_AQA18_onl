package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XpathSelectorsTest {
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
    public void xpathLocatorsTest() {
        driver.get("E:\\JavaProjects\\Testing\\TAF_AQA18_onl\\TAF_AQA18_onl\\src\\test\\resources\\index.html");

        //Абсолютный Xpath
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/p[1]")).isDisplayed());

        //Все элементы на странице
        Assert.assertEquals(128, driver.findElements(By.xpath("//*")).size());

        // Аналог поиска по tagName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        // Аналог родительского div и на один уровень ниже h1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());

        // Аналог родительского div и на любом уровене ниже div
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());


//Аттрибуты

        // Поиск элемента с тэгом div у которого есть аттрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        // Поиск элемента у которого есть аттрибут id cо значением top-logo
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'top-logo']")).isDisplayed());

        // Поиск элемента у которого есть аттрибут method cо значением и аттрибут target со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' and @target='_blank']")).isDisplayed());

        // Поиск элемента c аттрибутом lang или class со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@lang or @class=\"noSel newsletter\"]")).isDisplayed());

        // Поиск элемента у которого значение аттрибута начинается с
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id, 'new')]")).isDisplayed());

        // Поиск элемента у которого значение аттрибута содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'Template')]")).isDisplayed());


        //отличительная особенность Xpath - поиск по тексту
        // Поиск элемента у которого текстовое значение содержит равно
        Assert.assertTrue(driver.findElement(By.xpath("//*[text() = 'We are all animals!']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = '<table>']")).isDisplayed());
        //если текст непосредственно между открывающим и закрывающим тегом, тогда text можно заменить на точку

        // Поиск элемента у которого текстовое значение содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'All Projects')]")).isDisplayed());

        // Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'summary-links text-secondary']/a[2]")).isDisplayed());
        //в рамках одного уровня
        //в xpath масив начинается с элемента с индеком 1
        //используем в крайних случаях
    }

    @Test
    public void xpathAxesTest() {
        driver.get("E:\\JavaProjects\\Testing\\TAF_AQA18_onl\\TAF_AQA18_onl\\src\\test\\resources\\index.html");

        //syntax is axisname::nodetest[predicate]

        //подняться на один уровень /..
        // Поиск родителя у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::div")).isDisplayed());
        //лучше использовать parent::*

        // Поиск всех предков с тэгом div у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // Использование child - непосредственно дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::a")).isDisplayed());

        // Использование child - все дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div//a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div/descendant::a")).isDisplayed());

        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following::form")).isDisplayed());

        //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"dialog-title\"]/preceding::form")).isDisplayed());

        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding-sibling::form")).isDisplayed());
        //так же following
    }
}
