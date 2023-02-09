package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class UserStep extends BaseStep {
    private LoginPage loginPage;

    public UserStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
    }

    public void login(String email, String password) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
    }

    //@Step
    public DashboardPage loginSuccessful(String username, String password) {
        login(username, password);

        return new DashboardPage(driver);
    }

//    public DashboardPage loginSuccessful(UserGUI user) {
//        return loginPage.successfulLogin(user.getEmail(), user.getPassword());
//    }

    public LoginPage loginIncorrect(String username, String password) {
        login(username, password);

        return loginPage;
    }

}
