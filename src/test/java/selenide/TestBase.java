package selenide;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://litecart.stqa.ru/en";
        Configuration.timeout = 5000;
        Configuration.pageLoadTimeout = 5000;
        Configuration.headless = false;
        Configuration.browserCapabilities = options;

        open("/");
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
