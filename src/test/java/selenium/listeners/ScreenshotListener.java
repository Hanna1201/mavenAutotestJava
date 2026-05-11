package selenium.listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import selenium.TestBase;

import java.io.ByteArrayInputStream;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();

        if (testClass instanceof TestBase testBase) {
            byte[] screenshot = ((TakesScreenshot) testBase.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    result.getMethod().getMethodName() + " screenshot",
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    ".png"
            );
        }
    }
}
