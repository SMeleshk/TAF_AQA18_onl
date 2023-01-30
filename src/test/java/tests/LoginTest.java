package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.project.AddProjectPage;
import pages.project.AddReportReferencesPage;
import pages.project.AddTestCasePage;
import steps.NavigationSteps;

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

    @Test (description = "123")
    @Issue("AQA18-12")
    @TmsLink("TC-001")
    @Description("Description1")
    @Link("https://onliner.by")
    @Link(name = "catalog", type = "mylink", url = "https://onliner.by")
    @Severity(SeverityLevel.BLOCKER)
    public void loginSuccessfulTest() {
        Assert.assertTrue(
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                .isPageOpened()
        );
    }

    @Test
    public void addProjectTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        projectSteps.addProject("WP_01");

        Assert.assertEquals(driver.findElement(By.className("page_title")).getText(),
                "WP_01");
    }

    @Test
    public void radioButtonTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getRadioButtonType().selectByIndex(1);
        page.getRadioButtonType().selectByValue("3");
        page.getRadioButtonType().selectByText("Use a single repository for all cases (recommended)");
    }

    @Test
    public void checkBoxTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getCheckBox().select();
        page.getCheckBox().unselect();
    }

    @Test
    public void dropDownMenuTest() {

        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddTestCasePage page = new NavigationSteps(driver).navigateToAddTestCasePage();
        page.getSectionDropDown().selectByText("Test Cases");
        page.getTypeDropDown().selectByText("Automated");
        page.getTypeDropDown().selectByIndex(1);
        page.getTypeDropDown().searchAndSelectFirst("Auto");
        page.getPriorityDropDown().selectByText("High");
        page.getPriorityDropDown().selectByIndex(2);
        page.getAutomationTypeDropDown().selectByText("Ranorex");
        page.getTemplateDropDown().selectByText("Exploratory Session");
    }

    @Test
    public void radioButtonNewTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddReportReferencesPage page = new NavigationSteps(driver).navigateToReportReferencesPage();
        page.getReferencesRadioButtons().selectByIndex(1);
        page.getAccessRadioButtons().selectByIndex(1);
    }

}
