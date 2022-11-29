package com.github.pages.heroku;

import com.github.pages.AbstractPage;
import com.microsoft.playwright.Page;

public class SignUpPage extends AbstractPage {

    @Override
    protected String url() {
        return "https://signup.heroku.com/";
    }

    public SignUpPage(Page page) {
        super(page);
    }

}
