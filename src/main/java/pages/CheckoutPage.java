
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class CheckoutPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");

    private final By continueButton = By.id("continue");
    private final By cancelButton = By.id("cancel");
    private final By finishButton = By.id("finish");

    private final By errorMessage =
            By.cssSelector("[data-test='error']");

    private final By summaryItems = By.className("cart_item");
    private final By itemTotal =
            By.className("summary_subtotal_label");
    private final By tax = By.className("summary_tax_label");
    private final By total = By.className("summary_total_label");

    private final By confirmationMessage =
            By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void enterFirstName(String firstName) {
        waitUtils.waitForVisibility(firstNameField)
                .sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        waitUtils.waitForVisibility(lastNameField)
                .sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        waitUtils.waitForVisibility(postalCodeField)
                .sendKeys(postalCode);
    }

    public CheckoutPage enterCustomerInformation(
            String firstName,
            String lastName,
            String postalCode) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);

        return this;
    }

    public CheckoutPage clickContinue() {
        waitUtils.waitForClickable(continueButton).click();

        return this;
    }

    public void cancelCheckout() {
        waitUtils.waitForClickable(cancelButton).click();
    }

    public int getCheckoutItemCount() {
        return driver.findElements(summaryItems).size();
    }

    public String getItemTotal() {
        return waitUtils.waitForVisibility(itemTotal).getText();
    }

    public String getTax() {
        return waitUtils.waitForVisibility(tax).getText();
    }

    public String getTotal() {
        return waitUtils.waitForVisibility(total).getText();
    }

    public String getErrorMessage() {
        return waitUtils.waitForVisibility(errorMessage).getText();
    }

    public boolean isErrorDisplayed() {
        return !driver.findElements(errorMessage).isEmpty();
    }

    public String getConfirmationMessage() {
        return waitUtils.waitForVisibility(
                confirmationMessage
        ).getText();
    }

    public void clickFinish() {
        waitUtils.waitForClickable(finishButton).click();
    }
}