import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class MenuTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        driver = new ChromeDriver(options);
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void clickRubberDucksInMenu() {
        WebElement rubberDucksInMenu = driver.findElement(By.cssSelector("nav#site-menu li.category-1"));
        rubberDucksInMenu.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Rubber Ducks | My Store");
        softAssert.assertTrue(driver.getCurrentUrl().contains("rubber-ducks-c-1"));
        softAssert.assertAll();
    }

    @Test
    public void clickSubcategoryInMenu() {
        WebElement rubberDucksInMenu = driver.findElement(By.cssSelector("nav#site-menu li.category-1"));

        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksInMenu).perform();

        WebElement subcategoryInMenu = driver.findElement(By.cssSelector("nav#site-menu li.category-2"));
        subcategoryInMenu.click();

        WebElement textSubcategory = driver.findElement(By.cssSelector("h1.title"));

        Assert.assertEquals(textSubcategory.getText(), "Subcategory");
    }

    @Test
    public void clickRubberDucksThenClickHomeInMenu() {
        WebElement rubberDucksInMenu = driver.findElement(By.cssSelector("nav#site-menu li.category-1"));
        rubberDucksInMenu.click();

        WebElement homeInMenu = driver.findElement(By.cssSelector("nav#site-menu li.general-0"));
        homeInMenu.click();

        WebElement sliderOnHomePage = driver.findElement((By.cssSelector("ul#slider.rslides")));

        Assert.assertTrue(sliderOnHomePage.isDisplayed());
    }
}
