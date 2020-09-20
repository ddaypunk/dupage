package com.ddaypunk.dupage.aut.models.implementations.web;

import com.ddaypunk.dupage.aut.components.Button;
import com.ddaypunk.dupage.aut.models.PlaygroundHome;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertTrue;

@Component
@Profile("web")
public class WebPlaygroundHome implements PlaygroundHome {

    @Value("${app.test.host}")
    private String host;

    @Autowired
    private final WebDriver webDriver;

    @Autowired
    public WebPlaygroundHome(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void load() {
        webDriver.get(host);
        urlIsCorrect();
    }

    private void urlIsCorrect() {
        assertTrue(webDriver.getCurrentUrl().contains("gentle-beyond"));
    }

    public void clickLearnReact() {
        var button = new Button("Learn React");
        button.click();
    }
}
