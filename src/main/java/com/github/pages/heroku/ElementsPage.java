package com.github.pages.heroku;

import com.github.pages.AbstractPage;
import com.microsoft.playwright.Page;

public class ElementsPage extends AbstractPage {

    @Override
    protected String url() {
        return "https://elements.heroku.com/";
    }

    public ElementsPage(Page page) {
        super(page);
    }

}
