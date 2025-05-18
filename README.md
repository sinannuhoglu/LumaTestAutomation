
# LumaTestAutomation

A TestNG-Selenium based automated test framework for testing [Magento Luma Demo Store](https://magento.softwaretestingboard.com) functionalities like User Registration, Login, Forgot Password, Homepage UI, and Search features.  

Enhanced with Allure reporting, WebDriverManager, and designed for cross-browser testing using TestNG XML suites.


---

## Project Structure

```
src
├── main
│   └── java
│       └── org.example
│           ├── base              # BasePage logic (e.g., wait, click, find, type, screenshot)
│           ├── data              # Centralized Test Data
│           ├── pages             # Page Object Model (POM) classes
│           └── util              # DriverFactory and constants
├── test
│   └── java
│       └── org.example
│           ├── CreateNewAccountTest
│           ├── CustomerLoginTest
│           ├── ForgotPasswordTest
│           └── HomePageTest
```

---

## Features

- TestNG-based structured test cases
- Page Object Model (POM) for clean maintainability
- Cross-browser testing support (Chrome, Firefox, Edge)
- Rich Allure Reports with attached screenshots on failure
- Dynamic data generation (UUID-based random emails)
- TestNG parallel suite execution
- Maven integration for build and dependency management
- Uses WebDriverManager (auto driver setup)

---

## Technologies Used and Their Purpose

| Technology              | Purpose                                                     |
|------------------------|-------------------------------------------------------------|
| **Java 17+**            | Core programming language                                   |
| **Selenium WebDriver** | UI automation testing                                       |
| **TestNG**             | Testing framework and parallel test execution               |
| **Allure Reports**     | Rich test reporting and screenshots                         |
| **WebDriverManager**   | Automatic driver binaries setup                             |
| **AspectJ**            | Needed for Allure step logging via annotations              |
| **Maven**              | Build automation and dependency management                  |

---

## Test Coverage

| Test Class                | Covered Scenarios                                                                 |
|--------------------------|------------------------------------------------------------------------------------|
| `CreateNewAccountTest`   | Valid & invalid registration, field validations, success messages, page title     |
| `CustomerLoginTest`      | Login with valid/invalid credentials, required field errors, redirection testing  |
| `ForgotPasswordTest`     | Reset password with valid email, page title verification                         |
| `HomePageTest`           | Homepage title, logo visibility, search bar behavior                             |

---

## Allure Report Screenshots

### 1. **Overview of Test Execution**

![Image](https://github.com/user-attachments/assets/de1ed63d-5bf0-45a4-b2c6-ffa7454c8819)

### 2. **Test Suite Breakdown**

![Image](https://github.com/user-attachments/assets/3be80289-11b7-4d47-87e2-3d85e5247362)

![Image](https://github.com/user-attachments/assets/f2011d9a-bee1-4e7b-ba5e-9c4ce5bcc572)

### 3. **Tests Execution Timeline**

![Image](https://github.com/user-attachments/assets/e65daaad-c98e-4d0e-8309-113271335491)

### 4. **Test Result Summary by Category**

![Image](https://github.com/user-attachments/assets/3dbd65b2-0378-4d5f-ac9d-eaf8c1ea16ea)
