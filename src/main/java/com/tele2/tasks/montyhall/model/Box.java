package com.tele2.tasks.montyhall.model;

public class Box {

    private int number;
    private String content;

    public Box(int number, String content) {
       this.number = number;
       this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
