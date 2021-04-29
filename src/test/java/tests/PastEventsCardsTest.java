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

        softAssertions.assertThat(eventsPage.getCardsLanguageCheckResult()).isEqualTo("OK");
        softAssertions.assertThat(eventsPage.getCardsTitleCheckResult()).isEqualTo("OK");
        softAssertions.assertThat(eventsPage.getCardsDateCheckResult()).isEqualTo("OK");
        softAssertions.assertThat(eventsPage.getCardsRegistrationCheckResult("Registration closed")).isEqualTo("OK");
        softAssertions.assertThat(eventsPage.getCardsSpeakersCheckResult()).isEqualTo("OK");
        softAssertions.assertAll();
    }
}
