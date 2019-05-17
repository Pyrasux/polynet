package com.polytech.polyNet.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.polyNet.business.FeedService;
import com.polytech.polyNet.business.FeedServiceImpl;
import com.polytech.polyNet.business.PublicationService;
import com.polytech.polyNet.business.PublicationServiceImpl;
import com.polytech.polyNet.repository.JdbcStoryRepository;
import com.polytech.polyNet.repository.JpaStoryRepository;
import com.polytech.polyNet.repository.StoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    StoryRepository storyRepository() {
        return new JpaStoryRepository(datasource());
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
