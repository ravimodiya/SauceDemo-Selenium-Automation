package tests;
import data.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTests extends BaseTest {
    @Test(dataProvider = "checkoutValidationData",
            dataProviderClass = TestData.class)
    public void checkoutValidationTest(
            String firstName,
            String lastName,
            String postalCode,
            String expectedError) {

        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage =
                loginPage.login("standard_user", "secret_sauce");

        productsPage.addProductToCart("Sauce Labs Backpack");

        CartPage cartPage = productsPage.openCart();

        CheckoutPage checkoutPage = cartPage.clickCheckout();

        checkoutPage.enterCustomerInformation(
                firstName,
                lastName,
                postalCode
        );

        checkoutPage.clickContinue();

        Assert.assertEquals(
                checkoutPage.getErrorMessage(),
                expectedError
        );
    }
}