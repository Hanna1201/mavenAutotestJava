package selenide.object_based_po;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public boolean isSliderOnHomePageDisplayed() {
        return $("ul#slider.rslides").shouldBe(Condition.visible).isDisplayed();
    }
}
