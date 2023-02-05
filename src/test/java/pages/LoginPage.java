package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {

    //PageFactory
    @FindBy(id="user-name")
    public WebElement usernameInput;
    @FindBy(id="password")
    public WebElement passwordInput;
    @FindBy(id="login-button")
    public WebElement logInButton;
    @FindBys({
            @FindBy(id="user-name"),
            @FindBy(id="password"),
            @FindBy(id="login-button")
    })
    private List<WebElement> listOfElements;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageIdentifier() {
        return logInButton;
    }


    public void successfulLogin(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        logInButton.click();
    }

}
