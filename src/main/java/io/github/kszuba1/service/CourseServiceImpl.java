package io.github.kszuba1.service;

import io.github.kszuba1.dao.CourseRepository;
import io.github.kszuba1.entity.Course;
import io.github.kszuba1.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course findById(int id) {

        Optional<Course> resultCourse = courseRepository.findById(id);

        Course course = null;

        if (resultCourse.isPresent()) {
            course = resultCourse.get();
        }
        else {
            throw new RuntimeException("Course with Id = " + id + " not found");
        }

        return course;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourseById(int id) {

        courseRepository.deleteById(id);


    }

    @Override
    public void save(Course course) {

        courseRepository.save(course);

    }

    @Override
    public List<Course> findByTitle(String title) {
        return courseRepository.findAllByTitleContaining(title);
    }

    @Override
    public List<Course> findByTitleAndInstructor(String title, Instructor instructor) {
        return courseRepository.findAllByTitleContainingAndInstructor(title, instructor);
    }


}
