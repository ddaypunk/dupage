package com.ddaypunk.dupage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DupageApplicationTests {

	@Autowired
	private WebDriver driver;

	@Test
	void contextLoads() {
		var url = "https://google.com"; // Java 10: Local type inference

		driver.get(url);
		var googleSearchInput = driver.findElement(By.cssSelector("[title='Search']"));
		googleSearchInput.sendKeys("Star Wars");
		googleSearchInput.sendKeys(Keys.RETURN);

		assertTrue(driver.getCurrentUrl().contains("search"));
	}

}
