package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "E:\\JavaProjects\\Testing\\TAF_AQA18_onl\\TAF_AQA18_onl\\src\\test\\resources\\chromedriver.exe");

    return new ChromeDriver();
    }

}
