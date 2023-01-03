package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    //Frames
    //Открыть iFrame
    //Проверить, что текст внутри параграфа равен “Your content goes here.”

    @Test
    public void framesTest() {
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("iFrame")).click();

        waitsService.waitForVisibilityBy(By.tagName("h3"));
        driver.switchTo().frame("mce_0_ifr");
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),
                "Your content goes here.");
    }
}
