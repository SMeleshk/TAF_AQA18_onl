package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.WaitsService;

public class BaseTest {
    protected WebDriver driver;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();

        waitsService = new WaitsService(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
