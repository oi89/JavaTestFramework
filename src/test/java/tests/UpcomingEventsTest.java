package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import utils.BaseHooks;

public class UpcomingEventsTest extends BaseHooks {
    @Test
    public void checkUpcomingEventsTest() {
        MainPage mainPage = new MainPage();

        Selenide.open(Configuration.baseUrl);

        mainPage
                .acceptCookies()
                .clickEventsLink();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
