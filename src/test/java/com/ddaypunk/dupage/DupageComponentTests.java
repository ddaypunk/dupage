package com.ddaypunk.dupage;

import com.ddaypunk.dupage.components.Button;
import com.ddaypunk.dupage.core.DupageApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = DupageApplication.class)
public class DupageComponentTests {

    @Autowired
    private WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger("Component Tests");

    @Value("${test.host}")
    String host;

    @Test
    void testSiteWithButtonLoads() {
        // navigate to page
        LOGGER.info("Navigating to test page");
        driver.get(host);

        var button = new Button("Learn React");
        button.click();

        assertTrue(driver.getCurrentUrl().contains("playground"));

        button.click();

        assertTrue(driver.getCurrentUrl().contains("reactjs.org"));
    }
}
