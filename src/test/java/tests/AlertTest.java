package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test
    public void infoAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Alert");

        alert.accept(); //нажать OK (в любых его вариациях)
    }

    @Test
    public void confirmAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.accept();
        //тут фокус браузера смещается на страницу с алерта, никаких действий не требуется, алерт как объект исчезает

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok");

        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();

        //необходимо свичнуться, так как пердыдущий объект исчез, это новый
        alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.dismiss();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
    }

    @Test
    public void promptAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS prompt");

        alert.sendKeys("sdfsdf");
        alert.accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: sdfsdf");
    }

    @Test
    public void propertyTest() {
        System.out.println("testProp");
    }
}
