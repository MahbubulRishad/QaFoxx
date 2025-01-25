package com.tutorialninja.test.testCases;

import com.tutorialninja.pages.AccountSuccessPage;
import com.tutorialninja.pages.IndexPage;
import com.tutorialninja.test.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterAccountPage extends BaseTest {
    @Test
    public void verifyRegistrationShouldBeSuccessful(){

        AccountSuccessPage accountSuccessPage = page.getInstance(IndexPage.class)
                .clickOnMyAccountMenu()
                .clickOnRegisterLink()
                .fillFirstName(lorem.getFirstName())
                .fillLastName(lorem.getLastName())
                .fillEmail(lorem.getEmail())
                .fillTelephoneNo(String.valueOf(lorem.getPhone()))
                .fillPassword("12345")
                .fillConfirmPassword("12345")
                .clickOnSubscribeYesRadioBtn()
                .clickOnPrivacyPolicyCheckBox()
                .clickOnContinueBtn();

        Assert.assertTrue(accountSuccessPage.hasSuccessMessageDisplayed());
    }

}
