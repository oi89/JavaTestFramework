package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private final SelenideElement eventsLink = $("li.events-icon a");
    private final SelenideElement acceptCookiesBtn = $("button#onetrust-accept-btn-handler");

    public MainPage acceptCookies() {
        acceptCookiesBtn
                .shouldBe(Condition.visible)
                .click();
        logger.info("Нажата кнопка 'Принять' во всплывающем окне с cookies");

        return this;
    }

    public MainPage clickEventsLink() {
        eventsLink.click();
        logger.info("Нажата ссылка 'Events' в верхнем меню");

        return this;
    }
}