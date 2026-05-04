package object_based_po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationPage {

    private By errorNotification = By.cssSelector(".notice.errors");
    private By successNotification = By.cssSelector(".notice.success");

    private WebDriver driver;

    public NotificationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorMessageText() {
        return getNotificationText(errorNotification);
    }

    public String getSuccessMessageText() {
        return getNotificationText(successNotification);
    }

    private String getNotificationText(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}
