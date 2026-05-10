package selenide.object_based_po;

import static com.codeborne.selenide.Selenide.$;

public class MostPopularPage {

    public void clickOnProductCardWithoutSale() {
        $("li.product:not(:has(.sticker.sale))").click();
    }

    public void clickOnProductCardWithSale() {
        $("#box-most-popular .sale").click();
    }
}
