package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import pages.EventsPage;
import pages.MainPage;
import utils.BaseHooks;

public class PastEventsCardsTest extends BaseHooks {
    @Test
    public void checkPastEventsCardsTest() {
        MainPage mainPage = new MainPage();
        EventsPage eventsPage = new EventsPage();

        Selenide.open(Configuration.baseUrl);

        mainPage
                .acceptCookies()
                .clickEventsLink();
        eventsPage.clickPastEventsLink();

        for (int i = 0; i < eventsPage.getEventsCardsCount(); i++) {
            softAssertions.assertThat(eventsPage.getCardLanguageByNumber(i)).isNotEmpty();
            softAssertions.assertThat(eventsPage.getCardTitleByNumber(i)).isNotEmpty();
            softAssertions.assertThat(eventsPage.getCardDateByNumber(i)).isNotEmpty();
            softAssertions.assertThat(eventsPage.getCardRegistrationByNumber(i)).isEqualTo("Registration closed");
            softAssertions.assertThat(eventsPage.getCardSpeakersCountByNumber(i)).isNotEqualTo(0);
        }
        softAssertions.assertAll();
    }
}
