package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.EventsPage;
import pages.MainPage;
import utils.BaseHooks;
import utils.Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UpcomingEventsTest extends BaseHooks {
    Logger logger = LogManager.getLogger(UpcomingEventsTest.class);

    @Test
    public void checkUpcomingEventsCountTest() {
        mainPage
                .acceptCookies()
                .clickEventsLink();

        Assertions.assertEquals(eventsPage.getUpcomingEventsCount(),
                String.valueOf(eventsPage.getEventsCardsCount()));
    }

    @Test
    public void checkUpcomingEventsDatesTest() {
        String dateString;
        Date dateCard;
        Date dateNow = new Date();

        mainPage
                .acceptCookies()
                .clickEventsLink();

        // если дата одна - она должна быть больше или рана текущей дате
        // если указан диапазон дат - вторая дата должна быть меньше или равна текущей дате
        for (int i = 0; i < eventsPage.getEventsCardsCount(); i++) {
            dateString = eventsPage.getCardDateByNumber(i);
            dateCard = Helpers.getDateFromString(dateString);
            softAssertions.assertThat(dateCard.getTime()).isGreaterThanOrEqualTo(dateNow.getTime());
        }
        softAssertions.assertAll();
    }
}
