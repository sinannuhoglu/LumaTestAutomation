package org.example.pages;

import io.qameta.allure.Step;
import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.util.Constants.BASE_URL;
import static org.example.util.Constants.FORGOT_PASSWORD_PATH;

public class ForgotPasswordPage extends BasePage {
    private WebDriver driver;

    private By emailField = By.id("email_address");
    private By resetPasswordButton = By.cssSelector("button.action.submit.primary");
    private By pageTitle = By.cssSelector("h1.page-title span.base");
    private By successMessage = By.cssSelector("div.message-success.success.message");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Navigate directly to Forgot Password page")
    public void navigateToPage() {
        driver.get(BASE_URL + FORGOT_PASSWORD_PATH);
    }

    @Step("Enter email address: {0}")
    public void setEmail(String email) {
        type(emailField, email);
    }

    @Step("Click 'Reset My Password' button")
    public void clickResetPasswordButton() {
        click(resetPasswordButton);
    }

    @Step("Get page title text")
    public String getPageTitleText() {
        return find(pageTitle).getText();
    }

    @Step("Get success message text")
    public String getSuccessMessageText() {
        return waitUntilVisible(successMessage).getText();
    }
}
