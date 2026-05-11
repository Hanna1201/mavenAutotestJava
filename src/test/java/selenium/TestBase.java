package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import selenium.listeners.ScreenshotListener;

import java.time.Duration;

@Listeners(ScreenshotListener.class)
public class TestBase {

    //public static WebDriver driver;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        driver.set(new ChromeDriver(options));

        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        getDriver().get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }
}
