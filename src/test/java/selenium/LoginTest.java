package selenium;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.object_based_po.AccountPage;
import selenium.object_based_po.LoginPage;
import selenium.object_based_po.NotificationPage;

@Epic("User account")
@Feature("Login and logout")
public class LoginTest extends TestBase {

    private final String existingUserEmail = "hannakavaliova@gmail.com";
    private final String existingUserPassword = "Anna1234";
    private final String lostPasswordForEmail = "hannakavaliova1201@gmail.com";

    private LoginPage loginPage;
    private AccountPage accountPage;
    private NotificationPage notificationPage;

    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(getDriver());
        accountPage = new AccountPage(getDriver());
        notificationPage = new NotificationPage(getDriver());
    }

    @Story("Successful login")
    @Description("When existing user enters valid credentials, account box is displayed")
    @Test(description = "Successful login with existing user")
    public void existingUserSuccessfulLogin() {
        loginPage.attemptLogin(existingUserEmail, existingUserPassword);

        Assert.assertTrue(accountPage.isAccountBoxDisplayed());
    }

    @Story("Login with non-existing user")
    @Description("When user enters non-existing credentials, error notification is displayed")
    @Test(description = "Login with non-existing user")
    public void loginWithNonExistingUser() {
        loginPage.attemptLogin(generateEmail(), generatePassword());

        Assert.assertEquals(notificationPage.getErrorMessageText(), "Wrong password or the account is disabled, or does not exist");
    }

    @Story("Login validation")
    @Description("When user submits empty login form, browser validation message is displayed")
    @Test(description = "Login with empty fields")
    public void loginWithEmptyFields() {
        loginPage.clickButtonLogin();

        Assert.assertFalse(loginPage.validationMessageInputLogin().isEmpty());
    }

    @Story("Login validation")
    @Description("When user enters email without password, error notification is displayed")
    @Test(description = "Login without password")
    public void loginWithoutPassword() {
        loginPage.enterLogin(generatePassword());
        loginPage.clickButtonLogin();

        Assert.assertEquals(notificationPage.getErrorMessageText(), "You must provide both email address and password.");
    }

    @Story("Forgot password")
    @Description("When user requests password recovery, success notification is displayed")
    @Test(description = "Forgot password")
    public void forgotPassword() {
        loginPage.enterLogin(lostPasswordForEmail);
        loginPage.clickLostPassword();

        Assert.assertEquals(notificationPage.getSuccessMessageText(), "A new password has been sent to your email address.");
    }

    @Story("Logout")
    @Description("When logged-in user clicks logout, success notification is displayed")
    @Test(description = "Logout")
    public void logout() {
        loginPage.attemptLogin(existingUserEmail, existingUserPassword);
        accountPage.clickLogout();

        Assert.assertEquals(notificationPage.getSuccessMessageText(), "You are now logged out.");
    }

    private String generateEmail() {
        return "test" + System.currentTimeMillis() + "@gmail.com";
    }

    private String generatePassword() {
        return "Pass" + System.currentTimeMillis();
    }
}
