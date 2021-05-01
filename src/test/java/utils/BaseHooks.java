package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.EventsPage;
import pages.MainPage;

public class BaseHooks {
    protected SoftAssertions softAssertions;
    protected MainPage mainPage;
    protected EventsPage eventsPage;

    @BeforeEach
    public void beforeTest() {
        Selenide.clearBrowserCookies();
        Selenide.open(Configuration.baseUrl);

        softAssertions = new SoftAssertions();
        mainPage = new MainPage();
        eventsPage = new EventsPage();
    }

    @BeforeAll
    public static void setUp() {
        Config.init();
    }
}
