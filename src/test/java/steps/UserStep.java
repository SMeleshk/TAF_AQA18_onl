package steps;

import org.openqa.selenium.By;
import pages.LoginPage;
import pages.ProductsPage;

import static com.codeborne.selenide.Selenide.$;

public class UserStep {
    private LoginPage loginPage;

    public UserStep() {
        loginPage = new LoginPage();
    }

    public ProductsPage login(String username, String password) {
        loginPage.successfulLogin(username, password);
        return new ProductsPage();
    }

    public LoginPage logout() {
        $(By.id("react-burger-menu-btn")).click();
        $(By.id("logout_sidebar_link")).click();
        return new LoginPage();
    }
}
