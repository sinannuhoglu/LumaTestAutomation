package org.example.pages;

import io.qameta.allure.Step;
import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.util.Constants.CREATE_ACCOUNT_PATH;
import static org.example.util.Constants.BASE_URL;

public class CreateNewAccountPage extends BasePage {
    private WebDriver driver;

    private By firstNameField = By.name("firstname");
    private By lastNameField = By.name("lastname");
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By confirmPasswordField = By.name("password_confirmation");

    private By createAccountButton = By.cssSelector("button.action.submit.primary");

    private By passwordClassError = By.cssSelector("div#password-error.mage-error");
    private By confirmPasswordError = By.cssSelector("div#password-confirmation-error.mage-error");
    private By emailError = By.cssSelector("div#email_address-error.mage-error");

    private By successMessage = By.cssSelector("div.message-success.success.message");

    private By pageTitle = By.cssSelector("h1.page-title span.base");

    public CreateNewAccountPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Navigate to 'Create New Customer Account' page")
    public void navigateToPage() {
        driver.get(BASE_URL + CREATE_ACCOUNT_PATH);
    }

    @Step("Get Page Title Text")
    public String getPageTitleText() {
        return find(pageTitle).getText();
    }

    @Step("Enter First Name: {0}")
    public void setFirstName(String firstNameAsString) {
        type(firstNameField, firstNameAsString);
    }

    @Step("Enter Last Name: {0}")
    public void setLastName(String lastNameAsString) {
        type(lastNameField, lastNameAsString);
    }

    @Step("Enter Email: {0}")
    public void setEmail(String emailAsString) {
        type(emailField, emailAsString);
    }

    @Step("Enter Password")
    public void setPassword(String passwordAsString) {
        type(passwordField, passwordAsString);
    }

    @Step("Enter Confirm Password")
    public void setConfirmPassword(String confirmPasswordAsString) {
        type(confirmPasswordField, confirmPasswordAsString);
    }

    @Step("Click 'Create an Account' button")
    public void clickCreateAccountButton() {
        click(createAccountButton);
    }

    @Step("Get Password Error Message")
    public String getPasswordErrorMessage() {
        return find(passwordClassError).getText();
    }

    @Step("Get Confirm Password Error Message")
    public String getConfirmPasswordErrorMessage() {
        return find(confirmPasswordError).getText();
    }

    @Step("Get Email Error Message")
    public String getEmailErrorMessage() {
        return waitUntilVisible(emailError).getText();
    }

    @Step("Get Success Message")
    public String getSuccessMessage() {
        attachScreenshot("Success message displayed");
        return waitUntilVisible(successMessage).getText();
    }
}
