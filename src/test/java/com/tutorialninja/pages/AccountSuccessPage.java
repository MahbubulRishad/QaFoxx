package com.tutorialninja.pages;

import com.tutorialninja.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSuccessPage extends BasePage {
    public AccountSuccessPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasSuccessMessageDisplayed() {
        return getWebElements(By.xpath("//h1[contains(text(), 'Your Account Has Been Created!')]")).size() > 0;
    }
}
