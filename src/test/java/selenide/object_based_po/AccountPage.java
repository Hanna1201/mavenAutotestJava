package selenide.object_based_po;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage {

    private final String accountBox = "#box-account";
    private final String logout = "#box-account a[href$='logout']";

    public boolean isAccountBoxDisplayed() {
        return $(accountBox).shouldBe(Condition.visible).isDisplayed();
    }

    public void clickLogout() {
        $(logout).click();
    }
}
