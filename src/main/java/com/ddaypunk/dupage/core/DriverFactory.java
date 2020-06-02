package com.ddaypunk.dupage.core;

import com.ddaypunk.dupage.core.enums.Browser;
import com.ddaypunk.dupage.core.enums.Props;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Objects;

import static com.ddaypunk.dupage.core.enums.Browser.fromName;

/**
 * Responsible for configuring and providing ready to use driver instances
 */
public class DriverFactory {
    private static final Browser BROWSER = fromName(Props.BROWSER.getValue());

    public WebDriver getConfiguredDriver() {
        return switch (Objects.requireNonNull(BROWSER)) { // Java 14: Switch expressions
            case CHROME -> getChromeDriver();
            case EDGE -> getEdgeDriver();
            case FIREFOX -> getFirefoxDriver();
            case IE -> getIEDriver();
            case OPERA -> getOperaDriver();
            case SAFARI -> getSafariDriver();
        };
    }

    private WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver getFirefoxDriver() {
        // TODO: Firefox has this weird thing in the address bar when viewing google. Can we configure against that?
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver getEdgeDriver(){
        // TODO: Browser version conflict with driver WDM gives
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private WebDriver getIEDriver() {
        // TODO: This browser only starts up, but nothing happens
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    private WebDriver getOperaDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }

    private WebDriver getSafariDriver() {
        // TODO: check for any driver configuration needed
        return new SafariDriver();
    }
}
