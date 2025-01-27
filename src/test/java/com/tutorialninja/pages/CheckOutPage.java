package com.tutorialninja.pages;

import com.tutorialninja.base.BasePage;
import com.tutorialninja.util.General;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage clickOnCheckOutBtn() {
        getWebElement(By.xpath("//a[text() = 'Checkout']")).click();
        return this;
    }

    public CheckOutPage fillUseCouponCode(String couponCode) {
        WebElement expandCouponCode = getWebElement(By.xpath("(//a[text() ='Use Coupon Code ' ]//following::i[@class = 'fa fa-caret-down'])[1]"));

//        scrollToElement(expandCouponCode);
        expandCouponCode.click();

        getWebElement(By.xpath("//label[text() = 'Enter your coupon here']/following-sibling::div/input[@id = 'input-coupon']")).sendKeys(couponCode);

        return this;
    }

    public CheckOutPage estimateShippingAndTaxes(int countryIndex, int regionIndex, int postalCode) {
        WebElement expandEstimateShippingAndTaxes = getWebElement(By.xpath("//a[contains(text(), 'Estimate Shipping')]"));
        WebElement scrollToContinueBtn = getWebElement(By.xpath("//a[normalize-space() = 'Continue Shopping']"));

        scrollToElement(scrollToContinueBtn);
        General.elementLoadingTime();

        expandEstimateShippingAndTaxes.click();
        System.out.println("clicked on taxes expand");

        Select selectCountry = selectValueFromDropdown(getWebElement(By.xpath("//label[text() = 'Country']//following-sibling::div/select[@id = 'input-country']")));
        selectCountry.selectByIndex(countryIndex);

        Select region = selectValueFromDropdown(getWebElement(By.xpath("//label[text() = 'Region / State']//following-sibling::div/select[@id = 'input-zone']")));
        region.selectByIndex(regionIndex);

        getWebElement(By.xpath("//label[text() = 'Post Code']//following-sibling::div/input[@id = 'input-postcode']")).sendKeys(String.valueOf(postalCode));

        return this;
    }

    public CheckOutPage useGiftCertificate(String giftCode) {

        WebElement expandUseGiftCertificate = getWebElement(By.xpath("//a[normalize-space() = 'Use Gift Certificate']"));
        expandUseGiftCertificate.click();

        getWebElement(By.xpath("//label[contains(text(), 'Enter your gift certificate')]/following-sibling::div/input[@id = 'input-voucher']")).sendKeys(giftCode);

        return this;
    }

    public boolean hasErrorMessageIsDisplayed() {
        return getWebElements(By.xpath("//ul[@class = 'breadcrumb']/following-sibling::div[contains(@class, 'alert-danger')]")).size() > 0;
    }
}
