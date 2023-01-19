package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import factory.BrowserFactory;
import io.qameta.allure.*;
import models.Project;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.project.AddProjectPage;
import steps.NavigationStep;

public class LoginTest extends BaseTest {

    //@Test
    public void loginTest() {
        driver.get(ReadProperties.getUrl());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPasswordInput().sendKeys(ReadProperties.password());
        loginPage.getLoginButton().click();
        Assert.assertTrue(new DashboardPage(driver).isPageOpened());

    }

//    @Test (description = "123")
//    @Issue("AQA18-12")
//    @TmsLink("TC-001")
//    @Description("Description1")
//    @Link("https://onliner.by")
//    @Link(name = "catalog", type = "mylink", url = "https://onliner.by")
//    @Severity(SeverityLevel.BLOCKER)
//    public void loginSuccessfulTest() {
//        User user = new User.Builder()
//                .withEmail(ReadProperties.username())
//                        .withPassword(ReadProperties.password())
//                                .build();
//        Assert.assertTrue(
//        userStep.loginSuccessful(user)
//                .isPageOpened()
//        );
//    }

    @Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
        userStep.loginIncorrect(ReadProperties.username(), "123qqw")
                .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }
    @Test
    public void addProjectTest() {
        Project project = new Project();
        project.setName("WP_01");
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        projectSteps.addProject(project);

        Assert.assertEquals(driver.findElement(By.className("page_title")).getText(),
                "WP_01");
    }

    @Test
    public void radioButtonTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationStep(driver).navigateToAddProjectPage();
        page.getType().selectByIndex(1);
        page.getType().selectByValue("3");
        page.getType().selectByText("Use a single repository for all cases (recommended)");
    }
}
