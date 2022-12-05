package com.github.pages;

import com.github.factories.PageManager;
import com.microsoft.playwright.Page;

public abstract class AbstractPage {

    private final static String ERROR_MESSAGE_SELECTOR = "//*[@role='alert']";
    public Page page;

    public AbstractPage(Page page) {
        this.page = page;
    }

    protected abstract String url();

    public <T extends AbstractPage> T toPage(Class<T> clazz) {
        return PageManager.getPage(clazz);
    }

    public AbstractPage open() {
        page.navigate(url());
        return this;
    }

    public String getErrorMessage() {
        return page.textContent(ERROR_MESSAGE_SELECTOR);
    }
}
