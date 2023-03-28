package com.tele2.tasks.montyhall.model;

public enum GameMode {

    INTERACTIVE_MODE("1.Interactive mode"), PREDICTIVE_MODE("2.Predictive mode");

    private final String description;

    GameMode(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}
