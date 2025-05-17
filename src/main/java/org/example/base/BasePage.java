package org.example.base;

import org.openqa.selenium.By;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void type(By locator, String text)  {
        find(locator).sendKeys(text);
    }

    public WebElement waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilPageStabilizes() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void submit(By locator) {
        find(locator).submit();
    }

    @Attachment(value = "{screenshotName}", type = "image/png")
    public byte[] attachScreenshot(String screenshotName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
