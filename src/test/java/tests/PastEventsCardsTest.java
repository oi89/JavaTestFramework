package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseHooks;
import utils.Helpers;

import java.util.Date;

@DisplayName("Тесты на раздел Past Events")
public class PastEventsCardsTest extends BaseHooks {
    @Test
    @DisplayName("Проверка параметров карточек раздела Past Events")
    @Description("Тест проверяет параметры карточек событий раздела Past Events")
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
    @DisplayName("Проверка фильтрации событий раздела Past Events")
    @Description("Тест фильтрует события по полю Location и проверяет их количество, дату и теги")
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
