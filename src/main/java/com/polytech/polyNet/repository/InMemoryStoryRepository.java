package com.polytech.polyNet.repository;

import com.polytech.polyNet.business.Comms;
import com.polytech.polyNet.business.Story;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStoryRepository implements StoryRepository {
    private List<Story> stories = new ArrayList<Story>();

    public List<Story> findAll() {
        return stories;
    }

    public void save(Story story) {
        stories.add(story);
    }

    @Override
    public void saveComm(Comms comment) {
    }
}
