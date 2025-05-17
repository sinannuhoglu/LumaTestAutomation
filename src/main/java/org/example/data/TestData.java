package org.example.data;

import java.util.UUID;

public class TestData {
    public static final String VALID_FIRST_NAME = "Sinan";
    public static final String VALID_LAST_NAME = "Nuhoğlu";
    public static final String VALID_LOGIN_EMAIL = "sinan.nuhoglu@hotmail.com";
    public static final String VALID_PASSWORD = "Admin12345";

    public static final String INVALID_EMAIL = "sinan.nuhoglu@hotmail";
    public static final String MISMATCHED_PASSWORD = "Admin321!";
    public static final String INSUFFICIENT_PASSWORD = "ABC12345"; // only uppercase and digits
    public static final String SHORT_PASSWORD = "Ab12";
    public static final String INVALID_PASSWORD = "wrongpassword123";

    public static final String EXPECTED_SUCCESS_MESSAGE = "Thank you for registering";
    public static final String EXPECTED_REQUIRED_FIELD_MESSAGE = "This is a required field.";
    public static final String EXPECTED_INVALID_EMAIL_MESSAGE = "Please enter a valid email address";
    public static final String EXPECTED_MISMATCHED_PASSWORD_MESSAGE = "Please enter the same value again.";
    public static final String EXPECTED_INSUFFICIENT_PASSWORD_MESSAGE = "Minimum of different classes of characters in password is 3";
    public static final String EXPECTED_SHORT_PASSWORD_MESSAGE = "Minimum length of this field must be equal or greater than 8 symbols";
    public static final String EXPECTED_LOGIN_REQUIRED_FIELD_MESSAGE = "A login and a password are required.";
    public static final String EXPECTED_INCORRECT_LOGIN_MESSAGE = "The account sign-in was incorrect";
    public static final String EXPECTED_FORGOT_PASSWORD_SUCCESS_MESSAGE = "If there is an account associated with";
    public static final String EXPECTED_ACCOUNT_DISABLED_MESSAGE = "The account sign-in was incorrect or your account is disabled temporarily.";

    public static final String PAGE_TITLE_MY_ACCOUNT = "My Account";
    public static final String PAGE_TITLE_CREATE_ACCOUNT = "Create New Customer Account";
    public static final String PAGE_TITLE_CUSTOMER_LOGIN = "Customer Login";
    public static final String PAGE_TITLE_FORGOT_PASSWORD = "Forgot Your Password?";
    public static final String PAGE_TITLE_HOME = "Home Page";

    public static final String SEARCH_RESULT_URL_KEYWORD = "search";
    public static final String SEARCH_KEYWORD = "bag";

    public static final String BASE_DOMAIN = "magento.softwaretestingboard.com";

    public static String generateRandomEmail() {
        return "testuser_" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
    }
}
