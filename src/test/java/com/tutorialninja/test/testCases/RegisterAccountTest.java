package com.tutorialninja.test.testCases;

import com.tutorialninja.pages.AccountSuccessPage;
import com.tutorialninja.pages.IndexPage;
import com.tutorialninja.test.base.BaseTest;
import com.tutorialninja.util.General;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterAccountTest extends BaseTest {
    @Test (dataProvider = "getData")
    public void verifyRegistrationShouldBeSuccessful(String fname, String lname, String email, String tel, String pw, String cpw, String subLetter){

        AccountSuccessPage accountSuccessPage = page.getInstance(IndexPage.class)
                .clickOnMyAccountMenu()
                .clickOnRegisterLink()
                .fillFirstName(fname)
                .fillLastName(lname)
                .fillEmail(lorem.getEmail())
                .fillTelephoneNo(tel.replaceAll(".0", "").trim())
                .fillPassword(pw)
                .fillConfirmPassword(cpw)
                .selectNewsletterSubscribe(subLetter)
                .clickOnPrivacyPolicyCheckBox()
                .clickOnContinueBtn();

        Assert.assertTrue(accountSuccessPage.hasSuccessMessageDisplayed());
    }

    @DataProvider
    public Object[][] getData(){
        return General.getTestData("Sheet1");
    }

}
