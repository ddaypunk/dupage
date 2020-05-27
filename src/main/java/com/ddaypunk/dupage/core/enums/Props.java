package com.ddaypunk.dupage.core.enums;

/**
 * An enum to hold all the system property keys and related default values
 */
public enum Props {
    BROWSER("selenium.browser", "chrome"),
    IS_REMOTE("selenium.is.remote", "false");

    String key, defaultVal;

    Props(String key, String defaultVal) {
        this.key = key;
        this.defaultVal = defaultVal;
    }

    /**
     * Get the current system property for the key
     * @return String value or defaultVal if null
     */
    public String getValue() {
        return System.getProperty(key, defaultVal);
    }
}
