package com.polytech.polyNet.repository;

import com.polytech.polyNet.business.Comms;
import com.polytech.polyNet.business.Story;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class JpaStoryRepository implements StoryRepository {

    private DataSource datasource;

    public JpaStoryRepository(DataSource dataSource) {
        this.datasource = datasource;
    }

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Story> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Story s");
        return query.getResultList();
    }

    @Override
    public void save(Story story) {
        entityManager.persist(story);
    }

    @Override
    public void saveComm(Comms comment) {
        entityManager.persist(comment);
    }

    public List<Comms> findAllComms() {
        Query query = entityManager.createQuery("SELECT s FROM Comment s");
        return query.getResultList();
    }
}