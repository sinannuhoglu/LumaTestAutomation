package org.example;

import org.example.data.TestData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class CustomerLoginTest extends BaseTest {

    @Test(description = "Positive Test – Verifies that the form can be successfully submitted with valid input data.")
    public void testSubmitForm() {
        customerLoginPage.navigateToPage();
        customerLoginPage.setEmail(TestData.VALID_LOGIN_EMAIL);
        customerLoginPage.setPassword(TestData.VALID_PASSWORD);
        customerLoginPage.clickSignInButton();

        String pageTitle = customerLoginPage.getPageTitleText();
        Assert.assertEquals(pageTitle.trim(), TestData.PAGE_TITLE_MY_ACCOUNT,
                "Login was expected to be successful, but 'My Account' page title was not found. Actual: " + pageTitle);
    }

    @Test(description = "Positive Test – Verifies that clicking 'Create an Account' redirects to the 'Create New Customer Account' page.")
    public void testCreateAccountRedirection() {
        customerLoginPage.navigateToPage();
        customerLoginPage.clickCreateAccountButton();

        String actualTitle = customerLoginPage.getPageTitleText();
        Assert.assertEquals(actualTitle.trim(), TestData.PAGE_TITLE_CREATE_ACCOUNT,
                "Redirection failed or page title did not match.");
    }

    @Test(description = "Positive Test – Verifies that clicking 'Forgot Your Password?' redirects to the Forgot Password page.")
    public void testForgotPasswordLinkRedirectsCorrectly() {
        customerLoginPage.navigateToPage();
        customerLoginPage.clickForgotPasswordLink();

        String actualTitle = customerLoginPage.getPageTitleText();
        Assert.assertEquals(actualTitle.trim(), TestData.PAGE_TITLE_FORGOT_PASSWORD,
                "Redirection failed or page title did not match. Actual: " + actualTitle);
    }

    @Test(description = "Negative Test – Verifies that an invalid email format triggers the appropriate error message.")
    public void testInvalidEmailFormatShowsError() {
        customerLoginPage.navigateToPage();
        customerLoginPage.setEmail(TestData.INVALID_EMAIL);
        customerLoginPage.setPassword(TestData.VALID_PASSWORD);
        customerLoginPage.clickSignInButton();

        if (customerLoginPage.isElementPresent(customerLoginPage.getEmailErrorLocator())) {
            String actualErrorMessage = customerLoginPage.getEmailErrorMessage();
            Assert.assertTrue(actualErrorMessage.contains(TestData.EXPECTED_INVALID_EMAIL_MESSAGE),
                    "Invalid email format error message was not shown in #email-error. Actual: " + actualErrorMessage);
        } else {
            String generalError = customerLoginPage.getGeneralLoginErrorMessage();
            Assert.assertTrue(generalError.contains(TestData.EXPECTED_INVALID_EMAIL_MESSAGE)
                            || generalError.contains(TestData.EXPECTED_ACCOUNT_DISABLED_MESSAGE),
                    "Expected general login error not shown. Actual: " + generalError);
        }
    }

    @Test(description = "Negative Test – Verifies that required field errors appear when fields are left empty.")
    public void testEmptyEmailAndPasswordShowsRequiredFieldErrors() {
        customerLoginPage.navigateToPage();
        customerLoginPage.setEmail("");
        customerLoginPage.setPassword("");
        customerLoginPage.clickSignInButton();

        boolean emailFieldErrorPresent = customerLoginPage.isElementPresent(customerLoginPage.getEmailErrorLocator());
        boolean passwordFieldErrorPresent = customerLoginPage.isElementPresent(customerLoginPage.getPasswordErrorLocator());

        if (emailFieldErrorPresent && passwordFieldErrorPresent) {
            Assert.assertTrue(customerLoginPage.getEmailErrorMessage().contains(TestData.EXPECTED_REQUIRED_FIELD_MESSAGE));
            Assert.assertTrue(customerLoginPage.getPasswordErrorMessage().contains(TestData.EXPECTED_REQUIRED_FIELD_MESSAGE));
        } else {
            String generalError = customerLoginPage.getGeneralLoginErrorMessage();
            Assert.assertTrue(generalError.contains(TestData.EXPECTED_LOGIN_REQUIRED_FIELD_MESSAGE),
                    "The general error message was expected but not found. Actual: " + generalError);
        }
    }

    @Test(description = "Negative Test – Verifies that an incorrect login attempt shows the correct error message.")
    public void testIncorrectLoginShowsErrorMessage() {
        customerLoginPage.navigateToPage();
        customerLoginPage.setEmail(TestData.VALID_LOGIN_EMAIL);
        customerLoginPage.setPassword(TestData.INVALID_PASSWORD);
        customerLoginPage.clickSignInButton();

        String actualMessage = customerLoginPage.getGeneralLoginErrorMessage();
        Assert.assertTrue(customerLoginPage.isGeneralLoginErrorDisplayed());
        Assert.assertTrue(actualMessage.contains(TestData.EXPECTED_INCORRECT_LOGIN_MESSAGE),
                "Expected login error message not shown. Actual: " + actualMessage);
    }

    @Test(description = "UI Test – Verifies that the 'Customer Login' page title is correct.")
    public void testCustomerLoginPageTitle() {
        customerLoginPage.navigateToPage();

        String actualTitle = customerLoginPage.getPageTitleText();
        Assert.assertEquals(actualTitle.trim(), TestData.PAGE_TITLE_CUSTOMER_LOGIN,
                "Page title is incorrect on Customer Login page. Actual: " + actualTitle);
    }
}
