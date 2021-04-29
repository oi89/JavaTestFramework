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

    public String getCardsLanguageCheckResult() {
        String result = "OK";

        int i = 1;
        for (SelenideElement cardLang : eventCardsLanguage) {
            if (cardLang.getText().isEmpty()) {
                result = String.format("Не указан язык в карточке мероприятия №%d", i);
                break;
            }
            i++;
        }

        return result;
    }

    public String getCardsTitleCheckResult() {
        String result = "OK";

        int i = 1;
        for (SelenideElement cardTitle : eventCardsTitle) {
            if (cardTitle.getText().isEmpty()) {
                result = String.format("Не указан заголовок в карточке мероприятия №%d", i);
                break;
            }
            i++;
        }

        return result;
    }

    public String getCardsDateCheckResult() {
        String result = "OK";

        int i = 1;
        for (SelenideElement cardDate : eventCardsDate) {
            if (cardDate.getText().isEmpty()) {
                result = String.format("Не указана дата в карточке мероприятия №%d", i);
                break;
            }
            i++;
        }

        return result;
    }

    public String getCardsRegistrationCheckResult(String expectedStatus) {
        String result = "OK";

        int i = 1;
        for (SelenideElement cardRegistration : eventCardsRegistration) {
            if (!expectedStatus.equals(cardRegistration.getText())) {
                result = String.format("Статус регистрации не равен '%s' в карточке мероприятия №%d", expectedStatus, i);
                break;
            }
            i++;
        }

        return result;
    }

    public String getCardsSpeakersCheckResult() {
        String result = "OK";
        ElementsCollection speakers;

        int i = 1;
        for (SelenideElement eventCard : eventsCards) {
            speakers = eventCard.$$(eventCardsSpeakersLocator);
            if (speakers.isEmpty()) {
                result = String.format("Не указаны спикеры в карточке мероприятия №%d", i);
                break;
            }
            i++;
        }

        return result;
    }

    public EventsPage waitForLoading() {
        eventsLoader
                .shouldBe(Condition.appear)
                .shouldBe(Condition.disappear);

        return this;
    }
}
