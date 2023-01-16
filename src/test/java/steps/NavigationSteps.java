package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.project.AddProjectPage;
import pages.project.AddReportReferencesPage;
import pages.project.AddTestCasePage;

public class NavigationSteps extends BaseStep {

    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    public AddProjectPage navigateToAddProjectPage() {

        AddProjectPage page = new AddProjectPage(driver);
        page.openPageByUrl();

        return page;
    }

    public AddTestCasePage navigateToAddTestCasePage() {

        AddTestCasePage page = new AddTestCasePage(driver);
        page.openPageByUrl();

        return page;
    }

    public AddReportReferencesPage navigateToReportReferencesPage() {

        AddReportReferencesPage page = new AddReportReferencesPage(driver);
        page.openPageByUrl();

        return page;
    }
}
