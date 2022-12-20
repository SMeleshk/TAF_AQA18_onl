package baseEntities;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.WaitsService;
import steps.UserStep;

@Listeners()
public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowserFactory().getDriver();
        driver.get(ReadProperties.getUrl());

        iTestContext.setAttribute("driver", driver);

        userStep = new UserStep(driver);
        waitsService = new WaitsService(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {

        driver.quit();
    }
}
