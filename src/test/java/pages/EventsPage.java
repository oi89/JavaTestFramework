package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utils.Helpers;

import static com.codeborne.selenide.Selenide.*;

public class EventsPage extends BasePage {
    private final SelenideElement pastEventLink = $x("//span[contains(text(), 'Past')]/..");
    private final ElementsCollection eventsCards = $$("div.evnt-event-card");
    private final SelenideElement upcomingEventsCount = $x("//span[contains(text(), 'Upcoming')]/following-sibling::span[contains(@class, 'evnt-tab-counter')]");
    private final SelenideElement pastEventsCount = $x("//span[contains(text(), 'Past')]/following-sibling::span[contains(@class, 'evnt-tab-counter')]");
    private final ElementsCollection eventCardsLanguage = $$("div.evnt-event-card p.language");
    private final ElementsCollection eventCardsTitle = $$("div.evnt-event-card h1");
    private final ElementsCollection eventCardsDate = $$("div.evnt-event-card span.date");
    private final ElementsCollection eventCardsRegistration = $$("div.evnt-event-card span.status");
    private final String eventCardsSpeakersLocator = "div.evnt-speaker[data-name] img";
    private final SelenideElement locationFilter = $("div#filter_location");
    private final SelenideElement locationCanada = $("label[data-value='Canada']");
    private final ElementsCollection filterTags = $$("div.evnt-filters-content div.evnt-tags-cell label");

    @Step("Открытие раздела Past Events")
    public EventsPage clickPastEventsLink() {
        pastEventLink.click();
        Helpers.waitForLoading();

        Helpers.takeScreenshot();
        logger.info("Выбран раздел 'Past Events' в разделе событий");

        return this;
    }

    @Step("Клик в фильтр Location")
    public EventsPage clickLocationFilter() {
        locationFilter.click();
        Helpers.takeScreenshot();
        logger.info("Клик в фильтре 'Location'");

        return this;
    }

    @Step("Выбор значения Canada в фильтре Location")
    public EventsPage selectLocationCanada() {
        locationCanada
                .shouldBe(Condition.visible)
                .click();

        Helpers.waitForLoading();

        Helpers.takeScreenshot();
        logger.info("Выбрано значение 'Canada' в выпадающем списке");

        Selenide.actions().sendKeys(Keys.ESCAPE).perform();

        return this;
    }

    public int getEventsCardsCount() {
        return eventsCards.size();
    }

    public String getUpcomingEventsCount() {
        return upcomingEventsCount.getText();
    }

    public String getPastEventsCount() {
        return pastEventsCount.getText();
    }

    public String getCardLanguageByNumber(int index) {
        return eventCardsLanguage.get(index).getText();
    }

    public String getCardTitleByNumber(int index) {
        return eventCardsTitle.get(index).getText();
    }

    public String getCardDateByNumber(int index) {
        return eventCardsDate.get(index).getText();
    }

    public String getCardRegistrationByNumber(int index) {
        return eventCardsRegistration.get(index).getText();
    }

    public int getCardSpeakersCountByNumber(int index) {
        return eventsCards.get(index).$$(eventCardsSpeakersLocator).size();
    }

    public String getFilterTagTextByNumber(int index) {
        return filterTags.get(index).getText();
    }
}
