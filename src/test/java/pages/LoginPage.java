package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private final By usernameInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("login-button");


    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    //блок атомарных методов
    public SelenideElement getUsernameInput() { return $(usernameInputLocator);}
    public SelenideElement getPasswordInput() { return $(passwordInputLocator);}
    public SelenideElement getLoginButton() { return $(logInButtonLocator);}

    public void successfulLogin(String username, String password) {
        getUsernameInput().sendKeys(username);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();
    }

}
