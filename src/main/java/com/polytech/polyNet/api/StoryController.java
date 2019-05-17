package com.polytech.polyNet.api;

import com.polytech.polyNet.business.Comms;
import com.polytech.polyNet.business.PublicationService;
import com.polytech.polyNet.business.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoryController {

    @Autowired
    PublicationService publicationService;

    @Autowired
    com.polytech.polyNet.business.FeedService FeedService;

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

    @PostMapping("/comms/{id}")
        public List<Story> push (@RequestBody String content,@PathVariable("id") int id_story){
            publicationService.push(new Comms(content,id_story));
            return FeedService.fetchAll();
        }
    }


