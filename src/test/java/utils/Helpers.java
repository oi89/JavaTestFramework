package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class Helpers {
    static Logger logger = LogManager.getLogger(Helpers.class);
    private static final SelenideElement loader = $("div.evnt-global-loader");

    public static Date getDateFromString(String dateString) {
        Date date = null;

        // Если указан диапазон дат, то выбираем вторую дату, которую потом будем сравнивать
        if (dateString.contains("-")) {
            dateString = dateString.split("-")[1];
        }
        try {
            date = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(dateString);
        } catch (ParseException ex) {
            logger.info(ex.getMessage());
        }

        return date;
    }

    public static void waitForLoading() {
        try {
            loader
                    .shouldBe(Condition.appear)
                    .shouldBe(Condition.disappear);
        } catch (Exception ex) {
            logger.info("Ошибка при поиске loader загрузки");
            logger.info(ex.getMessage());
        }
    }

    public static void takeScreenshot() {
        Allure.addAttachment("Test Screenshot", new ByteArrayInputStream(Selenide.screenshot(OutputType.BYTES)));
    }
}
