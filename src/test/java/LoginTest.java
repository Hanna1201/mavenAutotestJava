import object_based_po.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test
    public void existingUserSuccessfulLogin() {
        loginPage.attemptLogin(existingUserEmail, existingUserPassword);

        Assert.assertTrue(accountPage.isAccountBoxDisplayed());
    }

    @Test
    public void loginWithNonExistingUser() {
        loginPage.attemptLogin(generateEmail(), generatePassword());

        Assert.assertEquals(notificationPage.getErrorMessageText(), "Wrong password or the account is disabled, or does not exist");
    }

    @Test
    public void loginWithEmptyFields() {
        loginPage.clickButtonLogin();

        Assert.assertFalse(loginPage.validationMessageInputLogin().isEmpty());
    }

    @Test
    public void loginWithoutPassword() {
        loginPage.enterLogin(generatePassword());
        loginPage.clickButtonLogin();

        Assert.assertEquals(notificationPage.getErrorMessageText(), "You must provide both email address and password.");
    }

    @Test
    public void forgotPassword() {
        loginPage.enterLogin(lostPasswordForEmail);
        loginPage.clickLostPassword();

        Assert.assertEquals(notificationPage.getSuccessMessageText(), "A new password has been sent to your email address.");
    }

    @Test
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
