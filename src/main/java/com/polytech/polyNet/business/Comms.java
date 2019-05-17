package com.polytech.polyNet.business;

import javax.persistence.*;

@Entity
@Table(name = "comment")

public class Comms {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
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

