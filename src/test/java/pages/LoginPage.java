package pages;

import baseEntities.BasePage;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //блок описания локаторов для элементов
    @FindBy (id = "name")
    public WebElement emailInput;
    @FindBy (id = "password")
    public WebElement passwordInput;
    @FindBy (id = "button_primary")
    public WebElement logInButton;
    @FindBy (className = "error-text")
    public WebElement errorTextLocator;

    //блок инициализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

}
