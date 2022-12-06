package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HWCalcRehauTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void validateRehauCalculator() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        driver.findElement(By.id("el_f_width")).sendKeys("3");
        driver.findElement(By.id("el_f_lenght")).sendKeys("4");

        WebElement selectWebElement1 = driver.findElement(By.id("room_type"));
        Select selectRoom = new Select(selectWebElement1);
        selectRoom.selectByValue("2");

        WebElement selectWebElement2 = driver.findElement(By.id("heating_type"));
        Select selectType = new Select(selectWebElement2);
        selectType.selectByValue("3");

        driver.findElement(By.id("el_f_losses")).sendKeys("100");
        driver.findElement(By.name("button")).click();

        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.id("floor_cable_power")).getAttribute("value"), "56");
        Assert.assertEquals(driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value"), "5");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
