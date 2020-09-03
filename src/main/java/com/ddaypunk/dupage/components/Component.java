package com.ddaypunk.dupage.components;

import com.ddaypunk.dupage.core.Selector;
import com.ddaypunk.dupage.core.Wait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

import static com.ddaypunk.dupage.core.enums.Condition.VISIBILITY;

public class Component extends RemoteWebElement {
    private static final Logger LOGGER = LogManager.getLogger("Component");

    private WebElement root = null;
    private By selector = null;
    private boolean isVisibilityRequired = true;

    public Component(Selector selector) {
        this(selector, true);
    }

    public Component(Selector selector, boolean isVisibilityRequired) {
        this.selector = selector.getBy();
        this.isVisibilityRequired = isVisibilityRequired;
    }

    public Component(By selector) {
        this(selector, true);
    }

    public Component(By selector, boolean isVisibilityRequired) {
        this.selector = selector;
        this. isVisibilityRequired = isVisibilityRequired;
    }

    public Component(WebElement root, String attribute) {
        this.root = root;

        if(!attribute.isEmpty()){
            Selector temp = new Selector(attribute, getAttribute(attribute));
            this.selector = temp.getBy();
        }

    }

    /**
     * Get the current root element of the component, checking for nullness and staleness of root
     * @return root element as a WebElement
     */
    public WebElement getRoot() {
        if(this.root == null) {
            LOGGER.debug("Component root is null, setting root...");
            setRoot();
        } else if (isStale()) {
            LOGGER.debug("Component root is stale, relocating...");
            setRoot();
        }

        return root;
    }

    private void setRoot() {
        Wait waiter = new Wait
                .Builder()
                ._for(VISIBILITY)
                .of(selector)
                .until(Duration.ofSeconds(10))
                .build();

        this.root = waiter.start();
    }

    private boolean isStale() {
        try {
            root.isEnabled();
            return false;
        } catch (StaleElementReferenceException e) {
            return true;
        }
    }
}
