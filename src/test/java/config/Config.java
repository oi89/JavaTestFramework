package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class Config {
    private static String browserName;
    private static Logger logger = LogManager.getLogger(Config.class);
    static ResourcesConfig resourcesConfig = ConfigFactory.create(ResourcesConfig.class);

    public static void init() {
        try {
            browserName = System.getProperty("browser").trim().toLowerCase();
        } catch (Exception exception) {
            logger.info("Браузер не был указан. Будет запущен Chrome.");
            browserName = "chrome";
        }

        WebDriver driver = Driver.getDriver(browserName);
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();

        Configuration.baseUrl = resourcesConfig.baseUrl();
    }
}
