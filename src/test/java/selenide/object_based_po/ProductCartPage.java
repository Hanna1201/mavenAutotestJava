package selenide.object_based_po;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class ProductCartPage {

    public void addProductToCart() {
        $("button[value='Add To Cart']").click();
    }

    public void selectSize(String size) {
        $("[name='options[Size]']").selectOptionByValue(size);
    }

    public boolean isLogoProductDisplayed() {
        return $("img[title='ACME Corp.']").shouldBe(Condition.visible).isDisplayed();
    }
}