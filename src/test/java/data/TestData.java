
        package data;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utils.ExcelDataReader;
import utils.JsonDataReader;

public class TestData {

    @DataProvider(name = "loginData")
    public Object[][] loginData() throws IOException {
        return JsonDataReader.getLoginData();
    }

    @DataProvider(name = "checkoutValidationData")
    public Object[][] checkoutValidationData() throws IOException {
        return ExcelDataReader.getCheckoutData();
    }
}

