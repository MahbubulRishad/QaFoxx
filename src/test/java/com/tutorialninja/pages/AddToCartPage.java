package com.tutorialninja.pages;

import com.tutorialninja.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage extends BasePage {
    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    public AddToCartPage fillProductQuantity(int quantity){
        getWebElement(By.xpath("//label[text() = 'Qty']/following-sibling::input[@id = 'input-quantity']")).clear();
        getWebElement(By.xpath("//label[text() = 'Qty']/following-sibling::input[@id = 'input-quantity']")).sendKeys(String.valueOf(quantity));
        return this;
    }

    public AddToCartPage clickOnAddToCartBtn(){
        getWebElement(By.xpath("//label[text() = 'Qty']/following-sibling::button[@id = 'button-cart']")).click();
        return this;
    }

    public CheckOutPage clickOnShoppingCartLink(){
        getWebElement(By.xpath("//a[text() = 'iMac']/following-sibling::a[text() = 'shopping cart']")).click();
        return getInstance(CheckOutPage.class);
    }

}
