package com.polytech.polyNet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
public class StoryController {

    @Autowired
    PublicationService publicationService;

    @Autowired
    FeedService FeedService;

    @PostMapping("/story")
    public void share(@RequestBody String content){
        publicationService.share(new Story(content));
        }

    @GetMapping("/feed")
    public List<Story> feed() {
        return FeedService.fetchAll();
    }

    @GetMapping("/toto")
    public void toto(@RequestParam("param1") Long param1, @RequestParam("param2") String param2){
        System.out.println(param1 + " " + param2);
    }

    @PostMapping("/comms")
        public void push (@RequestBody String content){
            publicationService.push(new Comms(content));
        }
    }


