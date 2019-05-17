package com.polytech.polyNet.business;

import com.polytech.polyNet.business.Comms;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

    @Entity
    @Table(name = "story")

    public class Story {
        @Id
        @Column(name = "ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "content")
        private String content;

        @OneToMany()
        @JoinColumn(name = "id_story")
        private List<Comms> list = new ArrayList<>();


    public List<Comms> getList() {
        return list;
    }

    public void setList(List<Comms> list) {
        this.list = list;
    }

    public Story(int id, String content, List<Comms> list) {

        this.id = id;
        this.content = content;
        this.list = list;
    }

    public Story(String content) {

        this.content = content;
    }

    public Story() {
    }

    public Story(int id, String content) {

        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Story{" +
                "content='" + content + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
