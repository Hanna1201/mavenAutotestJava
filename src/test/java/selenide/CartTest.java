package selenide;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenide.object_based_po.CartPage;
import selenide.object_based_po.HeaderPage;
import selenide.object_based_po.MostPopularPage;
import selenide.object_based_po.ProductCartPage;

@Epic("Cart")
@Feature("Add and remove products from cart")
public class CartTest extends TestBase {

    private MostPopularPage mostPopularPage;
    private ProductCartPage productCartPage;
    private HeaderPage headerPage;
    private CartPage cartPage;

    @BeforeMethod
    public void initPages() {
        mostPopularPage = new MostPopularPage();
        productCartPage = new ProductCartPage();
        headerPage = new HeaderPage();
        cartPage = new CartPage();
    }

    @Story("Add regular product to cart")
    @Description("When user opens product without sale and clicks Add To Cart, product appears in the cart with quantity 1")
    @Test(description = "Add regular product to cart")
    public void addProductToCart() {
        mostPopularPage.clickOnProductCardWithoutSale();
        productCartPage.addProductToCart();
        headerPage.waitUntilCartQuantityIs("1");
        headerPage.clickCartInHeader();

        Assert.assertEquals(cartPage.getQuantity(), "1");
    }

    @Story("Add sale product with selected size to cart")
    @Description("When user opens sale product, selects size and clicks Add To Cart, product appears in the cart with selected size")
    @Test(description = "Add sale product with selected size to cart")
    public void addProductWithSaleToCart() {
        mostPopularPage.clickOnProductCardWithSale();
        productCartPage.selectSize("Small");
        productCartPage.addProductToCart();
        headerPage.waitUntilCartQuantityIs("1");
        headerPage.clickCartInHeader();

        Assert.assertEquals(cartPage.getSize(), "Size: Small");
    }

    @Story("Remove product from cart")
    @Description("When user adds product to cart and removes it, empty cart message appears")
    @Test(description = "Remove product from cart")
    public void removeProductToCart() {
        mostPopularPage.clickOnProductCardWithoutSale();
        productCartPage.addProductToCart();
        headerPage.waitUntilCartQuantityIs("1");
        headerPage.clickCartInHeader();
        cartPage.clickRemoveFromCart();

        Assert.assertEquals(cartPage.getTextRemoveFromCart(), "There are no items in your cart.");
    }
}