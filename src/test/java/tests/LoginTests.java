package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.TestData;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestData.class)
    public void loginTest(String username, String password, String expectedResult) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (expectedResult.equals("success")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        } else {
            Assert.assertTrue(loginPage.isErrorDisplayed());
        }
    }
    @Test
    public void loginWithEmptyPasswordShowsValidationError() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "An empty password should display the password-required validation message"
        );

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "The user should remain on the login page"
        );
    }
}
