package com.github.tests;

import com.github.factories.PlaywrightManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {

    @BeforeMethod
    public void beforeMethod(){
        PlaywrightManager.getInstance()
                .init("chromium");
    }

    @AfterMethod
    public void afterMethod(){
        PlaywrightManager.getInstance().clear();
    }
}
