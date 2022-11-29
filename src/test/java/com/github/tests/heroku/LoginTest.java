package com.github.tests.heroku;

import com.github.factories.PageManager;
import com.github.pages.heroku.LoginPage;
import com.github.tests.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {

    @Test
    public void loginTest_Negative(){
        LoginPage loginPage = PageManager.getPage(LoginPage.class);
        loginPage.open();
        String actualMessage = loginPage.login("some@test.com", "aaa").getErrorMessage();
        Assert.assertEquals(actualMessage, "There was a problem with your login.");
    }
}
