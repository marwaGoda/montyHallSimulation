package com.tele2.tasks.montyhall.model;

public enum PlayerStrategy {

    KEEP_CHOICE("1.Keep first choice"), SWITCH_CHOICE("2.Switch first choice");

    private final String description;

    PlayerStrategy(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}
