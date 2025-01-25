package com.tutorialninja.pages;

import com.tutorialninja.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
