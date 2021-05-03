package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseHooks;
import utils.Helpers;
import java.util.Date;

@DisplayName("Тесты на раздел Upcoming Events")
public class UpcomingEventsTest extends BaseHooks {
    @Test
    @DisplayName("Проверка соотвествия количества карточек и их счетчика в разделе Upcoming Events")
    @Description("Тест сравнивает количество карточек событий со счетчиком")
    public void checkUpcomingEventsCountTest() {
        mainPage
                .acceptCookies()
                .clickEventsLink();

        Assertions.assertEquals(eventsPage.getUpcomingEventsCount(),
                String.valueOf(eventsPage.getEventsCardsCount()));
    }

    @Test
    @DisplayName("Проверка дат в карточках событий раздела Upcoming Events")
    @Description("Тест сравнивает даты в карточках событий с текущей датой")
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
