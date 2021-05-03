package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.EventsPage;
import pages.MainPage;
import pages.TalksLibraryPage;

@ExtendWith(TestExecutionWatcher.class)
public class BaseHooks {
    protected SoftAssertions softAssertions;
    protected MainPage mainPage;
    protected EventsPage eventsPage;
    protected TalksLibraryPage talksLibraryPage;

    @BeforeEach
    @Step("Открытие главной страницы events.epam.com")
    public void beforeTest() {
        Selenide.clearBrowserCookies();
        Selenide.open(Configuration.baseUrl);

        softAssertions = new SoftAssertions();
        mainPage = new MainPage();
        eventsPage = new EventsPage();
        talksLibraryPage = new TalksLibraryPage();
    }

    @BeforeAll
    public static void setUp() {
        Config.init();
    }
}
