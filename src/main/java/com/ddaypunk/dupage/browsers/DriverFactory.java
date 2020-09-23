package com.ddaypunk.dupage.browsers;

import com.ddaypunk.dupage.core.enums.Props;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.ddaypunk.dupage.browsers.Browser.fromName;

/**
 * Responsible for configuring and providing ready to use driver instances
 */
@Component
public class DriverFactory {
    @Value("${browser.desktop.width}")
    private int desktopWidth;

    @Value("${browser.desktop.height}")
    private int desktopHeight;

    private static final Browser BROWSER = fromName(Props.BROWSER.getValue());

    @Autowired
    private WebDriver chromeDriver;

    // Moved to simpler bean in DupageConfig for now
//    @Bean
//    @Profile("web")
//    public WebDriver getDriver() {
//        WebDriver driver;
//        Browser browser = Objects.requireNonNull(fromName(Props.BROWSER.getValue()));
//        switch (browser) { // Java 14: Switch expressions
//            case CHROME -> driver = chromeDriver;
//            default -> driver = null;
////            case EDGE -> getEdgeDriver();
////            case FIREFOX -> getFirefoxDriver();
////            case IE -> getIEDriver();
////            case OPERA -> getOperaDriver();
////            case SAFARI -> getSafariDriver();
//        }
//
//        driver.manage().window().setSize(new Dimension(desktopWidth, desktopHeight));
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        return driver;
//    }

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
