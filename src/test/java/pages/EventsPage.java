package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class EventsPage extends BasePage {
    private final SelenideElement pastEventLink = $x("//span[contains(text(), 'Past')]/..");
    private final SelenideElement eventsLoader = $("div.evnt-global-loader");
    private final ElementsCollection eventsCards = $$("div.evnt-event-card");
    private final SelenideElement upcomingEventsCount = $x("//span[contains(text(), 'Upcoming')]/following-sibling::span[contains(@class, 'evnt-tab-counter')]");
    private final ElementsCollection eventCardsLanguage = $$("div.evnt-event-card p.language");
    private final ElementsCollection eventCardsTitle = $$("div.evnt-event-card h1");
    private final ElementsCollection eventCardsDate = $$("div.evnt-event-card span.date");
    private final ElementsCollection eventCardsRegistration = $$("div.evnt-event-card span.status");
    private final String eventCardsSpeakersLocator = "div.evnt-speaker[data-name] img";

    public EventsPage clickPastEventsLink() {
        pastEventLink.click();
        logger.info("Выбран раздел 'Past Events' в разделе событий");

        waitForLoading();

        return this;
    }

    public int getEventsCardsCount() {
        return eventsCards.size();
    }

    public String getUpcomingEventsCount() {
        return upcomingEventsCount.getText();
    }

    public String getCardLanguageByNumber(int index) {
        return eventCardsLanguage.get(index).getText();
    }

    public String getCardTitleByNumber(int index) {
        return eventCardsTitle.get(index).getText();
    }

    public String getCardDateByNumber(int index) {
//        logger.info(index + " : " + eventCardsDate.get(index).getText());
        return eventCardsDate.get(index).getText();
    }

    public String getCardRegistrationByNumber(int index) {
        return eventCardsRegistration.get(index).getText();
    }

    public int getCardSpeakersCountByNumber(int index) {
        return eventsCards.get(index).$$(eventCardsSpeakersLocator).size();
    }

    public EventsPage waitForLoading() {
        eventsLoader
                .shouldBe(Condition.appear)
                .shouldBe(Condition.disappear);

        return this;
    }
}
