
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsPage;

public class LoginTests extends BaseTest {

    
    
    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test
    public void invalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "wrong_password");

        Assert.assertEquals(
            loginPage.getErrorMessage(),
            "Epic sadface: Username and password do not match any user in this service"
        );
    }

    @Test
    public void emptyUsernameTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "secret_sauce");

        Assert.assertEquals(
            loginPage.getErrorMessage(),
            "Epic sadface: Username is required"
        );
    }
}