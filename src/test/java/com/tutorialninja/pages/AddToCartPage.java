package com.tutorialninja.pages;

import com.tutorialninja.base.BasePage;
import com.tutorialninja.util.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
//        getWebElement(By.xpath("//label[text() = 'Qty']/following-sibling::button[@id = 'button-cart']")).click();
        getWebElement(By.xpath("(//button[normalize-space() = 'Add to Cart'])[1]")).click();
        General.elementLoadingTime();
        System.out.println("Add to cart is clicked");
        return this;
    }

    public CheckOutPage clickOnShoppingCartLink(){
//        WebElement shoppingCartLink = getWebElement(By.xpath("//a[text() = 'iMac']/following-sibling::a[text() = 'shopping cart']"));
        WebElement shoppingCartLink = getWebElement(By.xpath("//a//span[text() = 'Shopping Cart']"));
//        scrollToElement(shoppingCartLink);
        shoppingCartLink.click();
        return getInstance(CheckOutPage.class);
    }

}
