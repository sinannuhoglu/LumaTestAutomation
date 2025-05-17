package org.example;

import org.example.data.TestData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class ForgotPasswordTest extends BaseTest {

    @Test(description = "Positive Test – Verifies that a reset link is sent when a valid email is submitted.")
    public void testResetPasswordRequestWithValidEmail() {
        forgotPasswordPage.navigateToPage();
        forgotPasswordPage.setEmail(TestData.VALID_LOGIN_EMAIL);
        forgotPasswordPage.clickResetPasswordButton();

        String message = forgotPasswordPage.getSuccessMessageText();
        Assert.assertTrue(message.contains(TestData.EXPECTED_FORGOT_PASSWORD_SUCCESS_MESSAGE),
                "Success message after password reset request not shown as expected. Actual: " + message);
    }

    @Test(description = "UI Test – Verifies Forgot Password page loads and title is correct.")
    public void testForgotPasswordPageTitle() {
        forgotPasswordPage.navigateToPage();

        String title = forgotPasswordPage.getPageTitleText();
        Assert.assertEquals(title.trim(), TestData.PAGE_TITLE_FORGOT_PASSWORD,
                "Page title does not match expected. Actual: " + title);
    }
}
