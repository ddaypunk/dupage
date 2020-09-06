package com.ddaypunk.dupage.browsers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void initializeDriver();

    public void quitDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}
