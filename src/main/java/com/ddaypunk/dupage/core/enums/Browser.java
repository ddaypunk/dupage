package com.ddaypunk.dupage.core.enums;

import javax.annotation.Nullable;

public enum Browser {
    CHROME,
    EDGE,
    FIREFOX,
    IE,
    OPERA,
    SAFARI;

    @Nullable
    public static Browser fromName(String name) {
        for (Browser browser: values()) {
            if(browser.toString().equalsIgnoreCase(name)) {
                return browser;
            }
        }

        return null;
    }
}
