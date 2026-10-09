package factory;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver(String browser) {
        WebDriver webDriver;

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.setExperimentalOption("prefs",
                        Map.of("credentials_enable_service", false,
                                "profile.password_manager_leak_detection", false));
                webDriver = new ChromeDriver(options);
                break;

            case "firefox":
                webDriver = new FirefoxDriver();
                break;

            case "edge":
                webDriver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}