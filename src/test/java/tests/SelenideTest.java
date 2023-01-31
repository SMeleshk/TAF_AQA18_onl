package tests;

import baseEntities.BaseTest;
import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class SelenideTest extends BaseTest {

    @Test
    public void loginTest() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        SelenideElement loginButton = $("#button_primary");
        loginButton
                .should(exist)
                .shouldBe(enabled)
                .click();

//        $(withText("All Projects"))
//                .shouldBe(visible)
//                .shouldHave(text("All Projects")); //разницы между этими should нет, просто чтоб читалось легко

        $(By.xpath("//div[contains(text(), 'All Projects')]"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        $$(withText("All Projects"))
                .shouldBe(empty)
                .shouldBe(size(10))
                .shouldHave(texts( //плюс можно exactTexts, textsInAnyOrder и тд
                        "1",
                        "text 2",
                        "333")); //массив, с которым работать удобнее

        //еще удобно работать с фильтрами
        $$(withText("different elements"))
                .filterBy(text("expected text"))
                .exclude(hidden) //тут еще коллекция
                .findBy(visible); //тут уже 1 элемент

        $$(withText("different elements"))
                .filterBy(text("expected text"))
                .exclude(hidden)
                .get(1); //выбираем элемент из коллекции по индексу

        isChrome(); //проверка текущего браузера

    }

    @Test
    public void loginTest2() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        SelenideElement loginButton = $("#button_primary");
        loginButton
                .should(exist)
                .shouldBe(enabled)
                .click();

        loginButton.pressEnter();
        loginButton.append("1");



        $(By.xpath("//div[contains(text(), 'All Projects')]"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        $(withText("All Projects"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        $(byText("All Projects"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        $(byTitle("All Projects"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        $(byValue("All Projects"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

    }

}
