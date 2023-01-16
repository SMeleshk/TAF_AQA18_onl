package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {

    private List<UIElement> uiElementList;
    private List<String> textList;
    private UIElement dropDown;

    public DropDownMenu(WebDriver driver, String dropDownIdValue) {
        uiElementList = new ArrayList<>();
        textList = new ArrayList<>();
        dropDown = new UIElement(driver, driver.findElement(By.id(dropDownIdValue)));
        dropDown.click();
        for (WebElement webElement : dropDown.findElements(By.xpath("child::div/ul/li"))) {
            UIElement element = new UIElement(driver, webElement);
            uiElementList.add(element);
            textList.add(element.getText());
        }
    }

    public void selectByIndex(int index) {
        uiElementList.get(index).click();
    }

    public void selectByText(String text) {
        uiElementList.get(textList.indexOf(text)).click();
    }

}
