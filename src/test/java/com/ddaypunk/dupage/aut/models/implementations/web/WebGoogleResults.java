package com.ddaypunk.dupage.aut.models.implementations.web;

import com.ddaypunk.dupage.aut.models.GoogleResults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertTrue;

@Component
@Profile("web")
public class WebGoogleResults implements GoogleResults {

    @Autowired
    private final WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger("Google Results");


    @Autowired
    WebGoogleResults(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public String getFirstResultTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));

        // assert we are on the search view
		LOGGER.info("Checking for results page...");
		assertTrue(driver.getCurrentUrl().contains("search"));
		LOGGER.info("Results page found!!!");

		return driver.findElement(By.cssSelector("ol#b_results > li > h2 > a")).getText();
    }
}
