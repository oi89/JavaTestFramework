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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UpcomingEventsTest extends BaseHooks {
    MainPage mainPage;
    EventsPage eventsPage;
    Logger logger = LogManager.getLogger(UpcomingEventsTest.class);

    @Test
    public void checkUpcomingEventsCountTest() {
        mainPage = new MainPage();
        eventsPage = new EventsPage();

        Selenide.open(Configuration.baseUrl);

        mainPage
                .acceptCookies()
                .clickEventsLink();

        Assertions.assertEquals(eventsPage.getUpcomingEventsCount(),
                String.valueOf(eventsPage.getEventsCardsCount()));
    }

    @Test
    public void checkUpcomingEventsDatesTest() {
        mainPage = new MainPage();
        eventsPage = new EventsPage();
        String dateString;
        Date dateCard;
        Date dateNow = new Date();

        Selenide.open(Configuration.baseUrl);

        mainPage
                .acceptCookies()
                .clickEventsLink();

        // если дата одна - она должна быть больше или рана текущей дате
        // если указан диапазон дат - вторая дата должна быть меньше или равна текущей дате
        for (int i = 0; i < eventsPage.getEventsCardsCount(); i++) {
            dateString = eventsPage.getCardDateByNumber(i);
            if (dateString.contains("-")) {
                dateString = dateString.split("-")[1];
            }

            try {
                dateCard = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(dateString);
                softAssertions.assertThat(dateNow.getTime()).isLessThanOrEqualTo(dateCard.getTime());
            } catch (ParseException ex) {
                logger.info(ex.getMessage());
            } catch (NullPointerException ex) {
                logger.info(String.format("Дата из карточки №%d не была вычислена", i));
                logger.info(ex.getMessage());
            }
        }
        softAssertions.assertAll();
    }
}
