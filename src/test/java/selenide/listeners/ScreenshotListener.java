package selenide.listeners;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.service.ReportPortal;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.Calendar;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        File screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver())
                .getScreenshotAs(OutputType.FILE);

        ReportPortal.emitLog(
                result.getMethod().getMethodName() + " screenshot",
                "ERROR",
                Calendar.getInstance().getTime(),
                screenshot
        );
    }
}
