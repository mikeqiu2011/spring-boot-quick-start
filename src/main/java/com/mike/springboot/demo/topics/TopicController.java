package com.mike.springboot.demo.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;


    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public Topic getOneTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
//    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void createTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteOneTopics(@PathVariable String id) {
        topicService.deleteTopic(id);
    }

    @PutMapping("/topics/{id}")
    public void updateOneTopics(@PathVariable String id,
                                @RequestBody Topic topic) {
        topicService.updateTopic(id, topic);
    }

}
