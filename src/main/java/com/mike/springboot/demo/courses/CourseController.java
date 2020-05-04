package com.mike.springboot.demo.courses;

import com.mike.springboot.demo.topics.Topic;
import com.mike.springboot.demo.topics.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourse(id);
    }

    @GetMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/topics/{topicId}/courses")
//    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void createTopic(@RequestBody Course course,
                            @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, null, null));
        courseService.addCourse(course);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/topics/{topicId}/courses/{id}")
    public void updateCourse(@PathVariable String id,
                             @RequestBody Course course,
                             @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

}
