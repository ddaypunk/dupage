package com.ddaypunk.dupage.browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChromeDriverManager extends DriverManager{
    // Moved to simpler bean in DupageConfig for now
    // Thank you to https://stackoverflow.com/questions/43935784/spring-dependency-integration-with-selenium

    @Autowired
    private DesiredCapabilities caps;

    @Autowired
    private ChromeOptions opts;

    @Autowired
    private BeanFactory factory;

    @Override
    protected void initializeDriver() {
        caps = DesiredCapabilities.chrome();
        opts.addArguments("test-type");
        opts.addArguments("--disable-extensions");
        opts.addArguments("-incognito");
        opts.setAcceptInsecureCerts(true);
        opts.addArguments("--allow-insecure-localhost");
        caps.setCapability(ChromeOptions.CAPABILITY, opts);

        driver = factory.getBean(ChromeDriver.class, caps);
    }
}
