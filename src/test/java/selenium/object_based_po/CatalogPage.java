package selenium.object_based_po;

import io.qameta.allure.Step;
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

    @Step("Get page title")
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Step("Get current page URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Click Name filter")
    public void clickOnFilterName() {
        driver.findElement(nameFilter).click();
    }

    @Step("Get first product name")
    public String getNameFirstProduct() {
        return driver.findElement(firstProductName).getText();
    }

    @Step("Open first product card")
    public void clickOnFirstProduct() {
        driver.findElement(firstProductName).click();
    }

    @Step("Open product preview image")
    public void clickOnZoomImage() {
        driver.findElement(zoomFirstProduct).click();
    }

    @Step("Check that zoom image is displayed")
    public boolean isZoomImgDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(zoomImg)).isDisplayed();
    }
}
