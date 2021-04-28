package utils;

import com.codeborne.selenide.Selenide;
import config.Config;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseHooks {
    @BeforeEach
    public void beforeTest() {
        Selenide.clearBrowserCookies();
    }

    @BeforeAll
    public static void setUp() {
        Config.init();
    }
}
