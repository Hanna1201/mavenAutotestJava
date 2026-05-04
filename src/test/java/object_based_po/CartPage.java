package object_based_po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private By quantity = By.name("quantity");
    private By size = By.xpath("//p[contains(text(),'Size:')]");
    private By removeButtonOnCart = By.name("remove_cart_item");
    private By textEmptyCart = By.cssSelector("#checkout-cart-wrapper em");

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getQuantity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(quantity)).getAttribute("value");
    }

    public String getSize() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(size)).getText();
    }

    public void clickRemoveFromCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeButtonOnCart)).click();
    }

    public String getTextRemoveFromCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textEmptyCart)).getText();
    }
}
