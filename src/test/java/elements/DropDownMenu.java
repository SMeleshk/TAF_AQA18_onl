package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import services.WaitsService;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {

    private List<UIElement> uiElementList;
    private List<String> textList;
    private UIElement dropDownMenu;
    private UIElement dropDownList;
    private UIElement dropDownSearch;
    private UIElement uiElement;
    private WaitsService waitsService;

    public DropDownMenu(WebDriver driver, String dropDownIdValue) {
        dropDownMenu = new UIElement(driver, driver.findElement(By.id(dropDownIdValue)));
        uiElement = dropDownMenu.findUIElement(By.tagName("a"));
        dropDownList = dropDownMenu.findUIElement(By.className("chzn-results"));
        dropDownSearch = dropDownMenu.findUIElement(By.tagName("input"));

        waitsService = new WaitsService(driver);
        dropDownMenu.click(); //оно без этого клика не хочет наполнять списки элементами

        uiElementList = new ArrayList<>();
        textList = new ArrayList<>();
        for (WebElement webElement : dropDownList.findElements(By.tagName("li"))) {
            UIElement element = new UIElement(driver, webElement);
            uiElementList.add(element);
            textList.add(element.getText());
        }
    }

    public void openDropDown() {
        if(!dropDownMenu.isDisplayed()) {
            dropDownMenu.click();
            waitsService.waitForVisibilityBy(By.className("chzn-results"));
        }
    }

    public void search(String text) {
        openDropDown();
        dropDownSearch.sendKeys(text);
    }

    public void searchAndSelectFirst(String text) {
        openDropDown();
        dropDownSearch.sendKeys(text);
        dropDownMenu.findUIElement(By.className("active-result")).click();
    }

    public void selectByIndex(int index) {
        openDropDown();
        uiElementList.get(index).click();
    }

    public void selectByText(String text) {
        openDropDown();
        uiElementList.get(textList.indexOf(text)).click();
    }

}
