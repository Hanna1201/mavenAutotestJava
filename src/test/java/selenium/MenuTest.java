package selenium;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.object_based_po.CatalogPage;
import selenium.object_based_po.HomePage;
import selenium.object_based_po.MenuPage;
import selenium.object_based_po.SubCategoryPage;

@Epic("Menu")
@Feature("Menu navigation")
public class MenuTest extends TestBase {

    private MenuPage menuPage;
    private CatalogPage catalogPage;
    private SubCategoryPage subCategoryPage;
    private HomePage homePage;

    @BeforeMethod
    public void initPages() {
        menuPage = new MenuPage(getDriver());
        catalogPage = new CatalogPage(getDriver());
        subCategoryPage = new SubCategoryPage(getDriver());
        homePage = new HomePage(getDriver());
    }

    @Story("Open Rubber Ducks category from menu")
    @Description("When user clicks Rubber Ducks in menu, Rubber Ducks category page is opened")
    @Test(description = "Open Rubber Ducks category from menu")
    public void clickRubberDucksInMenu() {
        menuPage.clickRubberDucksInMenu();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(catalogPage.getPageTitle(), "Rubber Ducks | My Store");
        softAssert.assertTrue(catalogPage.getCurrentUrl().contains("rubber-ducks-c-1"));
        softAssert.assertAll();
    }

    @Story("Open Subcategory from menu")
    @Description("When user opens Rubber Ducks menu and clicks Subcategory, Subcategory page is opened")
    @Test(description = "Open Subcategory from menu")
    public void clickSubcategoryInMenu() {
        menuPage.openSubcategory();

        Assert.assertEquals(subCategoryPage.getSubcategoryText(), "Subcategory");
    }

    @Story("Return to home page from menu")
    @Description("When user opens Rubber Ducks category and clicks Home in menu, home page is opened")
    @Test(description = "Return to home page from menu")
    public void clickRubberDucksThenClickHomeInMenu() {
        menuPage.clickRubberDucksInMenu();
        menuPage.clickHomeInMenu();

        Assert.assertTrue(homePage.isSliderOnHomePageDisplayed());
    }
}
