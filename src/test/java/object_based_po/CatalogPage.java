package object_based_po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage {

    private By nameFilter = By.cssSelector("a[href$='sort=name']");
    private By firstProductName = By.cssSelector(".products .product:first-child .name");
    private By zoomFirstProduct = By.cssSelector(".products .product:first-child .zoomable");
    private By zoomImg = By.id("fancybox-img");

    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickOnFilterName(){
        driver.findElement(nameFilter).click();
    }

    public String getNameFirstProduct(){
        return driver.findElement(firstProductName).getText();
    }

    public void clickOnFirstProduct(){
        driver.findElement(firstProductName).click();
    }

    public void clickOnZoomImage(){
        driver.findElement(zoomFirstProduct).click();
    }

    public boolean isZoomImgDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(zoomImg)).isDisplayed();
    }
}
