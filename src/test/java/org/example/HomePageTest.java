package org.example;

import org.example.data.TestData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class HomePageTest extends BaseTest {

    @Test(description = "UI Test – Verifies that homepage loads successfully and title is correct")
    public void testHomePageTitle() {
        homePage.navigateToHomePage();

        String actualTitle = homePage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(TestData.PAGE_TITLE_HOME),
                "Homepage title is incorrect. Actual: " + actualTitle);
    }

    @Test(description = "UI + Positive Test – Verifies that the LUMA logo image is visible and clickable")
    public void testLogoVisibilityAndClick() {
        homePage.navigateToHomePage();

        Assert.assertTrue(homePage.isLogoImageVisible(), "LUMA logo image is not visible");
        homePage.clickLogo();

        String currentUrl = homePage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(TestData.BASE_DOMAIN),
                "Clicking the logo did not navigate to the homepage");
    }

    @Test(description = "Positive Test – Verifies that the search bar works and returns results")
    public void testSearchFunctionality() {
        homePage.navigateToHomePage();
        homePage.searchFor(TestData.SEARCH_KEYWORD);
        homePage.waitForSearchResults();

        String currentUrl = homePage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(TestData.SEARCH_RESULT_URL_KEYWORD) ||
                        homePage.getPageTitle().toLowerCase().contains(TestData.SEARCH_RESULT_URL_KEYWORD),
                "Search result page was not loaded");
    }
}
