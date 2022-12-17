package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicControlsTest extends BaseTest {

    //Dynamic Controls
    //Найти чекбокс
    //Нажать на кнопку
    //Дождаться надписи “It’s gone”
    //Проверить, что чекбокса нет

    //Найти инпут
    //Проверить, что он disabled
    //Нажать на кнопку
    //Дождаться надписи “It's enabled!”
    //Проверить, что инпут enabled

    Actions actions = new Actions(driver);

    @Test
    public void checkboxTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        actions
                .moveToElement(driver.findElement(By.cssSelector("[type='checkbox']")))
                .click()
                .moveToElement(driver.findElement(By.cssSelector("[onclick='swapCheckbox()']")))
                .click()
                .build()
                .perform();

        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("message")).getText(), "It's gone!");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        Assert.assertEquals(checkboxes.size(), 0);
    }

    @Test
    public void inputTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        Assert.assertFalse(driver.findElement(By.cssSelector("[type='text']")).isEnabled());

        actions
                .moveToElement(driver.findElement(By.cssSelector("[onclick='swapInput()']")))
                .click()
                .build()
                .perform();

        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("message")).getText(), "It's enabled!");
        Assert.assertTrue(driver.findElement(By.cssSelector("[type='text']")).isEnabled());
    }
}
