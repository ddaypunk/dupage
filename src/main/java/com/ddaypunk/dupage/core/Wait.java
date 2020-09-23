package com.ddaypunk.dupage.core;

import com.ddaypunk.dupage.core.enums.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class Wait {
    @Autowired
    private WebDriver webDriver;

    private Condition condition;
    private By selector;
    private Duration duration;


    public static final class Builder {
        @Autowired
        private WebDriver webDriver;
        private Condition condition;
        private By selector;
        private Duration duration;

        public Builder with(WebDriver driver) {
            this.webDriver = driver;
            return this;
        }

        public Builder _for(Condition condition) {
            this.condition = condition;
            return this;
        }

        public Builder of(By selector) {
            this.selector = selector;
            return this;
        }

        public Builder until(Duration duration) {
            this.duration = duration;
            return this;
        }

        public Wait build() {
            Wait wait = new Wait();
            wait.webDriver = this.webDriver;
            wait.condition = this.condition;
            wait.duration = this.duration;
            wait.selector = this.selector;
            return wait;
        }
    }

    public WebElement start() {
        return switch(condition) {
            case VISIBILITY -> waitForVisOf();
            // TODO: Throwing this for now until other branches are complete
            default -> throw new IllegalStateException("Unexpected value: " + condition);
        };
    }

    private WebElement waitForVisOf() {
        WebDriverWait wait = new WebDriverWait(webDriver, duration.toSeconds());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
}
