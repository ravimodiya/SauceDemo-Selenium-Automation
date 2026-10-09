package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.TestData;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductTests extends BaseTest {

    @Test
    public void verifyProductPage() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(productsPage.getProductCount(), 6);
        Assert.assertEquals(productsPage.getPageTitle(), "Products");
    }

    @Test
    public void addProductToCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addProductToCart("Sauce Labs Backpack");
        Assert.assertEquals(productsPage.getCartItemCount(), 1);
    }

    @Test
    public void removeProductFromCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addProductToCart("Sauce Labs Backpack");
        Assert.assertEquals(productsPage.getCartItemCount(), 1);

        productsPage.removeProductFromCart("Sauce Labs Backpack");
        Assert.assertEquals(productsPage.getCartItemCount(), 0);
    }


}
