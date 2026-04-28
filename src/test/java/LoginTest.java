import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest{

    private final String existingUserEmail = "hannakavaliova@gmail.com";
    private final String existingUserPassword = "Anna1234";
    private final String randomEmail = "test" + System.currentTimeMillis() + "@gmail.com";
    private final String randomPassword = "Pass" + System.currentTimeMillis();


    @Test
    public void existingUserSuccessfulLogin(){

        WebElement loginInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("login"));

        loginInput.sendKeys(existingUserEmail);
        passwordInput.sendKeys(existingUserPassword);
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box-account")));

        Assert.assertTrue(accountBox.isDisplayed());
    }

    @Test
    public void loginWithNonExistingUser(){

        WebElement loginInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("login"));

        loginInput.sendKeys(randomEmail);
        passwordInput.sendKeys(randomPassword);
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".notice.errors")));

        Assert.assertEquals(errorNotification.getText(),"Wrong password or the account is disabled, or does not exist");
    }

    @Test
    public void loginWithEmptyFields(){

        WebElement loginInput = driver.findElement(By.name("email"));
        WebElement loginButton = driver.findElement(By.name("login"));

        loginButton.click();

        Assert.assertFalse(loginInput.getAttribute("validationMessage").isEmpty());
    }

    @Test
    public void loginWithoutPassword(){

        WebElement loginInput = driver.findElement(By.name("email"));
        WebElement loginButton = driver.findElement(By.name("login"));

        loginInput.sendKeys(randomEmail);
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".notice.errors")));

        Assert.assertEquals(errorNotification.getText(),"You must provide both email address and password.");
    }

    @Test
    public void forgotPassword(){
        WebElement loginInput = driver.findElement(By.name("email"));
        WebElement lostPasswordButton = driver.findElement(By.name("lost_password"));

        loginInput.sendKeys("hannakavaliova1201@gmail.com");
        lostPasswordButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".notice.success")));

        Assert.assertEquals(successNotification.getText(),"A new password has been sent to your email address.");
    }

    @Test
    public void logout(){
        WebElement loginInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("login"));

        loginInput.sendKeys(existingUserEmail);
        passwordInput.sendKeys(existingUserPassword);
        loginButton.click();

        WebElement logout = driver.findElement(By.cssSelector("#box-account a[href='https://litecart.stqa.ru/en/logout']"));

        logout.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".notice.success")));

        Assert.assertEquals(successNotification.getText(),"You are now logged out.");
    }
}

