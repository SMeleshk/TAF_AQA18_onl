package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.io.File;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");

        List<WebElement> targetElements = waitsService.waitForAllVisibleElementsLocatedBy(By.className("figure"));

        Actions actions = new Actions(driver);
        actions
                .moveToElement(targetElements.get(0), 10, 10)
                .click(waitsService.waitForExists(By.cssSelector("[href='/users/1']")))
                .build()
                .perform(); //до этой команды список не выполняется

        Assert.assertTrue(waitsService.waitForInvisibilityOf(targetElements.get(0)));
    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement fileUploadElement = waitsService.waitForExists(By.xpath("//input[@type='file']"));
        //String pathToFile = "src" + File.separator + "test/resources/123456.txt";
        String pathToFile = ActionsTest.class.getClassLoader().getResource("123456.txt").getPath().substring(1);

        fileUploadElement.sendKeys(pathToFile);
        waitsService.waitForVisibilityBy(By.id("file-submit")).submit();

        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("uploaded-files")).getText().trim(),
                "123456.txt");

    }

    @Test
    public void fileUploadTest1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement fileUploadElement = waitsService.waitForExists(By.xpath("//input[@type='file']"));
        String pathToFile = ActionsTest.class.getClassLoader().getResource("download.jpeg").getPath().substring(1);
        System.out.println(pathToFile);

        fileUploadElement.sendKeys(pathToFile);
        waitsService.waitForVisibilityBy(By.id("file-submit")).submit();

        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("uploaded-files")).getText().trim(),
                "download.jpeg");
    }
}
