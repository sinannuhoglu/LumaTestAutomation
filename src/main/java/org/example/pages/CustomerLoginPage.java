package org.example.pages;

import io.qameta.allure.Step;
import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static org.example.util.Constants.*;

public class CustomerLoginPage extends BasePage {
    private WebDriver driver;

    private By emailField = By.name("login[username]");
    private By passwordField = By.name("login[password]");

    private By singInButton = By.id("send2");
    private By createAccountButton = By.cssSelector("a.action.create.primary");
    private By forgotPasswordLink = By.cssSelector("a.action.remind");

    private By emailError = By.id("email-error");
    private By passwordError = By.id("pass-error");
    private By generalLoginError = By.cssSelector("div.message-error.error.message");

    private By pageTitle = By.cssSelector("span.base");

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Navigate to the Customer Login page")
    public void navigateToPage() {
        driver.get(BASE_URL + LOGIN_PATH);
    }

    @Step("Enter Email: {0}")
    public void setEmail(String emailAsString) {
        type(emailField, emailAsString);
    }

    @Step("Enter Password")
    public void setPassword(String passwordAsString) {
        type(passwordField, passwordAsString);
    }

    @Step("Click 'Sign In' button")
    public void clickSignInButton() {
        click(singInButton);
    }

    @Step("Click 'Create an Account' button")
    public void clickCreateAccountButton() {
        click(createAccountButton);
    }

    @Step("Click 'Forgot Your Password?' link")
    public void clickForgotPasswordLink() {
        click(forgotPasswordLink);
    }

    @Step("Get Email Error Message")
    public String getEmailErrorMessage() {
        return find(emailError).getText();
    }

    @Step("Get Password Error Message")
    public String getPasswordErrorMessage() {
        return find(passwordError).getText();
    }

    @Step("Get General Login Error Message")
    public String getGeneralLoginErrorMessage() {
        attachScreenshot("General login error displayed");
        return waitUntilVisible(generalLoginError).getText();
    }

    @Step("Check if General Login Error is Displayed")
    public boolean isGeneralLoginErrorDisplayed() {
        return find(generalLoginError).isDisplayed();
    }

    @Step("Get Email Error Locator")
    public By getEmailErrorLocator() {
        return emailError;
    }

    @Step("Get Password Error Locator")
    public By getPasswordErrorLocator() {
        return passwordError;
    }

    @Step("Get Page Title Text")
    public String getPageTitleText() {
        return find(pageTitle).getText();
    }

    @Step("Check if element is present: {0}")
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
