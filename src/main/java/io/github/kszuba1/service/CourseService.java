package io.github.kszuba1.service;

import io.github.kszuba1.entity.Course;

import java.util.List;

public interface CourseService {

    Course findById(int id);

    List<Course> findAll();

    void deleteCourseById(int id);

    void save(Course course);

    List<Course> findByTitle(String title);

}
