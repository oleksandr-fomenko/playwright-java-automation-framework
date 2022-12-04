package com.github.tests.heroku;

import com.github.factories.PageManager;
import com.github.pages.heroku.SignUpPage;
import com.github.tests.AbstractTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends AbstractTest {

    private static final String FIRST_NAME = RandomStringUtils.randomAlphabetic(7);
    private static final String LAST_NAME = RandomStringUtils.randomAlphabetic(4, 10);
    private static final String EMAIL_ADDRESS = RandomStringUtils.randomAlphabetic(5, 12) + "@gmail.com";
    private static final String ROLE = "other";
    private static final String COUNTRY = "Ukraine";
    private static final String MAIN_PROGRAMMING_LANGUAGE = "java";

    @Test
    public void signUpTest() {
        SignUpPage signUpPage = PageManager.getPage(SignUpPage.class);
        signUpPage.open();
        signUpPage
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmailAddress(EMAIL_ADDRESS)
                .selectRole(ROLE)
                .selectCountryRegion(COUNTRY)
                .selectMainProgrammingLanguage(MAIN_PROGRAMMING_LANGUAGE)
                .clickOnCreateAccountButton();
        String actualMessage = signUpPage.getErrorMessage();
        Assert.assertEquals(actualMessage, "\n" +
                "    We could not verify you are not a robot. Please try the CAPTCHA again.\n" +
                "  ");

    }
}
