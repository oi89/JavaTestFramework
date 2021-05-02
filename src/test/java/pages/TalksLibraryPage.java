package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import utils.Helpers;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TalksLibraryPage extends BasePage {
    private final SelenideElement moreFiltersLink = $("div.show-more");
    private final SelenideElement categoryFilter = $("div#filter_category");
    private final SelenideElement categoryTesting = $("label[data-value='Testing']");
    private final SelenideElement locationFilter = $("div#filter_location");
    private final SelenideElement locationBelarus = $("label[data-value='Belarus']");
    private final SelenideElement languageFilter = $("div#filter_language");
    private final SelenideElement languageEnglish = $("label[data-value='ENGLISH']");
    private final ElementsCollection filterTags = $$("div.evnt-filters-content div.evnt-tags-cell label");
    private final ElementsCollection eventsCards = $$("div.evnt-talk-card");
    private final ElementsCollection eventCardsLanguage = $$("div.evnt-talk-card p.language");

    public TalksLibraryPage clickMoreFiltersLink() {
        moreFiltersLink.click();
        logger.info("Клик на ссылке 'More Filters'");

        return this;
    }

    public TalksLibraryPage clickCategoryFilter() {
        categoryFilter.click();
        logger.info("Клик в фильтре 'Category'");

        return this;
    }

    public TalksLibraryPage selectCategoryTesting() {
        categoryTesting
                .shouldBe(Condition.visible)
                .click();
        logger.info("Выбрано значение 'Testing' в выпадающем списке");

        return this;
    }

    public TalksLibraryPage clickLocationFilter() {
        locationFilter.click();
        logger.info("Клик в фильтре 'Location'");

        return this;
    }

    public TalksLibraryPage selectLocationBelarus() {
        locationBelarus
                .shouldBe(Condition.visible)
                .click();
        logger.info("Выбрано значение 'Belarus' в выпадающем списке");

        return this;
    }

    public TalksLibraryPage clickLanguageFilter() {
        languageFilter.click();
        logger.info("Клик в фильтре 'Language'");

        return this;
    }

    public TalksLibraryPage selectLanguageEnglish() {
        languageEnglish
                .shouldBe(Condition.visible)
                .click();
        logger.info("Выбрано значение 'English' в выпадающем списке");

        Helpers.waitForLoading();

        return this;
    }

    public int getFilterTagsCountByText(String tagText) {
        return filterTags
                .filter(Condition.text(tagText))
                .size();
    }

    public int getEventsCardsCount() {
        return eventsCards.size();
    }

    public String getCardLanguageByNumber(int index) {
        return eventCardsLanguage.get(index).getText();
    }
}
