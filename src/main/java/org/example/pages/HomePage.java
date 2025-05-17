package org.example.pages;

import io.qameta.allure.Step;
import org.example.base.BasePage;
import org.example.data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private WebDriver driver;

    private By logo = By.cssSelector("a.logo");
    private By searchBox = By.id("search");
    private By logoImage = By.cssSelector("a.logo img");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void waitForSearchResults() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(TestData.SEARCH_RESULT_URL_KEYWORD));
    }

    @Step("Navigate to home page")
    public void navigateToHomePage() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Step("Get the page title")
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Step("Check if logo image is visible")
    public boolean isLogoImageVisible() {
        return find(logoImage).isDisplayed();
    }

    @Step("Click on logo")
    public void clickLogo() {
        click(logo);
    }

    @Step("Search for keyword: {0}")
    public void searchFor(String keyword) {
        type(searchBox, keyword);
        submit(searchBox);
    }

    @Step("Get current URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
