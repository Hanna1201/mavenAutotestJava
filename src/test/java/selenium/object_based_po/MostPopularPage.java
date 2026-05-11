package selenium.object_based_po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MostPopularPage {

    private By firstProductWithoutSale = By.cssSelector("li.product:not(:has(.sticker.sale))");
    private By saleProductOnMainPage = By.cssSelector("#box-most-popular .sale");


    private WebDriver driver;

    public MostPopularPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open product card without sale")
    public void clickOnProductCardWithoutSale() {
        driver.findElement(firstProductWithoutSale).click();
    }

    @Step("Open product card with sale")
    public void clickOnProductCardWithSale() {
        driver.findElement(saleProductOnMainPage).click();
    }
}
