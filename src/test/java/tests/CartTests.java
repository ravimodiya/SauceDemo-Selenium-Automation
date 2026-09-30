package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTests extends BaseTest {

    @Test
    public void verifyAddedProductInCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addProductToCart("Sauce Labs Backpack");

        CartPage cartPage = productsPage.openCart();

        Assert.assertEquals(cartPage.getCartItemCount(), 1);
        Assert.assertTrue(cartPage.isProductPresent("Sauce Labs Backpack"));
    }

    @Test
    public void removeProductFromCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addProductToCart("Sauce Labs Backpack");

        CartPage cartPage = productsPage.openCart();

        Assert.assertTrue(cartPage.isProductPresent("Sauce Labs Backpack"));

        cartPage.removeProduct("Sauce Labs Backpack");

        Assert.assertEquals(cartPage.getCartItemCount(), 0);
    }

    @Test
    public void addMultipleProductsToCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.addProductToCart("Sauce Labs Bike Light");

        CartPage cartPage = productsPage.openCart();

        Assert.assertEquals(cartPage.getCartItemCount(), 2);
        Assert.assertTrue(cartPage.isProductPresent("Sauce Labs Backpack"));
        Assert.assertTrue(cartPage.isProductPresent("Sauce Labs Bike Light"));
    }
}