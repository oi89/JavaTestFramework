package tests;

import org.junit.jupiter.api.Test;
import utils.BaseHooks;

public class TalkLibraryTest extends BaseHooks {
    @Test
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
}
