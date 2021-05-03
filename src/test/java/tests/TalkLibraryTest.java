package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseHooks;

@DisplayName("Тесты на раздел Video")
public class TalkLibraryTest extends BaseHooks {
    @Test
    @DisplayName("Проверка фильтрации на странице Talks Library")
    @Description("Тест задает фильтры Category, Location, Language и проверяет теги и язык в найденных карточках")
    public void videoFiltersTest() {
        mainPage
                .acceptCookies()
                .clickVideoLink();
        talksLibraryPage
                .clickMoreFiltersLink()
                .clickCategoryFilter()
                .selectCategoryTesting()
                .clickLocationFilter()
                .selectLocationBelarus()
                .clickLanguageFilter()
                .selectLanguageEnglish();

        softAssertions.assertThat(talksLibraryPage.getFilterTagsCountByText("Testing"))
                .isNotEqualTo(0);
        softAssertions.assertThat(talksLibraryPage.getFilterTagsCountByText("Belarus"))
                .isNotEqualTo(0);
        softAssertions.assertThat(talksLibraryPage.getFilterTagsCountByText("ENGLISH"))
                .isNotEqualTo(0);

        for (int i = 0; i < talksLibraryPage.getEventsCardsCount(); i++) {
            softAssertions.assertThat(talksLibraryPage.getCardLanguageByNumber(i))
                    .isEqualTo("En");
        }
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Проверка поиска на странице Talks Library")
    @Description("Тест вводит ключевые слова в строку поиска и проверяет их отображение в найденных карточках")
    public void searchVideosTest() {
        String textForSearch = "QA";

        mainPage
                .acceptCookies()
                .clickVideoLink();
        talksLibraryPage.enterTextToSearchField(textForSearch);

        for (int i = 0; i < talksLibraryPage.getEventsCardsCount(); i++) {
            softAssertions.assertThat(talksLibraryPage.getCardTitleByNumber(i))
                    .contains(textForSearch);
        }
        softAssertions.assertAll();
    }
}
