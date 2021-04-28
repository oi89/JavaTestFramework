package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EventsPage extends BasePage {
    private final SelenideElement pastEventLink = $x("//span[contains(text(), 'Past')]/..");

    public EventsPage clickPastEventsLink() {
        pastEventLink.click();
        logger.info("Выбран раздел 'Past Events' в разделе событий");

        return this;
    }
}
