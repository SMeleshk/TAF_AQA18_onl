package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.project.AddProjectPage;

public class NavigationStep extends BaseStep {

    public NavigationStep(WebDriver driver) {
        super(driver);
    }

    public AddProjectPage navigateToAddProjectPage() {

        AddProjectPage page = new AddProjectPage(driver);
        page.openPageByUrl();

        return page;
    }
}
