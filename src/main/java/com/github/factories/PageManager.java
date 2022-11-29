package com.github.factories;

import com.github.pages.AbstractPage;
import com.microsoft.playwright.Page;

public class PageManager {

    public static Page newPage(){
        return PlaywrightManager.getInstance().getBrowser().newPage();
    }

    public static <T extends AbstractPage> T getPage(Class<T> clazz){
        try {
            return clazz.getConstructor(Page.class).newInstance(newPage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
