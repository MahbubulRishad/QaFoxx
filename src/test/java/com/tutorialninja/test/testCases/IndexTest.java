package com.tutorialninja.test.testCases;

import com.tutorialninja.pages.IndexPage;
import com.tutorialninja.pages.RegisterAccountPage;
import com.tutorialninja.test.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IndexTest extends BaseTest {

    @Test
    public void verifyRegisterFormIsDisplayed(){
        RegisterAccountPage registerAccountPage = page.getInstance(IndexPage.class)
                .clickOnMyAccountMenu()
                .clickOnRegisterLink();

        Assert.assertTrue(registerAccountPage.hasRegisterAccountTextDisplayed());

    }

}
