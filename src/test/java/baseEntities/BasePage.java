package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return $(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        open(ReadProperties.getUrl() + pagePath);
    }
}