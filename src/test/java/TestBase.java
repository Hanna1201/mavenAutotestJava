import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.manage(). timeouts().pageLoadTimeout(Duration.ofSeconds (5)) ;
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5)) ;
        driver. manage ().timeouts().implicitlyWait(Duration.ofSeconds (5));

        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
