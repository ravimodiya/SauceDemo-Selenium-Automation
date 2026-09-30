
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage {

    WebDriver driver;
    WaitUtils waitUtils;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage =By.cssSelector("[data-test='error']");

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