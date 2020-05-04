package com.mike.springboot.demo.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);

        return topics;
    }

    public Topic getTopic(String id){
        return topicRepository.findById(id).get();
    }

    public void deleteTopic(String id){
        topicRepository.deleteById(id);
    }

    public void updateTopic(String id, Topic topic){
        topicRepository.save(topic);

    }
}