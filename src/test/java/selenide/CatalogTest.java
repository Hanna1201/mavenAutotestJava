package selenide;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenide.object_based_po.CatalogPage;
import selenide.object_based_po.MenuPage;
import selenide.object_based_po.ProductCartPage;

@Epic("Catalog")
@Feature("Catalog product navigation and sorting")
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

    @Story("Open category page")
    @Description("When user clicks Rubber Ducks menu item, Rubber Ducks category page is opened")
    @Test(description = "Open Rubber Ducks category page")
    public void openCategoryPage() {
        menuPage.clickRubberDucksInMenu();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(catalogPage.getPageTitle(), "Rubber Ducks | My Store");
        softAssert.assertTrue(catalogPage.getCurrentUrl().contains("rubber-ducks-c-1"));
        softAssert.assertAll();
    }

    @Story("Sort products by name")
    @Description("When user opens Rubber Ducks category and clicks Name filter, products are sorted by name")
    @Test(description = "Sort products by name")
    public void sortProductsByName() {
        menuPage.clickRubberDucksInMenu();
        catalogPage.clickOnFilterName();

        Assert.assertEquals(catalogPage.getNameFirstProduct(), "Blue Duck");
    }

    @Story("Open product card")
    @Description("When user clicks the first product in catalog, product card is opened")
    @Test(description = "Open product card")
    public void openProductCard() {
        menuPage.clickRubberDucksInMenu();
        catalogPage.clickOnFirstProduct();

        Assert.assertTrue(productCartPage.isLogoProductDisplayed());
    }

    @Story("Open product preview")
    @Description("When user clicks product zoom image, product preview is displayed")
    @Test(description = "Open product preview")
    public void openProductPreview() {
        menuPage.clickRubberDucksInMenu();
        catalogPage.clickOnZoomImage();

        Assert.assertTrue(catalogPage.isZoomImgDisplayed());
    }
}
