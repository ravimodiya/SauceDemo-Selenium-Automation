package data;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "checkoutValidationData")
    public Object[][] checkoutValidationData() {
        return new Object[][] {
                {"", "Test", "395001", "Error: First Name is required"},
                {"Ravi", "", "395001", "Error: Last Name is required"},
                {"Ravi", "Test", "", "Error: Postal Code is required"}
        };
    }
}