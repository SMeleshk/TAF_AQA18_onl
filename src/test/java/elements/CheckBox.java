package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    private UIElement element;


    // Продумать механизм поиска этого элемента
    //поиск по name

    public CheckBox(WebDriver driver, String attributeNameValue) {
        element = new UIElement(driver, driver.findElement(By.name(attributeNameValue)));
    }

    public void select() {
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void unselect() {
        if(element.isSelected()) {
            element.click();
        }
    }
}
