package io.github.kszuba1.service;

import io.github.kszuba1.entity.Course;
import io.github.kszuba1.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course findById(int id);

    List<Course> findAll();

    void deleteCourseById(int id);

    void save(Course course);

    List<Course> findByTitleContaining(String title);

    List<Course> findByTitleAndInstructor(String title, Instructor instructor);

    boolean existsByTitle(String title);

    Course findByTitle(String title);

}
