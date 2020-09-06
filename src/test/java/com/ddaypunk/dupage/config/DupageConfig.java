package com.ddaypunk.dupage.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("application.properties")
@ComponentScan(basePackages = "com.ddaypunk.dupage")
public class DupageConfig {
    @Bean
    @Lazy
    public ChromeDriver chromeDriver(DesiredCapabilities desiredCapabilities) {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(desiredCapabilities);
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
