package pages;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    //PageFactory
    @FindBy(id="user-name")
    public WebElement usernameInput;
    @FindBy(id="password")
    public WebElement passwordInput;
    @FindBy(id="login-button")
    public WebElement logInButton;
    private Logger logger = LogManager.getLogger();

    public LoginPage(WebDriver driver) {
        super(driver);
        logger.info("[Info] Page Factory pattern is used to init elements");
    }

    @Override
    protected WebElement getPageIdentifier() {
        return logInButton;
    }


    public void successfulLogin(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        logInButton.click();
    }
}
