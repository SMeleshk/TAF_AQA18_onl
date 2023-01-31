package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    //блок описания локаторов для элементов
    private final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");

    //блок атомарных методов
    public SelenideElement getEmailInput() { return $(emailInputLocator);}
    public SelenideElement getPasswordInput() { return $(passwordInputLocator);}
    public SelenideElement getLoginButton() { return $(logInButtonLocator);}
    public SelenideElement getErrorTextElement() { return $(errorTextLocator); }

    public void successfulLogin(String email, String password) {
        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();
    }
}
