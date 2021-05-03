package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
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
    private final SelenideElement searchField = $("div.evnt-search-filter input.evnt-search");
    private final ElementsCollection eventCardsTitle = $$("div.evnt-talk-name span");

    @Step("Клик на ссылку More Filters")
    public TalksLibraryPage clickMoreFiltersLink() {
        moreFiltersLink.click();
        Helpers.takeScreenshot();
        logger.info("Клик на ссылке 'More Filters'");

        return this;
    }

    @Step("Клик в фильтр Category")
    public TalksLibraryPage clickCategoryFilter() {
        categoryFilter.click();
        Helpers.takeScreenshot();
        logger.info("Клик в фильтре 'Category'");

        return this;
    }

    @Step("Выбор значения Testing в фильтре Category")
    public TalksLibraryPage selectCategoryTesting() {
        categoryTesting
                .shouldBe(Condition.visible)
                .click();

        Helpers.takeScreenshot();
        logger.info("Выбрано значение 'Testing' в выпадающем списке");

        Selenide.actions().sendKeys(Keys.ESCAPE).perform();

        return this;
    }

    @Step("Клик в фильтр Location")
    public TalksLibraryPage clickLocationFilter() {
        locationFilter.click();
        Helpers.takeScreenshot();
        logger.info("Клик в фильтре 'Location'");

        return this;
    }

    @Step("Выбор значения Belarus в фильтре Location")
    public TalksLibraryPage selectLocationBelarus() {
        locationBelarus
                .shouldBe(Condition.visible)
                .click();

        Helpers.takeScreenshot();
        logger.info("Выбрано значение 'Belarus' в выпадающем списке");

        Selenide.actions().sendKeys(Keys.ESCAPE).perform();

        return this;
    }

    @Step("Клик в фильтр Language")
    public TalksLibraryPage clickLanguageFilter() {
        languageFilter.click();
        Helpers.takeScreenshot();
        logger.info("Клик в фильтре 'Language'");

        return this;
    }

    @Step("Выбор значения English в фильтре Language")
    public TalksLibraryPage selectLanguageEnglish() {
        languageEnglish
                .shouldBe(Condition.visible)
                .click();

        Helpers.waitForLoading();

        Helpers.takeScreenshot();
        logger.info("Выбрано значение 'English' в выпадающем списке");

        Selenide.actions().sendKeys(Keys.ESCAPE).perform();

        return this;
    }

    @Step("Ввод значения '{text}' в строку для поиска")
    public TalksLibraryPage enterTextToSearchField(String text) {
        searchField
                .shouldBe(Condition.enabled)
                .setValue(text);

        Helpers.waitForLoading();

        Helpers.takeScreenshot();
        logger.info(String.format("Введено значение '%s' в строку для поиск", text));

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

    public String getCardTitleByNumber(int index) {
        return eventCardsTitle.get(index).getText();
    }
}
