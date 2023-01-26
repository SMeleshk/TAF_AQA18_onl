package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
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

//    @Test
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

    //comment

//    @Test
//    public void loginIncorrectTest() {
//        Assert.assertEquals(
//        userStep.loginIncorrect(ReadProperties.username(), "123qqw")
//                .getErrorTextElement().getText(),
//                "Email/Login or Password is incorrect. Please try again."
//        );
//    }

//    @Test
//    public void radioButtonTest() {
//        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
//        AddProjectPage page = new NavigationStep(driver).navigateToAddProjectPage();
//        page.getType().selectByIndex(1);
//        page.getType().selectByValue("3");
//        page.getType().selectByText("Use a single repository for all cases (recommended)");
//    }
}
