package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.WaitsService;

public class BaseTest {
    protected WebDriver driver;
    protected WaitsService waitsService;
    protected Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();

        waitsService = new WaitsService(driver);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
