package com.polytech.polyNet;

public class Comms {

    private String content;
    private int id_story;

    public Comms(String content) {
        this.content = content;

    }

    public Comms(String content, int id_story) {
        this.content = content;
        this.id_story = id_story;
    }

    public Comms() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId_story() {
        return id_story;
    }

    public void setId_story(int id_story) {
        this.id_story = id_story;
    }
}

