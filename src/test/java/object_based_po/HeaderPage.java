package object_based_po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {

    private By cartQuantity = By.cssSelector("#cart .quantity");
    private By cartInHeader = By.cssSelector("#cart-wrapper #cart");

    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilCartQuantityIs(String count) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(cartQuantity, count));
    }

    public void clickCartInHeader() {
        driver.findElement(cartInHeader).click();
    }
}
