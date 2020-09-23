package com.ddaypunk.dupage.tests;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseTest {
    @Autowired
    WebDriver webDriver;

    @After
    public void close() {
        webDriver.quit();
    }
}
