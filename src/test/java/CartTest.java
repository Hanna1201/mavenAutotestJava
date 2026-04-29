import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCart() {

        WebElement firstProductOnMainPage = driver.findElement(By.cssSelector("li.product:not(:has(.sticker.sale))"));
        firstProductOnMainPage.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector("button[value='Add To Cart']"));
        addToCartButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#cart .quantity"), "1"));

        WebElement cartInHeader = driver.findElement(By.cssSelector("#cart-wrapper #cart"));
        cartInHeader.click();

        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("quantity")));

        Assert.assertEquals(quantity.getAttribute("value"), "1");
    }

    @Test
    public void addProductWithSaleToCart() {

        WebElement saleProductOnMainPage = driver.findElement(By.cssSelector("#box-most-popular .sale"));
        saleProductOnMainPage.click();

        Select dropdown = new Select(driver.findElement(By.name("options[Size]")));
        dropdown.selectByValue("Small");

        WebElement addToCartButton = driver.findElement(By.cssSelector("button[value='Add To Cart']"));
        addToCartButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#cart .quantity"), "1"));

        WebElement cartInHeader = driver.findElement(By.cssSelector("#cart-wrapper #cart"));
        cartInHeader.click();

        WebElement size = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Size:')]")));

        Assert.assertEquals(size.getText(), "Size: Small");
    }

    @Test
    public void removeProductToCart() {

        WebElement firstProductOnMainPage = driver.findElement(By.cssSelector("li.product:not(:has(.sticker.sale))"));
        firstProductOnMainPage.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector("button[value='Add To Cart']"));
        addToCartButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#cart .quantity"), "1"));

        WebElement cartInHeader = driver.findElement(By.cssSelector("#cart-wrapper #cart"));
        cartInHeader.click();

        WebElement removeButtonOnCart = driver.findElement(By.name("remove_cart_item"));
        removeButtonOnCart.click();

        WebElement textEmptyCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout-cart-wrapper em")));

        Assert.assertEquals(textEmptyCart.getText(), "There are no items in your cart.");
    }
}
