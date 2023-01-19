package com.github.pages.heroku;

import com.github.annotations.Loggable;
import com.github.dto.LoginDto;
import com.github.pages.AbstractPage;
import com.microsoft.playwright.Page;

public class LoginPage extends AbstractPage {

    private final static String EMAIL_SELECTOR = "#email";
    private final static String PASSWORD_SELECTOR = "#password";
    private final static String LOGIN_BUTTON_SELECTOR = "button[name='commit']";
    private final static String ERROR_MESSAGE_SELECTOR = "//div[@role='alert']";

    @Override
    protected String url() {
        return "https://id.heroku.com/login";
    }

    public LoginPage(Page page) {
        super(page);
    }

    @Loggable(message = "Login into the site by login=%s and password=***")
    public LoginPage login(String login, String password){
        page.fill(EMAIL_SELECTOR, login);
        page.fill(PASSWORD_SELECTOR, password);
        page.click(LOGIN_BUTTON_SELECTOR);
        return this;
    }

    @Loggable(message = "Login into the site by login data=%s")
    public LoginPage login(LoginDto loginDto){
        page.fill(EMAIL_SELECTOR, loginDto.getLogin());
        page.fill(PASSWORD_SELECTOR, loginDto.getPassword());
        page.click(LOGIN_BUTTON_SELECTOR);
        return this;
    }

    @Loggable(message = "Getting error message from login page...")
    public String getErrorMessage(){
        return page.textContent(ERROR_MESSAGE_SELECTOR);
    }
}
