package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //блок описания локаторов для элементов
    private final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");

    //блок инициализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    //блок атомарных методов
    public WebElement getEmailInput() { return driver.findElement(emailInputLocator);}
    public WebElement getPasswordInput() { return driver.findElement(passwordInputLocator);}
    public WebElement getLoginButton() { return driver.findElement(logInButtonLocator);}
    public WebElement getErrorTextElement() { return driver.findElement(errorTextLocator); }

    public void successfulLogin(String email, String password) {
        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();
    }

}
