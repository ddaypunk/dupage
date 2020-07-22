package com.ddaypunk.dupage.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;

/**
 * Browser related functionality
 */
public class Browser {

    @Autowired
    private WebDriver driver;

    public void close() {
        try {
            driver.quit();
            driver = null;
        } catch(UnreachableBrowserException e) {
            // ignore for now
        }
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void goTo(String url) { driver.get(url); }

    public void goTo(URL url) { driver.get(url.getPath()); }

    public void focusIFrame(WebElement frame) {
        driver.switchTo().frame(frame);
    }

    public void focusDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void focusWindow(String window){ driver.switchTo().window(window); }

    private class Cleanup implements Runnable {
        public void run() {
            close();
        }
    }

}
