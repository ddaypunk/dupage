package com.ddaypunk.dupage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DupageApplicationTests {

	@Autowired
	private WebDriver driver;

	@Test
	void contextLoads() {
		driver.get("https://google.com");
	}

}
