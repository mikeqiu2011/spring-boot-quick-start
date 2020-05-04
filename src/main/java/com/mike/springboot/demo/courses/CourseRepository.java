package com.mike.springboot.demo.courses;

import com.mike.springboot.demo.courses.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
    public List<Course> findByTopicId(String topicId);
}
