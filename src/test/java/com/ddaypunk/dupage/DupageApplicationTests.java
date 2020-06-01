package com.ddaypunk.dupage;

import com.ddaypunk.dupage.core.DupageApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = DupageApplication.class)
class DupageApplicationTests {

	@Autowired
	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger("test");

	@Test
	void contextLoads() {
		var url = "https://google.com"; // Java 10: Local type inference

		// navigate to page
		LOGGER.info("Navigating to test page");
		driver.get(url);

		// Find search input and utilize it
		LOGGER.info("Getting search input and entering search query");
		var googleSearchInput = driver.findElement(By.cssSelector("[title='Search']"));
		googleSearchInput.sendKeys("Star Wars");
		googleSearchInput.sendKeys(Keys.RETURN);

		// TODO: Extract this to wrapper class
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));

		// assert we are on the search view
		LOGGER.info("Checking for results page...");
		assertTrue(driver.getCurrentUrl().contains("search")
				&& driver.getCurrentUrl().contains("Star+Wars"));
		LOGGER.info("Results page found!!!");
	}

}
