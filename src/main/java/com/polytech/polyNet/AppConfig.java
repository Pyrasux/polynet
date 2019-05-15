package com.polytech.polyNet;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    StoryRepository storyRepository() {
        return new JdbcStoryRepository(datasource());
    }

    @Bean
    FeedService feedService() {
        return new FeedServiceImpl(storyRepository());
    }

    @Bean
    DataSource datasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://mysql-tristanpuaux.alwaysdata.net:3306/tristanpuaux_social?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC");
        dataSource.setUser("177084_root");
        dataSource.setPassword("root_2019");
        dataSource.setDatabaseName("tristanpuaux_social");
        return dataSource;
    }

    @Bean
    PublicationService publicationService() {
        return new PublicationServiceImpl(storyRepository());
    }
}
