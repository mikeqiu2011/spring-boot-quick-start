package com.mike.springboot.demo.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public List<Course> getAllCourse(String topicId){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll()
                .forEach(courses::add);

        return courses;
    }

    public Course getCourse(String id){
        return courseRepository.findById(id).get();
    }

    public void deleteCourse(String id){
        courseRepository.deleteById(id);
    }

    public void updateCourse(Course course){
        courseRepository.save(course);

    }
}
