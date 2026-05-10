package selenide.object_based_po;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CatalogPage {

    private final String firstProductName = ".products .product:first-child .name";

    public String getPageTitle() {
        return title();
    }

    public String getCurrentUrl() {
        return url();
    }

    public void clickOnFilterName() {
        $("a[href$='sort=name']").click();
    }

    public String getNameFirstProduct() {
        return $(firstProductName).shouldBe(Condition.visible).getText();
    }

    public void clickOnFirstProduct() {
        $(firstProductName).click();
    }

    public void clickOnZoomImage() {
        $(".products .product:first-child .zoomable").click();
    }

    public boolean isZoomImgDisplayed() {
        return $("#fancybox-img").shouldBe(Condition.visible).isDisplayed();
    }
}
