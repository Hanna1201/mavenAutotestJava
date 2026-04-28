import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CatalogTest extends BaseTest{

    @Test
    public void openCategoryPage(){
        WebElement rubberDucksInMenu = driver.findElement(By.cssSelector("nav#site-menu li.category-1"));
        rubberDucksInMenu.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Rubber Ducks | My Store");
        softAssert.assertTrue(driver.getCurrentUrl().contains("rubber-ducks-c-1"));
        softAssert.assertAll();
    }

    @Test
    public void sortProductsByName(){
        WebElement rubberDucksInMenu = driver.findElement(By.cssSelector("nav#site-menu li.category-1"));
        rubberDucksInMenu.click();

        WebElement nameFilter = driver.findElement(By.cssSelector("a[href$='sort=name']"));
        nameFilter.click();

        WebElement firstProductName = driver.findElement(By.cssSelector(".products .product:first-child .name"));

        Assert.assertEquals(firstProductName.getText(), "Blue Duck");
    }

    @Test
    public void openProductCard(){
        WebElement rubberDucksInMenu = driver.findElement(By.cssSelector("nav#site-menu li.category-1"));
        rubberDucksInMenu.click();

        WebElement firstProduct = driver.findElement(By.cssSelector(".products .product:first-child"));
        firstProduct.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[title='ACME Corp.']")));

        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void openProductPreview(){
        WebElement rubberDucksInMenu = driver.findElement(By.cssSelector("nav#site-menu li.category-1"));
        rubberDucksInMenu.click();

        WebElement zoomFirstProduct = driver.findElement(By.cssSelector(".products .product:first-child .zoomable"));
        zoomFirstProduct.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement zoomImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fancybox-img")));

        Assert.assertTrue(zoomImg.isDisplayed());
    }

}
