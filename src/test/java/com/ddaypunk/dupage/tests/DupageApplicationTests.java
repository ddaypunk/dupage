package com.ddaypunk.dupage.tests;

import com.ddaypunk.dupage.DupageConfig;
import com.ddaypunk.dupage.views.interfaces.GoogleHome;
import com.ddaypunk.dupage.views.interfaces.GoogleResults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DupageConfig.class)
class DupageApplicationTests extends BaseTest {

	@Autowired
	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger("App Tests");

	@Value("${test.host:https://google.com}")
	String host;

	@Test
	@Autowired
	void contextLoads(GoogleHome home, GoogleResults result) {
		// navigate to page
		LOGGER.info("Navigating to test page");
		home.load();
		home.searchFor("Star Wars");
		assertTrue(result.getFirstResultTitle().contains("Star Wars"));

		// Find search input and utilize it
//		LOGGER.info("Getting search input and entering search query");
//		var googleSearchInput = driver.findElement(By.cssSelector("[title='Search']"));
//		googleSearchInput.sendKeys("Star Wars");
//		googleSearchInput.sendKeys(Keys.RETURN);

		// TODO: Extract this to wrapper class
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));

		// assert we are on the search view
//		LOGGER.info("Checking for results page...");
//		assertTrue(driver.getCurrentUrl().contains("search")
//				&& driver.getCurrentUrl().contains("Star+Wars"));
//		LOGGER.info("Results page found!!!");
	}

}
