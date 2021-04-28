package config;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Driver;

public class Config {
    private static String browserName;
    private static Logger logger = LogManager.getLogger(Config.class);

    public static void init() {
        try {
            browserName = System.getProperty("browser").trim().toLowerCase();
        } catch (Exception exception) {
            logger.info("Браузер не был указан. Будет запущен Chrome.");
            browserName = "chrome";
        }
        logger.info("BROWSER = " + browserName);

        WebDriver driver = Driver.getDriver(browserName);
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();

        // Еще можно запускаться через -Dremote=<адрес грида>

//        if (browserName.equals(BrowserType.CHROME.getValue())) {
//            Configuration.browser = Browsers.CHROME;
//            Configuration.browserVersion = "90.0";
//        } else if (browserName.equals(BrowserType.FIREFOX.getValue())) {
//            Configuration.browser = Browsers.FIREFOX;
//            Configuration.browserVersion = "88.0";
//            logger.info("ВЕТКА FIREFOX");
//        }

//        Configuration.startMaximized = true;

        Configuration.baseUrl = "https://events.epam.com/";
//        Configuration.remote = "http://localhost:4444/wd/hub/";
//        Configuration.browserCapabilities = new DesiredCapabilities();
//        Configuration.browserCapabilities.setCapability("enableVNC", true);
//        Configuration.holdBrowserOpen = true;


    }
}
