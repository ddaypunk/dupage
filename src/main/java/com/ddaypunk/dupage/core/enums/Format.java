package com.ddaypunk.dupage.core.enums;

public enum Format {
    WITH_VALUE("[%s=\'%s\']"),
    WITHOUT_VALUE("[%s]");

    private String stringy;

    private Format(String formatter) {
        this.stringy = formatter;
    }

    public String get() {
        return this.stringy;
    }
}