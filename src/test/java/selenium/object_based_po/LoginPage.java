package selenium.object_based_po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private By loginInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");
    private By lostPasswordButton = By.name("lost_password");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Attempt login with email: {login}")
    public void attemptLogin(String login, String password) {
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Enter email: {login}")
    public void enterLogin(String login) {
        driver.findElement(loginInput).sendKeys(login);
    }

    @Step("Get email input validation message")
    public String validationMessageInputLogin() {
        return driver.findElement(loginInput).getAttribute("validationMessage");
    }

    @Step("Click login button")
    public void clickButtonLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("Click lost password button")
    public void clickLostPassword() {
        driver.findElement(lostPasswordButton).click();
    }
}
