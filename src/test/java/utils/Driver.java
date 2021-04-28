package utils;

import com.codeborne.selenide.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    public static WebDriver getDriver(String browserName) {
        URL url;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        try {
            url = new URL("http://localhost:4444/wd/hub/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        switch (browserName) {
            case Browsers.FIREFOX:
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "88.0");
                break;
            case Browsers.CHROME:
            default:
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "90.0");
         }

        capabilities.setCapability("enableVNC", true);

        return new RemoteWebDriver(url, capabilities);
    }
}
