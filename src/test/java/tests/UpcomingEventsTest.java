package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.EventsPage;
import pages.MainPage;
import utils.BaseHooks;

public class UpcomingEventsTest extends BaseHooks {
    @Test
    public void checkUpcomingEventsTest() {
        MainPage mainPage = new MainPage();
        EventsPage eventsPage = new EventsPage();

        Selenide.open(Configuration.baseUrl);

        mainPage
                .acceptCookies()
                .clickEventsLink();

        Assertions.assertEquals(eventsPage.getUpcomingEventsCount(),
                String.valueOf(eventsPage.getEventsCardsCount()));
    }
}
