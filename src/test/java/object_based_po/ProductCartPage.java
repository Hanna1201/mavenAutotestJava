package object_based_po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductCartPage {

    private By addToCartButton = By.cssSelector("button[value='Add To Cart']");
    private By sizeDropdown = By.name("options[Size]");
    private By logoProduct = By.cssSelector("img[title='ACME Corp.']");

    private WebDriver driver;

    public ProductCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void selectSize(String size) {
        Select dropdown = new Select(driver.findElement(sizeDropdown));
        dropdown.selectByValue(size);
    }

    public boolean isLogoProductDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoProduct)).isDisplayed();
    }
}
