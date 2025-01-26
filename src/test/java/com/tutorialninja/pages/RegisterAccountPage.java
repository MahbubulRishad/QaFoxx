package com.tutorialninja.pages;

import com.tutorialninja.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAccountPage extends BasePage {
    public RegisterAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasRegisterAccountTextDisplayed() {
        return getWebElements(By.xpath("//div[@id = 'content']/h1[text() = 'Register Account']")).size() > 0;
    }

    public RegisterAccountPage fillFirstName(String firstname) {
        getWebElement(By.xpath("//label[text() = 'First Name']/following-sibling::div/input[@id = 'input-firstname']")).sendKeys(firstname);
        return this;
    }

    public RegisterAccountPage fillLastName(String lastname) {
        getWebElement(By.xpath("//label[text() = 'Last Name']/following-sibling::div/input[@id = 'input-lastname']")).sendKeys(lastname);
        return this;
    }

    public RegisterAccountPage fillEmail(String email) {
        getWebElement(By.xpath("//label[text() = 'E-Mail']/following-sibling::div/input[@id = 'input-email']")).sendKeys(email);
        return this;
    }

    public RegisterAccountPage fillTelephoneNo(String telephoneNo) {
        getWebElement(By.xpath("//label[text() = 'Telephone']/following-sibling::div/input[@id = 'input-telephone']")).sendKeys(telephoneNo);
        return this;
    }

    public RegisterAccountPage fillPassword(String password) {
        getWebElement(By.xpath("//label[text() = 'Password']/following-sibling::div/input[@id = 'input-password']")).sendKeys(password);
        return this;
    }

    public RegisterAccountPage fillConfirmPassword(String confirmPassword) {
        getWebElement(By.xpath("//label[text() = 'Password Confirm']/following-sibling::div/input[@id = 'input-confirm']")).sendKeys(confirmPassword);
        return this;
    }

    public RegisterAccountPage clickOnSubscribeYesRadioBtn() {
        getWebElement(By.xpath("(//label[contains(text(), 'Subscribe')]/following-sibling::div/label/input)[1]")).click();
        return this;
    }


    public RegisterAccountPage clickOnSubscribeNoRadioBtn() {
        getWebElement(By.xpath("(//label[contains(text(), 'Subscribe')]/following-sibling::div/label/input)[2]")).click();
        return this;
    }

    public RegisterAccountPage selectNewsletterSubscribe(String subscription) {

        if (subscription.equalsIgnoreCase("yes")){
            clickOnSubscribeYesRadioBtn();
        } else {
            clickOnSubscribeNoRadioBtn();
        }

            return this;
    }


    public RegisterAccountPage clickOnPrivacyPolicyCheckBox() {
        getWebElement(By.xpath("//a[@class = 'agree']/following-sibling::input[@type='checkbox']")).click();
        return this;
    }

    public AccountSuccessPage clickOnContinueBtn() {
        getWebElement(By.xpath("//a[@class = 'agree']/following-sibling::input[@value='Continue']")).click();
        return getInstance(AccountSuccessPage.class);
    }
}
