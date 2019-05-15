package com.polytech.polyNet;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcStoryRepository implements StoryRepository {


    private DataSource dataSource;

    public JdbcStoryRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Story> findAll() {

        List<Story> results = new ArrayList();
        try {
            //GET CONNECTION
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM STORY";
            //EXECUTE QUERY
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            // FOR EACH ROW IN DATA BASE
            while (resultSet.next()) {
                // I GET THE CONTENT COLUMN
                String content = resultSet.getString("CONTENT");
                List<Comms> l = findAllComms(Integer.parseInt(resultSet.getString("ID")));
                Story story = new Story(content, l);
                // I ADD THE STORY TO THE RESULT
                results.add(story);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<Comms> findAllComms(int id) {

        List<Comms> results = new ArrayList();
        try {
            //GET CONNECTION
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM COMMENT WHERE id_story =" + id;
            //EXECUTE QUERY
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            // FOR EACH ROW IN DATA BASE
            while (resultSet.next()) {
                // I GET THE CONTENT COLUMN
                String content = resultSet.getString("content");
                Comms commentaire = new Comms(content);
                // I ADD THE STORY TO THE RESULT
                results.add(commentaire);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


    @Override
    public void save(Story story) {
        try {
            //GET CONNECTION
            System.out.println(story);
            Connection connection = dataSource.getConnection();
            String sql = "INSERT INTO STORY(CONTENT) VALUES('" + story.getContent() + "')";
            //EXECUTE QUERY
            connection.createStatement().execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveComm(Comms comment) {
        try {
            //GET CONNECTION
            System.out.println(comment);
            Connection connection = dataSource.getConnection();
            String sql = "INSERT INTO COMMENT(content,id_story) VALUES('" + comment.getContent() +"," + comment.getId_story() +"')";
            //EXECUTE QUERY
            connection.createStatement().execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



