package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Helpers;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private final SelenideElement eventsLink = $("li.events-icon a");
    private final SelenideElement videoLink = $("li.talks-library-icon a");
    private final SelenideElement acceptCookiesBtn = $("button#onetrust-accept-btn-handler");

    @Step("Нажатие кнопки 'Принять' в окне использования cookies")
    public MainPage acceptCookies() {
        acceptCookiesBtn
                .shouldBe(Condition.visible)
                .click();

        Helpers.takeScreenshot();
        logger.info("Нажата кнопка 'Принять' во всплывающем окне с cookies");

        return this;
    }

    @Step("Клик на меню Events")
    public MainPage clickEventsLink() {
        eventsLink
                .shouldBe(Condition.visible)
                .click();

        Helpers.takeScreenshot();
        logger.info("Нажата ссылка 'Events' в верхнем меню");

        return this;
    }

    @Step("Клик на меню Video")
    public MainPage clickVideoLink() {
        videoLink
                .shouldBe(Condition.visible)
                .click();

        Helpers.takeScreenshot();
        logger.info("Нажата ссылка 'Video' в верхнем меню");

        return this;
    }
}
