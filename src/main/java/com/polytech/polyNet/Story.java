package com.polytech.polyNet;

import java.util.List;

public class Story {
    private String content;
    private List<Comms> list;

    public List<Comms> getList() {
        return list;
    }

    public void setList(List<Comms> list) {
        this.list = list;
    }

    public Story(String content, List<Comms> list) {

        this.content = content;
        this.list = list;
    }

    public Story(String content) {

        this.content = content;
    }

    public Story() {
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
}
