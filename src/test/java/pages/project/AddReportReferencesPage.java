package pages.project;

import baseEntities.BasePage;
import elements.RadioButtonNew;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddReportReferencesPage extends BasePage {

    private final static String pagePath = "index.php?/reports/add_job/2&plugin=references_case_coverage";

    private final By addReportButtonLocator = By.id("submit");

    public AddReportReferencesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getReportButton() {
        return driver.findElement(addReportButtonLocator);
    }

    public RadioButtonNew getReferencesRadioButtons() {
        return new RadioButtonNew(driver, "custom_references_include");
    }

    public RadioButtonNew getAccessRadioButtons() {
        return new RadioButtonNew(driver, "access");
    }
}
