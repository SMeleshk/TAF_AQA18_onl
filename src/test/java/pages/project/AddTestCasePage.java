package pages.project;

import baseEntities.BasePage;
import elements.DropDownMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTestCasePage extends BasePage {
    private final static String pagePath = "index.php?/cases/add/2";

    private final By addTestCaseButtonLocator = By.id("accept");
    private final By titleInputLocator = By.id("title");

    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getTestCaseButton() {
        return driver.findElement(addTestCaseButtonLocator);
    }

    public WebElement getNameInput() {
        return driver.findElement(titleInputLocator);
    }

    public DropDownMenu getSectionDropDown() {
        return new DropDownMenu(driver, "section_id_chzn");
    }

    public DropDownMenu getTemplateDropDown() {
        return new DropDownMenu(driver, "template_id_chzn");
    }

    public DropDownMenu getTypeDropDown() {
        return new DropDownMenu(driver, "type_id_chzn");
    }

    public DropDownMenu getPriorityDropDown() {
        return new DropDownMenu(driver, "priority_id_chzn");
    }

    public DropDownMenu getAutomationTypeDropDown() {
        return new DropDownMenu(driver, "custom_automation_type_chzn");
    }
}
