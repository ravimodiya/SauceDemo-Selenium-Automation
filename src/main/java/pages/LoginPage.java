package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void enterUsername(String username) {
        waitUtils.waitForVisibility(usernameField)
                .sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUtils.waitForVisibility(passwordField)
                .sendKeys(password);
    }

    public ProductsPage clickLogin() {
        waitUtils.waitForClickable(loginButton).click();

        return new ProductsPage(driver);
    }

    public ProductsPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);

        return clickLogin();
    }

    public String getErrorMessage() {
        return waitUtils.waitForVisibility(errorMessage).getText();
    }

    public boolean isErrorDisplayed() {
        return !driver.findElements(errorMessage).isEmpty();
    }
}