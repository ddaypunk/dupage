package com.ddaypunk.dupage.aut.models.implementations.web;

import com.ddaypunk.dupage.aut.models.GoogleHome;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("web")
public class WebGoogleHome implements GoogleHome {
    @Value("${app.test.host}")
    private String host;

    private final WebDriver driver;

    @Autowired
    public WebGoogleHome(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void load() {
        driver.get(host);
    }

    @Override
    public void searchFor(String query) {
        var googleSearchInput = driver.findElement(By.cssSelector("[title='Search']"));
		googleSearchInput.sendKeys(query);
		googleSearchInput.sendKeys(Keys.RETURN);
    }
}
