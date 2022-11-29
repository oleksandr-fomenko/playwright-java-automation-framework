package com.github.pages;

import com.github.factories.PageManager;
import com.microsoft.playwright.Page;

public abstract class AbstractPage {

    protected abstract String url();
    public Page page;

    public AbstractPage(Page page){
        this.page = page;
    }

    public <T extends AbstractPage> T toPage(Class<T> clazz){
        return PageManager.getPage(clazz);
    }

    public AbstractPage open(){
        page.navigate(url());
        return this;
    }
}
