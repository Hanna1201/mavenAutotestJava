package selenium.object_based_po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    private By accountBox = By.id("box-account");
    private By logout = By.cssSelector("#box-account a[href$='logout']");

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check that account box is displayed")
    public boolean isAccountBoxDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountBox)).isDisplayed();
    }

    @Step("Click logout")
    public void clickLogout() {
        driver.findElement(logout).click();
    }
}
