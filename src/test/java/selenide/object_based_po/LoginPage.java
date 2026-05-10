package selenide.object_based_po;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final String loginInput = "[name='email']";
    private final String passwordInput = "[name='password']";
    private final String loginButton = "[name='login']";
    private final String lostPasswordButton = "[name='lost_password']";

    public void attemptLogin(String login, String password) {
        $(loginInput).setValue(login);
        $(passwordInput).setValue(password);
        $(loginButton).click();
    }

    public void enterLogin(String login) {
        $(loginInput).setValue(login);
    }

    public String validationMessageInputLogin() {
        return $(loginInput).getAttribute("validationMessage");
    }

    public void clickButtonLogin() {
        $(loginButton).click();
    }

    public void clickLostPassword() {
        $(lostPasswordButton).click();
    }
}
