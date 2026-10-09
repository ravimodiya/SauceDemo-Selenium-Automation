package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

public class CartPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By cartItems = By.className("cart_item");
    private final By checkoutButton = By.id("checkout");
    private final By continueShoppingButton = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public List<String> getCartProductNames() {
        List<WebElement> items = driver.findElements(cartItems);

        List<String> productNames = new ArrayList<>();

        for (WebElement item : items) {
            String name = item.findElement(
                    By.className("inventory_item_name")
            ).getText();

            productNames.add(name);
        }

        return productNames;
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public boolean isProductPresent(String productName) {
        return getCartProductNames().contains(productName);
    }

    public void removeProduct(String productName) {
        List<WebElement> items =
                driver.findElements(cartItems);

        for (WebElement item : items) {
            String name = item.findElement(
                    By.className("inventory_item_name")
            ).getText();

            if (name.equals(productName)) {
                item.findElement(By.cssSelector("button")).click();

                waitUtils.waitForInvisibility(
                        By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name' and text()='"
                                + productName + "']")
                );

                return;
            }
        }

        throw new IllegalArgumentException(
                "Product not found in cart: " + productName
        );
    }

    public CheckoutPage clickCheckout() {
        waitUtils.waitForClickable(checkoutButton).click();

        return new CheckoutPage(driver);
    }

    public ProductsPage continueShopping() {
        waitUtils.waitForClickable(
                continueShoppingButton
        ).click();

        return new ProductsPage(driver);
    }
}