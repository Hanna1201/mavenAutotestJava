package selenide.object_based_po;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class NotificationPage {

    private final String errorNotification = ".notice.errors";
    private final String successNotification = ".notice.success";

    public String getErrorMessageText() {
        return getNotificationText(errorNotification);
    }

    public String getSuccessMessageText() {
        return getNotificationText(successNotification);
    }

    private String getNotificationText(String locator) {
        return $(locator).shouldBe(Condition.visible).getText();
    }
}
