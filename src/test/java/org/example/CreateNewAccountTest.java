package org.example;

import org.example.data.TestData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class CreateNewAccountTest extends BaseTest {

    @Test(description = "Positive Test – Verifies that the form can be successfully submitted with valid input data.")
    public void testSubmitForm() {
        createNewAccountPage.navigateToPage();
        createNewAccountPage.setFirstName(TestData.VALID_FIRST_NAME);
        createNewAccountPage.setLastName(TestData.VALID_LAST_NAME);
        createNewAccountPage.setEmail(TestData.generateRandomEmail());
        createNewAccountPage.setPassword(TestData.VALID_PASSWORD);
        createNewAccountPage.setConfirmPassword(TestData.VALID_PASSWORD);
        createNewAccountPage.clickCreateAccountButton();

        String successText = createNewAccountPage.getSuccessMessage();
        Assert.assertTrue(successText.contains(TestData.EXPECTED_SUCCESS_MESSAGE),
                "Success message not found! Actual message: " + successText);
    }

    @Test(description = "Negative Test – Verifies that a required field error message appears when the email field is left empty.")
    public void testMissingEmailField() {
        createNewAccountPage.navigateToPage();
        createNewAccountPage.setFirstName(TestData.VALID_FIRST_NAME);
        createNewAccountPage.setLastName(TestData.VALID_LAST_NAME);
        createNewAccountPage.setPassword(TestData.VALID_PASSWORD);
        createNewAccountPage.setConfirmPassword(TestData.VALID_PASSWORD);
        createNewAccountPage.clickCreateAccountButton();

        Assert.assertTrue(driver.getPageSource().contains(TestData.EXPECTED_REQUIRED_FIELD_MESSAGE),
                "Expected required field error message was not found.");
    }

    @Test(description = "Negative Test – Verifies that an invalid email format triggers the appropriate error message.")
    public void testInvalidEmailFormat() {
        createNewAccountPage.navigateToPage();
        createNewAccountPage.setFirstName(TestData.VALID_FIRST_NAME);
        createNewAccountPage.setLastName(TestData.VALID_LAST_NAME);
        createNewAccountPage.setEmail(TestData.INVALID_EMAIL);
        createNewAccountPage.setPassword(TestData.VALID_PASSWORD);
        createNewAccountPage.setConfirmPassword(TestData.VALID_PASSWORD);
        createNewAccountPage.clickCreateAccountButton();

        String actualMessage = createNewAccountPage.getEmailErrorMessage();
        Assert.assertTrue(actualMessage.contains(TestData.EXPECTED_INVALID_EMAIL_MESSAGE),
                "Expected invalid email error message was not shown. Actual: " + actualMessage);
    }

    @Test(description = "Negative Test – Verifies that a mismatch between password and confirm password fields triggers an error.")
    public void testMismatchedPasswords() {
        createNewAccountPage.navigateToPage();
        createNewAccountPage.setFirstName(TestData.VALID_FIRST_NAME);
        createNewAccountPage.setLastName(TestData.VALID_LAST_NAME);
        createNewAccountPage.setEmail(TestData.generateRandomEmail());
        createNewAccountPage.setPassword(TestData.VALID_PASSWORD);
        createNewAccountPage.setConfirmPassword(TestData.MISMATCHED_PASSWORD);
        createNewAccountPage.clickCreateAccountButton();

        String actualMessage = createNewAccountPage.getConfirmPasswordErrorMessage();
        Assert.assertTrue(actualMessage.contains(TestData.EXPECTED_MISMATCHED_PASSWORD_MESSAGE),
                "Expected password mismatch error message was not shown. Actual: " + actualMessage);
    }

    @Test(description = "Negative Test – Verifies that a password with fewer than three character classes triggers an error.")
    public void testPasswordInsufficientCharacterClasses() {
        createNewAccountPage.navigateToPage();
        createNewAccountPage.setFirstName(TestData.VALID_FIRST_NAME);
        createNewAccountPage.setLastName(TestData.VALID_LAST_NAME);
        createNewAccountPage.setEmail(TestData.generateRandomEmail());
        createNewAccountPage.setPassword(TestData.INSUFFICIENT_PASSWORD);
        createNewAccountPage.setConfirmPassword(TestData.INSUFFICIENT_PASSWORD);
        createNewAccountPage.clickCreateAccountButton();

        String actualMessage = createNewAccountPage.getPasswordErrorMessage();
        Assert.assertTrue(actualMessage.contains(TestData.EXPECTED_INSUFFICIENT_PASSWORD_MESSAGE),
                "Expected password character class warning was not shown. Actual: " + actualMessage);
    }

    @Test(description = "Negative Test – Verifies that a password shorter than 8 characters triggers a length validation error.")
    public void testPasswordTooShort_Min8Characters() {
        createNewAccountPage.navigateToPage();
        createNewAccountPage.setFirstName(TestData.VALID_FIRST_NAME);
        createNewAccountPage.setLastName(TestData.VALID_LAST_NAME);
        createNewAccountPage.setEmail(TestData.generateRandomEmail());
        createNewAccountPage.setPassword(TestData.SHORT_PASSWORD);
        createNewAccountPage.setConfirmPassword(TestData.SHORT_PASSWORD);
        createNewAccountPage.clickCreateAccountButton();

        String actualMessage = createNewAccountPage.getPasswordErrorMessage();
        Assert.assertTrue(actualMessage.contains(TestData.EXPECTED_SHORT_PASSWORD_MESSAGE),
                "Expected password length warning was not shown. Actual: " + actualMessage);
    }

    @Test(description = "UI Test – Verifies that 'Create New Customer Account' page title is correct.")
    public void testCreateAccountPageTitle() {
        createNewAccountPage.navigateToPage();

        String actualTitle = createNewAccountPage.getPageTitleText();
        Assert.assertEquals(actualTitle.trim(), TestData.PAGE_TITLE_CREATE_ACCOUNT,
                "Page title is incorrect on Create Account page. Actual: " + actualTitle);
    }
}
