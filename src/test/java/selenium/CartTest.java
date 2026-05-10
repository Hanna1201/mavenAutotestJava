package selenium;
import selenium.object_based_po.CartPage;
import selenium.object_based_po.HeaderPage;
import selenium.object_based_po.MostPopularPage;
import selenium.object_based_po.ProductCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.TestBase;

public class CartTest extends TestBase {

    private MostPopularPage mostPopularPage;
    private ProductCartPage productCartPage;
    private HeaderPage headerPage;
    private CartPage cartPage;

    @BeforeMethod
    public void initPages() {
        mostPopularPage = new MostPopularPage(getDriver());
        productCartPage = new ProductCartPage(getDriver());
        headerPage = new HeaderPage(getDriver());
        cartPage = new CartPage(getDriver());
    }

    @Test
    public void addProductToCart() {
        mostPopularPage.clickOnProductCardWithoutSale();
        productCartPage.addProductToCart();
        headerPage.waitUntilCartQuantityIs("1");
        headerPage.clickCartInHeader();

        Assert.assertEquals(cartPage.getQuantity(), "1");
    }

    @Test
    public void addProductWithSaleToCart() {
        mostPopularPage.clickOnProductCardWithSale();
        productCartPage.selectSize("Small");
        productCartPage.addProductToCart();
        headerPage.waitUntilCartQuantityIs("1");
        headerPage.clickCartInHeader();

        Assert.assertEquals(cartPage.getSize(), "Size: Small");
    }

    @Test
    public void removeProductToCart() {
        mostPopularPage.clickOnProductCardWithoutSale();
        productCartPage.addProductToCart();
        headerPage.waitUntilCartQuantityIs("1");
        headerPage.clickCartInHeader();
        ;
        cartPage.clickRemoveFromCart();

        Assert.assertEquals(cartPage.getTextRemoveFromCart(), "There are no items in your cart.");
    }
}
