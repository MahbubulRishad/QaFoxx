package com.tutorialninja.pages;

import com.tutorialninja.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public AddToCartPage clickOnIMacProductDetails(){
        getWebElement(By.xpath("//h4//a[contains(text(), 'iMac')]")).click();
        return getInstance(AddToCartPage.class);
    }
}
