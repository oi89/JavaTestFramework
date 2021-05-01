package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.EventsPage;
import pages.MainPage;
import utils.BaseHooks;
import utils.Helpers;

import java.util.Date;

public class PastEventsCardsTest extends BaseHooks {
    @Test
    public void checkPastEventsCardsTest() {
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

    @Test
    public void checkEventsFilterByLocation() {
        String dateString;
        Date dateCard;
        Date dateNow = new Date();

        mainPage
                .acceptCookies()
                .clickEventsLink();
        eventsPage
                .clickPastEventsLink()
                .clickLocationFilter()
                .selectLocationCanada();

        softAssertions.assertThat(eventsPage.getPastEventsCount())
                .isEqualTo(String.valueOf(eventsPage.getEventsCardsCount()));

        for (int i = 0; i < eventsPage.getEventsCardsCount(); i++) {
            dateString = eventsPage.getCardDateByNumber(i);
            dateCard = Helpers.getDateFromString(dateString);
            softAssertions.assertThat(dateCard.getTime()).isLessThan(dateNow.getTime());
        }

        softAssertions.assertThat(eventsPage.getFilterTagTextByNumber(0))
                .isEqualTo("Canada");
        softAssertions.assertThat(eventsPage.getFilterTagTextByNumber(1))
                .isEqualTo("Toronto");

        softAssertions.assertAll();
    }
}
