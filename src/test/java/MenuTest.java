import object_based_po.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
