package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    //@Test
    public void loginTest() {
        driver.get(ReadProperties.getUrl());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPasswordInput().sendKeys(ReadProperties.password());
        loginPage.getLoginButton().click();
        //same as:
//        driver.findElement(By.id("name")).sendKeys(ReadProperties.username());
//        driver.findElement(By.id("password")).sendKeys(ReadProperties.password());
//        driver.findElement(By.id("button_primary")).click();

//        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'All Projects')]")).isDisplayed());
        Assert.assertTrue(new DashboardPage(driver).isPageOpened());

    }

    //@Test
    public void loginSuccessfulTest() {
        Assert.assertTrue(
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                .isPageOpened()
        );
    }

    //@Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
        userStep.loginIncorrect(ReadProperties.username(), "123qqw")
                .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }
}
