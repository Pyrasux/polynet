package com.polytech.polyNet;

import java.util.List;

public interface StoryRepository {
    List<Story> findAll();

    void save(Story story);
    void saveComm(Comms comment);
}
