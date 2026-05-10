package selenide;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenide.object_based_po.CatalogPage;
import selenide.object_based_po.HomePage;
import selenide.object_based_po.MenuPage;
import selenide.object_based_po.SubCategoryPage;

public class MenuTest extends TestBase {

    private MenuPage menuPage;
    private CatalogPage catalogPage;
    private SubCategoryPage subCategoryPage;
    private HomePage homePage;

    @BeforeMethod
    public void initPages() {
        menuPage = new MenuPage();
        catalogPage = new CatalogPage();
        subCategoryPage = new SubCategoryPage();
        homePage = new HomePage();
    }

    @Test
    public void clickRubberDucksInMenu() {
        menuPage.clickRubberDucksInMenu();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(catalogPage.getPageTitle(), "Rubber Ducks | My Store");
        softAssert.assertTrue(catalogPage.getCurrentUrl().contains("rubber-ducks-c-1"));
        softAssert.assertAll();
    }

    @Test
    public void clickSubcategoryInMenu() {
        menuPage.openSubcategory();

        Assert.assertEquals(subCategoryPage.getSubcategoryText(), "Subcategory");
    }

    @Test
    public void clickRubberDucksThenClickHomeInMenu() {
        menuPage.clickRubberDucksInMenu();
        menuPage.clickHomeInMenu();

        Assert.assertTrue(homePage.isSliderOnHomePageDisplayed());
    }
}
