import object_based_po.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class CatalogTest extends TestBase {

    private MenuPage menuPage;
    private CatalogPage catalogPage;
    private ProductCartPage productCartPage;

    @BeforeMethod
    public void initPages() {
        menuPage = new MenuPage(getDriver());
        catalogPage = new CatalogPage(getDriver());
        productCartPage = new ProductCartPage(getDriver());
    }

    @Test
    public void openCategoryPage() {
        menuPage.clickRubberDucksInMenu();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(catalogPage.getPageTitle(), "Rubber Ducks | My Store");
        softAssert.assertTrue(catalogPage.getCurrentUrl().contains("rubber-ducks-c-1"));
        softAssert.assertAll();
    }

    @Test
    public void sortProductsByName() {
        menuPage.clickRubberDucksInMenu();
        catalogPage.clickOnFilterName();

        Assert.assertEquals(catalogPage.getNameFirstProduct(), "Blue Duck");
    }

    @Test
    public void openProductCard() {
        menuPage.clickRubberDucksInMenu();
        catalogPage.clickOnFirstProduct();

        Assert.assertTrue(productCartPage.isLogoProductDisplayed());
    }

    @Test
    public void openProductPreview() {
        menuPage.clickRubberDucksInMenu();
        catalogPage.clickOnZoomImage();

        Assert.assertTrue(catalogPage.isZoomImgDisplayed());
    }
}
