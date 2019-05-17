package com.polytech.polyNet;

import com.polytech.polyNet.business.Story;
import com.polytech.polyNet.config.AppConfig;
import com.polytech.polyNet.repository.StoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String hash = new BCryptPasswordEncoder().encode("admin");
        System.out.println(hash);
    }
}
