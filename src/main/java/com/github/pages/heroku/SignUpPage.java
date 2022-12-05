package com.github.pages.heroku;

import com.github.pages.AbstractPage;
import com.microsoft.playwright.Page;

public class SignUpPage extends AbstractPage {

    private final static String FIRST_NAME_SELECTOR = "#first_name";
    private final static String LAST_NAME_SELECTOR = "#last_name";
    private final static String EMAIL_ADDRESS_SELECTOR = "#email";
    private final static String ROLE_SELECTOR = "#role";
    private final static String COUNTRY_REGION_SELECTOR = "#self_declared_country";
    private final static String MAIN_PROGRAMMING_LANGUAGE_SELECTOR = "#main_programming_language";
    private final static String CREATE_ACCOUNT_BUTTON_SELECTOR = "//input[@name='commit']";

    public SignUpPage(Page page) {
        super(page);
    }

    @Override
    protected String url() {
        return "https://signup.heroku.com/";
    }

    public SignUpPage setFirstName(String firstName) {
        page.fill(FIRST_NAME_SELECTOR, firstName);
        return this;
    }

    public SignUpPage setLastName(String lastName) {
        page.fill(LAST_NAME_SELECTOR, lastName);
        return this;
    }

    public SignUpPage setEmailAddress(String emailAddress) {
        page.fill(EMAIL_ADDRESS_SELECTOR, emailAddress);
        return this;
    }

    public SignUpPage selectRole(String role) {
        page.selectOption(ROLE_SELECTOR, role);
        return this;
    }

    public SignUpPage selectCountryRegion(String country) {
        page.selectOption(COUNTRY_REGION_SELECTOR, country);
        return this;
    }

    public SignUpPage selectMainProgrammingLanguage(String mainProgrammingLanguage) {
        page.selectOption(MAIN_PROGRAMMING_LANGUAGE_SELECTOR, mainProgrammingLanguage);
        return this;
    }

    public SignUpPage clickOnCreateAccountButton() {
        page.click(CREATE_ACCOUNT_BUTTON_SELECTOR);
        return this;
    }

}
