package com.tutorialninja.pages;

import com.tutorialninja.base.BasePage;
import com.tutorialninja.util.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class IndexPage extends BasePage {
    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public IndexPage clickOnMyAccountMenu(){
        getWebElement(By.xpath("//a[@title = 'My Account']")).click();
        return this;
    }

    public RegisterAccountPage clickOnRegisterLink(){
        getWebElement(By.xpath("//li//a[contains(text(), 'Register')]")).click();
      return getInstance(RegisterAccountPage.class);
    }

    public ProductDetailsPage hoverOverOnDesktopMenuAndClickOnMacCategory() {
        Actions actions = new Actions(driver);
        General.elementLoadingTime();
        actions.moveToElement(getWebElement(By.xpath("//a[contains(@class, 'dropdown-toggle') and text() = 'Desktops']"))).build().perform();

        getWebElement(By.xpath("//a[text() = 'Mac (1)']")).click();

        return getInstance(ProductDetailsPage.class);
    }
}
