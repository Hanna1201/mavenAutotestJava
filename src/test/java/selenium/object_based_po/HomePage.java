package selenium.object_based_po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private By sliderOnHomePage = By.cssSelector("ul#slider.rslides");


    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check that slider is displayed on home page")
    public boolean isSliderOnHomePageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sliderOnHomePage)).isDisplayed();
    }
}
