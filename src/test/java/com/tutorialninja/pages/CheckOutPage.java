package com.tutorialninja.pages;

import com.tutorialninja.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
//    scroll into Add To Cart Btn
    public boolean hasAddToCartBtnDisplayed() throws InterruptedException {

        WebElement AddToCartBtnEl = getWebElement(By.xpath("//a[text() = 'Checkout']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", AddToCartBtnEl);
            Thread.sleep(3000);
        return AddToCartBtnEl.isDisplayed();
    }
}
