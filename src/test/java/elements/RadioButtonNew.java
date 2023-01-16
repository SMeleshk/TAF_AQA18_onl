package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButtonNew {
    private List<UIElement> uiElementList;

    public RadioButtonNew(WebDriver driver, String attributeName) {
        uiElementList = new ArrayList<>();

        for (WebElement webElement : driver.findElements(By.name(attributeName))) {
            UIElement element = new UIElement(driver, webElement);
            uiElementList.add(element);
        }
    }

    public void selectByIndex(int index) {
        uiElementList.get(index).click();
    }
}
