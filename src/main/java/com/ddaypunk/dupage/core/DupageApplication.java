package com.ddaypunk.dupage.core;

import org.openqa.selenium.WebDriver;
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
		return new DriverFactory().getConfiguredDriver();
	}
}
