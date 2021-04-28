package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.junit.jupiter.api.BeforeEach;
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

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
