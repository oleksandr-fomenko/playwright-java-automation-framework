package com.github.pages.heroku;

import com.github.pages.AbstractPage;
import com.microsoft.playwright.Page;

public class LoginPage extends AbstractPage {

    private final static String EMAIL_SELECTOR = "#email";
    private final static String PASSWORD_SELECTOR = "#password";
    private final static String LOGIN_BUTTON_SELECTOR = "button[name='commit']";

    public LoginPage(Page page) {
        super(page);
    }

    @Override
    protected String url() {
        return "https://id.heroku.com/login";
    }

    public LoginPage login(String login, String password) {
        page.fill(EMAIL_SELECTOR, login);
        page.fill(PASSWORD_SELECTOR, password);
        page.click(LOGIN_BUTTON_SELECTOR);
        return this;
    }
}
