package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import factory.DriverFactory;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Framework", "Selenium + TestNG");
        extent.setSystemInfo("Language", "Java");
        extent.setSystemInfo("Browser", "Multiple");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest extentTest = test.get();
        Throwable throwable = result.getThrowable();

        String className = result.getTestClass().getName();
        String methodName = result.getMethod().getMethodName();

        String failureMessage = throwable != null
                ? throwable.getMessage()
                : "No exception details available";

        String exceptionType = throwable != null
                ? throwable.getClass().getSimpleName()
                : "Unknown exception";

        extentTest.fail("Test failed: " + className + "." + methodName);
        extentTest.fail("Exception: " + exceptionType);
        extentTest.fail("Failure reason: " + failureMessage);

        if (throwable != null) {
            extentTest.fail(throwable);
        }

        try {
            TakesScreenshot screenshot =
                    (TakesScreenshot) DriverFactory.getDriver();

            String base64Screenshot =
                    screenshot.getScreenshotAs(OutputType.BASE64);

            extentTest.addScreenCaptureFromBase64String(
                    base64Screenshot,
                    "Failure Screenshot"
            );
        } catch (Exception e) {
            extentTest.warning(
                    "Unable to capture screenshot: " + e.getMessage()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        test.remove();
    }
}

