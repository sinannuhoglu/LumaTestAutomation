package org.example;

import org.example.pages.CreateNewAccountPage;
import org.example.pages.CustomerLoginPage;
import org.example.pages.ForgotPasswordPage;
import org.example.pages.HomePage;
import org.example.util.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected CreateNewAccountPage createNewAccountPage;
    protected CustomerLoginPage customerLoginPage;
    protected ForgotPasswordPage forgotPasswordPage;
    protected HomePage homePage;

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverFactory.createDriver(browser);
        System.out.println("Started on: " + browser);

        createNewAccountPage = new CreateNewAccountPage(driver);
        customerLoginPage = new CustomerLoginPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        homePage = new HomePage(driver);

        System.out.println("setUp finished");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

        System.out.println("Test finished");
    }
}
