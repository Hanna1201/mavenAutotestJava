package selenium.object_based_po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubCategoryPage {
    private By textSubcategory = By.cssSelector("h1.title");

    private WebDriver driver;

    public SubCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSubcategoryText() {
        return driver.findElement(textSubcategory).getText();
    }
}
