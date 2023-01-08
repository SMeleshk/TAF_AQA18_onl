package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //блок описания локаторов для элементов
    private final By usernameInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("login-button");

    //блок инициализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    //блок атомарных методов
    public WebElement getUsernameInput() { return driver.findElement(usernameInputLocator);}
    public WebElement getPasswordInput() { return driver.findElement(passwordInputLocator);}
    public WebElement getLoginButton() { return driver.findElement(logInButtonLocator);}

    public void successfulLogin(String username, String password) {
        getUsernameInput().sendKeys(username);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();
    }

}
