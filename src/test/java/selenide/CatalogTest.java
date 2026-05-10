package selenide;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenide.object_based_po.CatalogPage;
import selenide.object_based_po.MenuPage;
import selenide.object_based_po.ProductCartPage;

public class CatalogTest extends TestBase {

    private MenuPage menuPage;
    private CatalogPage catalogPage;
    private ProductCartPage productCartPage;

    @BeforeMethod
    public void initPages() {
        menuPage = new MenuPage();
        catalogPage = new CatalogPage();
        productCartPage = new ProductCartPage();
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
