
package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static void initializeDriver(String browser) {

        WebDriver webDriver;

        switch (browser.toLowerCase()) {

            case "chrome":
                webDriver = new ChromeDriver();
                break;

            case "firefox":
                webDriver = new FirefoxDriver();
                break;

            case "edge":
                webDriver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Invalid browser: " + browser
                );
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