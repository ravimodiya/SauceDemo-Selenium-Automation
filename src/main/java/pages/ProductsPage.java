package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.WaitUtils;

public class ProductsPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By pageTitle = By.className("title");
    private final By inventoryItems = By.className("inventory_item");
    private final By sortDropdown = By.className("product_sort_container");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By cartBadge = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public String getPageTitle() {
        return waitUtils.waitForVisibility(pageTitle).getText();
    }

    public int getProductCount() {
        return driver.findElements(inventoryItems).size();
    }

    public List<String> getProductNames() {
        List<WebElement> products =
                driver.findElements(inventoryItems);

        List<String> productNames = new ArrayList<>();

        for (WebElement product : products) {
            String name = product.findElement(
                    By.className("inventory_item_name")
            ).getText();

            productNames.add(name);
        }

        return productNames;
    }

    public void sortProducts(String visibleText) {
        WebElement dropdown =
                waitUtils.waitForClickable(sortDropdown);

        new Select(dropdown).selectByVisibleText(visibleText);
    }

    public void addProductToCart(String productName) {
        WebElement product = getProductContainer(productName);

        product.findElement(By.cssSelector("button")).click();

        waitUtils.waitForVisibility(cartBadge);
    }

    public void removeProductFromCart(String productName) {
        WebElement product = getProductContainer(productName);

        product.findElement(By.cssSelector("button")).click();
    }

    public int getCartItemCount() {
        List<WebElement> badges =
                driver.findElements(cartBadge);

        if (badges.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(badges.get(0).getText());
    }

    public CartPage openCart() {
        waitUtils.waitForClickable(cartIcon).click();

        return new CartPage(driver);
    }

    private WebElement getProductContainer(String productName) {

        waitUtils.waitForVisibility(inventoryItems);

        List<WebElement> products =
                driver.findElements(inventoryItems);

        for (WebElement product : products) {

            String name = product.findElement(
                    By.className("inventory_item_name")
            ).getText();

            if (name.equals(productName)) {
                return product;
            }
        }

        throw new IllegalArgumentException(
                "Product not found: " + productName
        );
    }
}