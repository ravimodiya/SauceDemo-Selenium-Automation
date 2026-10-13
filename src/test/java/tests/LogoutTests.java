package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsPage;

public class LogoutTests extends BaseTest {

    @Test
    public void verifyLogoutSuccessfully() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        // Log in first
        loginPage.login("standard_user", "secret_sauce");

        // Verify successful login
        Assert.assertEquals(
                productsPage.getPageTitle(),
                "Products",
                "Products page was not displayed after login"
        );

        // Log out
        productsPage.logout();

        // Verify user returned to login page
        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login page was not displayed after logout"
        );
    }
}
