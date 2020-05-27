package com.ddaypunk.dupage.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DupageApplication {

	public static void main(String[] args) {
		SpringApplication.run(DupageApplication.class, args);
	}

	@Bean
	public WebDriver getDriver() {
		// TODO: build this out to return driver specified by run config
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
}
