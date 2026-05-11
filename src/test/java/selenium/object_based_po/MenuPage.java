package selenium.object_based_po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuPage {

    private By rubberDucksInMenu = By.cssSelector("nav#site-menu li.category-1");
    private By subcategoryInMenu = By.cssSelector("nav#site-menu li.category-2");
    private By homeInMenu = By.cssSelector("nav#site-menu li.general-0");


    private WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click Rubber Ducks in menu")
    public void clickRubberDucksInMenu() {
        driver.findElement(rubberDucksInMenu).click();
    }

    @Step("Open Subcategory from menu")
    public void openSubcategory() {
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(rubberDucksInMenu))
                .click(driver.findElement(subcategoryInMenu))
                .perform();
    }

    @Step("Click Home in menu")
    public void clickHomeInMenu() {
        driver.findElement(homeInMenu).click();
    }
}
