package baseEntities;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class BaseTest {

    @BeforeSuite
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 15000;
        Configuration.fastSetValue = true;
//        Configuration.assertionMode = AssertionMode.SOFT; //если ассерт упал, тест идёт дальше все равно
//        Configuration.headless = true;
//        Configuration.reportsFolder = "target/"; //работает на репорты JUnit
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
