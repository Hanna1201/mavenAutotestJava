package selenide.object_based_po;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    public String getQuantity() {
        return $("[name='quantity']").shouldBe(Condition.visible).getAttribute("value");
    }

    public String getSize() {
        return $x("//p[contains(text(),'Size:')]").shouldBe(Condition.visible).getText();
    }

    public void clickRemoveFromCart() {
        $("[name='remove_cart_item']").shouldBe(Condition.visible).click();
    }

    public String getTextRemoveFromCart() {
        return $("#checkout-cart-wrapper em").shouldBe(Condition.visible).getText();
    }
}
