package com.ddaypunk.dupage.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("application.properties")
@ComponentScan(basePackages = "com.ddaypunk.dupage")
public class DupageConfig {
    @Autowired
    private ChromeOptions opts;

    @Bean
    @Lazy
    public ChromeDriver chromeDriver(DesiredCapabilities desiredCapabilities) {
        WebDriverManager.chromedriver().setup();
        opts.addArguments("test-type");
        opts.addArguments("--disable-extensions");
        opts.addArguments("-incognito");
        opts.setAcceptInsecureCerts(true);
        opts.addArguments("--allow-insecure-localhost");
        return new ChromeDriver(opts);
    }

    @Bean
    public DesiredCapabilities desiredCapabilities() {
        return new DesiredCapabilities();
    }

    @Bean
    public ChromeOptions chromeOptions() {
        return new ChromeOptions();
    }
}
