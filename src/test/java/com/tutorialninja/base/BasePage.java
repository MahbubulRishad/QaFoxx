package com.tutorialninja.base;

import com.aventstack.extentreports.Status;
import com.tutorialninja.report.ReportTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage extends Page {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public WebElement getWebElement(By locator) {
        WebElement webElement = null;
        try {
            waitForWebElement(locator);
            webElement = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println(locator.toString() + "Not Found");
        }

        return webElement;
    }

    @Override
    public List<WebElement> getWebElements(By locator) {
        List<WebElement> webElements = null;
        try {
            waitForWebElement(locator);
            webElements = driver.findElements(locator);
        } catch (Exception e) {
            System.out.println(locator.toString() + "Not Found");
        }

        return webElements;
    }

    @Override
    public void waitForWebElement(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println(locator.toString() + "Not found");
        }
    }

    public Select selectValueFromDropdown(WebElement locator) {
        Select select = new Select(locator);
        return select;
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void setInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.INFO, message);
        }
    }
}
