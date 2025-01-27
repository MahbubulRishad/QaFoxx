package com.tutorialninja.test.testCases;

import com.tutorialninja.pages.CheckOutPage;
import com.tutorialninja.pages.IndexPage;
import com.tutorialninja.test.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {

    @Test
    public void verifyGuestUserSuccessfullyPlaceAnOrder() {
        CheckOutPage checkOutPage = page.getInstance(IndexPage.class)
                .hoverOverOnDesktopMenuAndClickOnMacCategory()
                .clickOnIMacProductDetails()
                .fillProductQuantity(2)
                .clickOnAddToCartBtn()
                .clickOnShoppingCartLink()
                .fillUseCouponCode("ABCD")
                .estimateShippingAndTaxes(3, 2, 2100)
                .useGiftCertificate("abcx")
                .clickOnCheckOutBtn();

        Assert.assertTrue(checkOutPage.hasErrorMessageIsDisplayed());

    }

}
