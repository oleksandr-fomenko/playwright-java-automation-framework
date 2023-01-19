package com.github.factories;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.function.Supplier;

public class PlaywrightManager {
    private static PlaywrightManager instance;
    private final ThreadLocal<Playwright> threadLocalPlaywright = new ThreadLocal<>();
    private final ThreadLocal<Browser> threadLocalBrowser = new ThreadLocal<>();

    private PlaywrightManager() {
    }

    public static PlaywrightManager getInstance() {
        if (instance == null) {
            synchronized (PlaywrightManager.class) {
                if (instance == null) {
                    instance = new PlaywrightManager();
                }
            }
        }
        return instance;
    }

    public synchronized void init(String browserName){
        Playwright playwright = Playwright.create();
        Browser browser = getBrowser(playwright, browserName).get();
        threadLocalPlaywright.set(playwright);
        threadLocalBrowser.set(browser);
    }

    public Playwright getPlaywright(){
        return threadLocalPlaywright.get();
    }

    public Browser getBrowser(){
        return threadLocalBrowser.get();
    }

    public synchronized void clear(){
        threadLocalBrowser.get().close();
        threadLocalPlaywright.get().close();
        threadLocalBrowser.remove();
        threadLocalPlaywright.remove();
    }

    private Supplier<Browser> getBrowser(Playwright playwright, String browserName) {
        return switch (browserName) {
            case "chromium" -> () -> playwright.chromium().launch(getCommonLaunchOptions());
            case "webkit" -> () -> playwright.webkit().launch(getCommonLaunchOptions());
            case "firefox" -> () -> playwright.firefox().launch(getCommonLaunchOptions());
            default -> throw new IllegalArgumentException(browserName);
        };
    }

    private BrowserType.LaunchOptions getCommonLaunchOptions(){
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        return new BrowserType.LaunchOptions()
                .setHeadless(isHeadless);
    }

}
