package selenide.object_based_po;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {

    public void waitUntilCartQuantityIs(String count) {
        $("#cart .quantity").shouldHave(Condition.text(count));
    }

    public void clickCartInHeader() {
        $("#cart-wrapper #cart").click();
    }
}
