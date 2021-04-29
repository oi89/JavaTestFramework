package utils;

import com.codeborne.selenide.Selenide;
import config.Config;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseHooks {
    protected SoftAssertions softAssertions;

    @BeforeEach
    public void beforeTest() {
        Selenide.clearBrowserCookies();
        softAssertions = new SoftAssertions();
    }

    @BeforeAll
    public static void setUp() {
        Config.init();
    }
}
