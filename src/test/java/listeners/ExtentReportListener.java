        package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import factory.DriverFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onStart(org.testng.ITestContext context) {

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter(
                        "test-output/ExtentReport.html"
                );

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Framework", "Selenium + TestNG");
        extent.setSystemInfo("Language", "Java");
        extent.setSystemInfo("Browser", "Multiple");
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(
                        result.getMethod().getMethodName()
                );

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail("Test failed");
        test.get().fail(result.getThrowable());

        String screenshotPath = captureScreenshot(result);

        if (screenshotPath != null) {
            try {
                test.get().addScreenCaptureFromPath(
                        screenshotPath
                );
            } catch (Exception e) {
                test.get().warning(
                        "Unable to attach screenshot: "
                                + e.getMessage()
                );
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test skipped");
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {

        extent.flush();
        test.remove();
    }

    private String captureScreenshot(ITestResult result) {

        try {
            Path screenshotDirectory =
                    Paths.get("test-output/screenshots");

            Files.createDirectories(screenshotDirectory);

            String testName =
                    result.getMethod().getMethodName();

            String fileName =
                    testName + "_" + System.currentTimeMillis() + ".png";

            Path screenshotPath =
                    screenshotDirectory.resolve(fileName);

            TakesScreenshot screenshot =
                    (TakesScreenshot) DriverFactory.getDriver();

            byte[] screenshotBytes =
                    screenshot.getScreenshotAs(
                            OutputType.BYTES
                    );

            Files.write(
                    screenshotPath,
                    screenshotBytes
            );

            return screenshotPath.toString();

        } catch (IOException | RuntimeException e) {

            return null;
        }
    }
}

